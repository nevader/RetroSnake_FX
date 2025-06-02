package pl.s24825.model;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Objects;

public class Engine {

    private long timePassed;
    private long timeStarted;

    private boolean isGameOver;

    private int currentDirection;
    private boolean changedDirection = false;
    private ArrayList<Point2D> lastbody = new ArrayList<>();

    private final GraphicsContext board;

    private final Image back1 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/view/assets/background1.png")));
    private final Image back2 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/view/assets/background2.png")));

    private final int rows;
    private final int columns;
    private final int squareSize;
    private final int width;
    private final int height;

    private int totalScore = 0;
    private final int fruitScore = 5;

    private final Snake snake;
    private final Food food;

    private final int UP = 0;
    private final int DOWN = 1;
    private final int LEFT = 2;
    private final int RIGHT = 3;


    public Engine(GraphicsContext board, int rows, int columns, int squareSize, int width, int height) {
        this.board = board;
        this.rows = rows;
        this.columns = columns;
        this.squareSize = squareSize;
        this.height = height;
        this.width = width;
        this.snake = new Snake(board);
        this.food = new Food(board);

    }


    public void start() {
        snake.generateStartingSnake(rows / 2, columns / 2, 3);
        food.generateFoodCords(rows, columns, snake.getSnakeBody());
        food.generateFoodType();
        timeStarted = System.currentTimeMillis();

    }


    public void mainGame() {
        whereToMove(currentDirection);
        gameOver();
        if (isGameOver) {
            return;
        }
        drawBackGround();
        food.drawFood(squareSize);
        snake.drawSnake(squareSize);
        snake.updateSnake();
        eatFood();
        lastbody = snake.getSnakeBody();
        changedDirection = false;


    }

    public void drawBackGround() {

        Image image;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if ((i + j) % 2 == 0) {
                    image = back1;
                } else {
                    image = back2;
                }
                board.drawImage(image, i * squareSize, j * squareSize, squareSize, squareSize);
            }
        }
    }

    public void whereToMove(int currentDirection) {
        switch (currentDirection) {
            case RIGHT:
                snake.moveRight();
                break;
            case LEFT:
                snake.moveLeft();
                break;
            case UP:
                snake.moveUp();
                break;
            case DOWN:
                snake.moveDown();
                break;
        }

    }


    public void eatFood() {



        if (snake.getSnakeHead().getX() == food.getFoodX() &&
                snake.getSnakeHead().getY() == food.getFoodY()) {

            if (food.getCurrentFood() == food.getSizeUpFood()) {
                snake.getSnakeBody().add(new Point2D(-50, -50));
            } else if (food.getCurrentFood() == food.getSizeDownFood()) {
                if (snake.getSnakeBody().size() > 1) {
                    int index = snake.getSnakeBody().size() - 1;
                    snake.getSnakeBody().remove(index);
                }
            }

            totalScore += (fruitScore * timePassed/1000);

            food.generateFoodCords(rows, columns, snake.getSnakeBody());
            food.generateFoodType();
        }
    }

    public void gameOver() {

        int x = (int) snake.getSnakeHead().getX();
        int y = (int) snake.getSnakeHead().getY();

        if (x < 0 || y < 0 ||
                x * squareSize >= width ||
                y * squareSize >= height) {
            isGameOver = true;
        }

        for (int i = 1; i < lastbody.size(); i++) {
            if (snake.getSnakeHead().getX() == lastbody.get(i).getX() &&
                    snake.getSnakeHead().getY() == lastbody.get(i).getY()) {
                isGameOver = true;
                break;
            }
        }
    }

    public long calculateTime() {
        timePassed = System.currentTimeMillis() - timeStarted;
        return timePassed;
    }

    public void setCurrentDirection(int currentDirection) {
        this.currentDirection = currentDirection;
    }

    public int getCurrentDirection() {
        return currentDirection;
    }

    public boolean isChangedDirection() {
        return changedDirection;
    }

    public void setChangedDirection(boolean changedDirection) {
        this.changedDirection = changedDirection;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public String getTotalScore() {
        return String.valueOf(totalScore);
    }
}
