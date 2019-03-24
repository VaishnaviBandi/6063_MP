package com.example.snakegame.engine;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.snakegame.SecondaryActivity;
import com.example.snakegame.classes.Coordinate;
import com.example.snakegame.enums.Direction;
import com.example.snakegame.enums.TileType;
import com.example.snakegame.enums.GameState;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import android.widget.Toast;
public class GameEngine extends SecondaryActivity {
    public static final int GameWidth = 28;
    public static final int GameHeight = 42;
    //Creating a list of coordinate objects.
    private List<Coordinate> walls= new ArrayList<>();
    private Random random = new Random();
    private boolean increaseTail = false;
    private List<Coordinate> snake = new ArrayList<>();
    private List<Coordinate> apples = new ArrayList<>();
    private Direction currentDirection = Direction.East;
    private GameState currentGameState = GameState.Running;
    private int score = 0;
    Context context;

    private Coordinate getSnakeHead() {
        return snake.get(0);
    }
    public GameEngine(Context context) {
        this.context = context;
    }

    public void initGame() {
        AddWalls();

        AddApples();

        AddSnake();


    }
    public void UpdateDirection(Direction newDirection) {
        if( Math.abs(newDirection.ordinal() - currentDirection.ordinal()) %2 == 1) {
            currentDirection = newDirection;
        }
    }
    public int Update() {
        try{
            switch(currentDirection) {
                case North:
                    UpdateSnake(0, 1);
                    break;
                case East:
                    UpdateSnake(1,0);
                    break;
                case South:
                    UpdateSnake(0,-1);
                    break;
                case West:
                    UpdateSnake(-1,0);
                    break;
            }
            for (Coordinate w: walls) {
                if (snake.get(0).equals(w)) {
                    currentGameState = GameState.Lost;
                    return score;
                }
            }

            //Check self collissions
            for (int i = 1 ; i < snake.size(); i++) {
                if(getSnakeHead().equals(snake.get(i))) {
                    currentGameState = GameState.Lost;
                    return score;
                }

            }
            //Check apples
            Coordinate appleToRemove = null;
            for( Coordinate apple: apples) {
                if (getSnakeHead().equals(apple)){
                    appleToRemove = apple;
                    increaseTail = true;
                    score = score + 1;
                }
            }
            if (appleToRemove != null) {
                apples.remove(appleToRemove);
                AddApples();
            }
            return score;}catch(Exception e){
                return score;
        }
    }
    public TileType[][] getMap() {
            TileType[][] map = new TileType[GameWidth][GameHeight];
            for (int x = 0; x < GameWidth; x++) {
                for (int y = 0; y < GameHeight; y++) {
                    map[x][y] = TileType.Nothing;
                }
            }

                for (Coordinate s : snake) {
                    map[s.getX()][s.getY()] = TileType.SnakeTail;
                }
        for(Coordinate a: apples) {
            map[a.getX()][a.getY()] = TileType.Apple;
        }
       map[snake.get(0).getX()][snake.get(0).getY()] = TileType.SnakeHead;

       for(Coordinate wall: walls) {
           map[wall.getX()][wall.getY()] = TileType.Wall;
       }
       return map;
    }
    private void UpdateSnake(int x, int y) {
        int newX = snake.get(snake.size() - 1).getX();
        int newY = snake.get(snake.size() - 1).getY();

        for (int i = snake.size() - 1; i > 0; i--) {
            snake.get(i).setX(snake.get(i-1).getX());
            snake.get(i).setY(snake.get(i-1).getY());
        }
        if (increaseTail) {
            snake.add(new Coordinate(newX, newY));
            increaseTail = false;
        }
        snake.get(0).setX(snake.get(0).getX() + x);
        snake.get(0).setY(snake.get(0).getY() + y);
    }
    private void AddSnake() {
        snake.clear();
        snake.add(new Coordinate(7,7));
        snake.add(new Coordinate(6,7));
        snake.add(new Coordinate(5,7));
        snake.add(new Coordinate(4,7));
        snake.add(new Coordinate(3,7));
        snake.add(new Coordinate(2,7));

    }
    private void AddWalls() {
        //Top and Bottom Walls
        for (int x = 0; x < GameWidth; x++) {
            walls.add(new Coordinate(x,0));
            walls.add(new Coordinate(x, GameHeight- 1));
        }
        //Left and Right Walls
        for (int y = 0; y < GameHeight; y++) {
            walls.add(new Coordinate(0,y));
            walls.add(new Coordinate(GameWidth - 1, y));
        }
    }

    private void AddApples() {
        Log.d("Moooooooooooooooo","nooooooooooooo");
        Coordinate coordinate = null;
        boolean added = false;
        while( !added) {
            int x = random.nextInt(GameWidth - 3)+1;
            int y = random.nextInt(GameHeight - 3)+1;

            coordinate = new Coordinate(x, y);
            boolean collision = false;
            Log.d("coord", coordinate.toString());
            for(Coordinate s : snake) {
                if(s.equals(coordinate)) {
                    collision = true;
//                    break;
                }
            }
            if (collision == true) {
                continue;
            }
            for(Coordinate a: apples) {
                if(a.equals(coordinate)) {
                    collision = true;
//                    break;
                }
            }

            added = !collision;
        }

        apples.add(coordinate);
    }
    public GameState getCurrentGameState() {
        return currentGameState;
    }
}
