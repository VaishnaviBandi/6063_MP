package com.example.snakegame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.snakegame.engine.GameEngine;
import com.example.snakegame.views.SnakeView;
import android.content.Intent;
public class MainActivity extends AppCompatActivity {

        private GameEngine gameEngine;
        private SnakeView snakeView;
        private Button button;
        private Button button1;
        private Button button2;
        private Button button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);

//        gameEngine = new GameEngine();
//        gameEngine.initGame();
//        snakeView = (SnakeView) findViewById(R.id.snakeView);
//        snakeView.setSnakeViewMap(gameEngine.getMap());
        button = (Button) findViewById(R.id.button);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById((R.id.button3));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondaryActivity.class);
//        snakeView.invalidate();
                startActivity(intent);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, TertiaryActivity.class);
//        snakeView.invalidate();
                startActivity(intent1);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, FourthActivity.class);
//        snakeView.invalidate();
                startActivity(intent2);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(MainActivity.this, FifithActivity.class);
//        snakeView.invalidate();
                startActivity(intent3);
            }
        });
    }

}
