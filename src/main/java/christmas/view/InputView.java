package christmas.view;

import christmas.constant.Message;
import christmas.util.ConsoleUtil;

public class InputView {

    public void introduceEvent() {
        ConsoleUtil.println(Message.EVENT_INTRODUCE.getMessage());
    }

    public String askForReservationNumber() {
        ConsoleUtil.println(Message.ASK_FOR_RESERVATION_MONTH.getMessage());
        return ConsoleUtil.input();
    }
}
