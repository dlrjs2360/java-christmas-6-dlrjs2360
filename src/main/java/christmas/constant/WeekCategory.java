package christmas.constant;

public enum WeekCategory {
    WEEKEND(DiscountAmount.WEEKEND),
    WEEKDAY(DiscountAmount.WEEKEND);

    private final DiscountAmount discountAmount;

    WeekCategory(DiscountAmount discountAmount) {
        this.discountAmount = discountAmount;
    }

    public int getDiscountAmount() {
        return discountAmount.getAmount();
    }

}
