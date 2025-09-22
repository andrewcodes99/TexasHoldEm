package edu.up.cs301.TexasHoldEm;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.SurfaceView;

/**
 * @Author: Andrew Asch
 * @Desc: Game view creates the Surface View and holds
 * the methods used to draw objects in the game
 */
public class GameView extends SurfaceView{


    //Instance variables
    private Game game;
    Paint white = new Paint();
    Paint red = new Paint();
    Paint blueChips = new Paint();
    Paint greenChips = new Paint();
    Paint blackChips = new Paint();


    //top left x, top left y, bottom right x, bottom right y
    public static final int cardWidth = 150;
    public static final int cardHeight = 210;
    public static final int cardSpacing = 10;
    public static final int chipRadius = 20;


    //P1 cards
    public static final int[] p1area = {0, 0, 768, 300};
    public static final int[] p1card =
            {(p1area[0]+p1area[2])/2+10, p1area[1], (p1area[0]+p1area[2])/2+cardWidth+cardSpacing,
            p1area[1]+cardHeight};
    public static final RectF p1Card1 = new RectF(p1card[0], p1card[1],p1card[2],p1card[3]);
    public static final RectF p1Card2 = new RectF(p1card[0]-cardWidth-cardSpacing, p1card[1],
            p1card[2]-cardWidth-cardSpacing, p1card[3]);

    //P2 cards
    public static final int[] p2area = {768, 0, 1536, 300};
    public static final int[] p2card =
            {(p2area[0]+p2area[2])/2+10, p2area[1], (p2area[0]+p2area[2])/2+cardWidth+cardSpacing,
            p2area[1]+cardHeight};
    public static final RectF p2Card1 = new RectF(p2card[0],p2card[1],p2card[2],p2card[3]);
    public static final RectF p2Card2 = new RectF(p2card[0]-cardWidth-cardSpacing, p2card[1],
            p2card[2]-cardWidth-cardSpacing, p2card[3]);

    //P3 cards
    public static final int[] p3area = {1536, 0, 2304, 300};
    public static final int[] p3card =
            {(p3area[0]+p3area[2])/2+10, p3area[1], (p3area[0]+p3area[2])/2+cardWidth+cardSpacing,
            p3area[1]+cardHeight};
    public static final RectF p3Card1 = new RectF(p3card[0], p3card[1], p3card[2], p3card[3]);
    public static final RectF p3Card2 = new RectF(p3card[0]-cardWidth-cardSpacing, p3card[1],
            p3card[2]-cardWidth-cardSpacing, p3card[3]);

    //P4 cards
    public static final int[] p4area = {1536, 650, 2304, 1000};
    public static final int[] p4card =
            {(p4area[0]+p4area[2])/2+10, p4area[3]-cardHeight-50,
            (p4area[0]+p4area[2])/2+cardWidth+cardSpacing, p4area[3]-50};
    public static final RectF p4Card1 = new RectF(p4card[0], p4card[1], p4card[2], p4card[3]);
    public static final RectF p4Card2 = new RectF(p4card[0]-cardWidth-cardSpacing, p4card[1],
            p4card[2]-cardWidth-cardSpacing, p4card[3]);

    //P5 cards
    public static final int[] p5area = {768, 650, 1536, 1000};
    public static final int[] p5card =
            {(p5area[0]+p5area[2])/2+10, p5area[3]-cardHeight-50,
            (p5area[0]+p5area[2])/2+cardWidth+cardSpacing, p5area[3]-50};
    public static final RectF p5Card1 = new RectF(p5card[0], p5card[1], p5card[2], p5card[3]);
    public static final RectF p5Card2 = new RectF(p5card[0]-cardWidth-cardSpacing, p5card[1],
            p5card[2]-cardWidth-cardSpacing, p5card[3]);

    //P6 cards
    public static final int[] p6area = {0, 650, 768, 1000};
    public static final int[] p6card =
            {(p6area[0]+p6area[2])/2+10, p6area[3]-cardHeight-50,
            (p6area[0]+p6area[2])/2+cardWidth+cardSpacing, p6area[3]-50};
    public static final RectF p6Card1 = new RectF(p6card[0], p6card[1], p6card[2], p6card[3]);
    public static final RectF p6Card2 = new RectF(p6card[0]-cardWidth-cardSpacing, p6card[1],
            p6card[2]-cardWidth-cardSpacing, p6card[3]);

    public static final int[] riverArea = {0, 300, 2304, 650};
    public static final int[] riverCard =
            {(riverArea[0]+riverArea[2])/4, riverArea[1]+100,
            (riverArea[0]+riverArea[2])/4+cardWidth+cardSpacing, riverArea[1]+100+cardHeight};
    public static final RectF pile = new RectF (riverCard[0] + (cardWidth * 6)+cardSpacing, riverCard[1],
            riverCard[2] + (cardWidth * 6) - cardSpacing, riverCard[3]);


    //constructor for the View
    public GameView(Context context, AttributeSet attr) {
        super(context, attr);
        setWillNotDraw(false);

        //green table
        setBackgroundColor(0xFF35654D);
        //chip/other colors
        white.setColor(0xFFE8E8E8);
        white.setStyle(Paint.Style.FILL);
        red.setColor(0xFFDF0100);
        red.setStyle(Paint.Style.FILL);
        blueChips.setColor(0xFF0071E3);
        blueChips.setStyle(Paint.Style.FILL);
        greenChips.setColor(0xFF093b27);
        greenChips.setStyle(Paint.Style.FILL);
        blackChips.setColor(0xFF2A2A28);
        blackChips.setStyle(Paint.Style.FILL);
    }

    //https://stackoverflow.com/questions/5834654/passing-arguments-to-surfaceview-via-constructor
    //need a reference to the game to determine which players and cards we need to draw
    public void passInGame(Game game){
        this.game = game;
    }

    //should see if the card is flipped or not
    public void drawCards(Canvas canvas){
        if (game.getPlayers().get(0).playerExists()){
            //game.getPlayer(1).getHand(0);
            canvas.drawBitmap(createCardImage(0),null, p1Card1, null);
            //game.getPlayer(1).getHand(1);
            canvas.drawBitmap(createCardImage(0),null, p1Card2, null);
        }
        if (game.getPlayers().get(1).playerExists()){
            //game.getPlayer(2).getHand(0);
            canvas.drawBitmap(createCardImage(0),null, p2Card1, null);
            //game.getPlayer(2).getHand(1);
            canvas.drawBitmap(createCardImage(0),null, p2Card2, null);
        }
        if (game.getPlayers().get(2).playerExists()){
            //game.getPlayer(3).getHand(0);
            canvas.drawBitmap(createCardImage(0),null, p3Card1, null);
            //game.getPlayer(3).getHand(1);
            canvas.drawBitmap(createCardImage(0),null, p3Card2, null);
        }
        if (game.getPlayers().get(3).playerExists()){
            //game.getPlayer(4).getHand(0);
            canvas.drawBitmap(createCardImage(0),null, p4Card1, null);
            //game.getPlayer(4).getHand(1);
            canvas.drawBitmap(createCardImage(0),null, p4Card2, null);
        }
        if (game.getPlayers().get(4).playerExists()){
            //game.getPlayer(5).getHand(0);
            canvas.drawBitmap(createCardImage(6),null, p5Card1, null);
            //game.getPlayer(5).getHand(1);
            canvas.drawBitmap(createCardImage(7),null, p5Card2, null);
        }
        if (game.getPlayers().get(5).playerExists()){
            //game.getPlayer(6).getHand(0);
            canvas.drawBitmap(createCardImage(0),null, p6Card1, null);
            //game.getPlayer(6).getHand(1);
            canvas.drawBitmap(createCardImage(0),null, p6Card2, null);
        }
        for (int i = 0; i<=4; i++) {
            RectF river = new RectF(riverCard[0] + (cardWidth * i)+cardSpacing, riverCard[1],
                    riverCard[2] + (cardWidth * i) - cardSpacing, riverCard[3]);
            canvas.drawBitmap(createCardImage(i + 1),null, river, null);

        }
        canvas.drawBitmap(createCardImage(0),null, pile, null);
    }

    public void drawChips(Canvas canvas){

    }

    public Bitmap createCardImage(int i){
        Drawable CardsSrc = getResources().getDrawable(R.drawable.c0);
        if(i == 1){
            CardsSrc = getResources().getDrawable(R.drawable.c13);
        }
        if(i == 2){
            CardsSrc = getResources().getDrawable(R.drawable.c1);
        }
        if(i == 3){
            CardsSrc = getResources().getDrawable(R.drawable.c2);
        }
        if(i == 4){
            CardsSrc = getResources().getDrawable(R.drawable.c3);
        }
        if(i == 5){
            CardsSrc = getResources().getDrawable(R.drawable.c4);
        }
        if(i == 6){
            CardsSrc = getResources().getDrawable(R.drawable.c51);
        }
        if(i == 7){
            CardsSrc = getResources().getDrawable(R.drawable.c52);
        }
        BitmapDrawable image = (BitmapDrawable) CardsSrc;
        return image.getBitmap();
    }


    @Override
    public void onDraw(Canvas canvas) {
        drawCards(canvas);
    }

}






//not too sure if this is going to be used so taking it out for now
/*
public static final int[] p1chips =
            {(p1area[0]+p1area[2])/4, p1area[1]+200, (p1area[0]+p1area[2])/2+cardWidth+10,
                    p1area[1]+50+cardHeight};

/**
//player areas (used for debugging)
canvas.drawRect(p1area[0], p1area[1], p1area[2], p1area[3], red);
canvas.drawRect(p2area[0], p2area[1], p2area[2], p2area[3], greenChips);
canvas.drawRect(p3area[0], p3area[1], p3area[2], p3area[3], blackChips);
canvas.drawRect(riverArea[0], riverArea[1], riverArea[2], riverArea[3], blueChips);
canvas.drawRect(p4area[0], p4area[1], p4area[2], p4area[3], red);
canvas.drawRect(p5area[0], p5area[1], p5area[2], p5area[3], greenChips);
canvas.drawRect(p6area[0], p6area[1], p6area[2], p6area[3], blackChips);





canvas.drawRect(riverCard[0] + (cardWidth * i)+cardSpacing, riverCard[1],
                    riverCard[2] + (cardWidth * i) - cardSpacing, riverCard[3], white)






*/