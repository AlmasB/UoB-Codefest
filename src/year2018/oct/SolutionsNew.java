package year2018.oct;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
public class SolutionsNew implements Codefest {

    // Hint: length
    @Override
    public int challenge1(String s) {
        return s.length();
    }

    // Hint: vowels
    @Override
    public int challenge2(String s) {
        String vowels = "aeiou";
        int numVowels = 0;

        for (char c : s.toCharArray()) {
            if (vowels.contains(String.valueOf(c).toLowerCase())) {
                numVowels++;
            }
        }

        return numVowels;
    }

    // Hint: sum, then square
    @Override
    public int challenge3(int a, int b) {
        return (a + b) * (a + b);
    }

    // Hint: difference of last and previous to last
    @Override
    public int challenge4(int a, int b, int c) {
        return c + c - b;
    }

    // Hint: unique elements
    @Override
    public int challenge5(List<String> list) {
        return new HashSet<>(list).size();
    }

    // Hint: in one but not the other
    @Override
    public int challenge6(List<String> list1, List<String> list2) {
        List<String> l1 = new ArrayList<>(list1);
        List<String> l2 = new ArrayList<>(list2);

        l1.retainAll(list2);
        l2.retainAll(list1);

        return (list1.size() - l1.size()) + (list2.size() - l2.size());
    }

    // Hint: the middle
    @Override
    public int challenge7(int a, int b, int c) {
        int max = max(a, max(b, c));
        int min = min(a, min(b, c));

        if (a > min && a < max) {
            return a;
        } else if (b > min && b < max) {
            return b;
        }

        return c;
    }

    // Hint: right-angled triangle
    @Override
    public int challenge8(int a, int b) {
        return (int) Math.sqrt(a * a + b * b);
    }

    // Hint: rectangle area
    @Override
    public int challenge9(int a, int b, int c, int d) {
        return (c - a) * (d - b);
    }

    // Hint: number of k-combinations of n elements
    @Override
    public int challenge10(int a, int b) {
        return fact(b) / (fact(a) * fact(b - a));
    }

    private int fact(int n) {
        if (n == 0 || n == 1)
            return 1;
        else
            return n * fact(n - 1);
    }
}
