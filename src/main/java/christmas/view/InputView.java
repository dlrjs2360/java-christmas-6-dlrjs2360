package christmas.view;

import christmas.constant.Message;
import christmas.util.ConsoleUtil;

public class InputView {

    public void introduceEvent() {
        ConsoleUtil.println(Message.EVENT_INTRODUCE.getMessage());
    }

    public String askForReservationMonth() {
        ConsoleUtil.println(Message.ASK_FOR_RESERVATION_MONTH.getMessage());
        return ConsoleUtil.input();
    }

    public String askForMenuAndAmount() {
        ConsoleUtil.println(Message.ASK_FOR_MENU_AND_AMOUNT.getMessage());
        return ConsoleUtil.input();
    }
}
