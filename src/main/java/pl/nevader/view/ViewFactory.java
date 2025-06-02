package pl.s24825.view;

import pl.s24825.Settings;
import pl.s24825.controller.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.ArrayList;

public class ViewFactory {

    private ArrayList<Stage> activeStages;
    private Styles styles = Styles.MEDIUM;
    private final Settings settings;

    public ViewFactory(Settings settings) {
        this.activeStages = new ArrayList<>();
        this.settings = settings;
    }


    public void showHighScores() {
        BaseController highScores = new HighScoresController(this, "HighScores.fxml", settings);
        initializeStages(highScores);
    }

    public void showMainMenu() {
        BaseController mainMenu = new MainMenuController(this, "MainMenu.fxml", settings);
        initializeStages(mainMenu);

    }

    public void showGameWindow() {
        BaseController gameWindow = new GameWindowController(this, "GameWindow.fxml", settings);
        initializeStages(gameWindow);
    }

    public void showNewGame() {
        BaseController newGame = new NewGameController(this, "NewGame.fxml", settings);
        initializeStages(newGame);
    }

    private void initializeStages (BaseController controller) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/" + controller.getFxmlName()));
        fxmlLoader.setController(controller);

        Parent parent;

        try {
            parent = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Scene scene = new Scene(parent);
        Stage stage = new Stage();

        stage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("/view/" + Styles.getCssPath(styles)).toExternalForm());
        stage.setMinHeight(400);
        stage.setMinWidth(500);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);

        parent.requestFocus();
        stage.show();

        activeStages.add(stage);
    }

    public void closeStage (Stage stageToClose) {
        stageToClose.close();
        activeStages.remove(stageToClose);
    }


    public void dropShadowOn (MouseEvent event) {

        ImageView source = (ImageView) event.getSource();

        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(4);
        dropShadow.setOffsetY(6);
        dropShadow.setColor(Color.BLACK);

        source.setEffect(dropShadow);
    }

    public void dropShadowOff (MouseEvent event) {
        ImageView source = (ImageView) event.getSource();
        source.setEffect(null);
    }

}
