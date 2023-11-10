package christmas.controller;

import christmas.domain.Reservation;
import christmas.util.ConsoleUtil;
import christmas.validator.PurchaseValidator;
import christmas.validator.ReservationValidator;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventController {
    InputView inputView;
    OutputView outputView;
    ReservationValidator reservationValidator;
    PurchaseValidator purchaseValidator;

    Reservation reservation;

    public EventController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.reservationValidator = new ReservationValidator();
        this.purchaseValidator = new PurchaseValidator();
    }

    public void run() {
        introduceEvent();
        initReservation();
    }

    public void introduceEvent() {
        inputView.introduceEvent();
    }

    public void initReservation() {
        try {
            reservation = new Reservation(inputView.askForReservationNumber(), reservationValidator);
        } catch (IllegalArgumentException e) {
            ConsoleUtil.println(e.getMessage());
            initReservation();
        }
    }
}
