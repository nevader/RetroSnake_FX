package pl.s24825.model;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import java.util.ArrayList;

public class Snake {

    private final ArrayList<Point2D> snakeBody;
    private Point2D snakeHead;
    private final GraphicsContext board;

    private final Image snakeHeadImg;
    private final Image snakeBodyImg;

    public Snake(GraphicsContext board) {
        this.board = board;
        this.snakeBody = new ArrayList<>();
        this.snakeHeadImg = new Image(getClass().getResourceAsStream("/view/assets/snakeHead.png"));
        this.snakeBodyImg = new Image(getClass().getResourceAsStream("/view/assets/snakeBody.png"));
    }



    public void generateStartingSnake(int startingX, int startingY, int snakeLength) {

       snakeHead = new Point2D(startingX, startingY);
       snakeBody.add(snakeHead);
       snakeBody.add(new Point2D(startingX, startingY - 1));
       snakeBody.add(new Point2D(startingX, startingY - 2));

    }



    public void updateSnake() {

        snakeBody.set(0, snakeHead);

        for (int i = snakeBody.size() - 1; i >= 1; i--) {
            Point2D temp = snakeBody.get(i-1);
            snakeBody.set(i, temp);
        }


    }



    public void drawSnake(int squareSize) {

        board.drawImage(snakeHeadImg, snakeHead.getX() * squareSize, snakeHead.getY() * squareSize,
                squareSize, squareSize);

        for (int i = 1; i < snakeBody.size(); i++) {
            board.drawImage(snakeBodyImg, snakeBody.get(i).getX() * squareSize,
                    snakeBody.get(i).getY() * squareSize,
                    squareSize, squareSize);

        }
    }



    public void moveRight() {
        snakeHead = snakeHead.add(1, 0);
    }

    public void moveLeft() {
        snakeHead = snakeHead.subtract(1, 0);
    }

    public void moveUp() {
        snakeHead = snakeHead.subtract(0, 1);
    }

    public void moveDown() {
        snakeHead = snakeHead.add(0, 1);
    }



    public Point2D getSnakeHead() {
        return snakeHead;
    }

    public ArrayList<Point2D> getSnakeBody() {
        return snakeBody;
    }
}
