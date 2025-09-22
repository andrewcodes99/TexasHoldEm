package edu.up.cs301.TexasHoldEm;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Andrew, Alex
 *
 * @desc Creates a deck object (an array list of cards)
 * When a card is dealt, a card property will be toggled.
 * When the deck is shuffled, the dealt properties of the
 * cards will be set to false, allowing them to be selected
 * again.
 */
public class Deck {
    private ArrayList<Card> deck;


    //https://stackoverflow.com/questions/1104975/a-for-loop-to-iterate-over-an-enum-in-java
    public Deck(){
        //TODO: deck.size-1 might not be right
        deck = new ArrayList<>();
        //add a card for all 52 cards that exist within the deck
        for (Card.SUIT suit : Card.SUIT.values()) {
            for (Card.VALUE value : Card.VALUE.values()) {
                deck.add(new Card(suit, value, false, false, deck.size()-1));
            }
        }
    }//constructor

    public void shuffleDeck(){
        for (int i = 0; i < deck.size(); i++) {
            deck.get(i).resetCard(); //flipped and dealt = false;
        }
    }

    //returns cardID so that the card can be added to players hand
    public void dealCards(CardHolder recipient){
        Random rand = new Random();
        int cardID = rand.nextInt(52); //0 - 51
        //if we pick a card that has already been dealt, try again
        while (deck.get(cardID).getDealt()){
            cardID = rand.nextInt(52);
        }
        Card c = deck.get(cardID).dealCard();
        //add the dealt card to the receiving player hand
        recipient.setHand(c);
    }

    //used for the river, and any hands left after betting
    public void flipCards(int cardID){ //0-51
        deck.get(cardID).flipCard();
    }
}


