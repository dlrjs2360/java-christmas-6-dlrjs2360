package christmas.validator;

import christmas.constant.event.OrderLimit;
import christmas.constant.message.ErrorMessage;

public class OrderAmountValidator implements Validator<String>{

    @Override
    public void validate(String data) {
        isNumeric(data);
        isInRange(Integer.parseInt(data));
    }

    private void isNumeric(String orderAmount) {
        try {
            Integer.parseInt(orderAmount);
        } catch (NumberFormatException e) {
            throwException(ErrorMessage.INVALID_ORDER);
        }
    }

    private void isInRange(int orderAmount) {
        if (orderAmount < OrderLimit.orderAmountMin()
            || orderAmount > OrderLimit.orderAmountMax()) {
            throwException(ErrorMessage.INVALID_ORDER);
        }
    }
}
