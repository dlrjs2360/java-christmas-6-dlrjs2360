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
import christmas.validator.TotalOrderValidator;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.List;

public class EventController {

    InputView inputView;
    OutputView outputView;

    ReservationValidator reservationValidator;
    OrderValidator orderValidator;
    OrderAmountValidator orderAmountValidator;
    OrderMenuValidator orderMenuValidator;
    TotalOrderValidator totalOrderValidator;

    Reservation reservation;
    TotalOrder totalOrder;
    DiscountController discountController;

    public EventController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.reservationValidator = new ReservationValidator();
        this.orderValidator = new OrderValidator();
        this.orderAmountValidator = new OrderAmountValidator();
        this.orderMenuValidator = new OrderMenuValidator();
        this.totalOrderValidator = new TotalOrderValidator();
    }

    public void run() {
        introduceEvent();
        initReservation();
        initOrder();
        printPreBenefitMessage();
        printTotalOrder();
        initDiscountController();
        printTotalPrice();
        printGit();
        printDiscountTable();
        printTotalDiscountPrice();
    }

    void introduceEvent() {
        inputView.introduceEvent();
    }

    void initReservation() {
        try {
            reservation = new Reservation(inputView.askForReservationMonth(), reservationValidator);
        } catch (IllegalArgumentException e) {
            ConsoleUtil.println(e.getMessage());
            initReservation();
        }
    }

    void initOrder() {
        try {
            List<String> seperatedOrderInput = ParseUtil.parseToList(
                inputView.askForMenuAndAmount(), CommonLetter.ORDER_SEPARATOR.getLetter());
            List<Order> orders = seperatedOrderInput.stream()
                .map(purchase -> new Order(purchase, orderValidator, orderMenuValidator,
                    orderAmountValidator))
                .toList();
            totalOrder = new TotalOrder(orders, totalOrderValidator);
        } catch (IllegalArgumentException e) {
            ConsoleUtil.println(e.getMessage());
            initOrder();
        }
    }

    void printPreBenefitMessage() {
        outputView.printPreBenefitMessage(reservation.getReservationDate());
    }

    void printTotalOrder() {
        outputView.printTotalOrder(totalOrder);
    }

    void initDiscountController() {
        discountController = new DiscountController(totalOrder,reservation.getReservationDate());
    }

    private void printTotalPrice() {
        outputView.printTotalPrice(discountController.getNotDiscountedPrice());
    }

    private void printGit() {
        outputView.printGift(discountController.canGetGift());
    }

    private void printDiscountTable() {
        outputView.printDiscountTable(discountController.initDiscountTable());
    }

    private void printTotalDiscountPrice() {
        outputView.printTotalDiscountPrice(discountController.getTotalDiscountedPrice());
    }
}
