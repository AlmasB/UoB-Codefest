package year2018.dec.level6;

import java.util.Arrays;

/**
 * For Year 3 (Level 6).
 *
 * @author Almas Baimagambetov
 */
public class Main {

    private static final Codefest c = new Solutions();
    private static int count = 1;

    public static void main(String[] args) {
        Runnable[] challenges = new Runnable[] {
                Main::challenge1,
                Main::challenge2,
                Main::challenge3,
                Main::challenge4,
                Main::challenge5
        };

        for (int i = 0; i < challenges.length; i++) {
            System.out.println("Challenge " + (i + 1));
            count = 1;

            challenges[i].run();
            System.out.println();
        }
    }

    private static void challenge1() {
        test(c.challenge1("3 + 5 + 7") == 15);
        test(c.challenge1("0 + -5 + -9 + 3") == -11);
        test(c.challenge1("10 * 15") == 150);
        test(c.challenge1("20 / 10") == 2);
    }

    private static void challenge2() {
        int[] input1 = {10, 20, 30, 40};

        test(Arrays.equals(new int[] {0, 2}, c.challenge2(input1, 40)));

        int[] input2 = {10, 30, 50, 80};

        test(Arrays.equals(new int[] {1, 3}, c.challenge2(input2, 110)));
    }

    private static void challenge3() {
        int[] input1 = {105, 103};
        int[] input2 = {100, 234};

        test(c.challenge3(input1, input2) == 1235);

        int[] input3 = {21, 52};
        int[] input4 = {65, 44};

        test(c.challenge3(input3, input4) == 137);
    }

    private static void challenge4() {
        test(c.challenge4(javafx.geometry.Point2D.class, 10.0, 15.0).equals(new javafx.geometry.Point2D(10.0, 15.0)));
        test(c.challenge4(java.awt.Point.Double.class, -33.0, 15.0).equals(new java.awt.Point.Double(-33.0, 15.0)));
    }

    private static void challenge5() {
        String input1 = "public int f(int i){return 3+5;}";

        test(c.challenge5(input1, 0) == 8);

        String input2 = "private static int f2(int i)\n"
                + "{\n"
                + "return i * i - 8;\n"
                + "}\n";

        test(c.challenge5(input2, 3) == 1);

        String input3 = "private static int f3(int i)\n"
                + "{\n"
                + "return i / 1 - 1;\n"
                + "}\n";

        test(c.challenge5(input3, 4) == 3);
    }

    private static void test(boolean result) {
        System.out.println("Input " + (count++) + ": " + (result ? "OK" : "FAIL!"));
    }
}
