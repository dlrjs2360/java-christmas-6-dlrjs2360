package christmas.constant.discount;

public enum DiscountCriteria {

    DISCOUNT_START(10_000),
    GIFT(120_000);

    private final int price;

    DiscountCriteria(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public boolean canGetGift(int totalPrice) {
        return totalPrice >= GIFT.getPrice();
    }

    public boolean canGetDiscount(int totalPrice) {
        return totalPrice >= DISCOUNT_START.getPrice();
    }
}
