package christmas.domain;

import christmas.constant.event.Menu;
import christmas.constant.event.Menu.Category;
import christmas.validator.OrderMenuValidator;

public class OrderMenu {
    private final Menu menu;
    private static final OrderMenuValidator orderMenuValidator;
    public OrderMenu(String menu) {
        validate(menu);
        this.menu = Menu.of(menu);
    }

    static {
        orderMenuValidator = new OrderMenuValidator();
    }

    private void validate(String menu) {
        orderMenuValidator.validate(menu);
    }

    public Menu getMenu() {
        return menu;
    }

    public int getPrice() {
        return menu.getPrice();
    }

    public Category getCategory() {
        return menu.getCategory();
    }
}

