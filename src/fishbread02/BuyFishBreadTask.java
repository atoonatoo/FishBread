package fishbread02;

import java.util.Random;

public class BuyFishBreadTask implements Runnable {
    private final Customer customer;
    private final FishBreadSeller seller;

    public BuyFishBreadTask(Customer customer, FishBreadSeller seller) {
        this.customer = customer;
        this.seller = seller;
    }

    @Override
    public void run() {
        Random random = new Random();
        FishBreadType[] types = FishBreadType.values();

        FishBreadType selectedType = types[random.nextInt(types.length)];
        int count = random.nextInt(5) + 1;

        int totalPrice = selectedType.getPrice() * count;

        if (customer.getWalletBalance() >= totalPrice) {
            customer.buyFishBread(seller, selectedType, count);
        }
    }
}