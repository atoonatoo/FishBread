package fishbread01;

import java.util.ArrayList;
import java.util.List;

public class Customer extends Thread {
    private int wallet;
    private final List<FishBread> FishBreads = new ArrayList<>();
    public Customer(int initialMoney) {
        this.wallet = initialMoney;
    }

    public boolean buyFishBread(FishBreadSeller seller, FishBreadType type, int count) {
        int totalPrice = type.getPrice() * count;

        if (wallet < totalPrice) {
            return false;
        }

        List<FishBread> bought = seller.sell(type, count, totalPrice);
        wallet -= totalPrice;
        FishBreads.addAll(bought);

        return true;
    }

    public FishBread eatFishBread(int index) {
        if (index < 0 || index >= FishBreads.size()) {
            return null;
        }
        return FishBreads.remove(index);
    }

    public List<FishBread> getFishBreads() {
        return FishBreads;
    }

    public int getWalletBalance() {
        return wallet;
    }

    public int getFishBreadsSize() {
        return FishBreads.size();
    }
}
