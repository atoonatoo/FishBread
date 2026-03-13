package fishbread02;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

public class Customer {
    private static final AtomicLong idGenerator = new AtomicLong(1);

    private final long id;
    private final String name;
    private int wallet;
    private final List<FishBread> fishBreads = new ArrayList<>();

    public Customer(String name, int initialMoney) {
        this.id = idGenerator.getAndIncrement();
        this.name = name;
        this.wallet = initialMoney;
    }

    public void buyFishBread(FishBreadSeller seller, FishBreadType type, int count) {
        int totalPrice = type.getPrice() * count;

        List<FishBread> bought = seller.sell(this, type, count, totalPrice);
        this.wallet -= totalPrice;
        this.fishBreads.addAll(bought);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return id == customer.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String getName() { return name; }
    public List<FishBread> getFishBreads() { return fishBreads; }
    public int getWalletBalance() { return wallet; }
}