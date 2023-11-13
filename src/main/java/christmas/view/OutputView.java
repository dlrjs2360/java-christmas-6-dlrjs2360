package christmas.view;

import christmas.constant.message.CommonLetter;
import christmas.constant.discount.DiscountCategory;
import christmas.constant.event.EventDate;
import christmas.constant.event.Gift;
import christmas.constant.message.Message;
import christmas.domain.TotalOrder;
import christmas.util.ConsoleUtil;
import christmas.util.ParseUtil;
import java.util.HashMap;
import java.util.stream.Collectors;

public class OutputView {

    private final String NEW_LINE = CommonLetter.NEW_LINE.getLetter();
    private final String NON_PROFIT = Message.DISCOUNT_NON_PROFIT.getMessage();

    public void printTotalOrder(TotalOrder totalOrder) {
        ConsoleUtil.printMessage(Message.TOTAL_ORDER_HEADER.getMessage()
            + NEW_LINE + totalOrder.toString());
    }

    public void printPreBenefitMessage(int reservationDate) {
        ConsoleUtil.printMessage(EventDate.EVENT_MONTH.getNumber()
            + "월 " + reservationDate + "일" + Message.PRE_BENEFIT_INTRODUCE.getMessage());
    }

    public void printTotalPrice(int totalPrice) {
        ConsoleUtil.printMessage(Message.TOTAL_PRICE_HEADER.getMessage() + NEW_LINE
            + ParseUtil.parseToThousandUnit(totalPrice));
    }

    public void printGift(boolean canGetGift) {
        ConsoleUtil.printMessage(Message.GIFT_HEADER.getMessage() + NEW_LINE
            + parseGift(canGetGift));
    }

    public void printDiscountTable(HashMap<DiscountCategory, Integer> discountTable) {
        ConsoleUtil.printMessage(Message.DISCOUNT_TABLE_HEADER.getMessage() + NEW_LINE
            + parseDiscountTable(discountTable));
    }

    public void printTotalDiscountPrice(int totalDiscountedPrice) {
        ConsoleUtil.printMessage(Message.TOTAL_DISCOUNT_PRICE_HEADER.getMessage() + NEW_LINE
            + parseTotalDiscountPrice(totalDiscountedPrice));
    }

    public void printExpectedPrice(int expectedPrice) {
        ConsoleUtil.printMessage(Message.EXPECTED_PRICE_HEADER.getMessage() + NEW_LINE
            + ParseUtil.parseToThousandUnit(expectedPrice));
    }

    public void printBadge(String badge) {
        ConsoleUtil.printMessage(Message.BADGE_HEADER.getMessage() + NEW_LINE + badge);
    }

    private String parseDiscountTable(HashMap<DiscountCategory, Integer> discountTable) {
        if (discountTable.isEmpty()) {
            return NON_PROFIT;
        }
        return arrangeDiscountTable(discountTable);
    }

    private String parseGift(boolean canGetGift) {
        if (!canGetGift) {
            return NON_PROFIT;
        }
        return Gift.GIFT_MENU.toString();
    }

    private String arrangeDiscountTable(HashMap<DiscountCategory, Integer> discountTable) {
        return discountTable.entrySet().stream()
            .map(entry -> entry.getKey().getName() + " " + ParseUtil.addMinusSign(
                    ParseUtil.parseToThousandUnit(entry.getValue())))
            .collect(Collectors.joining(CommonLetter.NEW_LINE.getLetter()));
    }

    private String parseTotalDiscountPrice(int totalDiscountedPrice) {
        String parsedPrice = ParseUtil.parseToThousandUnit(totalDiscountedPrice);
        if (totalDiscountedPrice > 0) {
            return ParseUtil.addMinusSign(parsedPrice);
        }
        return parsedPrice;
    }


}
