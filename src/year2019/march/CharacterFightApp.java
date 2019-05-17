package year2019.march;

import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import year2019.march.custom.MyCharacter;
import year2019.march.custom.MyCharacter2;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
public class CharacterFightApp extends Application {

    private static final double TURN_DELAY = 2.0;

    private Pane root = new Pane();
    private TextArea output = new TextArea();
    private CharacterView view1;
    private CharacterView view2;

    private AnimationTimer timer;
    private double t = 0;

    private BaseCharacter char1;
    private BaseCharacter char2;

    private Parent createContent() {
        root.setPrefSize(1600, 900);
        root.setBackground(null);

        output.setFont(Font.font(48));
        output.setTranslateY(200);

        initGame();

        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                t += 0.016;

                if (t > TURN_DELAY) {
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

        view1 = new CharacterView(char1);
        view2 = new CharacterView(char2);

        view1.setLayoutX(10);
        view1.setLayoutY(10);

        view2.layoutXProperty().bind(root.widthProperty().subtract(230 + 10));
        view2.setLayoutY(10);

        root.getChildren().setAll(view1, view2, output);
    }

    private void onUpdate() {
        Move move1 = char1.makeMove(char2);
        Move move2 = char2.makeMove(char1);

        char1.addOpponentMove(move2);
        char2.addOpponentMove(move1);

        MoveResult result = move1.getType().checkAgainst(move2.getType());

        if (result == MoveResult.DRAW) {

            pushMessage("Both players used " + move1.getType() + "! No damage to either!");

        } else if (result == MoveResult.WIN) {

            dealDamage(char1, char2, move1.getType());

        } else { // LOSE

            dealDamage(char2, char1, move2.getType());
        }

        // reset status for both
        char1.onMoveFinished();
        char2.onMoveFinished();

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
            playAttackAnimation(atk, 0);

            pushMessage(atk.getName() + " does no damage with " + moveType + ". " + target.getName() + " is invulnerable!");
            return;
        }

        int dmg = atk.getDamageFrom(moveType);

        double dmgModifier = atk.getWeaponElement().getDamageModifierAgainst(target.getArmorElement());

        dmg = (int)(dmg * dmgModifier + 1);

        boolean isCrit = atk.isCritical();

        if (isCrit) {
            dmg = (int)(dmg * 1.75);
        }

        target.takeDamage(dmg);

        playAttackAnimation(atk, dmg);

        pushMessage(
                (isCrit ? "CRITICAL! " : "") +
                        atk.getName() + " uses " + moveType + " to deal " + dmg + " " + atk.getWeaponElement() + " damage to " + target.getName()
        );
    }

    private void playAttackAnimation(BaseCharacter character, int dmg) {
        CharacterView view = character == char1 ? view1 : view2;

        TranslateTransition tt = new TranslateTransition(Duration.seconds(0.33), view);
        tt.setAutoReverse(true);
        tt.setCycleCount(2);
        tt.setFromX(0);
        tt.setToX(view == view1 ? root.getWidth() / 2 : - root.getWidth() / 2);
        tt.setOnFinished(e -> {

            Text textDamage = new Text("" + dmg);
            textDamage.setFont(Font.font(58));
            textDamage.setTranslateX(root.getWidth() / 2);
            textDamage.setTranslateY(200);

            root.getChildren().add(textDamage);

            TranslateTransition tt2 = new TranslateTransition(Duration.seconds(1.5), textDamage);
            tt2.setToY(-10);
            tt2.setOnFinished(e2 -> root.getChildren().remove(textDamage));
            tt2.play();
        });
        tt.play();
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
