package christmas.validator;

import christmas.constant.ErrorMessage;
import christmas.constant.EventDate;
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
            throwException(ErrorMessage.INVALID_RESERVATION_DATE);
        }
    }

    public void isInRange(int reservationNumber) {
        if (reservationNumber < EventDate.EVENT_START_DAY.getNumber()
            || reservationNumber > EventDate.EVENT_END_DAY.getNumber()) {
            throwException(ErrorMessage.INVALID_RESERVATION_DATE);
        }
    }
}
