package christmas.constant;

public enum DiscountCategory {
    CHRISTMAS_EVENT("크리스마스 디데이 할인"),
    WEEKEND_EVENT("주말 할인"),
    WEEKDAY_EVENT("평일 할인"),
    GIFT_EVENT("증정 이벤트"),
    SPECIAL_DAY("특별 할인");

    private final String name;

    DiscountCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
