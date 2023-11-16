package christmas.view;

import christmas.constant.message.Message;
import christmas.util.ConsoleUtil;

public class InputView {

    public void introduceEvent() {
        ConsoleUtil.printMessage(Message.introduce());
    }

    public String askForReservationMonth() {
        ConsoleUtil.printMessage(Message.askForReservationDay());
        return ConsoleUtil.input();
    }

    public String askForMenuAndAmount() {
        ConsoleUtil.printMessage(Message.askForMenuAndAmount());
        return ConsoleUtil.input();
    }
}
