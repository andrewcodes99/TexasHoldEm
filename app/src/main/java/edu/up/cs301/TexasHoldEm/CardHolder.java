package edu.up.cs301.TexasHoldEm;

import java.util.ArrayList;

/**
 * @author Andrew
 *
 * @desc A cardholder can be a player or the
 * river. Since the river has no chips to start and
 * 5 cards max, while a player has chips to start and
 * 2 cards, we pass in these vars in the childs const.
 * The cards will be in the hand (an arrayList),
 */
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
    //adds card one by one to hand
    //TODO: add better error checking when dealing cards
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
