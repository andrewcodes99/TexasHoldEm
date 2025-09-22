package edu.up.cs301.TexasHoldEm;


/**
@Author: Andrew Asch
 */
public class Card {


    //instance variables
    private SUIT suit;
    private VALUE value;
    private boolean dealt;
    private boolean flipped;
    enum SUIT{HEART, DIAMOND, CLUB, SPADE}
    enum VALUE{TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE}


    //could've added an ownedBy property, but doing so
    //would mean having to loop through 52 cards on top of everything
    //else everytime the drawing is invalidated. Super slow. Have player
    //have a hand.
    public Card(SUIT suit, VALUE value, boolean dealt, boolean flipped){
        this.suit = suit;
        this.value = value;
        this.dealt = dealt;
        this.flipped = flipped;
    }

    public boolean getDealt(){
        return dealt;
    }

    public int getCardID(SUIT suit, VALUE value){
        //https://coderanch.com/t/511143/java/casting-int-enum-type
        return 13 * suit.ordinal() + value.ordinal();
    }

    //setters
    public void dealCard(){
        this.dealt = true;
    }

    public void flipCard(){
        this.flipped = true;
    }

    public void resetCard(){
        this.dealt = false;
        this.flipped = false;
    }
}

