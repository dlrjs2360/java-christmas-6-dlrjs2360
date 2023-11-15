package christmas.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ReservationTest {

    @Test
    @DisplayName("예약 날을 꺼낼 수 있다.")
    void reservation_Day_Can_Get() {
        // given
        String reservationDate = "15";
        Reservation reservation = new Reservation(reservationDate);

        // when
        int actual = reservation.getReservationDate();

        // then
        assertEquals(actual, Integer.parseInt(reservationDate));
    }

    @Test
    @DisplayName("예약 날이 숫자가 아닐 때 예외를 던진다.")
    void reservation_day_Must_Be_Numeric() {
        // given
        String reservationDate = "a";

        // when

        // then
        assertThrows(IllegalArgumentException.class, () -> new Reservation(reservationDate));
    }

    @ParameterizedTest
    @DisplayName("예약 날이 범위를 벗어날 때 예외를 던진다.")
    @CsvSource(value = {"0", "32", "-1"})
    void reservation_day_Must_Be_In_Range(String reservationDate) {
        // given

        // when

        // then
        assertThrows(IllegalArgumentException.class, () -> new Reservation(reservationDate));
    }

    @Test
    @DisplayName("예약 날짜가 잘못된 경우 '[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요'라는 에러 메시지를 보여 준다.")
    void reservation_Exception_Must_Throw_Right_Message() {
        // given
        String reservationDate = "-ㅁ";

        // when

        // then
        assertThatThrownBy(() -> new Reservation(reservationDate))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요");
    }
}