package christmas.view;

import christmas.constant.CommonLetter;
import christmas.constant.EventDate;
import christmas.constant.Gift;
import christmas.constant.Message;
import christmas.domain.TotalOrder;
import christmas.util.ConsoleUtil;

public class OutputView {

    public void printTotalOrder(TotalOrder totalOrder) {
        ConsoleUtil.print(CommonLetter.NEW_LINE.getLetter());
        ConsoleUtil.println(Message.TOTAL_ORDER_HEADER.getMessage());
        ConsoleUtil.print(totalOrder.toString());
    }

    public void printPreBenefitMessage(int reservationDate) {
        StringBuilder sb = new StringBuilder()
            .append(EventDate.EVENT_MONTH.getNumber())
            .append("월 ")
            .append(reservationDate)
            .append("일")
            .append(Message.PRE_BENEFIT_INTRODUCE.getMessage());
        ConsoleUtil.println(sb.toString());
    }

    public void printTotalPrice(int totalPrice) {
        StringBuilder sb = new StringBuilder()
            .append(CommonLetter.NEW_LINE.getLetter())
            .append(Message.TOTAL_PRICE_HEADER.getMessage())
            .append(CommonLetter.NEW_LINE.getLetter())
            .append(totalPrice)
            .append("원");
        ConsoleUtil.println(sb.toString());
    }

    public void printGift(boolean canGetGift) {
        ConsoleUtil.print(CommonLetter.NEW_LINE.getLetter());
        ConsoleUtil.println(Message.GIFT_HEADER.getMessage());
        if (canGetGift) {
            ConsoleUtil.println(Gift.GIFT_MENU.toString());
            return;
        }
        ConsoleUtil.println(Message.DISCOUNT_NON_PROFIT.getMessage());
    }

    public void printDiscountTable(String discountTable) {
        ConsoleUtil.print(CommonLetter.NEW_LINE.getLetter());
        ConsoleUtil.println(Message.DISCOUNT_TABLE_HEADER.getMessage());
        ConsoleUtil.print(discountTable);
    }

    public void printTotalDiscountPrice(String totalDiscountedPrice) {
        ConsoleUtil.println(
            CommonLetter.NEW_LINE.getLetter()
                + Message.TOTAL_DISCOUNT_PRICE_HEADER.getMessage()
                + CommonLetter.NEW_LINE.getLetter()
                + "-"
                + totalDiscountedPrice
                + "원");
    }

    public void printExpectedPrice(String expectedPrice) {
        ConsoleUtil.println(
            CommonLetter.NEW_LINE.getLetter()
                + Message.EXPECTED_PRICE_HEADER.getMessage()
                + CommonLetter.NEW_LINE.getLetter()
                + expectedPrice
                + "원");
    }

    public void printBadge(String badge) {
        ConsoleUtil.println(
            CommonLetter.NEW_LINE.getLetter()
                + Message.BADGE_HEADER.getMessage()
                + CommonLetter.NEW_LINE.getLetter()
                + badge);
    }
}
