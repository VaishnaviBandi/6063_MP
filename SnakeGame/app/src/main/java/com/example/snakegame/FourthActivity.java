package com.example.snakegame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import com.example.snakegame.engine.GameEngine;

import com.example.snakegame.engine.GameEngine;
import com.example.snakegame.views.SnakeView;
import com.example.snakegame.enums.GameState;
import android.content.Intent;
import android.os.Handler;
import android.widget.Toast;
import com.example.snakegame.enums.Direction;
public class FourthActivity extends AppCompatActivity implements View.OnTouchListener{
    public GameEngine gameEngine;
    private SnakeView snakeView;
    private Handler handler = new Handler();
    private final long updateDelay = 100;
    private float prevX, prevY;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        gameEngine = new GameEngine(getApplicationContext());
        gameEngine.initGame();
        snakeView = (SnakeView) findViewById(R.id.snakeView);
        snakeView.setOnTouchListener(this);
        startUpdateHandler();
    }
    private void startUpdateHandler() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                gameEngine.Update();
                if (gameEngine.getCurrentGameState() == GameState.Running) {
                    handler.postDelayed(this, updateDelay);
                }
                if (gameEngine.getCurrentGameState() == GameState.Lost) {
                    OnGameLost();
                }
                try {
                    snakeView.setSnakeViewMap(gameEngine.getMap());
                }
                catch(ArrayIndexOutOfBoundsException e){
                    Log.d("You Lost!","Try again!");
                    Toast.makeText(getApplicationContext(),"Ouch!!!! Sorry mate :(..You Lost.",Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(),"Your score for the game is "+gameEngine.Update(),Toast.LENGTH_SHORT).show();
                }
                snakeView.invalidate();
            }
        }, updateDelay);
    }
    private void OnGameLost() {
        Toast.makeText(this,"Ouch!!!! Sorry mate :(..You Lost.",Toast.LENGTH_SHORT).show();
        Toast.makeText(this,"Your score for the game is "+gameEngine.Update(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                prevX = event.getX();
                prevY = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                float newX = event.getX();
                float newY = event.getY();
                //check for swiping actions
                //UP-DOWN DIRECTION
                if(Math.abs(newX - prevX) > Math.abs(newY - prevY)) {
                    //LEFT - RIGHT
                    if(newX > prevX) {
                        //RIGHT
                        gameEngine.UpdateDirection(Direction.East);
                    }else {
                        //LEFT
                        gameEngine.UpdateDirection(Direction.West);
                    }
                }else if (newY > prevY) {
                    //UP
                    gameEngine.UpdateDirection(Direction.North);
                } else {
                    //DOWN
                    gameEngine.UpdateDirection(Direction.South);
                }
                break;
        }
        return true;
    }
}
