package year2019.jan;

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
        test(c.challenge1("I") == 1);
        test(c.challenge1("IV") == 4);
        test(c.challenge1("XX") == 20);
        test(c.challenge1("XXIII") == 23);
        test(c.challenge1("MM") == 2000);
        test(c.challenge1("MMXIX") == 2019);
        test(c.challenge1("MXXIV") == 1024);
    }

    private static void challenge2() {
        test(c.challenge2("University of Brighton", "Behring nifty virtuoso"));
        test(c.challenge2("Computer Science", "cement occupiers"));
        test(c.challenge2("software tools", "flowers tatoos"));
    }

    private static void challenge3() {
        int[] input1 = {10, 20, 30, 40};

        test(Arrays.equals(new int[] {0, 2}, c.challenge3(input1, 40)));

        int[] input2 = {10, 30, 50, 80};

        test(Arrays.equals(new int[] {1, 3}, c.challenge3(input2, 110)));
    }

    private static void challenge4() {
        test(c.challenge4(1590233) == 103);
        test(c.challenge4(510885549) == 589);
        test(c.challenge4(-8134772) == -842);
    }

    private static void challenge5() {
        test(c.challenge5("Aoaxascebmkc").equals("python"));
        test(c.challenge5("baifbbad").equals("code"));
        test(c.challenge5("tcecqh").equals("why"));
    }

    private static void test(boolean result) {
        System.out.println("Input " + (count++) + ": " + (result ? "OK" : "FAIL!"));
    }
}
