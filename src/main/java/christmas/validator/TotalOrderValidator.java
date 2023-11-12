package christmas.validator;

import christmas.constant.ErrorMessage;
import christmas.constant.EventInfo;
import christmas.constant.Menu;
import christmas.domain.Order;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TotalOrderValidator implements Validator<List<Order>> {

    int totalAmount;
    HashMap<String, Boolean> menuCheck;
    Set<Menu.Category> categoryCheck;

    @Override
    public void validate(List<Order> orders) {
        init();
        for (Order order : orders) {
            validateMenuCheck(order.getMenu().getName());
            validateTotalAmount(totalAmount + order.getAmount());
            totalAmount += order.getAmount();
            menuCheck.put(order.getMenu().getName(), true);
            categoryCheck.add(order.getMenu().getCategory());
        }
        validateOnlyDrink();
    }

    private void init() {
        totalAmount = 0;
        menuCheck = new HashMap<>();
        categoryCheck = new HashSet<>();
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

    private void validateOnlyDrink() {
        if (categoryCheck.size() == 1 && categoryCheck.contains(Menu.Category.DRINK)) {
            throwException(ErrorMessage.INVALID_ORDER);
        }
    }
}
