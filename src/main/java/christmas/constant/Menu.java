package christmas.constant;

public enum Menu {
    MUSHROOM_CREAM_SOUP("양송이수프", 6_000, Category.APPETIZER),
    TAPAS("타파스", 5_500, Category.APPETIZER),
    CAESAR_SALAD("시저샐러드", 8_000, Category.APPETIZER),

    T_BORN_STEAK("T본스테이크", 55_000, Category.MAIN_DISH),
    PORK_LIP("바비큐립", 54_000, Category.MAIN_DISH),
    SEAFOOD_PASTA("해산물파스타", 35_000, Category.MAIN_DISH),
    CHRISTMAS_PAST("크리스마스파스타", 25_000, Category.MAIN_DISH),

    CHOCOLATE_CAKE("초콜릿케이크", 8_000, Category.DESSERT),
    ICE_CREAM("아이스크림", 6_000, Category.DESSERT),
    ZERO_COKE("제로콜라", 3_000, Category.DRINK),
    RED_WINE("레드와인", 10_000, Category.DRINK),
    SHAM_PAIN("샴페인", 15_000, Category.DRINK);

    public enum Category {
        APPETIZER("에피타이저"),
        MAIN_DISH("메인"),
        DESSERT("디저트"),
        DRINK("음료");

        private final String name;

        Category(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }


    private final String name;
    private final int price;
    private final Category category;

    Menu(String name, int price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public static boolean isValueOf(String name) {
        for (Menu menu : Menu.values()) {
            if (menu.name.equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static Menu of(String name) {
        for (Menu menu : Menu.values()) {
            if (menu.name.equals(name)) {
                return menu;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getMessage());
    }

}
