package com.traider.journal.System;

import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.BinanceApiRestClient;
import com.binance.api.client.domain.account.Account;
import com.binance.api.client.domain.account.AssetBalance;
import com.binance.api.client.domain.general.SymbolInfo;
import com.binance.api.client.domain.market.TickerStatistics;
import com.traider.journal.Coin;
import com.traider.journal.Models.Trade;
import com.traider.journal.Models.Symbol;
import com.traider.journal.Repositories.TradeRepository;
import com.traider.journal.Services.SymbolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Binance {

	private final String apiKey = "";
	private final String secret = "";
	BinanceApiClientFactory factory = BinanceApiClientFactory.newInstance(apiKey, secret);
	BinanceApiRestClient client = factory.newRestClient();
	@Autowired
	private SymbolService symbolService;
	@Autowired
	private TradeRepository tradeRepository;

	public ArrayList<Coin> getUserBalance() {
		Account account = client.getAccount();
		ArrayList<Coin> coins = new ArrayList<>();
		for (AssetBalance a : account.getBalances()) {
			Coin c = new Coin();

			c.setCoin(a.getAsset(), a.getLocked(), a.getFree());
			// System.out.println(c.getAsset());
			if (c.getFree() != 0 | c.getLocked() != 0) {
				c.setLastPrice(getCoinPrice(c.getAsset(), "USDT"));
				coins.add(c);
			}
		}
		return coins;
	}

	public ArrayList<com.binance.api.client.domain.account.Trade> getAllOperationforCoin(String coin) {

		List<com.binance.api.client.domain.account.Trade> myTrades = client.getMyTrades(coin + "USDT");
		ArrayList<String> symbolsContain = new ArrayList<>();

		for (SymbolInfo symbolInfo : client.getExchangeInfo().getSymbols()) {
			Symbol s = symbolService.getByName(symbolInfo.getSymbol());
			System.out.println(s);
			System.out.println(symbolInfo.getSymbol());
			if (s == null) {
				Symbol symbol = new Symbol();
				symbol.setName(symbolInfo.getSymbol());
				symbolService.saveOrUpdate(symbol);
			}
			if (symbolInfo.getSymbol().contains(coin)) {
				symbolsContain.add(symbolInfo.getSymbol());
			}
		}
		System.out.println(symbolsContain);
		List<Trade> myTrade = new ArrayList<>();
		for (String s : symbolsContain) {
			List<com.binance.api.client.domain.account.Trade> myTraids1 = client.getMyTrades(s);
			if (myTraids1.size() > 0) {
				myTrade.addAll(myTrade);
			}
		}
		System.out.println(myTrades);
		return (ArrayList<com.binance.api.client.domain.account.Trade>) myTrades;
	}

	public double getCoinPrice(String coin, String toCoin) {
		if (coin.equals(toCoin)) {
			return 1;
		}
		try {
			TickerStatistics tickerStatistics = client.get24HrPriceStatistics(coin + toCoin);
			return Double.parseDouble(tickerStatistics.getLastPrice());
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	public void getAllUserOrdersDone(String coin) {
		int delay = 500;
		List<com.binance.api.client.domain.account.Trade> myTrades = client.getMyTrades(coin + "BUSD");
		if (myTrades.size() > 0) {
			for (com.binance.api.client.domain.account.Trade trade : myTrades) {
				Trade od = tradeRepository.findByOrderId(trade.getOrderId());
				if (od == null) {
					od = new Trade();
					od.cloneTrade(trade);
					tradeRepository.save(od);
				}
			}
		}
	}
}
