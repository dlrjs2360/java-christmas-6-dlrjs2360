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
    public void printTotalOrder(TotalOrder totalOrder) {
        ConsoleUtil.printMessage(Message.totalOrderHeader()
            + CommonLetter.newLine() + totalOrder.toString());
    }

    public void printPreBenefitMessage(int reservationDate) {
        ConsoleUtil.printMessage(EventDate.eventMonth()
            + "월 " + reservationDate + "일" + Message.preBenefitIntroduce());
    }

    public void printTotalPrice(int totalPrice) {
        ConsoleUtil.printMessage(Message.totalPriceHeader() + CommonLetter.newLine()
            + ParseUtil.parseToThousandUnit(totalPrice));
    }

    public void printGift(boolean canGetGift) {
        ConsoleUtil.printMessage(Message.giftHeader() + CommonLetter.newLine()
            + parseGift(canGetGift));
    }

    public void printDiscountTable(HashMap<DiscountCategory, Integer> discountTable) {
        ConsoleUtil.printMessage(Message.discountTableHeader() + CommonLetter.newLine()
            + parseDiscountTable(discountTable));
    }

    public void printTotalDiscountPrice(int totalDiscountedPrice) {
        ConsoleUtil.printMessage(Message.totalDiscountPriceHeader() + CommonLetter.newLine()
            + parseTotalDiscountPrice(totalDiscountedPrice));
    }

    public void printExpectedPrice(int expectedPrice) {
        ConsoleUtil.printMessage(Message.expectedPriceHeader() + CommonLetter.newLine()
            + ParseUtil.parseToThousandUnit(expectedPrice));
    }

    public void printBadge(String badge) {
        ConsoleUtil.printMessage(Message.badgeHeader() + CommonLetter.newLine() + badge);
    }

    private String parseDiscountTable(HashMap<DiscountCategory, Integer> discountTable) {
        if (discountTable.isEmpty()) {
            return Message.nonProfit();
        }
        return arrangeDiscountTable(discountTable);
    }

    private String parseGift(boolean canGetGift) {
        if (!canGetGift) {
            return Message.nonProfit();
        }
        return Gift.GIFT_MENU.toString();
    }

    private String arrangeDiscountTable(HashMap<DiscountCategory, Integer> discountTable) {
        return discountTable.entrySet().stream()
            .map(entry -> entry.getKey().getName() + " " + ParseUtil.addMinusSign(
                    ParseUtil.parseToThousandUnit(entry.getValue())))
            .collect(Collectors.joining(CommonLetter.newLine()));
    }

    private String parseTotalDiscountPrice(int totalDiscountedPrice) {
        String parsedPrice = ParseUtil.parseToThousandUnit(totalDiscountedPrice);
        if (totalDiscountedPrice > 0) {
            return ParseUtil.addMinusSign(parsedPrice);
        }
        return parsedPrice;
    }


}
