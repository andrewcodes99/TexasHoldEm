package edu.up.cs301.TexasHoldEm;

public class Controller {

    private RiverView RiverView;
    private Model RiverModel;

    public Controller(RiverView rv){
        this.RiverView = rv;
        this.RiverModel = RiverView.getRiverModel();
    }

}
