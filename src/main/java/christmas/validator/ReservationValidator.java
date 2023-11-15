package christmas.validator;

import christmas.constant.event.EventDate;
import christmas.constant.message.ErrorMessage;
import christmas.util.ParseUtil;

public class ReservationValidator implements Validator<String> {

    public void validate(String reservationNumber) {
        isNumeric(reservationNumber);
        isInRange(ParseUtil.parseToInt(reservationNumber));
    }

    private void isNumeric(String reservationNumber) {
        try {
            Integer.parseInt(reservationNumber);
        } catch (NumberFormatException e) {
            throwException(ErrorMessage.INVALID_RESERVATION_DATE);
        }
    }

    private void isInRange(int reservationNumber) {
        if (reservationNumber < EventDate.eventStartDay()
            || reservationNumber > EventDate.eventEndDay()) {
            throwException(ErrorMessage.INVALID_RESERVATION_DATE);
        }
    }
}
