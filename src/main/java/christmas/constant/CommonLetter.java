package christmas.constant;

public enum CommonLetter {
    ORDER_SEPARATOR(","),
    MENU_AMOUNT_SEPARATOR("-"),
    SPACE(" "),
    NEW_LINE("\n");

    private final String letter;

    CommonLetter(String letter) {
        this.letter = letter;
    }

    public String getLetter() {
        return letter;
    }
}
