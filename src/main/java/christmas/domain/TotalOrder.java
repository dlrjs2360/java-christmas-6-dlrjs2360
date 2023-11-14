package christmas.domain;

import christmas.constant.event.Menu.Category;
import christmas.validator.OrderAmountValidator;
import christmas.validator.OrderMenuValidator;
import christmas.validator.OrderValidator;
import christmas.validator.TotalOrderValidator;
import java.util.HashMap;
import java.util.List;

public class TotalOrder {

    private final List<Order> orders;
    private final HashMap<Category, Integer> categoryChecker;

    public TotalOrder(List<String> seperatedOrder, TotalOrderValidator totalOrderValidator
        , OrderValidator orderValidator, OrderMenuValidator orderMenuValidator,
        OrderAmountValidator orderAmountValidator) {
        List<Order> parsedOrders = initOrders(seperatedOrder, orderValidator, orderMenuValidator,
            orderAmountValidator);
        validate(parsedOrders, totalOrderValidator);
        this.categoryChecker = totalOrderValidator.getCategoryCheck();
        this.orders = parsedOrders;
    }

    private void validate(List<Order> orders, TotalOrderValidator totalOrderValidator) {
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

    private List<Order> initOrders(List<String> orderInput, OrderValidator orderValidator,
        OrderMenuValidator orderMenuValidator, OrderAmountValidator orderAmountValidator) {
        return orderInput.stream().map(
                order -> new Order(order, orderValidator, orderMenuValidator, orderAmountValidator))
            .toList();
    }

}
