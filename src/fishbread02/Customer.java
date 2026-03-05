package fishbread02;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Customer extends Thread {
    private int wallet;
    private final List<FishBread> FishBreads = new ArrayList<>();
    private final FishBreadSeller seller;

    public Customer(int initialMoney, FishBreadSeller seller) {
        this.wallet = initialMoney;
        this.seller = seller;
    }

    @Override
    public void run() {
        Random random = new Random();
        FishBreadType[] types = FishBreadType.values();

        FishBreadType selectedType = types[random.nextInt(types.length)];
        int count = random.nextInt(5) + 1;

        buyFishBread(seller, selectedType, count);
    }

    public boolean buyFishBread(FishBreadSeller seller, FishBreadType type, int count) {
        int totalPrice = type.getPrice() * count;
        if (wallet < totalPrice) return false;

        List<FishBread> bought = seller.sell(type, count, totalPrice);
        wallet -= totalPrice;
        FishBreads.addAll(bought);
        return true;
    }

    public List<FishBread> getFishBreads() { return FishBreads; }
    public int getWalletBalance() { return wallet; }
}