package christmas.constant;

public enum Gift {
    GIFT_MENU(Menu.CHAMPAGNE, 1);

    private final Menu menu;
    private final int giftAmount;

    Gift(Menu menu, int giftAmount) {
        this.menu = menu;
        this.giftAmount = giftAmount;
    }

    public Menu getMenu() {
        return menu;
    }

    public int getGiftPrice() {
        return menu.getPrice();
    }

    @Override
    public String toString() {
        return new StringBuilder()
            .append(menu.getName())
            .append(" ")
            .append(giftAmount)
            .append("개").toString();
    }
}
