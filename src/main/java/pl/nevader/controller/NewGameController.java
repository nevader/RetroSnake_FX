package pl.s24825.controller;

import pl.s24825.Settings;
import pl.s24825.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class NewGameController extends BaseController {

    public NewGameController(ViewFactory viewFactory, String fxmlName, Settings settings) {
        super(viewFactory, fxmlName, settings);
    }

    @FXML
    private TextField sizeField;

    @FXML
    private TextField speedField;

    @FXML
    private Label errorLabelSize;

    @FXML
    private Label errorLabelSpeed;

    @FXML
    void BackOnHover(MouseEvent event) {
        viewFactory.dropShadowOn(event);
    }

    @FXML
    void BackOnNotHover(MouseEvent event) {
        viewFactory.dropShadowOff(event);
    }

    @FXML
    void backOnClicked(MouseEvent event) {
        Stage stage = (Stage) sizeField.getScene().getWindow();

        viewFactory.showMainMenu();
        viewFactory.closeStage(stage);
    }

    @FXML
    void playOnClicked(MouseEvent event) {

        boolean speed = false;
        boolean size = false;

        boolean isSpeedNumeric = speedField.getText().chars().allMatch( Character::isDigit );
        boolean isSizeNumberic = sizeField.getText().chars().allMatch( Character::isDigit );


        if (speedField.getText().isEmpty()) {
            errorLabelSpeed.setText("enter speed value");
        } else if (!isSpeedNumeric || Integer.parseInt(speedField.getText()) < 0) {
            errorLabelSpeed.setText("enter valid value");
        } else {
            speed = true;
        }

        if (sizeField.getText().isEmpty()) {
            errorLabelSize.setText("enter size value");
        } else if (!isSizeNumberic || Integer.parseInt(sizeField.getText()) < 0) {
            errorLabelSize.setText("enter valid value");
        } else {
            size = true;
        }

        if (speed && size) {

            settings.setSpeed(Integer.parseInt(speedField.getText()));
            settings.setColumns(Integer.parseInt(sizeField.getText()));
            settings.setRows(Integer.parseInt(sizeField.getText()));
            Stage stage = (Stage) sizeField.getScene().getWindow();

            viewFactory.showGameWindow();
            viewFactory.closeStage(stage);
        }
    }


    @FXML
    void playOnHover(MouseEvent event) {
        viewFactory.dropShadowOn(event);
    }

    @FXML
    void playOnNotHover(MouseEvent event) {
        viewFactory.dropShadowOff(event);

    }
}
