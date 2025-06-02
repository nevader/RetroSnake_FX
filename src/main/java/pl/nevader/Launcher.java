package pl.s24825;

import javafx.application.Application;
import javafx.stage.Stage;
import pl.s24825.view.ViewFactory;

public class Launcher extends Application {
    public static void main(String[] args) {

        launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {

        Settings settings = new Settings();
        ViewFactory viewFactory = new ViewFactory(settings);
        viewFactory.showMainMenu();

    }
}
