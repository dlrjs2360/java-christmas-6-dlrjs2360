package christmas.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class OrderAmountTest {

    @Test
    @DisplayName("개수가 숫자일 때 꺼내올 수 있다.")
    void order_Amount_Can_Get() {
        // given
        String amount = "1";
        OrderAmount orderAmount = new OrderAmount(amount);

        // when
        int actual = orderAmount.getAmount();

        // then
        assertEquals(actual, Integer.parseInt(amount));
    }

    @Test
    @DisplayName("개수가 숫자가 아닐 때 예외를 던진다.")
    void order_Amount_Must_Be_Numeric() {
        // given
        String amount = "a";

        // when

        // then
        assertThrows(IllegalArgumentException.class, () -> new OrderAmount(amount));
    }

    @ParameterizedTest
    @DisplayName("개수가 범위를 벗어날 때 예외를 던진다.")
    @ValueSource(strings = {"0", "21"})
    void order_Amount_Must_Be_In_Range(String amount) {
        // given

        // when

        // then
        assertThrows(IllegalArgumentException.class, () -> new OrderAmount(amount));
    }
}