package year2019.march;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
public enum  Element {
    NEUTRAL(1.00, 0.75, 0.75, 0.75, 0.75),
    FIRE   (1.25, 0.00, 0.25, 0.50, 2.00),
    WATER  (1.25, 2.00, 0.00, 0.25, 0.50),
    AIR    (1.25, 0.50, 2.00, 0.00, 0.25),
    EARTH  (1.25, 0.25, 0.50, 2.00, 0.00);

    private double[] modifiers;

    Element(double... modifiers) {
        this.modifiers = modifiers;
    }

    public double getDamageModifierAgainst(Element element) {
        return this.modifiers[element.ordinal()];
    }
}
