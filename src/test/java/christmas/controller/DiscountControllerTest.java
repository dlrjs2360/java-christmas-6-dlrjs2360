package christmas.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import christmas.constant.event.Menu;
import christmas.constant.message.CommonLetter;
import christmas.domain.TotalOrder;
import christmas.util.ParseUtil;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DiscountControllerTest {

    @Test
    @DisplayName("일정 금액 이상 구매 시 선물을 증정한다.")
    void canGetGift() {
        // given
        String orderInput = "아이스크림-1,레드와인-2";
        int day = 3;
        List<String> separatedOrderInput = ParseUtil.parseToList(orderInput, CommonLetter.orderSeparator());
        TotalOrder totalOrder = new TotalOrder(separatedOrderInput);
        DiscountController discountController = new DiscountController(totalOrder,day);

        // when
        boolean actual = discountController.canGetGift();

        // then
        assertTrue(actual);
    }

    @Test
    @DisplayName("일정 금액 이하로 구매 시 선물을 증정 받지 못한다.")
    void cannotGetGift() {
        // given
        String orderInput = "아이스크림-1,레드와인-1";
        int day = 3;
        List<String> separatedOrderInput = ParseUtil.parseToList(orderInput, CommonLetter.orderSeparator());
        TotalOrder totalOrder = new TotalOrder(separatedOrderInput);

        // when
        DiscountController discountController = new DiscountController(totalOrder,day);
        boolean actual = discountController.canGetGift();

        // then
        assertFalse(actual);
    }

    @Test
    @DisplayName("할인이 적용되지 않은 총구매금액을 계산할 수 있다.")
    void getNotDiscountedPrice() {
        // given
        String orderInput = "아이스크림-1,레드와인-1";
        int day = 3;
        List<String> separatedOrderInput = ParseUtil.parseToList(orderInput, CommonLetter.orderSeparator());
        TotalOrder totalOrder = new TotalOrder(separatedOrderInput);

        // when
        DiscountController discountController = new DiscountController(totalOrder,day);
        int actual = discountController.getNotDiscountedPrice();

        // then
        assertThat(actual).isEqualTo(Menu.ICE_CREAM.getPrice()+Menu.RED_WINE.getPrice());
    }

}