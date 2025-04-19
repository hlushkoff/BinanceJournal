package com.traider.journal.System;

import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.BinanceApiRestClient;
import com.traider.journal.Models.Trade;
import com.traider.journal.Repositories.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Trades {
    private final String apiKey = "";
    private final String secret = "";
    BinanceApiClientFactory factory = BinanceApiClientFactory.newInstance(apiKey, secret);
    BinanceApiRestClient client = factory.newRestClient();

    @Autowired
    private TradeRepository tradeRepository;

    public void getTradesCoin(String coin) throws InterruptedException {
        ///Get all trades for the BUSDT
        List<com.binance.api.client.domain.account.Trade> myTrades = client.getMyTrades(coin + "BUSD");
        if (myTrades.size() > 0) {
            for (com.binance.api.client.domain.account.Trade trade :
                    myTrades) {
                Trade od = tradeRepository.findByOrderId(trade.getOrderId());
                if (od == null) {
                    od = new Trade();
                    od.cloneTrade(trade);
                    tradeRepository.save(od);
                }
            }
        }
        //get all trades for USDT
        Thread.sleep(1000); // Deayed weight of API 10
        myTrades = client.getMyTrades(coin + "USDT");
        if (myTrades.size() > 0) {
            for (com.binance.api.client.domain.account.Trade trade :
                    myTrades) {
                Trade od = tradeRepository.findByOrderId(trade.getOrderId());
                if (od == null) {
                    od = new Trade();
                    od.cloneTrade(trade);
                    tradeRepository.save(od);
                }
            }
        }
        //getall trades BTC
        Thread.sleep(1000); // Deayed weight of API 10
        myTrades = client.getMyTrades(coin + "BTC");
        if (myTrades.size() > 0) {
            for (com.binance.api.client.domain.account.Trade trade :
                    myTrades) {
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