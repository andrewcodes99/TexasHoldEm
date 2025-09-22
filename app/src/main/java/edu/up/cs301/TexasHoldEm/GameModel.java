package edu.up.cs301.TexasHoldEm;

import android.graphics.Paint;

public class GameModel {
    public int potValue = 0;

    //which players are playing (corresponds to SV number)
    public boolean player1Exists = true;
    public boolean player2Exists = true;
    public boolean player3Exists = true;
    public boolean player4Exists = true;
    public boolean selfExists = true;
    public boolean player5Exists = true;

    //player inventory
    public int player1Value = 100;
    public int player2Value = 100;
    public int player3Value = 100;
    public int player4Value = 100;
    public int myValue = 100;
    public int player5Value = 100;


    public int riverCards = 3; //the number of river cards flipped




}
