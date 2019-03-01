package year2019.march;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import year2019.march.custom.MyCharacter;
import year2019.march.custom.MyCharacter2;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
public class CharacterFightApp extends Application {

    private TextArea output = new TextArea();
    private AnimationTimer timer;
    private double t = 0;

    private BaseCharacter char1;
    private BaseCharacter char2;

    private Parent createContent() {
        output.setFont(Font.font(48));

        StackPane root = new StackPane();
        root.getChildren().add(output);

        initGame();

        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                t += 0.016;

                if (t > 1) {
                    onUpdate();
                    t = 0;
                }
            }
        };
        timer.start();

        return root;
    }

    private void initGame() {
        char1 = new MyCharacter();
        char2 = new MyCharacter2();
    }

    private void onUpdate() {
        Move move1 = char1.makeMove(char2);
        Move move2 = char2.makeMove(char1);

        MoveResult result = move1.getType().checkAgainst(move2.getType());

        if (result == MoveResult.DRAW) {

            pushMessage("Both players used " + move1.getType() + "! Rolling dice!");

            int die1 = CombatMath.getRandomValue(char1.getLuck());
            int die2 = CombatMath.getRandomValue(char1.getLuck());

            if (die1 == die2) {
                pushMessage("Both players rolled " + die1 + "! No damage to either.");
            } else if (die1 > die2) {

                pushMessage(char1.getName() + " is lucky!");

                dealDamage(char1, char2, move1.getType());

            } else { // die2 > die1

                pushMessage(char2.getName() + " is lucky!");

                dealDamage(char2, char1, move2.getType());
            }

        } else if (result == MoveResult.WIN) {

            dealDamage(char1, char2, move1.getType());

        } else { // LOSE

            dealDamage(char2, char1, move2.getType());
        }

        if (char1.isDead()) {
            timer.stop();
            pushMessage(char2.getName() + " wins!");

        } else if (char2.isDead()) {
            timer.stop();
            pushMessage(char1.getName() + " wins!");
        }
    }

    private void dealDamage(BaseCharacter atk, BaseCharacter target, MoveType moveType) {
        if (target.isInvulnerable()) {
            pushMessage(atk.getName() + " does no damage with " + moveType + ". " + target.getName() + " is invulnerable!");
            return;
        }

        int dmg = atk.getDamageFrom(moveType);

        double dmgModifier = atk.getWeaponElement().getDamageModifierAgainst(target.getArmorElement());

        dmg = (int)(dmg * dmgModifier + 1);

        boolean isCrit = atk.isCritical();

        if (isCrit) {
            dmg = (int)(dmg * 1.3);
        }

        target.takeDamage(dmg);

        // reset crit status for both
        atk.reset();

        pushMessage(
                (isCrit ? "CRITICAL! " : "") +
                        atk.getName() + " uses " + moveType + " to deal " + dmg + " " + atk.getWeaponElement() + " damage to " + target.getName()
        );
    }

    private void pushMessage(String text) {
        output.appendText(text + "\n\n");
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(createContent()));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
