package com.traider.journal.Models;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
public class Trade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    private String price;
    private String qty;
    private String quoteQty;
    private String commission;
    private String commissionAsset;
    private long time;
    private String symbol;
    @JsonProperty("isBuyer")
    private boolean buyer;
    @JsonProperty("isMaker")
    private boolean maker;
    @JsonProperty("isBestMatch")
    private boolean bestMatch;
    private String orderId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getQuoteQty() {
        return quoteQty;
    }

    public void setQuoteQty(String quoteQty) {
        this.quoteQty = quoteQty;
    }

    public String getCommission() {
        return commission;
    }

    public void setCommission(String commission) {
        this.commission = commission;
    }

    public String getCommissionAsset() {
        return commissionAsset;
    }

    public void setCommissionAsset(String commissionAsset) {
        this.commissionAsset = commissionAsset;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public boolean isBuyer() {
        return buyer;
    }

    public void setBuyer(boolean buyer) {
        this.buyer = buyer;
    }

    public boolean isMaker() {
        return maker;
    }

    public void setMaker(boolean maker) {
        this.maker = maker;
    }

    public boolean isBestMatch() {
        return bestMatch;
    }

    public void setBestMatch(boolean bestMatch) {
        this.bestMatch = bestMatch;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trade trade = (Trade) o;
        return time == trade.time && buyer == trade.buyer && maker == trade.maker && bestMatch == trade.bestMatch && Objects.equals(price, trade.price) && Objects.equals(qty, trade.qty) && Objects.equals(quoteQty, trade.quoteQty) && Objects.equals(commission, trade.commission) && Objects.equals(commissionAsset, trade.commissionAsset) && Objects.equals(symbol, trade.symbol) && Objects.equals(orderId, trade.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, qty, quoteQty, commission, commissionAsset, time, symbol, buyer, maker, bestMatch, orderId);
    }

    public void cloneTrade(com.binance.api.client.domain.account.Trade trade){
        this.price = trade.getPrice();
        this.qty = trade.getQty();
        this.quoteQty = trade.getQuoteQty();
        this.commission = trade.getCommission();
        this.commissionAsset = trade.getCommissionAsset();
        this.time = trade.getTime();
        this.symbol = trade.getSymbol();
        this.buyer = trade.isBuyer();
        this.maker = trade.isMaker();
        this.bestMatch = trade.isBestMatch();
        this.orderId = trade.getOrderId();

    }
}
