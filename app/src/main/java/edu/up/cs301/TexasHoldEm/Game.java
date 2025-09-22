package edu.up.cs301.TexasHoldEm;

import java.util.ArrayList;

public class Game {
    public final int MAX_PLAYERS = 6;
    private Deck deck;
    private int playerCount;
    private ArrayList<Player> players;
    private River river;


    public Game(int playerCount){
        this.playerCount = playerCount;
        deck = new Deck();
        river = new River();
        players = new ArrayList<>();
        for(int p = 0; p < MAX_PLAYERS; p++) {
            players.add(new Player());
        }

        //toggle which players are playing
        if(playerCount == 6){
            for(int p = 0; p < playerCount; p++) {
                players.get(p).setExists(true);
            }
        }
        if(playerCount == 5){
            for(int p = 0; p < playerCount; p++) {
                players.get(p).setExists(true); //nobody in spot 6
            }
        }
        if(playerCount == 4){
            for(int p = 0; p < 3; p++) {
                //nobody in spots 4 or 6 (user is 5)
                players.get(p).setExists(true);
            }
            players.get(5).setExists(true);
        }
        if(playerCount == 3){
            players.get(1).setExists(true);
            players.get(3).setExists(true);
            players.get(5).setExists(true);
        }
        if(playerCount == 2){
            players.get(2).setExists(true);
            players.get(5).setExists(true);
        }
    }

    public int getPlayerCount(){  return playerCount;  }
    public ArrayList<Player> getPlayers(){  return players;  }
    public Player getPlayer (int i){  return players.get(i);  }
    public River getRiver(){  return river;  }
}
