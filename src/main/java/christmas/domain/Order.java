package christmas.domain;

import christmas.constant.event.Menu.Category;
import christmas.constant.message.CommonLetter;
import christmas.constant.event.Menu;
import christmas.util.ParseUtil;
import christmas.validator.OrderAmountValidator;
import christmas.validator.OrderMenuValidator;
import christmas.validator.OrderValidator;
import java.util.List;

public class Order {

    private final static OrderValidator orderValidator;
    private final OrderMenu menu;
    private final OrderAmount amount;

    public Order(String orderInput){
        String[] validatedOrderInfo = parseOrderInfo(orderInput);
        this.menu = new OrderMenu(validatedOrderInfo[0]);
        this.amount = new OrderAmount(validatedOrderInfo[1]);
    }

    static {
        orderValidator = new OrderValidator();
    }

    private void validate(String purchase) {
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
