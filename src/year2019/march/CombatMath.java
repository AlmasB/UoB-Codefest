package year2019.march;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
public class CombatMath {

    /**
     * @param rangeLimit max exclusive
     * @return a value in range [0..rangeLimit)
     */
    public static int getRandomValue(int rangeLimit) {
        return (int)(Math.random() * rangeLimit);
    }

    public static int getRandomLuckDamage(int luck) {
        return (int)(getRandomValue(luck) * 0.5);
    }
}
