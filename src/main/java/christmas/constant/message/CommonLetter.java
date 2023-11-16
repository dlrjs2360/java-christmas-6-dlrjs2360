package christmas.constant.message;

public enum CommonLetter {
    ORDER_SEPARATOR(","),
    MENU_AMOUNT_SEPARATOR("-"),
    SPACE(" "),
    NEW_LINE("\n"),
    MINUS("-");

    private final String letter;

    CommonLetter(String letter) {
        this.letter = letter;
    }

    public String getLetter() {
        return letter;
    }

    public static String space() {
        return SPACE.getLetter();
    }

    public static String newLine() {
        return NEW_LINE.getLetter();
    }

    public static String minus() {
        return MINUS.getLetter();
    }

    public static String orderSeparator() {
        return ORDER_SEPARATOR.getLetter();
    }

    public static String menuAmountSeparator() {
        return MENU_AMOUNT_SEPARATOR.getLetter();
    }

}
