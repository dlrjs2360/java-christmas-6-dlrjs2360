package christmas.controller;

import christmas.constant.message.CommonLetter;
import christmas.domain.TotalOrder;
import christmas.domain.Reservation;
import christmas.util.ConsoleUtil;
import christmas.util.ParseUtil;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.List;

public class EventController {

    private final InputView inputView;
    private final OutputView outputView;

    private Reservation reservation;
    private TotalOrder totalOrder;
    private DiscountController discountController;

    public EventController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        initEvent();
        printBenefits();
    }

    private void initEvent() {
        introduceEvent();
        initReservation();
        initOrder();
    }

    private void printBenefits() {
        printPreBenefitMessage();
        printTotalOrder();
        initDiscountController();
        printTotalPrice();
        printGift();
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
            reservation = new Reservation(inputView.askForReservationMonth());
        } catch (IllegalArgumentException e) {
            ConsoleUtil.printMessage(e.getMessage());
            initReservation();
        }
    }

    private void initOrder() {
        try {
            totalOrder = new TotalOrder(separateOrderInput());
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

    private void printGift() {
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
