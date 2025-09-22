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
import java.util.HashMap;

/**
 * @Author: Andrew, Alex, Nikos, Joseph
 * @Desc: Game view creates the Surface View and holds
 * the methods used to draw objects in the game.
 *
 * TODO: Clean in up. Write graphics for game loop.
 * We ran out of time working on this file as we spent
 * a ridiculous amount of time trying to find a cleaner
 * bitmap solution.
 *
 */
public class GameView extends SurfaceView{
    private Game game;
    //https://www.geeksforgeeks.org/java/hashmap-get-method-in-java/
    //https://stackoverflow.com/questions/3626752/key-existence-check-in-hashmap
    //TODO: should store what we create so that we dont recreate every time we draw
    //index into dict, if result is null, call create function and add. Then use bitmap
    HashMap<String, Bitmap> bitmaps;

    Paint white = new Paint();
    Paint red = new Paint();
    Paint blueChips = new Paint();
    Paint greenChips = new Paint();
    Paint blackChips = new Paint();

    //trial and error found the dimensions of the screen.
    //top left x, top left y, bottom right x, bottom right y
    public static final int cardWidth = 150;
    public static final int cardHeight = 210;
    public static final int cardSpacing = 10;
    public static final int chipLeftMargin = 10;
    public static final int chipTopMargin = 100;
    public static final int chipWidth = 266;
    public static final int chipHeight = 200;


    public static final int[] p1area = {0, 0, 768, 300};
    //subtract 10 from card to draw second
    public static final int[] p1card =
            {(p1area[0]+p1area[2])/2+10, p1area[1],
                    (p1area[0]+p1area[2])/2+cardWidth+cardSpacing,
                    p1area[1]+cardHeight};

    //Will use the RectF objects to create bitmap
    //TODO: need to clean these vars up
    public static final RectF p1Card1 = new RectF(p1card[0], p1card[1],p1card[2],p1card[3]);
    public static final RectF p1Card2 = new RectF(p1card[0]-cardWidth-cardSpacing, p1card[1],
            p1card[2]-cardWidth-cardSpacing, p1card[3]);
    public static final int[] p1chips =
            {p1area[0]+chipLeftMargin, p1area[1]+chipTopMargin,
                    p1area[0]+chipLeftMargin+chipWidth,
                    p1area[1]+chipTopMargin+chipHeight};
    public static final RectF p1chipBM = new RectF(p1chips[0], p1chips[1],p1chips[2],p1chips[3]);

    public static final int[] p2area = {768, 0, 1536, 300};
    public static final int[] p2card =
            {(p2area[0]+p2area[2])/2+10, p2area[1],
                    (p2area[0]+p2area[2])/2+cardWidth+cardSpacing,
                    p2area[1]+cardHeight};
    public static final RectF p2Card1 = new RectF(p2card[0],p2card[1],p2card[2],p2card[3]);
    public static final RectF p2Card2 = new RectF(p2card[0]-cardWidth-cardSpacing, p2card[1],
            p2card[2]-cardWidth-cardSpacing, p2card[3]);
    public static final int[] p2chips =
            {p2area[0]+chipLeftMargin, p2area[1]+chipTopMargin,
                    p2area[0]+chipLeftMargin+chipWidth,
                    p2area[1]+chipTopMargin+chipHeight};
    public static final RectF p2chipBM = new RectF(p2chips[0], p2chips[1],p2chips[2],p2chips[3]);

    public static final int[] p3area = {1536, 0, 2304, 300};
    public static final int[] p3card =
            {(p3area[0]+p3area[2])/2+10, p3area[1],
                    (p3area[0]+p3area[2])/2+cardWidth+cardSpacing,
                    p3area[1]+cardHeight};
    public static final RectF p3Card1 = new RectF(p3card[0], p3card[1], p3card[2], p3card[3]);
    public static final RectF p3Card2 = new RectF(p3card[0]-cardWidth-cardSpacing, p3card[1],
            p3card[2]-cardWidth-cardSpacing, p3card[3]);
    public static final int[] p3chips =
            {p3area[0]+chipLeftMargin, p3area[1]+chipTopMargin,
                    p3area[0]+chipLeftMargin+chipWidth,
                    p3area[1]+chipTopMargin+chipHeight};
    public static final RectF p3chipBM = new RectF(p3chips[0], p3chips[1],p3chips[2],p3chips[3]);

    public static final int[] riverArea = {0, 300, 2304, 650};
    public static final int[] riverCard =
            {(riverArea[0]+riverArea[2])/4, riverArea[1]+100,
                    (riverArea[0]+riverArea[2])/4+cardWidth+cardSpacing,
                    riverArea[1]+100+cardHeight};
    public static final RectF pile = new RectF (riverCard[0] + (cardWidth * 6)+cardSpacing, riverCard[1],
            riverCard[2] + (cardWidth * 6) - cardSpacing, riverCard[3]);

    public static final int[] p4area = {768, 650, 1536, 1000};
    public static final int[] p4card =
            {(p4area[0]+p4area[2])/2+10, p4area[3]-cardHeight-50,
                    (p4area[0]+p4area[2])/2+cardWidth+cardSpacing,
                    p4area[3]-50};
    public static final RectF p4Card1 = new RectF(p4card[0], p4card[1], p4card[2], p4card[3]);
    public static final RectF p4Card2 = new RectF(p4card[0]-cardWidth-cardSpacing, p4card[1],
            p4card[2]-cardWidth-cardSpacing, p4card[3]);
    public static final int[] p4chips =
            {p4area[0]+chipLeftMargin, p4area[1]+chipTopMargin,
                    p4area[0]+chipLeftMargin+chipWidth,
                    p4area[1]+chipTopMargin+chipHeight};
    public static final RectF p4chipBM = new RectF(p4chips[0], p4chips[1],p4chips[2],p4chips[3]);

    public static final int[] p5area = {0, 650, 768, 1000};
    public static final int[] p5card =
            {(p5area[0]+p5area[2])/2+10, p5area[3]-cardHeight-50,
                    (p5area[0]+p5area[2])/2+cardWidth+cardSpacing,
                    p5area[3]-50};
    public static final RectF p5Card1 = new RectF(p5card[0], p5card[1], p5card[2], p5card[3]);
    public static final RectF p5Card2 = new RectF(p5card[0]-cardWidth-cardSpacing, p5card[1],
            p5card[2]-cardWidth-cardSpacing, p5card[3]);
    public static final int[] p5chips =
            {p5area[0]+chipLeftMargin, p5area[1]+chipTopMargin,
                    p5area[0]+chipLeftMargin+chipWidth,
                    p5area[1]+chipTopMargin+chipHeight};
    public static final RectF p5chipBM = new RectF(p5chips[0], p5chips[1],p5chips[2],p5chips[3]);


    public GameView(Context context, AttributeSet attr) {
        super(context, attr);
        setWillNotDraw(false);
        bitmaps = new HashMap<String, Bitmap>();

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
    //need a reference to the game to determine which players and cards
    //we need to draw
    public void passInGame(Game game){
        this.game = game;
    }
    //TODO:
    //if we can figure out a way to specify location without hardcoding
    //x and y, this method will be a lot cleaner.
    //If player exists. Loop thru hand. If flipped, get card name. Draw
    public void drawCards(Canvas canvas){
        if (game.getPlayers().get(0).playerExists()){
            //TODO:This wont work. Needs to be written as described above
            //TODO: or as written in the commented out drawCards at the bottom
            //TODO: of the class. game.getPlayers() returns an arraylist of players
            //TODO: .get(0) gets the first player, not get(1), and getHand doesn't take any args.
            //TODO: loop over the hand instead.
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
            canvas.drawBitmap(createCardImage(6),null, p4Card1, null);
            //game.getPlayer(4).getHand(1);
            canvas.drawBitmap(createCardImage(7),null, p4Card2, null);
        }
        if (game.getPlayers().get(4).playerExists()){
            //game.getPlayer(5).getHand(0);
            canvas.drawBitmap(createCardImage(0),null, p5Card1, null);
            //game.getPlayer(5).getHand(1);
            canvas.drawBitmap(createCardImage(0),null, p5Card2, null);
        }
        for (int i = 0; i<=4; i++) {
            RectF river = new RectF(riverCard[0] + (cardWidth * i)+cardSpacing, riverCard[1],
                    riverCard[2] + (cardWidth * i) - cardSpacing, riverCard[3]);
            canvas.drawBitmap(createCardImage(i + 1),null, river, null);

        }
        canvas.drawBitmap(createCardImage(0),null, pile, null);
    }

    //TODO: Need to implement further
    //add text amount
    //add a pot
    //add error checking
    //add dealer chip
    public void drawChips(Canvas canvas){
        canvas.drawBitmap(createCardImage(8), null, p1chipBM, null);
        canvas.drawBitmap(createCardImage(8), null, p2chipBM, null);
        canvas.drawBitmap(createCardImage(8), null, p3chipBM, null);
        canvas.drawBitmap(createCardImage(8), null, p4chipBM, null);
        canvas.drawBitmap(createCardImage(8), null, p5chipBM, null);

    }

    //TODO: Figure out a better way to create images
    public Bitmap createCardImage(int i){ //where i will eventually be .getCardName (KING of HEARTS)
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
        if(i == 8){
            CardsSrc = getResources().getDrawable(R.drawable.pot);
        }
        BitmapDrawable image = (BitmapDrawable) CardsSrc;
        return image.getBitmap();
    }

    /**
    public void drawCards(Canvas canvas){
        if (game.getPlayers().get(0).playerExists()){
            for (Card card : game.getPlayers().get(0).getHand()){
                //if (card.isFlipped()){
                    Bitmap b = bitmaps.get(card.getImgName());
                    if (b == null){ //bitmap has not been created yet
                        //https://stackoverflow.com/questions/46829973/how-get-drawable-from-string-path


                        b = bitmaps.get(card.getImgName());
                    }
                    else{  System.out.println("Bitmap error");  }


                    canvas.drawBitmap(b, null, p1CardRect, null);
                }
            }
            canvas.drawRect(p1card[0], p1card[1], p1card[2], p1card[3], white);
            canvas.drawRect(p1card[0]-cardWidth-cardSpacing, p1card[1],
                    p1card[2]-cardWidth-10, p1card[3], white);
            Bitmap p1inv = BitmapFactory.decodeFile("../res/drawable/pot.png");
            Drawable d = new BitmapDrawable(p1inv);
        }
        if (game.getPlayers().get(1).playerExists()){
            canvas.drawRect(p2card[0], p2card[1], p2card[2], p2card[3], white);
            canvas.drawRect(p2card[0]-cardWidth-cardSpacing, p2card[1],
                    p2card[2]-cardWidth-10, p2card[3], white);
        }
        if (game.getPlayers().get(2).playerExists()){
            canvas.drawRect(p3card[0], p3card[1], p3card[2], p3card[3], white);
            canvas.drawRect(p3card[0]-cardWidth-cardSpacing, p3card[1],
                    p3card[2]-cardWidth-10, p3card[3], white);
        }
        if (game.getPlayers().get(3).playerExists()){
            canvas.drawRect(p4card[0], p4card[1], p4card[2], p4card[3], white);
            canvas.drawRect(p4card[0]-cardWidth-cardSpacing, p4card[1],
                    p4card[2]-cardWidth-10, p4card[3], white);
        }
        if (game.getPlayers().get(4).playerExists()){
            canvas.drawRect(p5card[0], p5card[1], p5card[2], p5card[3], white);
            canvas.drawRect(p5card[0]-cardWidth-cardSpacing, p5card[1],
                    p5card[2]-cardWidth-10, p5card[3], white);
        }
        for (int i = 0; i<=4; i++) {
            canvas.drawRect(riverCard[0] + (cardWidth * i)+cardSpacing, riverCard[1],
                    riverCard[2] + (cardWidth * i) - cardSpacing, riverCard[3], white);
        }
        //draw deck
        canvas.drawRect(riverCard[0] + (cardWidth * 6)+cardSpacing, riverCard[1],
                riverCard[2] + (cardWidth * 6) - cardSpacing, riverCard[3], white);
    }
*/


    @Override
    public void onDraw(Canvas canvas) {
        /**
        //player areas (used for debugging)
        canvas.drawRect(p1area[0], p1area[1], p1area[2], p1area[3], red);
        canvas.drawRect(p2area[0], p2area[1], p2area[2], p2area[3], greenChips);
        canvas.drawRect(p3area[0], p3area[1], p3area[2], p3area[3], blackChips);
        canvas.drawRect(riverArea[0], riverArea[1], riverArea[2], riverArea[3], blueChips);
        canvas.drawRect(p4area[0], p4area[1], p4area[2], p4area[3], red);
        canvas.drawRect(p5area[0], p5area[1], p5area[2], p5area[3], greenChips);
         */

        drawCards(canvas);
        drawChips(canvas);

    }

}


