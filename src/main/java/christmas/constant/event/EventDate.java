package christmas.constant.event;

import christmas.constant.calender.Calender;

public enum EventDate {
    EVENT_YEAR(2023),
    EVENT_MONTH(12),
    EVENT_START_DAY(1),
    EVENT_END_DAY(EVENT_MONTH.getEventMonthEndDay()),
    EVENT_D_DAY(25);

    private final int number;

    EventDate(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private int getEventMonthEndDay() {
        return Calender.of(number).getEnd();
    }

    public static int eventMonth() {
        return EVENT_MONTH.getNumber();
    }

    public static int eventStartDay() {
        return EVENT_START_DAY.getNumber();
    }

    public static int eventEndDay() {
        return EVENT_END_DAY.getNumber();
    }

    public static int eventDday() {
        return EVENT_D_DAY.getNumber();
    }

    public static int eventYear() {
        return EVENT_YEAR.getNumber();
    }

    public static boolean canGetDDayDiscount(int day) {
        return day <= eventDday();
    }
}