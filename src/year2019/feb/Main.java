package year2019.feb;

import javafx.geometry.Point2D;

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
                Main::challenge5,
                Main::challenge6,
                Main::challenge7,
                Main::challenge8,
                Main::challenge9,
                Main::challenge10
        };

        for (int i = 0; i < challenges.length; i++) {
            System.out.println("Challenge " + (i + 1));
            count = 1;

            challenges[i].run();
            System.out.println();
        }
    }

    private static void challenge1() {
        test(c.challenge1(new int[] { 1, 3, 5, 7 }) == 9);
        test(c.challenge1(new int[] { -5, 10, -15, 7 }) == 30);
        test(c.challenge1(new int[] { 4, 6, -8, 10, 12 }) == 20);
    }

    private static void challenge2() {
        test(c.challenge2("LRUD").equals(new Point2D(0, 0)));
        test(c.challenge2("L2LRL").equals(new Point2D(-3, 0)));
        test(c.challenge2("U2D2DRL3").equals(new Point2D(-2, -1)));
        test(c.challenge2("LUDDR1").equals(new Point2D(0, -1)));
    }

    private static void challenge3() {
        test(c.challenge3(1590233, 8537369) == 7067136);
        test(c.challenge3(510885549, 497981190) == 187104459);
        test(c.challenge3(-8134772, 3726139) == 5612647);
    }

    private static void challenge4() {
        test(c.challenge4(1, 0) == 0);
        test(c.challenge4(1, 1) == 45);
        test(c.challenge4(-1, -1) == 225);
        test(c.challenge4(0, -1) == 270);
    }

    private static void challenge5() {
        test(c.challenge5("One hundred and thirty five") == 135);
        test(c.challenge5("Two hundred and sixty three") == 263);
        test(c.challenge5("Twenty five") == 25);
    }

    private static void challenge6() {
        test(c.challenge6("The official University of Brighton Codefest! Will you participate?") == 1);
        test(c.challenge6("Once you know what this challenge is about, it will be much easier to solve the challenge, won't it?") == 3);
        test(c.challenge6("Come on! Give us a smile - you are on camera!") == 2);
        test(c.challenge6("Right... How many clues will it take them to solve this ...") == 2);
    }

    private static void challenge7() {
        for (int i = 0; i < 10; i++) {
            test(c.challenge7() == i*i);
        }
    }

    private static void challenge8() {
        test(c.challenge8(25, "sqrt") == 5);
        test(c.challenge8(30, "square") == 900);
        test(c.challenge8(81, "sqrt sqrt quad sqrt") == 9);
        test(c.challenge8(2, "quad square") == 256);
    }

    private static void challenge9() {
        test(c.challenge9("racecar") == 0);
        test(c.challenge9("abba") == 0);
        test(c.challenge9("ab") == 1);
        test(c.challenge9("abad") == 1);
        test(c.challenge9("abcd") == 3);
    }

    private static void challenge10() {
        test(c.challenge10("forTest10a", "!").equals("Ensure your Solutions class does not reference Main!"));
        test(c.challenge10("forTest10b", ":)").equals("Good luck! :)"));
    }

    private String forTest10a(String s) {
        return "Ensure your Solutions class does not reference Main" + s;
    }

    private String forTest10b(String s) {
        return "Good luck! " + s;
    }

    private static void test(boolean result) {
        System.out.println("Input " + (count++) + ": " + (result ? "OK" : "FAIL!"));
    }
}
