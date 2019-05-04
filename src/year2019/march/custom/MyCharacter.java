package year2019.march.custom;

import year2019.march.BaseCharacter;
import year2019.march.Move;
import year2019.march.MoveType;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
public class MyCharacter extends BaseCharacter {

    public MyCharacter() {
        setName("Char 1");
    }

    @Override
    protected Move makeMove(BaseCharacter other) {
        if (getHp() < 50)
            setNextMoveInvulnerable();

        return new Move(MoveType.BLOCK);
    }
}
