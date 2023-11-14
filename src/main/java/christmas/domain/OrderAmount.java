package christmas.domain;

import christmas.util.ParseUtil;
import christmas.validator.OrderAmountValidator;

public class OrderAmount {
    private static final OrderAmountValidator orderAmountValidator;
    private final int amount;
    public OrderAmount(String amount) {
        validate(amount);
        this.amount = ParseUtil.parseToInt(amount);
    }

    static {
        orderAmountValidator = new OrderAmountValidator();
    }

    private void validate(String amount) {
        orderAmountValidator.validate(amount);
    }

    public int getAmount() {
        return amount;
    }
}
