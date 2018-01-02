package ruoping.app.hanabi;

import ruoping.app.hanabi.data.GameMode;
import ruoping.app.hanabi.data.HanabiCard;
import ruoping.app.hanabi.data.PlayerHand;
import ruoping.app.hanabi.data.HanabiCard.Color;
import ruoping.app.hanabi.fragments.CardTableFragment;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class HanabiGameActivity extends FragmentActivity implements CardTableFragment.OnFragmentInteractionListener {
    public static final int MAX_LIVES = 4;
    public static final int MIN_LIVES = 0;
    public static final int MAX_HINTS = 8;
    public static final int MIN_HINTS = 0;
    public static final int CARDS_PER_COLOR = 5;
    public static final int CARDS_PER_HAND = 5;

    public HashMap<Color, List<Boolean>> playedCards;
    public int playerCount;
    public int livesLeft;
    public int hintsLeft;
    public ArrayList<HanabiCard> deck;
    public ArrayList<PlayerHand> playerHands;
    public int gameMode;
    ImageView one, two, three, four;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hanabi_game);
        one = (ImageView) findViewById(R.id.ownCard1);
        two = (ImageView) findViewById(R.id.ownCard2);
        three = (ImageView) findViewById(R.id.ownCard3);
        four = (ImageView) findViewById(R.id.ownCard4);

        Intent intent = getIntent();
        gameMode = intent.getIntExtra(MainActivity.GAME_MODE, -1);
        playerCount = intent.getIntExtra(MainActivity.NUMBER_OF_PLAYERS, -1);

        initializeResources();
        playedCards = setupEmptyTable();
        deck = setupDeck(gameMode);
        playerHands = dealHands();

        // display your hand
        one.setImageResource(R.drawable.red1);
        two.setImageResource(R.drawable.red2);
        three.setImageResource(R.drawable.red3);
        four.setImageResource(R.drawable.red4);

        // make the cards buttons
        one.setOnClickListener(new PlayCardListener());
        two.setOnClickListener(new PlayCardListener());
        three.setOnClickListener(new PlayCardListener());
        four.setOnClickListener(new PlayCardListener());

        String playerName = intent.getStringExtra(MainActivity.PLAYER_NAME);
        TextView playerNameView = (TextView) findViewById(R.id.playerName);
        playerNameView.setText(playerName);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void displayCardTable(View view){
        Fragment fr = new CardTableFragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_card_table, fr);
        ft.commit();
    }

    public static ArrayList<HanabiCard> setupDeck(int gameMode){
        ArrayList<HanabiCard> deck = new ArrayList<>();

        //for each color
        for (int c = 0; c < GameMode.getColorCount(gameMode); c++) {
            // for each number in a color
            for (int i = 1; i <= CARDS_PER_COLOR; i++) {
                deck.add(new HanabiCard(i, HanabiCard.Color.values()[c]));
            }
        }
        Collections.shuffle(deck);
        return new ArrayList<>();
    }

    private HashMap<Color, List<Boolean>> setupEmptyTable() {
        HashMap<Color, List<Boolean>> playedCards = new HashMap<Color, List<Boolean>>();
        Boolean[] emptyCardStack = new Boolean[CARDS_PER_COLOR];
        for (Color color: Color.values()){
            playedCards.put(color, new ArrayList<>(Arrays.asList(emptyCardStack)));
        }
        return playedCards;
    }

    private void initializeResources() {
        livesLeft = MAX_LIVES;
        hintsLeft = MAX_HINTS;
    }

    private ArrayList<PlayerHand> dealHands () {
        ArrayList<PlayerHand> playerHands = new ArrayList<>();

        // draw cards into every player's hand
        for (int p = 0; p < playerCount; p++) {
            playerHands.add(new PlayerHand(p == 0 ? true:false, new ArrayList<HanabiCard>()));
            for (int c = 0; c < CARDS_PER_HAND; c++) {
                drawCard(p);
            }
        }
        return playerHands;
    }
    private void updateOwnHand() {

    }

    private void updateAllHandsImages() {

    }

    private void drawCard(int playerId) {
        playerHands.get(playerId).getCards().add(deck.remove(0));
    }

    // how to display cards as buttons?
    // create a "hand" of cards, and display them on screen
    // make each card a button
}

class PlayCardListener implements View.OnClickListener {
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.ownCard1){
            // send ownCard1 value to card table
        }
    }
}