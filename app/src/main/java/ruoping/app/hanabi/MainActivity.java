package ruoping.app.hanabi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;

import ruoping.app.hanabi.data.GameMode;

public class MainActivity extends AppCompatActivity {
    public static final String PLAYER_NAME = "PLAYER_NAME";
    public static final String NUMBER_OF_PLAYERS = "NUMBER_OF_PLAYERS";
    public static final String GAME_MODE = "GAME_MODE";

    private NumberPicker gameModePicker;
    private NumberPicker numberOfPlayersPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // display picker how many players in game
         numberOfPlayersPicker = (NumberPicker) findViewById(R.id.numberOfPlayers);
        numberOfPlayersPicker.setMaxValue(5);
        numberOfPlayersPicker.setMinValue(2);
        numberOfPlayersPicker.setWrapSelectorWheel(false);
        numberOfPlayersPicker.setOnValueChangedListener(new NumberOfPlayersListener());

        // display picker for which kind of Hanabi you wanna play
        gameModePicker = (NumberPicker) findViewById(R.id.gameMode);
        gameModePicker.setMaxValue(GameMode.getAllModes().size() -1);
        gameModePicker.setMinValue(0);
        gameModePicker.setFormatter(new NumberPicker.Formatter() {
            @Override
            public String format(int value) {
                return GameMode.getAllModesStr().get(value);
            }
        });
        gameModePicker.setOnValueChangedListener(new GameModeListener());
        gameModePicker.setWrapSelectorWheel(false);
    }

    public void startGame(View view) {
        EditText playerName = (EditText) findViewById(R.id.playerName);
        String message = playerName.getText().toString();

        Intent intent = new Intent(this, HanabiGameActivity.class);
        intent.putExtra(PLAYER_NAME, message);
        intent.putExtra(NUMBER_OF_PLAYERS, numberOfPlayersPicker.getValue());
        intent.putExtra(GAME_MODE, gameModePicker.getValue());
        startActivity(intent);
    }
}

class GameModeListener implements NumberPicker.OnValueChangeListener {
    @Override
    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
        int value = newVal;
    }
}

class NumberOfPlayersListener implements NumberPicker.OnValueChangeListener {
    @Override
    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
        int value = newVal;
    }
}