package christmas.domain;

import christmas.util.ParseUtil;
import christmas.validator.OrderAmountValidator;

public class OrderAmount {
    private final int amount;

    public OrderAmount(String amount, OrderAmountValidator orderAmountValidator) {
        validate(amount, orderAmountValidator);
        this.amount = ParseUtil.parseToInt(amount);
    }

    void validate(String amount, OrderAmountValidator orderAmountValidator) {
        orderAmountValidator.validate(amount);
    }

    public int getAmount() {
        return amount;
    }
}
