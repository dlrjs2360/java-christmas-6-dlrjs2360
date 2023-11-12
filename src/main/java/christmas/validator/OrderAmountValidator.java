package christmas.validator;

import christmas.constant.ErrorMessage;
import christmas.constant.OrderLimit;

public class OrderAmountValidator implements Validator<String>{

    @Override
    public void validate(String data) {
        isNumeric(data);
        isInRange(Integer.parseInt(data));
    }

    void isNumeric(String orderAmount) {
        try {
            Integer.parseInt(orderAmount);
        } catch (NumberFormatException e) {
            throwException(ErrorMessage.INVALID_ORDER);
        }
    }

    void isInRange(int orderAmount) {
        if (orderAmount < OrderLimit.ORDER_AMOUNT_MIN.getNumber()
            || orderAmount > OrderLimit.ORDER_AMOUNT_MAX.getNumber()) {
            throwException(ErrorMessage.INVALID_ORDER);
        }
    }
}
