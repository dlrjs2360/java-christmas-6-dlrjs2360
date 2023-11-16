package christmas.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import christmas.constant.event.Menu;
import christmas.constant.event.Menu.Category;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderMenuTest {

    @Test
    @DisplayName("주문한 메뉴를 꺼낼 수 있다.")
    void order_Menu_Can_Get() {
        // given
        String menu = "아이스크림";
        OrderMenu orderMenu = new OrderMenu(menu);

        // when
        String actual = orderMenu.getMenu().getName();

        // then
        assertEquals(actual, menu);
    }

    @Test
    @DisplayName("주문한 메뉴의 가격을 꺼낼 수 있다.")
    void order_Menu_Price_Can_Get() {
        // given
        String menu = "아이스크림";
        OrderMenu orderMenu = new OrderMenu(menu);

        // when
        int actual = orderMenu.getPrice();
        int expected = Menu.of(menu).getPrice();

        // then
        assertEquals(actual, expected);
    }

    @Test
    @DisplayName("주문한 메뉴의 카테고리를 꺼낼 수 있다.")
    void order_Menu_Category_Can_Get() {
        // given
        String menu = "아이스크림";
        OrderMenu orderMenu = new OrderMenu(menu);

        // when
        Category actual = orderMenu.getCategory();
        Category expected = Menu.of(menu).getCategory();

        // then
        assertEquals(actual, expected);
    }

    @Test
    @DisplayName("주문한 메뉴의 카테고리가 다르지 않다.")
    void order_Menu_Category_Must_Be_Same() {
        // given
        String menu = "아이스크림";
        OrderMenu orderMenu = new OrderMenu(menu);

        // when
        Category actual = orderMenu.getCategory();
        Category expected = Category.DRINK;

        // then
        assertNotEquals(actual, expected);
    }
}