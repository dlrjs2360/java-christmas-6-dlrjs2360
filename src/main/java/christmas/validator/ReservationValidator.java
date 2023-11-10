package christmas.validator;

import christmas.constant.ErrorMessage;
import christmas.constant.EventInfo;
import christmas.util.ParseUtil;

public class ReservationValidator implements Validator<String> {

    public void validate(String reservationNumber) {
        isNumeric(reservationNumber);
        isInRange(ParseUtil.parseToInt(reservationNumber));
    }

    public void isNumeric(String reservationNumber) {
        try {
            Integer.parseInt(reservationNumber);
        } catch (NumberFormatException e) {
            throwException(ErrorMessage.RESERVATION_INPUT_ERROR);
        }
    }

    public void isInRange(int reservationNumber) {
        if (reservationNumber < EventInfo.EVENT_START_DAY.getNumber() || reservationNumber > EventInfo.EVENT_END_DAY.getNumber()) {
            throwException(ErrorMessage.RESERVATION_INPUT_ERROR);
        }
    }
}
