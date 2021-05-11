package com.traider.journal;

public class Coin {
    private String asset;
    private double free;
    private double locked;
    private double lastPrice;
    private double priceInWallet;
    public String getAsset() {
        return asset;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public double getFree() {
        return free;
    }

    public void setFree(double free) {
        this.free = free;
    }

    public double getLocked() {
        return locked;
    }

    public void setLocked(double locked) {
        this.locked = locked;
    }

    public double getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(double lastPrice) {
        this.lastPrice = lastPrice;
        this.priceInWallet = lastPrice * (this.free + this.locked);
    }

    public double getPriceInWallet() {
        return priceInWallet;
    }

    public void setCoin(String asset, String locked, String free){
        this.asset = asset;
        this.locked = Double.parseDouble(locked);
        this.free = Double.parseDouble(free);
    }


    @Override
    public String toString() {
        return "Coin{" +
                "asset='" + asset + '\'' +
                ", free=" + free +
                ", locked=" + locked +
                '}';
    }
}
