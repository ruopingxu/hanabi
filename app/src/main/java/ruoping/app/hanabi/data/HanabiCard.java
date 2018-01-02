package ruoping.app.hanabi.data;

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
    private boolean numberKnown;
    private boolean colorKnown;

    public HanabiCard(int number, Color color) {
        this.number = number;
        this.color = color;
        numberKnown = false;
        colorKnown = false;
    }

    public int getNumber() {
        return number;
    }

    public Color getColor() {
        return color;
    }

    public String getImageFile() {
        return color.toString() + Integer.toString(number);
    }

    public void hintNumber() {
        numberKnown = true;
    }

    public void hintColor() {
        colorKnown = true;
    }

    public boolean isNumberKnown(){
        return numberKnown;
    }

    public boolean isColorKnown() {
        return colorKnown;
    }
}