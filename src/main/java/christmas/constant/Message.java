package christmas.constant;

public enum Message {
    EVENT_INTRODUCE("안녕하세요! 우테코 식당 "+EventInfo.EVENT_MONTH.getNumber()+"월 이벤트 플래너입니다."),
    ASK_FOR_RESERVATION_MONTH(EventInfo.EVENT_MONTH.getNumber()+"월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해주세요!)"),
    ASK_FOR_MENU_AND_AMOUNT("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
