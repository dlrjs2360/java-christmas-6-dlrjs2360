package christmas.constant.calender;

public enum DayOfWeek {
    MONDAY(DiscountOfWeek.WEEKDAY),
    TUESDAY(DiscountOfWeek.WEEKDAY),
    WEDNESDAY(DiscountOfWeek.WEEKDAY),
    THURSDAY(DiscountOfWeek.WEEKDAY),
    FRIDAY(DiscountOfWeek.WEEKEND),
    SATURDAY(DiscountOfWeek.WEEKEND),
    SUNDAY(DiscountOfWeek.WEEKDAY);

    private final DiscountOfWeek discountOfWeek;

    DayOfWeek(DiscountOfWeek discountOfWeek) {
        this.discountOfWeek = discountOfWeek;
    }

    public int getDiscountAmount() {
        return discountOfWeek.getDiscountAmount();
    }

    public boolean isWeekend() {
        return discountOfWeek == DiscountOfWeek.WEEKEND;
    }

}
