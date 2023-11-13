package christmas.constant;

import java.time.DayOfWeek;
import java.time.LocalDate;

public enum Calender {
    JANUARY(1),
    FEBRUARY(2),
    MARCH(3),
    APRIL(4),
    MAY(5),
    JUNE(6),
    JULY(7),
    AUGUST(8),
    SEPTEMBER(9),
    OCTOBER(10),
    NOVEMBER(11),
    DECEMBER(12);

    private final int month;

    Calender(int month) {
        this.month = month;
    }

    public int getEnd() {
        return LocalDate.of(EventDate.EVENT_YEAR.getNumber(), month, 1).lengthOfMonth();
    }

    public static Calender of(int month) {
        for (Calender calender : Calender.values()) {
            if (calender.month == month) {
                return calender;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.INVALID_EVENT_DATE.getMessage());
    }

    public static DayOfWeek getDayOfWeek(int day) {
        return LocalDate.of(EventDate.EVENT_YEAR.getNumber(),EventDate.EVENT_MONTH.getNumber(), day).getDayOfWeek();
    }

}
