package christmas;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.constant.message.CommonLetter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EventTest extends NsTest {

    @Test
    @DisplayName("특별한 날에는 특별 할인이 적용된다.")
    void get_Special_Discount() {
        assertSimpleTest(() -> {
            run("24", "아이스크림-1,레드와인-1");
            assertThat(output()).contains(
                "특별 할인:" + CommonLetter.space() + "-1,000원"
            );
        });
    }

    @Test
    @DisplayName("이벤트 날짜 전까지는 디데이 할인이 적용된다.")
    void get_Dday_Discount_Before_Event_Day() {
        assertSimpleTest(() -> {
            run("25", "아이스크림-1,레드와인-1");
            assertThat(output()).contains(
                "크리스마스 디데이 할인:" + CommonLetter.space() + "-3,400원"
            );
        });
    }

    @Test
    @DisplayName("이벤트 날짜를 넘으면 디데이 할인이 적용되지 않는다.")
    void get_Dday_Discount() {
        assertSimpleTest(() -> {
            run("26", "아이스크림-1,레드와인-1");
            assertThat(output()).doesNotContain(
                "크리스마스 디데이 할인:" + CommonLetter.space() + "-3,400원"
            );
        });
    }

    @Test
    @DisplayName("일정 금액 이상 구매 시 선물을 증정한다.")
    void canGetGift() {
        assertSimpleTest(() -> {
            run("3", "아이스크림-1,레드와인-2");
            assertThat(output()).contains(
                "<증정 메뉴>" + CommonLetter.newLine() +
                    "샴페인 1개"
            );
        });
    }

    @Test
    @DisplayName("평일에는 디저트 메뉴에 개당 할인 혜택을 제공한다.")
    void get_Benefits_With_Weekday() {
        assertSimpleTest(() -> {
            run("5", "초코케이크-1,제로콜라-1");
            assertThat(output()).contains(
                "평일 할인:" + CommonLetter.space() + "-2,023원"
            );
        });
    }

    @Test
    @DisplayName("주말에는 메인 메뉴에 개당 할인 혜택을 제공한다.")
    void get_Benefits_With_Weekend() {
        assertSimpleTest(() -> {
            run("8", "티본스테이크-2,제로콜라-1");
            assertThat(output()).contains(
                "주말 할인:" + CommonLetter.space() + "-4,046원"
            );
        });
    }

    @Test
    @DisplayName("총구매금액이 일정 금액을 넘지 않으면 할인 혜택이 제공되지 않는다.")
    void no_Benefits_With_Under_Purchase_Price() {
        assertSimpleTest(() -> {
            run("1", "아이스크림-1,제로콜라-1");
            assertThat(output()).contains(
                "<혜택 내역>" + CommonLetter.newLine() +
                    "없음"
            );
        });
    }

    @Test
    @DisplayName("일정 금액 이하의 할인을 받으면 뱃지를 획득하지 못한다.")
    void no_Badge_With_Under_Benefits() {
        assertSimpleTest(() -> {
            run("3", "초코케이크-1,제로콜라-1");
            assertThat(output()).contains(
                "<12월 이벤트 배지>" + CommonLetter.newLine() +
                    "없음"
            );
        });
    }

    @Test
    @DisplayName("일정 금액 이상의 할인을 받으면 뱃지를 획득한다.")
    void get_Badge_With_Over_Benefits() {
        assertSimpleTest(() -> {
            run("3", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).contains(
                "<12월 이벤트 배지>" + CommonLetter.newLine() +
                    "산타"
            );
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
