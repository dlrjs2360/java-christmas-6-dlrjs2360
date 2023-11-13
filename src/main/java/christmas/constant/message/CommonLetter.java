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
}
