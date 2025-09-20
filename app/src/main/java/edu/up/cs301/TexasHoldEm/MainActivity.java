package edu.up.cs301.TexasHoldEm;

import android.os.Bundle;
import android.view.SurfaceView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //this will need to depend on user selections
        //should also eventually include which bots
        Game game = new Game(6);

        GameView sv = findViewById(R.id.mainSV);
        sv.passInGame(game);


    }
}