package christmas.constant.calender;

import christmas.constant.discount.DiscountAmount;

public enum DiscountOfWeek {
    WEEKEND(DiscountAmount.WEEKEND),
    WEEKDAY(DiscountAmount.WEEKEND);

    private final DiscountAmount discountAmount;

    DiscountOfWeek(DiscountAmount discountAmount) {
        this.discountAmount = discountAmount;
    }

    public int getDiscountAmount() {
        return discountAmount.getAmount();
    }

}
