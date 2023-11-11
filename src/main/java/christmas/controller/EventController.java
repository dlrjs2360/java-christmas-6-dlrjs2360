package christmas.controller;

import christmas.constant.CommonLetter;
import christmas.domain.TotalOrder;
import christmas.domain.Order;
import christmas.domain.Reservation;
import christmas.util.ConsoleUtil;
import christmas.util.ParseUtil;
import christmas.validator.OrderAmountValidator;
import christmas.validator.OrderMenuValidator;
import christmas.validator.OrderValidator;
import christmas.validator.ReservationValidator;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventController {

    InputView inputView;
    OutputView outputView;
    ReservationValidator reservationValidator;
    OrderValidator orderValidator;
    OrderAmountValidator orderAmountValidator;
    OrderMenuValidator orderMenuValidator;

    Reservation reservation;
    TotalOrder orders;

    public EventController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.reservationValidator = new ReservationValidator();
        this.orderValidator = new OrderValidator();
        this.orderAmountValidator = new OrderAmountValidator();
        this.orderMenuValidator = new OrderMenuValidator();
    }

    public void run() {
        introduceEvent();
        initReservation();
        initOrder();
    }

    public void introduceEvent() {
        inputView.introduceEvent();
    }

    public void initReservation() {
        try {
            reservation = new Reservation(inputView.askForReservationMonth(), reservationValidator);
        } catch (IllegalArgumentException e) {
            ConsoleUtil.println(e.getMessage());
            initReservation();
        }
    }

    public void initOrder() {
        try {
            orders = new TotalOrder(
                ParseUtil.parseToList(inputView.askForMenuAndAmount(),
                    CommonLetter.ORDER_SEPARATOR.getLetter()).stream()
                .map(purchase -> new Order(purchase, orderValidator, orderMenuValidator,
                    orderAmountValidator))
                .toList());
        } catch (IllegalArgumentException e) {
            ConsoleUtil.println(e.getMessage());
            initOrder();
        }
    }
}
