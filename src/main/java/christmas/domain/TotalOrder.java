package christmas.domain;

import christmas.constant.event.Menu.Category;
import christmas.validator.TotalOrderValidator;
import java.util.HashMap;
import java.util.List;

public class TotalOrder {

    private static final TotalOrderValidator totalOrderValidator;
    private final List<Order> orders;
    private final HashMap<Category, Integer> categoryChecker;

    public TotalOrder(List<String> seperatedOrder) {
        List<Order> parsedOrders = initOrders(seperatedOrder);
        validate(parsedOrders);
        this.categoryChecker = totalOrderValidator.getCategoryCheck();
        this.orders = parsedOrders;
    }

    static {
        totalOrderValidator = new TotalOrderValidator();
    }

    private void validate(List<Order> orders) {
        totalOrderValidator.validate(orders);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Order order : orders) {
            sb.append(order.toString());
        }
        return sb.toString();
    }

    public int getTotalPrice() {
        return orders.stream()
            .mapToInt(Order::getPrice)
            .sum();
    }

    public HashMap<Category, Integer> getCategoryChecker() {
        return categoryChecker;
    }

    private List<Order> initOrders(List<String> orderInput) {
        return orderInput.stream().map(Order::new).toList();
    }

}
