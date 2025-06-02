package pl.s24825.model;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Random;

public class Food {

    private final Image foodIncSizeImg;
    private final Image foodDecSizeImg;
    private Image foodToDraw;
    private int currentFood;
    private Random rand;

    private int foodX;
    private int foodY;

    private final int sizeDownFood = 2;
    private final int sizeUpFood = 1;


    private final GraphicsContext board;

    public Food(GraphicsContext board) {
        this.board = board;
        this.foodIncSizeImg = new Image(getClass().getResourceAsStream("/view/assets/fruitSize.png"));
        this.foodDecSizeImg = new Image(getClass().getResourceAsStream("/view/assets/fruitDecize.png"));
        rand = new Random();
    }


    public void drawFood(int squareSize) {
        board.drawImage(foodToDraw, foodX * squareSize, foodY * squareSize, squareSize, squareSize);
    }

    public void generateFoodCords(int rows, int columns, ArrayList<Point2D> snakeBody) {

        start:
        while (true) {
            foodX = (int) (Math.random() * rows);
            foodY = (int) (Math.random() * columns);

            for (Point2D snake : snakeBody) {
                if (snake.getX() == foodX && snake.getY() == foodY) {
                    continue start;
                }
            }
            break;
        }
    }

    public void generateFoodType() {
        int val = rand.nextInt(10)+1;

        if (val == 1) {
            foodToDraw = foodDecSizeImg;
            currentFood = sizeDownFood;
        } else {
            foodToDraw = foodIncSizeImg;
            currentFood = sizeUpFood;
        }
    }



    public int getFoodX() {
        return foodX;
    }

    public int getFoodY() {
        return foodY;
    }

    public int getCurrentFood() {
        return currentFood;
    }

    public int getSizeDownFood() {
        return sizeDownFood;
    }

    public int getSizeUpFood() {
        return sizeUpFood;
    }
}
