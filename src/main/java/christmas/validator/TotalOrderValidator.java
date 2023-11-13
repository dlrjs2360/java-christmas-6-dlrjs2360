package christmas.validator;

import christmas.constant.message.ErrorMessage;
import christmas.constant.event.Menu;
import christmas.constant.event.Menu.Category;
import christmas.constant.event.OrderLimit;
import christmas.domain.Order;
import java.util.HashMap;
import java.util.List;

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
            validateMenuCheck(order); // 디미터 법칙 위반
            validateTotalAmount(totalAmount + order.getAmount());
            addTotalAmount(order);
            addMenu(order);
            checkCategoryAmount(order);
        }
        validateOnlyDrink();
    }

    private void init() {
        totalAmount = 0;
        menuCheck = new HashMap<>();
        categoryCheck = new HashMap<>();
    }

    private void addTotalAmount(Order order) {
        totalAmount += order.getAmount();
    }

    private void addMenu(Order order) {
        menuCheck.put(order.getMenuName(), true);
    }

    private void checkCategoryAmount(Order order) {
        categoryCheck.put(
            order.getMenu().getCategory(),
            categoryCheck.getOrDefault(order.getMenuCategory(), 0) + order.getAmount());
    }

    private void validateTotalAmount(int totalAmount) {
        if (totalAmount > OrderLimit.ORDER_AMOUNT_MAX.getNumber()) {
            throwException(ErrorMessage.INVALID_ORDER);
        }
    }

    private void validateMenuCheck(Order order) {
        if (menuCheck.getOrDefault(order.getMenuName(), false)) {
            throwException(ErrorMessage.INVALID_ORDER);
        }
    }

    private void validateOnlyDrink() {
        if (categoryCheck.keySet().size() == 1 && categoryCheck.containsKey(Menu.Category.DRINK)) {
            throwException(ErrorMessage.INVALID_ORDER);
        }
    }
}
