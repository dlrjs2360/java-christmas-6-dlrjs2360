package christmas.constant.message;

public enum ErrorMessage {
    INVALID_RESERVATION_DATE("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INVALID_ORDER("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    INVALID_EVENT_DATE("유효하지 않은 이벤트 날짜입니다. 다시 설정해 주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] "+message;
    }

    public static String getInvalidOrderMessage() {
        return INVALID_ORDER.getMessage();
    }

    public static String getInvalidReservationDateMessage() {
        return INVALID_RESERVATION_DATE.getMessage();
    }

    public static String getInvalidEventDateMessage() {
        return INVALID_EVENT_DATE.getMessage();
    }
}
