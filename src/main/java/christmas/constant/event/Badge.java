package christmas.constant.event;

import christmas.constant.message.Message;
import java.util.Arrays;
import java.util.Comparator;

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
        for (Badge badge : sortByPrice()) {
            if (price >= badge.getPrice()) {
                return badge.getName();
            }
        }
        return Message.nonProfit();
    }

    public static Badge[] sortByPrice() {
        Badge[] badges = Badge.values();
        Arrays.sort(badges, Comparator.comparingInt(Badge::getPrice).reversed());
        return badges;
    }
}
