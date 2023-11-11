package christmas.constant;

public enum EventInfo {
    EVENT_MONTH(12),
    EVENT_START_DAY(1),
    EVENT_END_DAY(31),
    EVENT_D_DAY(25),
    ORDER_AMOUNT_MIN(1),
    ORDER_AMOUNT_MAX(20);

    private final int month;

    EventInfo(int month) {
        this.month = month;
    }

    public int getNumber() {
        return month;
    }
}