package christmas.domain;

import christmas.util.ParseUtil;
import christmas.validator.ReservationValidator;

public class Reservation {

    private final int reservationNumber;

    public Reservation(String reservationNumber, ReservationValidator reservationValidator) {
        validate(reservationNumber, reservationValidator);
        this.reservationNumber = ParseUtil.parseToInt(reservationNumber);
    }

    void validate(String reservationNumber, ReservationValidator reservationValidator) {
        reservationValidator.validate(reservationNumber);
    }

}
