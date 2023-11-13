package christmas.controller;

import christmas.constant.DiscountCriteria;
import christmas.domain.TotalOrder;

public class DiscountController {

    private final TotalOrder totalOrder;
    private final int totalPrice;

    public DiscountController(TotalOrder totalOrder) {
        this.totalOrder = totalOrder;
        this.totalPrice = totalOrder.getTotalPrice();
    }

    private boolean canGetDiscount() {
        return DiscountCriteria.DISCOUNT_START.canGetDiscount(totalPrice);
    }

    public boolean canGetGift() {
        return DiscountCriteria.GIFT.canGetGift(totalPrice);
    }

    public int getNotDiscountedPrice() {
        return totalPrice;
    }
}
