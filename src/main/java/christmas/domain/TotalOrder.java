package christmas.domain;

import christmas.constant.Menu;
import christmas.constant.Menu.Category;
import christmas.validator.TotalOrderValidator;
import java.util.HashMap;
import java.util.List;

public class TotalOrder {

    private final List<Order> orders;
    private final HashMap<Category, Integer> categoryChecker;

    public TotalOrder(List<Order> orders, TotalOrderValidator totalOrderValidator) {
        validate(orders, totalOrderValidator);
        this.categoryChecker = totalOrderValidator.getCategoryCheck();
        this.orders = orders;
    }

    private void validate(List<Order> orders, TotalOrderValidator totalOrderValidator) {
        totalOrderValidator.validate(orders);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Order order : orders) {
            stringBuilder.append(order.toString());
        }
        return stringBuilder.toString();
    }

    public int getTotalPrice() {
        return orders.stream()
            .mapToInt(Order::getPrice)
            .sum();
    }

    public HashMap<Category, Integer> getCategoryChecker() {
        return categoryChecker;
    }

}
