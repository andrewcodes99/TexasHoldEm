package edu.up.cs301.TexasHoldEm;

public class Card {
    private SUIT suit;
    private VALUE value;
    private boolean dealt;
    private boolean flipped;

    private int cardID;

    enum SUIT{
        HEARTS, DIAMONDS, CLUBS, SPADES
    }

    enum VALUE{
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
    }

    //could've added an ownedBy property, but doing so
    //would mean having to loop through 52 cards on top of everything
    //else everytime the drawing is invalidated. Super slow. Have player
    //have a hand.
    public Card(SUIT suit, VALUE value, boolean dealt, boolean flipped, int cardID){
        this.suit = suit;
        this.value = value;
        this.dealt = dealt;
        this.flipped = flipped;
        this.cardID = cardID;
    }

    public boolean getDealt(){
        return dealt;
    }

    //https://stackoverflow.com/questions/6667243/using-enum-values-as-string-literals
    public String getCardName(){
        return suit.toString() + " of " + value.toString();
    }

    //https://coderanch.com/t/511143/java/casting-int-enum-type
    public int getCardID(){
        return cardID;
    }

    //setters
    public Card dealCard(){
        this.dealt = true;
        return this;
    }

    public void flipCard(){
        this.flipped = true;
    }

    public void resetCard(){
        this.dealt = false;
        this.flipped = false;
    }

    //getters
    public boolean isFlipped(){  return flipped;  }
}

