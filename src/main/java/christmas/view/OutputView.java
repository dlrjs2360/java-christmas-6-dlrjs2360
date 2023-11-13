package christmas.view;

import christmas.constant.CommonLetter;
import christmas.constant.DiscountCategory;
import christmas.constant.EventDate;
import christmas.constant.Gift;
import christmas.constant.Message;
import christmas.domain.TotalOrder;
import christmas.util.ConsoleUtil;
import christmas.util.ParseUtil;
import java.util.HashMap;
import java.util.stream.Collectors;

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
        String sb = CommonLetter.NEW_LINE.getLetter()
            + Message.TOTAL_PRICE_HEADER.getMessage()
            + CommonLetter.NEW_LINE.getLetter()
            + ParseUtil.parseToThousandUnit(totalPrice)
            + "원";
        ConsoleUtil.println(sb);
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

    public void printDiscountTable(HashMap<DiscountCategory, Integer> discountTable) {
        ConsoleUtil.println(
            CommonLetter.NEW_LINE.getLetter()
                + Message.DISCOUNT_TABLE_HEADER.getMessage()
                + CommonLetter.NEW_LINE.getLetter()
                + discountTable.entrySet().stream()
                .map(entry -> entry.getKey().getName() + " : " + "-" + ParseUtil.parseToThousandUnit(entry.getValue()) + "원")
                .collect(Collectors.joining(CommonLetter.NEW_LINE.getLetter()))
        );
    }

    public void printTotalDiscountPrice(int totalDiscountedPrice) {
        ConsoleUtil.println(
            CommonLetter.NEW_LINE.getLetter()
                + Message.TOTAL_DISCOUNT_PRICE_HEADER.getMessage()
                + CommonLetter.NEW_LINE.getLetter()
                + "-"
                + ParseUtil.parseToThousandUnit(totalDiscountedPrice)
                + "원");
    }

    public void printExpectedPrice(int expectedPrice) {
        ConsoleUtil.println(
            CommonLetter.NEW_LINE.getLetter()
                + Message.EXPECTED_PRICE_HEADER.getMessage()
                + CommonLetter.NEW_LINE.getLetter()
                + ParseUtil.parseToThousandUnit(expectedPrice)
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
