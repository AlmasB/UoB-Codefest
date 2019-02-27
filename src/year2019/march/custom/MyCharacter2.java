package year2019.march.custom;

import year2019.march.BaseCharacter;
import year2019.march.Move;
import year2019.march.MoveType;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
public class MyCharacter2 extends BaseCharacter {

    public MyCharacter2() {
        super();

        addIntellect(30);
    }

    @Override
    public Move makeMove(BaseCharacter other) {
        if (Math.random() < 0.5) {
            return new Move(MoveType.ATTACK);
        }

        if (Math.random() < 0.5) {
            return new Move(MoveType.BLOCK);
        }

        return new Move(MoveType.SKILL);
    }
}
