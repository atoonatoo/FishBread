package fishbread02;

public enum FishBreadType {
    RED_BEAN("팥", 1000),
    CREAM("크림", 1500),
    HOT("매운", 2000);

    private final String name;
    private final int price;

    FishBreadType(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
