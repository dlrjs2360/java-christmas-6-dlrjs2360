package christmas.domain;

import christmas.constant.event.Menu;
import christmas.constant.event.Menu.Category;
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

    public int getPrice() {
        return menu.getPrice();
    }

    public Category getCategory() {
        return menu.getCategory();
    }
}

