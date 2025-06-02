package pl.s24825.controller;

import pl.s24825.Settings;
import pl.s24825.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController extends BaseController implements Initializable{


    public MainMenuController(ViewFactory viewFactory, String fxmlName, Settings settings) {
        super(viewFactory, fxmlName, settings);
    }

    @FXML
    private ImageView exitButton;

    @FXML
    private ImageView highScoresButton;

    @FXML
    private ImageView newGameButton;

    @FXML
    private ImageView optionsButton;



    @FXML
    void exitNotHover(MouseEvent event) {
        viewFactory.dropShadowOff(event);

    }

    @FXML
    void exitOnClicked(MouseEvent event) {
        Stage stage = (Stage) newGameButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void exitOnHover(MouseEvent event) {
        viewFactory.dropShadowOn(event);

    }



    @FXML
    void highScoresClicked(MouseEvent event) {
        Stage stage = (Stage) newGameButton.getScene().getWindow();

        viewFactory.showHighScores();
        viewFactory.closeStage(stage);

    }

    @FXML
    void highScoresNotHover(MouseEvent event) {
        viewFactory.dropShadowOff(event);

    }

    @FXML
    void highScoresOnHover(MouseEvent event) {
        viewFactory.dropShadowOn(event);

    }



    @FXML
    void newGameClicked(MouseEvent event) {
        Stage stage = (Stage) newGameButton.getScene().getWindow();

        viewFactory.showNewGame();
        viewFactory.closeStage(stage);
    }

    @FXML
    void newGameNotHover(MouseEvent event) {
        viewFactory.dropShadowOff(event);
    }

    @FXML
    void newGameOnHover(MouseEvent event) {
        viewFactory.dropShadowOn(event);

    }

    @FXML
    void optionsMouseClicked(MouseEvent event) {

    }

    @FXML
    void optionsNotHover(MouseEvent event) {
        viewFactory.dropShadowOff(event);

    }

    @FXML
    void optionsOnHover(MouseEvent event) {
        viewFactory.dropShadowOn(event);

    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
