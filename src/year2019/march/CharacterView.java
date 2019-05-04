package year2019.march;

import javafx.beans.binding.Bindings;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
public class CharacterView extends Parent {

    private BaseCharacter character;

    public CharacterView(BaseCharacter character) {
        this.character = character;

        Rectangle bg = new Rectangle(200, 40, null);
        bg.setArcWidth(15);
        bg.setArcHeight(15);
        bg.setStroke(Color.BLACK);
        bg.setStrokeWidth(2.5);

        Rectangle bar = new Rectangle(198, 38);
        bar.setTranslateX(1);
        bar.setTranslateY(1);

        bar.widthProperty().bind(character.hp.divide(150.0).multiply(198));
        bar.fillProperty().bind(
                Bindings.when(character.hp.greaterThan(50)).then(Color.LIGHTGREEN).otherwise(Color.RED)
        );

        getChildren().addAll(bar, bg);


    }

}
