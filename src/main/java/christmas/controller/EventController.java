package christmas.controller;

import christmas.constant.message.CommonLetter;
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

    private final InputView inputView;
    private final OutputView outputView;

    private final ReservationValidator reservationValidator;
    private final OrderValidator orderValidator;
    private final OrderAmountValidator orderAmountValidator;
    private final OrderMenuValidator orderMenuValidator;
    private final TotalOrderValidator totalOrderValidator;

    private Reservation reservation;
    private TotalOrder totalOrder;
    private DiscountController discountController;

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
        printExpectedPrice();
        printBadge();
    }

    private void introduceEvent() {
        inputView.introduceEvent();
    }

    private void initReservation() {
        try {
            reservation = new Reservation(inputView.askForReservationMonth(), reservationValidator);
        } catch (IllegalArgumentException e) {
            ConsoleUtil.printMessage(e.getMessage());
            initReservation();
        }
    }

    private void initOrder() {
        try {
            totalOrder = new TotalOrder(separateOrderInput(), totalOrderValidator, orderValidator,
                orderMenuValidator, orderAmountValidator);
        } catch (IllegalArgumentException e) {
            ConsoleUtil.printMessage(e.getMessage());
            initOrder();
        }
    }

    private void printPreBenefitMessage() {
        outputView.printPreBenefitMessage(reservation.getReservationDate());
    }

    private void printTotalOrder() {
        outputView.printTotalOrder(totalOrder);
    }

    private void initDiscountController() {
        discountController = new DiscountController(totalOrder, reservation.getReservationDate());
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

    private void printExpectedPrice() {
        outputView.printExpectedPrice(discountController.getExpectedPrice());
    }

    private void printBadge() {
        outputView.printBadge(discountController.getBadge());
    }

    private List<String> separateOrderInput() {
        return ParseUtil.parseToList(inputView.askForMenuAndAmount(),
            CommonLetter.orderSeparator());
    }
}
