package christmas.validator;

import christmas.constant.CommonLetter;
import christmas.constant.ErrorMessage;

public class OrderValidator implements Validator<String> {
    public void validate(String order) {
        isSplitWithSeparator(order);
    }

    void isSplitWithSeparator(String order) {
        if (order.split(CommonLetter.MENU_AMOUNT_SEPARATOR.getLetter()).length != 2) {
            throwException(ErrorMessage.INVALID_ORDER);
        }
    }

}
