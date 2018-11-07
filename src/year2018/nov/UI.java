package year2018.nov;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.text.Font;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
class UI {

    private GraphicsContext g;
    private final int width;
    private final int height;

    UI(GraphicsContext g) {
        this.g = g;
        width = (int) g.getCanvas().getWidth();
        height = (int) g.getCanvas().getHeight();
    }

    void draw(WeatherData data) {
        // CODEFEST: REPLACE CODE BELOW

        g.setFont(Font.font(68));
        g.fillText(data.getCityName(), 50, 100);
        g.fillText(String.valueOf(data.getTemperature()) + " C", 50, 170);
    }
}
