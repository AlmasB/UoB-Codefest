package year2019.march;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
public abstract class BaseCharacter {

    private int hp = 100;

    private int strength = 1;
    private int vitality = 1;
    private int intellect = 1;

    private int luck = 5;

    private int attributePoints = 30;

    public final int getHp() {
        return hp;
    }

    final void takeDamage(int value) {
        hp -= value;
    }

    boolean isDead() {
        return hp <= 0;
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

    public final void addStrength(int value) {
        checkValue(value);

        strength += value;
        attributePoints -= value;
    }

    public final void addVitality(int value) {
        checkValue(value);

        vitality += value;
        attributePoints -= value;
    }

    public final void addIntellect(int value) {
        checkValue(value);

        intellect += value;
        attributePoints -= value;
    }

    public final void addLuck(int value) {
        checkValue(value);

        luck += value;
        attributePoints -= value;
    }

    public abstract Move makeMove(BaseCharacter other);

    private void checkValue(int value) {
        if (value > attributePoints) {
            throw new RuntimeException("You cannot use more than 30 attribute points!");
        }
    }
}
