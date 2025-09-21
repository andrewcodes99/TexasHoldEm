package edu.up.cs301.TexasHoldEm;

import java.util.ArrayList;

//going to need something to assign a bot or user to a playerID
//still need to create functionality for both

public class Player extends CardHolder{
    private boolean isDealer;
    private boolean exists;
    private boolean folded;

    public Player(){
        super(1000, 2);
        this.isDealer = false;
        this.exists = false;
        this.folded = false;
    }

    //setters
    //Does the player exist within the context of them game
    public void setExists(boolean exists){  this.exists = exists;  }
    public void setDealer(boolean isDealer){  this.isDealer = isDealer;  }
    public void setFolded(boolean folded){  this.folded = folded;  }

    //getters
    public boolean isDealer(){  return isDealer;  }
    public boolean playerExists(){  return exists;  }
    public boolean playerFolded(){  return folded;  }
}
