package christmas.view;

import christmas.constant.message.Message;
import christmas.util.ConsoleUtil;

public class InputView {

    public void introduceEvent() {
        ConsoleUtil.printMessage(Message.EVENT_INTRODUCE.getMessage());
    }

    public String askForReservationMonth() {
        ConsoleUtil.printMessage(Message.ASK_FOR_RESERVATION_MONTH.getMessage());
        return ConsoleUtil.input();
    }

    public String askForMenuAndAmount() {
        ConsoleUtil.printMessage(Message.ASK_FOR_MENU_AND_AMOUNT.getMessage());
        return ConsoleUtil.input();
    }
}
