package christmas.domain;

import christmas.constant.EventInfo;
import java.util.List;

public class TotalOrder {
    private final List<Order> orders;

    public TotalOrder(List<Order> orders) {
        validate(calculateTotalAmount());
        this.orders = orders;
    }

    private void validate(int totalAmount) {
    }


}
