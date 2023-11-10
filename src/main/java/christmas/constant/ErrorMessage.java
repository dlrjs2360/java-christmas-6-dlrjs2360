package christmas.constant;

public enum ErrorMessage {
    RESERVATION_INPUT_ERROR("유효하지 않은 날짜입니다. 다시 입력해 주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR]"+message;
    }
}
