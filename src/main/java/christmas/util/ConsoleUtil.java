package christmas.util;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleUtil {
    public static void print(String message) {
        System.out.print(message);
    }

    public static void println(String message) {
        System.out.println(message);
    }

    public static String input() {
        return Console.readLine();
    }
}
