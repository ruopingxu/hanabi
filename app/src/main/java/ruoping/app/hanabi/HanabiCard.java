package ruoping.app.hanabi;

/**
 * Created by app on 12/26/17.
 */

public class HanabiCard {
    public enum Color {
        GREEN,
        RED,
        BLUE,
        YELLOW,
        WHITE,
        RAINBOW
    }

    private int number;
    private Color color;

    public HanabiCard(int number, Color color) {
        this.number = number;
        this.color = color;
    }

    public int getNumber() {
        return number;
    }

    public Color getColor() {
        return color;
    }

}

