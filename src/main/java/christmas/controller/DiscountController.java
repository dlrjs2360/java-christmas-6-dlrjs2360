package christmas.controller;

import christmas.constant.event.Badge;
import christmas.constant.calender.Calender;
import christmas.constant.calender.DayOfWeek;
import christmas.constant.discount.DiscountAmount;
import christmas.constant.discount.DiscountCategory;
import christmas.constant.discount.DiscountCriteria;
import christmas.constant.event.EventDate;
import christmas.constant.event.Gift;
import christmas.constant.event.Menu.Category;
import christmas.constant.event.SpecialDay;
import christmas.domain.TotalOrder;
import java.util.HashMap;

public class DiscountController {

    private final int day;
    private final int totalPrice;
    private final TotalOrder totalOrder;
    private final HashMap<DiscountCategory, Integer> discountTable;

    public DiscountController(TotalOrder totalOrder, int day) {
        this.day = day;
        this.totalOrder = totalOrder;
        this.totalPrice = totalOrder.getTotalPrice();
        this.discountTable = new HashMap<>();
    }

    public boolean canGetGift() {
        return DiscountCriteria.canGetGift(totalPrice);
    }

    public int getNotDiscountedPrice() {
        return totalPrice;
    }

    public HashMap<DiscountCategory, Integer> initDiscountTable() {
        calculateBenefits();
        return discountTable;
    }

    public int getTotalDiscountedPrice() {
        return discountTable.values().stream()
            .mapToInt(Integer::intValue)
            .sum();
    }

    public int getExpectedPrice() {
        int giftPrice = 0;
        if (canGetGift()) {
            giftPrice = Gift.getGiftPrice();
        }
        return totalPrice - getTotalDiscountedPrice() + giftPrice;
    }

    public String getBadge() {
        return Badge.getBadge(getTotalDiscountedPrice());
    }

    private void calculateBenefits() {
        if (!canGetDiscount()) {
            return;
        }
        calculateChristmasDiscount();
        calculateWeekDiscount();
        calculateSpecialDayDiscount();
        calculateGiftDiscount();
    }

    private void calculateChristmasDiscount() {
        if (EventDate.canGetDDayDiscount(day)) {
            discountTable.put(DiscountCategory.CHRISTMAS_EVENT, getChristmasEventDiscount());
        }
    }

    private void calculateWeekDiscount() {
        int discountAmount;
        if (isWeekend()) {
            discountAmount = getWeekDiscount(Category.MAIN_DISH);
            if (discountAmount != 0) {
                discountTable.put(DiscountCategory.WEEKEND_EVENT, discountAmount);
            }
            return;
        }
        discountAmount = getWeekDiscount(Category.DESSERT);
        if (discountAmount != 0) {
            discountTable.put(DiscountCategory.WEEKDAY_EVENT, discountAmount);
        }
    }

    private boolean canGetDiscount() {
        return DiscountCriteria.canGetDiscount(totalPrice);
    }

    private void calculateSpecialDayDiscount() {
        if (SpecialDay.isSpecialDay(day)) {
            discountTable.put(DiscountCategory.SPECIAL_DAY, DiscountAmount.getSpecialDayDiscount());
        }
    }

    private void calculateGiftDiscount() {
        if (canGetGift()) {
            discountTable.put(DiscountCategory.GIFT_EVENT, Gift.getGiftPrice());
        }
    }

    private int getChristmasEventDiscount() {
        return DiscountAmount.calculateChristmasDiscount(day);
    }

    private int getWeekDiscount(Category category) {
        return getDayOfWeek().getDiscountAmount() * totalOrder.getCategoryChecker()
            .getOrDefault(category, 0);
    }

    private boolean isWeekend() {
        return getDayOfWeek().isWeekend();
    }

    private DayOfWeek getDayOfWeek() {
        return DayOfWeek.valueOf(Calender.getDayOfWeek(day).toString());
    }


}
