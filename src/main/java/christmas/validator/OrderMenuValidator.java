package christmas.validator;

import christmas.constant.message.ErrorMessage;
import christmas.constant.event.Menu;

public class OrderMenuValidator implements Validator<String>{

    @Override
    public void validate(String data) {
        isInMenu(data);
    }

    void isInMenu(String menu) {
        if (!Menu.isValueOf(menu)) {
            throwException(ErrorMessage.INVALID_ORDER);
        }
    }
}
