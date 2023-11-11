package christmas.util;

import christmas.constant.CommonLetter;
import java.util.Arrays;
import java.util.List;

public class ParseUtil {
    public static int parseToInt(String number) {
        return Integer.parseInt(number);
    }

    public static List<String> parseToList(String order, String separator) {
        return Arrays.asList(order.split(separator));
    }

    public static String[] parseToArray(String order, String separator) {
        return order.split(separator);
    }
}
