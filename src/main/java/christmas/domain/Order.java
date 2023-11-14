package christmas.domain;

import christmas.constant.event.Menu.Category;
import christmas.constant.message.CommonLetter;
import christmas.constant.event.Menu;
import christmas.util.ParseUtil;
import christmas.validator.OrderAmountValidator;
import christmas.validator.OrderMenuValidator;
import christmas.validator.OrderValidator;

public class Order {

    private final OrderMenu menu;
    private final OrderAmount amount;

    public Order(String orderInput, OrderValidator orderValidator,
        OrderMenuValidator orderMenuValidator, OrderAmountValidator orderAmountValidator) {
        validate(orderInput, orderValidator);
        String[] validatedOrderInfo = parseOrderInfo(orderInput);
        this.menu = new OrderMenu(validatedOrderInfo[0], orderMenuValidator);
        this.amount = new OrderAmount(validatedOrderInfo[1], orderAmountValidator);
    }

    void validate(String purchase, OrderValidator orderValidator) {
        orderValidator.validate(purchase);
    }

    public Menu getMenu() {
        return menu.getMenu();
    }

    public String getMenuName() {
        return getMenu().getName();
    }

    public Category getMenuCategory() {
        return menu.getCategory();
    }

    public int getAmount() {
        return amount.getAmount();
    }

    @Override
    public String toString() {
        return menu.getMenu().getName() + CommonLetter.space() +
            amount.getAmount() + "개" + CommonLetter.newLine();
    }

    public int getPrice() {
        return menu.getPrice() * amount.getAmount();
    }

    private String[] parseOrderInfo(String orderInput) {
        return ParseUtil.parseToArray(orderInput, CommonLetter.menuAmountSeparator());
    }
}
