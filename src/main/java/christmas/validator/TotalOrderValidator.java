package christmas.validator;

import christmas.constant.ErrorMessage;
import christmas.constant.EventDate;
import christmas.constant.Menu;
import christmas.constant.Menu.Category;
import christmas.constant.OrderLimit;
import christmas.domain.Order;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TotalOrderValidator implements Validator<List<Order>> {

    int totalAmount;
    HashMap<String, Boolean> menuCheck;

    public HashMap<Category, Integer> getCategoryCheck() {
        return categoryCheck;
    }

    HashMap<Menu.Category, Integer> categoryCheck;

    @Override
    public void validate(List<Order> orders) {
        init();
        for (Order order : orders) {
            validateMenuCheck(order.getMenu().getName());
            validateTotalAmount(totalAmount + order.getAmount());
            totalAmount += order.getAmount();
            menuCheck.put(order.getMenu().getName(), true);
            categoryCheck.put(order.getMenu().getCategory(),
            categoryCheck.getOrDefault(order.getMenu().getCategory(), 0) + order.getAmount());
        }
        validateOnlyDrink();
    }

    private void init() {
        totalAmount = 0;
        menuCheck = new HashMap<>();
        categoryCheck = new HashMap<>();
    }

    private void validateTotalAmount(int totalAmount) {
        if (totalAmount > OrderLimit.ORDER_AMOUNT_MAX.getNumber()) {
            throwException(ErrorMessage.INVALID_ORDER);
        }
    }

    private void validateMenuCheck(String menuName) {
        if (menuCheck.getOrDefault(menuName, false)) {
            throwException(ErrorMessage.INVALID_ORDER);
        }
    }

    private void validateOnlyDrink() {
        if (categoryCheck.keySet().size() == 1 && categoryCheck.containsKey(Menu.Category.DRINK)) {
            throwException(ErrorMessage.INVALID_ORDER);
        }
    }
}
