package edu.up.cs301.TexasHoldEm;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList<Card> deck;


    //https://stackoverflow.com/questions/1104975/a-for-loop-to-iterate-over-an-enum-in-java
    public Deck(){

        deck = new ArrayList<>();
        for (Card.SUIT suit : Card.SUIT.values()) {
            for (Card.VALUE value : Card.VALUE.values()) {
                deck.add(new Card(suit, value, false, false, deck.size()-1));
            }
        }
    }//constructor

    public void shuffleDeck(){
        for (int i = 0; i < deck.size(); i++) {
            deck.get(i).resetCard();
        }
    }

    //returns cardID so that the card can be added to players hand
    public void dealCards(CardHolder recipient){
        Random rand = new Random();
        int cardID = rand.nextInt(52); //0 - 51
        while (deck.get(cardID).getDealt()){
            cardID = rand.nextInt(52);
        }
        Card c = deck.get(cardID).dealCard();
        recipient.setHand(c);
    }

    public void flipCards(int cardID){ //0-51
        deck.get(cardID).flipCard();
    }
}


