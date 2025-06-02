package pl.s24825.controller;

import pl.s24825.Settings;
import pl.s24825.model.Engine;
import pl.s24825.view.ViewFactory;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

public class GameWindowController extends BaseController implements Initializable {


    @FXML
    private ImageView finalScoreImg;
    @FXML
    private TextField finalScoreLabel;

    @FXML
    private TextField nameField;

    @FXML
    private ImageView nameImg;

    @FXML
    private Canvas canvas;

    @FXML
    private Text timeLabel;

    @FXML
    private Text scoreLabel;

    @FXML
    private ImageView timeImg;

    @FXML
    private ImageView scoreImg;

    @FXML
    private ImageView exitBtn;

    @FXML
    private ImageView loseScreen;

    @FXML
    private ImageView submitBtn;

    @FXML
    void sbmitOnNotHover(MouseEvent event) {
        viewFactory.dropShadowOff(event);
    }

    @FXML
    void subOnPressed(MouseEvent event) {
        saveHighSCore();

        Stage stage = (Stage) canvas.getScene().getWindow();

        viewFactory.showMainMenu();
        viewFactory.closeStage(stage);
    }

    @FXML
    void submitOnHover(MouseEvent event) {
        viewFactory.dropShadowOn(event);

    }

    @FXML
    void exitOnHover(MouseEvent event) {
        viewFactory.dropShadowOn(event);

    }

    @FXML
    void exitOnNotHover(MouseEvent event) {
        viewFactory.dropShadowOff(event);

    }

    @FXML
    void exitOnPressed(MouseEvent event) {
        Stage stage = (Stage) canvas.getScene().getWindow();

        viewFactory.showMainMenu();
        viewFactory.closeStage(stage);

    }

    @FXML
    void onKeyPressed(KeyEvent event) {

        KeyCode code = event.getCode();

        if (code == KeyCode.R && !event.isShiftDown()) {
            Stage stage = (Stage) canvas.getScene().getWindow();

            viewFactory.showGameWindow();
            viewFactory.closeStage(stage);
        }

        if (code == KeyCode.R && event.isShiftDown()) {

            Stage stage = (Stage) canvas.getScene().getWindow();

            viewFactory.closeStage(stage);
            viewFactory.showMainMenu();

        }

        int currentDirection = engine.getCurrentDirection();

        if (!engine.isChangedDirection()) {
            if (code == KeyCode.RIGHT) {
                if (currentDirection != LEFT) {
                    engine.setCurrentDirection(RIGHT);
                    engine.setChangedDirection(true);
                }

            } else if (code == KeyCode.LEFT) {
                if (currentDirection != RIGHT) {
                    engine.setCurrentDirection(LEFT);
                    engine.setChangedDirection(true);
                }

            } else if (code == KeyCode.UP) {
                if (currentDirection != DOWN) {
                    engine.setCurrentDirection(UP);
                    engine.setChangedDirection(true);
                }

            } else if (code == KeyCode.DOWN) {
                if (currentDirection != UP) {
                    engine.setCurrentDirection(DOWN);
                    engine.setChangedDirection(true);
                }
            }
        }
    }

    private int width;
    private int height;
    private int squareSize;

    private GraphicsContext board;
    private Engine engine;

    private final int UP = 0;
    private final int DOWN = 1;
    private final int LEFT = 2;
    private final int RIGHT = 3;

    private Timeline clock;
    private Timeline score;
    private Timeline game;





    public GameWindowController(ViewFactory viewFactory, String fxmlName, Settings settings) {
        super(viewFactory, fxmlName, settings);
    }

    public void timerTimeLine() {
        DateFormat timeFormat = new SimpleDateFormat( "mm:ss" );
        clock = new Timeline(
                new KeyFrame(
                        Duration.millis( 500 ),
                        event -> {
                            timeLabel.setText( timeFormat.format(engine.calculateTime()));
                            if (engine.isGameOver()) {
                                clock.stop();
                            }
                        }
                )
        );
        clock.setCycleCount( Animation.INDEFINITE );
        clock.play();
    }
    public void scoreTimeLine() {
        score = new Timeline(
                new KeyFrame(
                        Duration.millis( 500 ), event -> {
                            scoreLabel.setText(engine.getTotalScore());
                    if (engine.isGameOver()) {
                        score.stop();
                    }
                }
                )
        );
        score.setCycleCount( Animation.INDEFINITE );
        score.play();
    }

    public void gameTimeLine() {
        game = new Timeline(
                new KeyFrame(
                        Duration.millis(settings.getSpeed()), event -> {
                            if (engine.isGameOver()) {
                                loseScreenEnable();
                                game.stop();
                            }
                            engine.mainGame();
                }
                )
        );

        game.setCycleCount( Animation.INDEFINITE );
        game.play();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        setValues();

        this.engine = new Engine(board, settings.getRows(), settings.getColumns(), squareSize, width, height);
        Parent anchorPane = canvas.getParent();
        anchorPane.requestFocus();
        engine.start();


        timerTimeLine();
        scoreTimeLine();
        gameTimeLine();
    }

    private void setValues() {
        this.board = canvas.getGraphicsContext2D();
        this.width = (int) canvas.getWidth();
        this.height = (int) canvas.getHeight();
        this.squareSize = width / settings.getColumns();
    }


    private void loseScreenEnable() {
        loseScreen.setVisible(true);
        exitBtn.setVisible(true);
        submitBtn.setVisible(true);
        finalScoreImg.setVisible(true);
        nameField.setVisible(true);
        nameImg.setVisible(true);
        finalScoreLabel.setText(engine.getTotalScore());
        finalScoreLabel.setVisible(true);
    }


    private void saveHighSCore() {
        String name = nameField.getText();
        String highscore = name + ":" + engine.getTotalScore();

        File scoreFile = new File("highscore.txt");

        if (!scoreFile.exists()) {
            try {
                scoreFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        FileWriter fileWriter;
        BufferedWriter bufferedWriter = null;

        try {
            fileWriter = new FileWriter(scoreFile, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(highscore);
            bufferedWriter.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
