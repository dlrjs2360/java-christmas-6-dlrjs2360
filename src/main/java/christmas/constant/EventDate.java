package christmas.constant;

public enum EventDate {
    EVENT_MONTH(12),
    EVENT_START_DAY(1),
    EVENT_END_DAY(Calender.of(EventDate.EVENT_MONTH.getNumber()).getEnd()),
    EVENT_D_DAY(25);

    private final int number;

    EventDate(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}