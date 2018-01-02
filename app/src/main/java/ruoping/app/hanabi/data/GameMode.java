package ruoping.app.hanabi.data;

import java.util.ArrayList;

/**
 * Created by ruoping on 12/29/17.
 */

public final class GameMode {
    public static String NORMAL_STR = "Normal"; // 0
    public static String RAINBOW_STR = "Rainbow"; // 1

    public static int NORMAL = 0; // 0
    public static int RAINBOW = 1; // 1

    public static int getDeckSize(int gameMode) {
        switch (gameMode) {
            case 0:     //Normal
                return 25;
            case 1:     //Rainbow
                return 30;
            default:    //invalid input
                return -1;
        }
    }

    public static int getColorCount(int gameMode) {
        switch (gameMode) {
            case 0:     //Normal
                return 5;
            case 1:     //Rainbow
                return 6;
            default:    //invalid input
                return -1;
        }
    }

    public static ArrayList<String> getAllModesStr() {
        ArrayList<String> allModes = new ArrayList<>();
        allModes.add(NORMAL_STR);
        allModes.add(RAINBOW_STR);
        return allModes;
    }

    public static ArrayList<Integer> getAllModes() {
        ArrayList<Integer> allModes = new ArrayList<>();
        allModes.add(NORMAL);
        allModes.add(RAINBOW);
        return allModes;
    }

    public static String toString(int gameMode) {
        switch (gameMode) {
            case 0:
                return NORMAL_STR;
            case 1:
                return RAINBOW_STR;
            default:
                return "";
        }
    }

    public static int toInt(String gameMode) {
        switch (gameMode) {
            case "Normal":
                return NORMAL;
            case "Rainbow":
                return RAINBOW;
            default:
                return -1;
        }
    }
}
