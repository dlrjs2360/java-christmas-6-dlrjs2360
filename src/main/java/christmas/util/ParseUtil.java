package christmas.util;

import christmas.constant.discount.DiscountCategory;
import christmas.constant.message.CommonLetter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ParseUtil {
    public static int parseToInt(String number) {
        return Integer.parseInt(number);
    }

    public static List<String> parseToList(String value, String separator) {
        return Arrays.asList(value.split(separator));
    }

    public static String[] parseToArray(String value, String separator) {
        return value.split(separator);
    }

    public static String parseToThousandUnit(int number) {
        return String.format("%,d원", number);
    }

    public static String addMinusSign(String price) {
        return CommonLetter.minus() + price;
    }


}
