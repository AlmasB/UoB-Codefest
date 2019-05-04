package year2019.march;

import javafx.beans.binding.Bindings;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
public class CharacterView extends Parent {

    private BaseCharacter character;

    public CharacterView(BaseCharacter character) {
        this.character = character;

        Rectangle bg = new Rectangle(230, 40, null);
        bg.setArcWidth(15);
        bg.setArcHeight(15);
        bg.setStroke(Color.BLACK);
        bg.setStrokeWidth(2.5);

        Rectangle bar = new Rectangle(bg.getWidth() - 2, 38);
        bar.setTranslateX(1);
        bar.setTranslateY(1);

        bar.widthProperty().bind(character.hp.divide(150.0).multiply(bg.getWidth() - 2));
        bar.fillProperty().bind(
                Bindings.when(character.hp.greaterThan(50)).then(Color.LIGHTGREEN).otherwise(Color.RED)
        );

        bg.visibleProperty().bind(character.hp.greaterThan(0));
        bar.visibleProperty().bind(character.hp.greaterThan(0));

        Text textWeapon = new Text();
        textWeapon.setFont(Font.font(28));
        textWeapon.textProperty().bind(character.weaponElement.asString("Weapon: %s"));
        textWeapon.setTranslateY(65);

        Text textArmor = new Text();
        textArmor.setFont(Font.font(28));
        textArmor.textProperty().bind(character.weaponElement.asString("Armour: %s"));
        textArmor.setTranslateY(65 + 35);

        getChildren().addAll(bar, bg, textWeapon, textArmor);



    }
}
