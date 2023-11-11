package christmas.domain;

import christmas.constant.EventInfo;
import christmas.validator.TotalOrderValidator;
import java.util.List;

public class TotalOrder {
    private final List<Order> orders;

    public TotalOrder(List<Order> orders, TotalOrderValidator totalOrderValidator) {
        validate(orders, totalOrderValidator);
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


}
