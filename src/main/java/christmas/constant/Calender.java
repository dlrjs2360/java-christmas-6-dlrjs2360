package christmas.constant;

public enum Calender {
    JANUARY(1,31), FEBRUARY(2,28), MARCH(3,31), APRIL(4,30), MAY(5,31), JUNE(6,30),
    JULY(7,31), AUGUST(8,31), SEPTEMBER(9,30), OCTOBER(10,31), NOVEMBER(11,30), DECEMBER(12,31);

    private final int month;
    private final int end;

    Calender(int month, int end) {
        this.month = month;
        this.end = end;
    }

    public int getEnd() {
        return end;
    }

    public static Calender of(int month) {
        for (Calender calender : Calender.values()) {
            if (calender.month == month) {
                return calender;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.INVALID_EVENT_DATE.getMessage());
    }
}
