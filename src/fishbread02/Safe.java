package fishbread02;

public class Safe {
    private int money = 0;

    public synchronized void store(int amount) {
        this.money += amount;
    }

    public int getBalance() {
        return money;
    }
}
