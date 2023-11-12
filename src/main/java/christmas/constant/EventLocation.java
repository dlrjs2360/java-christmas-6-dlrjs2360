package christmas.constant;

public enum EventLocation {
    LOCATION_NAME("우테코"),
    LOCATION_CATEGORY("식당");

    private final String name;

    EventLocation(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
