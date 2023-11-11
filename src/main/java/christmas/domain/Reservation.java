package christmas.domain;

import christmas.util.ParseUtil;
import christmas.validator.ReservationValidator;

public class Reservation {

    private final int reservationDate;

    public Reservation(String reservationDate, ReservationValidator reservationValidator) {
        validate(reservationDate, reservationValidator);
        this.reservationDate = ParseUtil.parseToInt(reservationDate);
    }

    void validate(String reservationNumber, ReservationValidator reservationValidator) {
        reservationValidator.validate(reservationNumber);
    }

    public int getReservationDate() {
        return reservationDate;
    }

}
