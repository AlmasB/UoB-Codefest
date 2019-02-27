package year2019.march.custom;

import year2019.march.BaseCharacter;
import year2019.march.Move;
import year2019.march.MoveType;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
public class MyCharacter extends BaseCharacter {

    @Override
    public Move makeMove(BaseCharacter other) {
        return new Move(MoveType.BLOCK);
    }
}
