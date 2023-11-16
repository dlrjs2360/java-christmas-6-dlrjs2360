package christmas.validator;

import christmas.constant.event.Menu;
import christmas.constant.message.ErrorMessage;

public class OrderMenuValidator implements Validator<String>{

    @Override
    public void validate(String data) {
        isInMenu(data);
    }

    private void isInMenu(String menu) {
        if (!Menu.isValueOf(menu)) {
            throwException(ErrorMessage.INVALID_ORDER);
        }
    }
}
