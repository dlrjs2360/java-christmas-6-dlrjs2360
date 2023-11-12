package christmas.controller;

import christmas.constant.DiscountCriteria;
import christmas.domain.TotalOrder;

public class DiscountController {

    private final TotalOrder totalOrder;

    public DiscountController(TotalOrder totalOrder) {
        this.totalOrder = totalOrder;
    }

    private boolean canGetDiscount(int totalPrice) {
        return DiscountCriteria.DISCOUNT_START.canGetDiscount(totalPrice);
    }

    public boolean canGetGift(int totalPrice) {
        return DiscountCriteria.GIFT.canGetGift(totalPrice);
    }

    public int getNotDiscountedPrice() {
        return totalOrder.getTotalPrice();
    }
}
