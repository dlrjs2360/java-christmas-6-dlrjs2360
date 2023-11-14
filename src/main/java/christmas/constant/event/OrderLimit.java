package christmas.constant.event;

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

    public static int orderAmountMin() {
        return ORDER_AMOUNT_MIN.getNumber();
    }

    public static int orderAmountMax() {
        return ORDER_AMOUNT_MAX.getNumber();
    }
}
