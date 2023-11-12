package christmas.constant;

public enum Gift {
    GIFT_MENU(Menu.CHAMPAGNE);

    private final Menu menu;

    Gift(Menu menu) {
        this.menu = menu;
    }

    public Menu getMenu() {
        return menu;
    }

    public int getGiftPrice() {
        return menu.getPrice();
    }
}
