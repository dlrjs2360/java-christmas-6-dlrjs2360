package christmas.domain;

import christmas.constant.CommonLetter;
import christmas.constant.Menu;
import christmas.util.ParseUtil;
import christmas.validator.OrderAmountValidator;
import christmas.validator.OrderMenuValidator;
import christmas.validator.OrderValidator;

public class Order {

    private final OrderMenu menu;
    private final OrderAmount amount;

    public Order(String orderInput,
        OrderValidator orderValidator,
        OrderMenuValidator orderMenuValidator,
        OrderAmountValidator orderAmountValidator)
    {
        validate(orderInput, orderValidator);
        String[] validatedOrderInfo = ParseUtil.parseToArray(orderInput,
            CommonLetter.MENU_AMOUNT_SEPARATOR.getLetter());
        this.menu = new OrderMenu(validatedOrderInfo[0], orderMenuValidator);
        this.amount = new OrderAmount(validatedOrderInfo[1], orderAmountValidator);
    }

    void validate(String purchase, OrderValidator orderValidator) {
        orderValidator.validate(purchase);
    }

    public Menu getMenu() {
        return menu.getMenu();
    }

    public int getAmount() {
        return amount.getAmount();
    }
}
