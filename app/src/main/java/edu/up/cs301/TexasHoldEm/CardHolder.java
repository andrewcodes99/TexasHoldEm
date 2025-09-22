package edu.up.cs301.TexasHoldEm;

import java.util.ArrayList;

public class CardHolder {
    private final int MAX_HAND_LENGTH;
    private ArrayList<Card> hand;
    private int chipInventory;

    public CardHolder(int chipInventory, final int MAX_HAND_LENGTH){
        hand = new ArrayList<>();
        this.chipInventory = chipInventory;
        this.MAX_HAND_LENGTH = MAX_HAND_LENGTH;
    }

    //getters
    public ArrayList<Card> getHand() {  return hand;  }
    public int getChipInventory() {  return chipInventory;  }

    //setters
    public void setHand(Card c) {
        if(hand.size() <= MAX_HAND_LENGTH){
            hand.add(c);
        }
    }
    //don't really need this. but if we want to slow down
    //dealing, it is visually necessary
    public void removeHand(){
        for(int i = 0; i < hand.size(); i++){
            hand.remove(i);
        }
    }
    public void updateChipInventory(int chipInventory){
        this.chipInventory = chipInventory;
    }
}
