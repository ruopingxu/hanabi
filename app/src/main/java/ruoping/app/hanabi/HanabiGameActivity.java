package ruoping.app.hanabi;

import ruoping.app.hanabi.HanabiCard.Color;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;

public class HanabiGameActivity extends AppCompatActivity {
    public static final int MAX_LIVES = 4;
    public static final int MIN_LIVES = 0;
    public static final int MAX_HINTS = 8;
    public static final int MIN_HINTS = 0;
    public static final int CARDS_PER_COLOR = 5;

    public HashMap<Color, int[]> playedCards;
    public int livesLeft;
    public int hintsLeft;
    public ArrayList<HanabiCard> deck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        playedCards.put(Color.BLUE, new int[CARDS_PER_COLOR]);
        playedCards.put(Color.GREEN, new int[CARDS_PER_COLOR]);
        playedCards.put(Color.RED, new int[CARDS_PER_COLOR]);
        playedCards.put(Color.WHITE, new int[CARDS_PER_COLOR]);
        playedCards.put(Color.YELLOW, new int[CARDS_PER_COLOR]);
        playedCards.put(Color.RAINBOW, new int[CARDS_PER_COLOR]);

        livesLeft = MAX_LIVES;
        hintsLeft = MAX_HINTS;

        deck = shuffleDeck();


        setContentView(ruoping.app.hanabi.R.layout.fragment_card_table);
        setContentView(ruoping.app.hanabi.R.layout.activity_hanabi_game);
//        Intent intent = getIntent();
//        String playerName = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
//        TextView playerNameView = (TextView) findViewById(R.id.playerNameView);
//        playerNameView.setText(playerName);
    }

    public static ArrayList<HanabiCard> shuffleDeck(){
        return new ArrayList<>();
    }

    // how to display cards as buttons?
    // create a "hand" of cards, and display them on screen
    // make each card a button
}
