package christmas.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.constant.event.Menu;
import christmas.constant.message.CommonLetter;
import christmas.util.ParseUtil;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TotalOrderTest {

    @Test
    @DisplayName("주문한 메뉴의 총 가격을 계산할 수 있다.")
    void total_Order_Can_calculate_Total_Price() {
        // given
        String orderInput = "아이스크림-1,레드와인-1";
        List<String> parsedOrderInput = ParseUtil.parseToList(orderInput, CommonLetter.orderSeparator());
        TotalOrder totalOrder = new TotalOrder(parsedOrderInput);

        // when
        int actual = totalOrder.getTotalPrice();

        // then
        assertEquals(actual, Menu.ICE_CREAM.getPrice()+Menu.RED_WINE.getPrice());
    }

    @Test
    @DisplayName("주문한 메뉴의 카테고리별 개수를 확인할 수 있다.")
    void total_Order_Count_Per_Category_Can_Get() {
        // given
        String orderInput = "아이스크림-1,레드와인-1";
        List<String> parsedOrderInput = ParseUtil.parseToList(orderInput, CommonLetter.orderSeparator());
        TotalOrder totalOrder = new TotalOrder(parsedOrderInput);

        // when
        int actual = totalOrder.getCategoryChecker().get(Menu.ICE_CREAM.getCategory());

        // then
        assertEquals(actual, 1);
    }
}