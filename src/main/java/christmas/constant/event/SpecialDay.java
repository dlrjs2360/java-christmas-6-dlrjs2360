package christmas.constant.event;

public enum SpecialDay {
    SPECIAL_DAY(3, 10, 17, 24, 25, 31);

    private final int[] days;

    SpecialDay(int... days) {
        this.days = days;
    }

    public static boolean isSpecialDay(int day) {
        for (int specialDay : SPECIAL_DAY.days) {
            if (specialDay == day) {
                return true;
            }
        }
        return false;
    }

}
