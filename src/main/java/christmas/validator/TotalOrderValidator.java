package christmas.validator;

import christmas.constant.ErrorMessage;
import christmas.constant.EventInfo;
import christmas.constant.Menu;
import christmas.domain.Order;
import java.util.HashMap;
import java.util.List;

public class TotalOrderValidator implements Validator<List<Order>> {

    int totalAmount = 0;
    HashMap<String, Boolean> menuCheck = new HashMap<>();

    @Override
    public void validate(List<Order> orders) {
        for (Order order : orders) {
            validateMenuCheck(order.getMenu().getName());
            validateTotalAmount(totalAmount + order.getAmount());
            totalAmount += order.getAmount();
            menuCheck.put(order.getMenu().getName(), true);
        }
    }

    private void validateTotalAmount(int totalAmount) {
        if (totalAmount > EventInfo.ORDER_AMOUNT_MAX.getNumber()) {
            throwException(ErrorMessage.INVALID_ORDER);
        }
    }

    private void validateMenuCheck(String menuName) {
        if (menuCheck.getOrDefault(menuName, false)) {
            throwException(ErrorMessage.INVALID_ORDER);
        }
    }
}
