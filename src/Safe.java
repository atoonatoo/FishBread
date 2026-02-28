public class Safe {
    private int money = 0;

    public void store(int amount) {
        this.money += amount;
    }

    public int getBalance() {
        return money;
    }
}
