package christmas.constant;

import java.util.function.BiFunction;

public enum Badge {
    SANTA("산타",5000),
    TREE("트리", 10000),
    STAR("별", 20000);

    private final String name;
    private final int price;

    Badge(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public static String getBadge(int price) {
        for (Badge badge : Badge.values()) {
            if (badge.getPrice() <= price) {
                return badge.getName();
            }
        }
        return Message.DISCOUNT_NON_PROFIT.getMessage();
    }
}
