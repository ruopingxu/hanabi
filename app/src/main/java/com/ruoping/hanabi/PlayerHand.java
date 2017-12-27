package com.ruoping.hanabi;

import java.util.ArrayList;

/**
 * Created by ruoping on 12/26/17.
 *
 * Structure that contains all the cards in a player's hand.
 */

class PlayerHand {
    // decides if the user can see the cards.
    boolean isSelfPlayer;
    ArrayList<HanabiCard> cards;

    public PlayerHand(boolean isSelfPlayer, ArrayList<HanabiCard> startingCards) {
        this.isSelfPlayer = isSelfPlayer;
        this.cards = startingCards;
    }

    /**
     * Play a card from this hand, based on the card's location. Because that's all the player
     * can input.
     * @param cardIndex
     */
    public void playCard(int cardIndex) {
        HanabiCard playedCard = cards.remove(cardIndex);
        // put this card on the appropriate slot on the table
        // maybe update lives left
        // maybe update hints left
    }

}
