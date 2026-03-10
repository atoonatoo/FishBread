package fishbread02;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String name;
    private int wallet;
    private final List<FishBread> fishBreads = new ArrayList<>();

    public Customer(String name, int initialMoney) {
        this.name = name;
        this.wallet = initialMoney;
    }

    public void buyFishBread(FishBreadSeller seller, FishBreadType type, int count) {
        int totalPrice = type.getPrice() * count;

        List<FishBread> bought = seller.sell(this, type, count, totalPrice);
        this.wallet -= totalPrice;
        this.fishBreads.addAll(bought);
    }

    public String getName() { return name; }
    public List<FishBread> getFishBreads() { return fishBreads; }
    public int getWalletBalance() { return wallet; }
}