package year2019.march;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
public abstract class BaseCharacter {

    private String name;

    private int hp = 150;

    private int strength = 1;
    private int vitality = 1;
    private int intellect = 1;

    private int luck = 5;

    private int attributePoints = 30;

    private Element armorElement = Element.NEUTRAL;
    private Element weaponElement = Element.NEUTRAL;

    private int critCount = 2;
    private int invulCount = 1;

    private boolean isCritical = false;
    private boolean isInvulnerable = false;

    public final String getName() {
        return name;
    }

    protected final void setName(String name) {
        this.name = name;
    }

    public final int getHp() {
        return hp;
    }

    final void takeDamage(int value) {
        hp -= value;
    }

    boolean isDead() {
        return hp <= 0;
    }

    public final boolean isCritical() {
        return isCritical;
    }

    protected final void setNextMoveAsCritical() {
        if (critCount == 0)
            return;

        isCritical = true;

        // if lots of luck and 50% chance works, then this critical is free
        if (luck > 20 && Math.random() < 0.5) {
            critCount++;
        }

        critCount--;
    }

    public final int getStrength() {
        return strength;
    }

    public final int getVitality() {
        return vitality;
    }

    public final int getIntellect() {
        return intellect;
    }

    public final int getLuck() {
        return luck;
    }

    public final int getDamageFrom(MoveType type) {
        int dmg = calcDamage(type);

        // deal at least 1 damage
        return Math.max(dmg, 1);
    }

    private int calcDamage(MoveType type) {
        switch (type) {
            case ATTACK:
                return strength + CombatMath.getRandomValue(luck);
            case SKILL:
                return intellect + CombatMath.getRandomValue(luck);
            case BLOCK:
                return vitality + CombatMath.getRandomValue(luck);
            default:
                throw new RuntimeException("Can't happen! " + type);
        }
    }

    protected final void addStrength(int value) {
        checkValue(value);

        strength += value;
        attributePoints -= value;
    }

    protected final void addVitality(int value) {
        checkValue(value);

        vitality += value;
        attributePoints -= value;
    }

    protected final void addIntellect(int value) {
        checkValue(value);

        intellect += value;
        attributePoints -= value;
    }

    protected final void addLuck(int value) {
        checkValue(value);

        luck += value;
        attributePoints -= value;
    }

    protected final void setArmorElement(Element armorElement) {
        this.armorElement = armorElement;
    }

    final Element getArmorElement() {
        return armorElement;
    }

    protected final void setWeaponElement(Element weaponElement) {
        this.weaponElement = weaponElement;
    }

    final Element getWeaponElement() {
        return weaponElement;
    }

    final boolean isInvulnerable() {
        return isInvulnerable;
    }

    protected void setNextMoveInvulnerable() {
        if (invulCount == 0)
            return;

        invulCount--;
        isInvulnerable = true;
    }

    protected void resetAttributePoints() {
        strength = 1;
        vitality = 1;
        intellect = 1;

        luck = 5;

        attributePoints = 30;
    }

    final void reset() {
        isCritical = false;
        isInvulnerable = false;
    }

    protected abstract Move makeMove(BaseCharacter other);

    private void checkValue(int value) {
        if (value < 0)
            throw new RuntimeException("Value cannot be negative!");

        if (value > attributePoints)
            throw new RuntimeException("You cannot use more than 30 attribute points!");
    }
}
