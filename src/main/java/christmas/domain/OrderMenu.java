package christmas.domain;

import christmas.constant.Menu;
import christmas.validator.OrderMenuValidator;

public class OrderMenu {
    private final Menu menu;

    public OrderMenu(String menu, OrderMenuValidator orderMenuValidator) {
        validate(menu, orderMenuValidator);
        this.menu = Menu.of(menu);
    }

    void validate(String menu, OrderMenuValidator orderMenuValidator) {
        orderMenuValidator.validate(menu);
    }

    public Menu getMenu() {
        return menu;
    }
}

