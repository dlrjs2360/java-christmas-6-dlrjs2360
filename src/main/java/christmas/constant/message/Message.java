package christmas.constant.message;

import christmas.constant.event.EventDate;
import christmas.constant.event.EventLocation;

public enum Message {
    EVENT_INTRODUCE("안녕하세요! " + EventLocation.getLocationName() + " "
        + EventLocation.getLocationCategory() + " " + EventDate.eventMonth()
        + "월 이벤트 플래너입니다."),
    ASK_FOR_RESERVATION_DAY(
        EventDate.eventMonth() + "월 중 " + EventLocation.getLocationCategory()
            + " 예상 방문 날짜는 언제인가요? (숫자만 입력해주세요!)"),
    ASK_FOR_MENU_AND_AMOUNT("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),
    PRE_BENEFIT_INTRODUCE("에 " + EventLocation.getLocationName() + CommonLetter.space()
        + EventLocation.getLocationCategory() + "에서 받을 이벤트 혜택 미리 보기!"),
    TOTAL_ORDER_HEADER(CommonLetter.newLine() + "<주문 메뉴>"),
    TOTAL_PRICE_HEADER("<할인 전 총주문 금액>"),
    DISCOUNT_NON_PROFIT("없음"),
    GIFT_HEADER(CommonLetter.newLine() + "<증정 메뉴>"),
    DISCOUNT_TABLE_HEADER(CommonLetter.newLine() + "<혜택 내역>"),
    TOTAL_DISCOUNT_PRICE_HEADER(CommonLetter.newLine() + "<총혜택 금액>"),
    EXPECTED_PRICE_HEADER(CommonLetter.newLine() + "<할인 후 예상 결제 금액>"),
    BADGE_HEADER(
        CommonLetter.newLine() + "<" + EventDate.eventMonth() + "월 이벤트 배지>");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static String nonProfit() {
        return DISCOUNT_NON_PROFIT.getMessage();
    }

    public static String introduce() {
        return EVENT_INTRODUCE.getMessage();
    }

    public static String askForReservationDay() {
        return ASK_FOR_RESERVATION_DAY.getMessage();
    }

    public static String askForMenuAndAmount() {
        return ASK_FOR_MENU_AND_AMOUNT.getMessage();
    }

    public static String preBenefitIntroduce() {
        return PRE_BENEFIT_INTRODUCE.getMessage();
    }

    public static String totalOrderHeader() {
        return TOTAL_ORDER_HEADER.getMessage();
    }

    public static String totalPriceHeader() {
        return TOTAL_PRICE_HEADER.getMessage();
    }

    public static String giftHeader() {
        return GIFT_HEADER.getMessage();
    }

    public static String discountTableHeader() {
        return DISCOUNT_TABLE_HEADER.getMessage();
    }

    public static String totalDiscountPriceHeader() {
        return TOTAL_DISCOUNT_PRICE_HEADER.getMessage();
    }

    public static String expectedPriceHeader() {
        return EXPECTED_PRICE_HEADER.getMessage();
    }

    public static String badgeHeader() {
        return BADGE_HEADER.getMessage();
    }
}
