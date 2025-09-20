package edu.up.cs301.TexasHoldEm;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceView;


public class RiverView extends SurfaceView {

    //instance variables
    private Model RiverModel;

    //Paint for the background

    public RiverView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.RiverModel = new Model();
        setWillNotDraw(false);
    }

    public void drawRiver(Canvas canvas){

    }


    @Override
    public void onDraw (Canvas canvas){

    }

    public Model getRiverModel(){
        return this.RiverModel;
    }

}