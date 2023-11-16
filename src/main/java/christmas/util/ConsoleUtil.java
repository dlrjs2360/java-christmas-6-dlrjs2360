package christmas.util;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleUtil {

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static String input() {
        return Console.readLine();
    }
}
