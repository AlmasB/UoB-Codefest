package year2019.march;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
public enum MoveType {
    ATTACK, SKILL, BLOCK;

    private static final Map<MoveType, MoveType> winMap = new HashMap<>();

    static {
        winMap.put(ATTACK, SKILL);
        winMap.put(SKILL, BLOCK);
        winMap.put(BLOCK, ATTACK);
    }

    public MoveResult checkAgainst(MoveType other) {
        if (this == other)
            return MoveResult.DRAW;

        return winMap.get(this) == other ? MoveResult.WIN : MoveResult.LOSE;
    }
}
