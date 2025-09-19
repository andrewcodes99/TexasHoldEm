package edu.up.cs301.TexasHoldEm;

import android.os.Bundle;

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
        /**
        GameView PV1 = findViewById(R.id.surfaceView1);
        GameView PV2 = findViewById(R.id.surfaceView2);
        GameView PV3 = findViewById(R.id.surfaceView3);
        GameView PV4 = findViewById(R.id.surfaceView4);
        GameView PV5 = findViewById(R.id.surfaceView5);
        GameView PV6 = findViewById(R.id.surfaceView6);
        GameView RV = findViewById(R.id.mainSV);
         */
    }
}