package edu.up.cs301.TexasHoldEm;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class GameView extends SurfaceView{
    Paint greenTable = new Paint();
    Paint red = new Paint();
    Paint black = new Paint();
    //Paint greenChips = new Paint();
    //Paint blue = new Paint();


    public GameView(Context context, AttributeSet attr) {
        super(context, attr);
        setWillNotDraw(false);

        greenTable.setColor(0xFF35654D);
        greenTable.setStyle(Paint.Style.FILL);
        red.setColor(0xFFFF654D);
        red.setStyle(Paint.Style.FILL);
        black.setColor(0xFFFFFFFF);
        black.setStyle(Paint.Style.FILL);
    }




}

