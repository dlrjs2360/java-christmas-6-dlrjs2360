package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import christmas.constant.event.Menu;
import christmas.constant.event.Menu.Category;
import christmas.constant.event.OrderLimit;
import christmas.constant.message.CommonLetter;
import christmas.validator.OrderAmountValidator;
import christmas.validator.OrderMenuValidator;
import christmas.validator.OrderValidator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class OrderTest {

    @Test
    @DisplayName("주문한 메뉴를 꺼낼 수 있다.")
    void order_Menu_Can_Get() {
        // given
        Menu menu = Menu.ICE_CREAM;
        String orderInput = menu.getName() + CommonLetter.menuAmountSeparator() + "1";
        Order order = new Order(orderInput);

        // when
        Menu actual = order.getMenu();

        // then
        assertThat(actual).isEqualTo(menu);
    }

    @Test
    @DisplayName("주문한 메뉴의 이름을 꺼낼 수 있다.")
    void order_Menu_Name_Can_Get() {
        // given
        Menu menu = Menu.ICE_CREAM;
        String orderInput = menu.getName() + CommonLetter.menuAmountSeparator() + "1";
        Order order = new Order(orderInput);

        // when
        String actual = order.getMenuName();

        // then
        assertThat(actual).isEqualTo(menu.getName());
    }

    @Test
    @DisplayName("주문한 메뉴의 카테고리를 꺼낼 수 있다.")
    void order_Menu_Category_Can_Get() {
        // given
        Menu menu = Menu.ICE_CREAM;
        String orderInput = menu.getName() + CommonLetter.menuAmountSeparator() + "1";
        Order order = new Order(orderInput);

        // when
        Category actual = order.getMenuCategory();

        // then
        assertThat(actual).isEqualTo(menu.getCategory());
    }

    @Test
    @DisplayName("주문한 메뉴의 개수를 꺼낼 수 있다.")
    void order_Menu_Amount_Can_Get() {
        // given
        Menu menu = Menu.ICE_CREAM;
        int amount = 1;
        String orderInput = menu.getName() + CommonLetter.menuAmountSeparator() + amount;
        Order order = new Order(orderInput);

        // when
        int actual = order.getAmount();

        // then
        assertThat(actual).isEqualTo(amount);
    }

    @Test
    @DisplayName("주문한 메뉴의 가격을 꺼낼 수 있다.")
    void order_Menu_Price_Can_Get() {
        // given
        Menu menu = Menu.ICE_CREAM;
        int amount = 1;
        String orderInput = menu.getName() + CommonLetter.menuAmountSeparator() + amount;
        Order order = new Order(orderInput);

        // when
        int actual = order.getPrice();

        // then
        assertThat(actual).isEqualTo(menu.getPrice());
    }

    @Test
    @DisplayName("주문 메뉴를 숫자로 입력할 수 없다.")
    void order_Menu_Must_Be_Literal() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Order("1-1");
        });
    }

    @Test
    @DisplayName("주문 개수를 문자로 입력할 수 없다.")
    void order_Amount_Must_Be_Numeric() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Order("아이스크림-A");
        });
    }

    @Test
    @DisplayName("메뉴판에 없는 메뉴를 주문할 수 없다.")
    void order_Menu_Must_Be_In_Board() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Order("생수-1");
        });
    }

    @ParameterizedTest
    @DisplayName("주문 개수가 정해진 개수를 벗어나면 예외가 발생한다.")
    @CsvSource(value = {"아이스크림-0", "아이스크림-21"})
    void order_Amount_Must_Be_In_Range(String orderInput) {
        assertThrows(IllegalArgumentException.class, () -> {
            new Order(orderInput + OrderLimit.orderAmountMax() + 1);
        });
    }

    @ParameterizedTest
    @DisplayName("주문 메뉴와 주문 개수를 입력할 때 구분자가 다르면 예외가 발생한다.")
    @CsvSource(value = {"아이스크림:1", "아이스크림1"})
    void order_Must_Separated_With_Separator(String orderInput) {
        assertThrows(IllegalArgumentException.class, () -> {
            new Order(orderInput);
        });
    }

    @Test
    @DisplayName("주문 상황에서 예외가 발생하면 '[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.'라는 에러 메시지를 보여 준다.")
    void order_Exception_Must_throw_Right_Message() {
        assertThatThrownBy(() -> {
            new Order("-1");
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }


}