package christmas.constant;

public enum DayOfWeek {
    MONDAY(WeekCategory.WEEKDAY),
    TUESDAY(WeekCategory.WEEKDAY),
    WEDNESDAY(WeekCategory.WEEKDAY),
    THURSDAY(WeekCategory.WEEKDAY),
    FRIDAY(WeekCategory.WEEKEND),
    SATURDAY(WeekCategory.WEEKEND),
    SUNDAY(WeekCategory.WEEKDAY);

    private final WeekCategory weekCategory;

    DayOfWeek(WeekCategory weekCategory) {
        this.weekCategory = weekCategory;
    }

    public int getDiscountAmount() {
        return weekCategory.getDiscountAmount();
    }

    public boolean isWeekend() {
        return weekCategory == WeekCategory.WEEKEND;
    }

}
