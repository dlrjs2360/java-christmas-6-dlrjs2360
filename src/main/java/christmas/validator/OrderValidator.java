package christmas.validator;

import christmas.constant.message.CommonLetter;
import christmas.constant.message.ErrorMessage;

public class OrderValidator implements Validator<String> {
    public void validate(String order) {
        isSplitWithSeparator(order);
    }

    void isSplitWithSeparator(String order) {
        if (splitOrder(order).length != 2) {
            throwException(ErrorMessage.INVALID_ORDER);
        }
    }

    private String[] splitOrder(String order) {
        return order.split(CommonLetter.MENU_AMOUNT_SEPARATOR.getLetter());
    }

}
