package christmas.constant;

public enum OrderLimit {
    ORDER_AMOUNT_MIN(1),
    ORDER_AMOUNT_MAX(20);

    private final int number;

    OrderLimit(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
