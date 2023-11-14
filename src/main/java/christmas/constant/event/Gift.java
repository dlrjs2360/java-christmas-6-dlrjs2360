package christmas.constant.event;

import christmas.constant.event.Menu;

public enum Gift {
    GIFT_MENU(Menu.CHAMPAGNE, 1);

    private final Menu menu;
    private final int giftAmount;

    Gift(Menu menu, int giftAmount) {
        this.menu = menu;
        this.giftAmount = giftAmount;
    }

    public static int getGiftPrice() {
        return GIFT_MENU.menu.getPrice();
    }

    @Override
    public String toString() {
        return menu.getName() + " " + giftAmount + "개";
    }
}
