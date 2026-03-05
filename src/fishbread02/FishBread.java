package fishbread02;

public class FishBread {
    private final FishBreadType type;

    public FishBread(FishBreadType type) {
        this.type = type;
    }

    public String getTypeName() {
        return type.getName();
    }
}
