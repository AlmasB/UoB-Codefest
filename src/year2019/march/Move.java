package year2019.march;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
public class Move {

    private final MoveType type;

    public Move(MoveType type) {
        this.type = type;
    }

    public MoveType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Move:" + type.toString();
    }
}
