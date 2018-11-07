package year2018.nov;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
public class App extends Application {

    private static final int WIDTH = 600;
    private static final int HEIGHT = 800;

    private static final int SCREEN_UPDATE_SECONDS = 3;

    private List<WeatherData> dataItems = new ArrayList<>();

    private double t = 0;
    private int index = 0;

    private Parent createContent() {
        addMockData();

        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        GraphicsContext g = canvas.getGraphicsContext2D();

        UI ui = new UI(g);

        Pane root = new Pane(canvas);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                g.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

                WeatherData data = dataItems.get(index);

                ui.draw(data);

                t += 0.016;

                if (t > SCREEN_UPDATE_SECONDS) {
                    t = 0;
                    index++;

                    if (index == dataItems.size()) {
                        index = 0;
                    }
                }
            }
        };
        timer.start();

        return root;
    }

    private void addMockData() {
        dataItems.add(new WeatherData(
                "London",
                "UK",
                "Heathrow Airport",
                13.0,
                9.1,
                WeatherData.WindDirection.SOUTH,
                58.6,
                12.3,
                WeatherData.WeatherStatus.CLOUDY,
                101,
                WeatherData.PollutionLevel.LOW,
                15, 34)
        );

        dataItems.add(new WeatherData(
                "Paris",
                "France",
                "Charles de Gaulle Airport",
                16.5,
                4.5,
                WeatherData.WindDirection.EAST,
                45.1,
                3.4,
                WeatherData.WeatherStatus.SUNNY,
                101.4,
                WeatherData.PollutionLevel.MEDIUM,
                23, 11)
        );
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
