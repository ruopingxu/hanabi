package ruoping.app.hanabi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.app.PLAYERNAME";
    public static final String[] GAME_MODES = {
            GameMode.Classic.toString(),
            GameMode.Rainbow.toString()
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // display picker how many players in game
        NumberPicker numberOfPlayersPicker = (NumberPicker) findViewById(R.id.numberOfPlayers);
        numberOfPlayersPicker.setMaxValue(5);
        numberOfPlayersPicker.setMinValue(2);

        // display picker for which kind of Hanabi you wanna play
        NumberPicker gameModePicker = (NumberPicker) findViewById(R.id.gameMode);
        gameModePicker.setMaxValue(GAME_MODES.length -1);
        gameModePicker.setMinValue(0);
        gameModePicker.setFormatter(new NumberPicker.Formatter() {
            @Override
            public String format(int value) {
                return GAME_MODES[value];
            }
        });
    }

    public void startGame(View view) {
        EditText playerName = (EditText) findViewById(R.id.playerName);
        String message = playerName.getText().toString();

        Intent intent = new Intent(this, HanabiGameActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    /**
     * enum for the types of Hanabi games there are, with different rules
     */
    public enum GameMode {
        Classic("Classic"),
        Rainbow("Rainbow")
        ;
        private final String mode;

        GameMode(String mode) {
            this.mode = mode;
        }

        public String toString(){
            return mode;
        }
    }
}
