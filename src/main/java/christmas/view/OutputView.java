package christmas.view;

import christmas.constant.CommonLetter;
import christmas.constant.EventInfo;
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
            .append(EventInfo.EVENT_MONTH.getNumber())
            .append("월 ")
            .append(reservationDate)
            .append("일")
            .append(Message.PRE_BENEFIT_INTRODUCE.getMessage());
        ConsoleUtil.println(sb.toString());
    }
}
