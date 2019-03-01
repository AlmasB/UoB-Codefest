package year2019.march.custom;

import year2019.march.BaseCharacter;
import year2019.march.Element;
import year2019.march.Move;
import year2019.march.MoveType;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
public class MyCharacter2 extends BaseCharacter {

    public MyCharacter2() {
        setName("Character 2");

        addIntellect(15);
        addLuck(15);

        setArmorElement(Element.AIR);
        setWeaponElement(Element.FIRE);
    }

    @Override
    protected Move makeMove(BaseCharacter other) {
        setNextMoveAsCritical();
        setNextMoveInvulnerable();

        if (Math.random() < 0.5) {
            return new Move(MoveType.ATTACK);
        }

        if (Math.random() < 0.5) {
            return new Move(MoveType.BLOCK);
        }

        return new Move(MoveType.SKILL);
    }
}
