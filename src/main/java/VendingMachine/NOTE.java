package VendingMachine;

public enum NOTE {

    TEN(10),
    TWENTY(20),
    FIFTY(50),
    HUNDRED(100),
    FIVE_HUNDRED(500),
    THOUSAND(1000);

    private final int value;

    NOTE(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
