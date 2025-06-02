package pl.s24825.controller;

import pl.s24825.Settings;
import pl.s24825.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import java.util.ResourceBundle;

public class HighScoresController extends BaseController implements Initializable {
    public HighScoresController(ViewFactory viewFactory, String fxmlName, Settings settings) {
        super(viewFactory, fxmlName, settings);
    }

    @FXML
    private ImageView backBtn;

    @FXML
    private TextArea highscoreTableName;

    @FXML
    private TextArea highscoreTableScore;

    @FXML
    void backClicked(MouseEvent event) {
        Stage stage = (Stage) highscoreTableName.getScene().getWindow();

        viewFactory.showMainMenu();
        viewFactory.closeStage(stage);
    }

    @FXML
    void backNotHover(MouseEvent event) {
        viewFactory.dropShadowOff(event);

    }

    @FXML
    void backOnHover(MouseEvent event) {
        viewFactory.dropShadowOn(event);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pupulateHighScore();
        highscoreTableName.scrollTopProperty().bindBidirectional(highscoreTableScore.scrollTopProperty());
    }

    private void pupulateHighScore() {

        ArrayList<String> high = new ArrayList<>();

        FileReader fileReader;
        BufferedReader bufferedReader = null;

        try {

            fileReader = new FileReader("highscore.txt");
            bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();

            while (line != null) {
                high.add(line);
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<String> sortedHigh = bubbleSort(high, high.size());

        for (int i = sortedHigh.size(); i >= 1; i--) {

            highscoreTableName.appendText(digitremove(sortedHigh.get(i-1)) + "\n");
            highscoreTableScore.appendText(stringtoint(sortedHigh.get(i-1)) + "\n");
        }
    }

    public ArrayList<String> bubbleSort(ArrayList<String> arr, int n) {
        if (n == 1)                     //passes are done
        {
            return arr;
        }

        for (int i=0; i<n-1; i++)       //iteration through unsorted elements
        {
            long arri = stringtoint(arr.get(i));
            long arri1 = stringtoint(arr.get(i+1));
            if (arri > arri1)      //check if the elements are in order
            {                           //if not, swap them
                String temp = arr.get(i);
                arr.set(i, arr.get(i+1));
                arr.set(i+1, temp);
            }
        }

        bubbleSort(arr, n-1);           //one pass done, proceed to the next
        return arr;
    }


    public long stringtoint(String st) {
        String DIGIT_AND_DECIMAL_REGEX = "[^\\d.]";
        String digits = st.replaceAll(DIGIT_AND_DECIMAL_REGEX, "");
        return Long.parseLong(digits);
    }

    public String digitremove(String st) {
        String Regex = "[\\d]";
        String letters = st.replaceAll(Regex, "");
        return letters.replace(":", "");
    }
}
