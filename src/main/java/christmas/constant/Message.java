package christmas.constant;

public enum Message {
    EVENT_INTRODUCE("안녕하세요! "+EventLocation.LOCATION_NAME.getName()+" "+ EventDate.EVENT_MONTH.getNumber()+"월 이벤트 플래너입니다."),
    ASK_FOR_RESERVATION_MONTH(
        EventDate.EVENT_MONTH.getNumber()+"월 중 "+EventLocation.LOCATION_CATEGORY.getName()+" 예상 방문 날짜는 언제인가요? (숫자만 입력해주세요!)"),
    ASK_FOR_MENU_AND_AMOUNT("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),
    PRE_BENEFIT_INTRODUCE("에 "+EventLocation.LOCATION_NAME.getName()+" "+EventLocation.LOCATION_CATEGORY.getName()+"에서 받을 이벤트 혜택 미리 보기!"),
    TOTAL_ORDER_HEADER("<주문 내역>"),
    TOTAL_PRICE_HEADER("<할인 전 총주문 금액>"),
    DISCOUNT_NON_PROFIT("없음"),
    GIFT_HEADER("<증정 메뉴>"),
    DISCOUNT_TABLE_HEADER("<혜택 내역>"),
    TOTAL_DISCOUNT_PRICE_HEADER("<총혜택 금액>"),
    EXPECTED_PRICE_HEADER("<할인 후 예상 결제 금액>"),
    BADGE_HEADER("<"+EventDate.EVENT_MONTH.getNumber()+"월 이벤트 배지>");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
