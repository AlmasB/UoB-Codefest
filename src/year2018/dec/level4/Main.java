package year2018.dec.level4;

/**
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
                Main::challenge6
        };

        for (int i = 0; i < challenges.length; i++) {
            System.out.println("Challenge " + (i + 1));
            count = 1;

            challenges[i].run();
        }
    }

    private static void challenge1() {
        test(c.challenge1("Hello") == 5);
        test(c.challenge1("H") == 1);
        test(c.challenge1("Brighton University") == 19);
    }

    private static void challenge2() {
        test(c.challenge2("Hello") == 2);
        test(c.challenge2("H") == 0);
        test(c.challenge2("Brighton University") == 6);
    }

    private static void challenge3() {
        test(c.challenge3(1, 2) == 9);
        test(c.challenge3(2, 2) == 16);
        test(c.challenge3(2, 4) == 36);
    }

    private static void challenge4() {
        test(c.challenge4(1, 2, 3) == 2);
        test(c.challenge4(4, 1, 5) == 4);
        test(c.challenge4(5, 3, 7) == 5);
    }

    private static void challenge5() {
        test(c.challenge5(3, 4) == 5);
        test(c.challenge5(8, 6) == 10);
        test(c.challenge5(5, 12) == 13);
    }

    private static void challenge6() {
        test(c.challenge6(0, 0, 20, 20) == 400);
        test(c.challenge6(15, 10, 30, 15) == 75);
        test(c.challenge6(5, 20, 10, 30) == 50);
    }

    private static void test(boolean result) {
        System.out.println("Input " + (count++) + ": " + (result ? "OK" : "FAIL!"));
    }
}
