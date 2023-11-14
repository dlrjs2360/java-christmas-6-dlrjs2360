package christmas.domain;

import christmas.util.ParseUtil;
import christmas.validator.ReservationValidator;

public class Reservation {

    private final int reservationDate;
    private static final ReservationValidator reservationValidator;
    public Reservation(String reservationDate) {
        validate(reservationDate);
        this.reservationDate = ParseUtil.parseToInt(reservationDate);
    }

    static {
        reservationValidator = new ReservationValidator();
    }

    private void validate(String reservationNumber) {
        reservationValidator.validate(reservationNumber);
    }

    public int getReservationDate() {
        return reservationDate;
    }

}
