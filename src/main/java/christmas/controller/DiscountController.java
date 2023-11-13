package christmas.controller;

import christmas.constant.Badge;
import christmas.constant.Calender;
import christmas.constant.DayOfWeek;
import christmas.constant.DiscountAmount;
import christmas.constant.DiscountCategory;
import christmas.constant.DiscountCriteria;
import christmas.constant.Gift;
import christmas.constant.Menu.Category;
import christmas.constant.SpecialDay;
import christmas.domain.TotalOrder;
import christmas.util.ConsoleUtil;
import christmas.util.ParseUtil;
import java.util.HashMap;
import java.util.stream.Collectors;

public class DiscountController {

    private final TotalOrder totalOrder;
    private final int day;
    private final int totalPrice;
    private final HashMap<DiscountCategory, Integer> discountTable = new HashMap<>();

    public DiscountController(TotalOrder totalOrder, int day) {
        this.day = day;
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

    public HashMap<DiscountCategory,Integer> initDiscountTable() {
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
            giftPrice = Gift.GIFT_MENU.getGiftPrice();
        }
        return totalPrice - getTotalDiscountedPrice() + giftPrice;
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
        discountTable.put(DiscountCategory.CHRISTMAS_EVENT, getChristmasEventDiscount());
    }

    private void calculateWeekDiscount() {
        if (isWeekend()) {
            discountTable.put(DiscountCategory.WEEKEND_EVENT,
                getWeekDiscount(totalOrder.getCategoryChecker().get(Category.MAIN_DISH)));
            return;
        }
        discountTable.put(DiscountCategory.WEEKDAY_EVENT,
            getWeekDiscount(totalOrder.getCategoryChecker().get(Category.DESSERT)));
    }

    private void calculateSpecialDayDiscount() {
        if (SpecialDay.SPECIAL_DAY.isSpecialDay(day)) {
            discountTable.put(DiscountCategory.SPECIAL_DAY, DiscountAmount.SPECIAL_DAY.getAmount());
        }
    }

    private void calculateGiftDiscount() {
        if (canGetGift()) {
            discountTable.put(DiscountCategory.GIFT_EVENT, Gift.GIFT_MENU.getGiftPrice());
        }
    }

    private int getChristmasEventDiscount() {
        return DiscountAmount.calculateChristmasDiscount(day);
    }

    private int getWeekDiscount(int discountMenuCount) {
        return getDayOfWeek().getDiscountAmount() * discountMenuCount;
    }

    private boolean isWeekend() {
        return getDayOfWeek().isWeekend();
    }

    private DayOfWeek getDayOfWeek() {
        return DayOfWeek.valueOf(Calender.getDayOfWeek(day).toString());
    }

    public String getBadge() {
        return Badge.getBadge(getTotalDiscountedPrice());
    }


}
