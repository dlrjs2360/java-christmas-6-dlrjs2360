package christmas.constant;

public enum DiscountAmount {
    WEEKDAY(2_023),
    WEEKEND(2_023),
    CHRISTMAS_D_DAY_UNIT(100),
    CHRISTMAS_DEFAULT(1_000),
    SPECIAL_DAY(1_000);

    private final int amount;

    DiscountAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public static int calculateChristmasDiscount(int day) {
        return CHRISTMAS_DEFAULT.getAmount() + CHRISTMAS_D_DAY_UNIT.getAmount() * (day-1);
    }
}
