package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
        Scene scene = new Scene(fxml.load());
        stage.setTitle("JavaFX MySQL CRUD - Alien / Relogio / Portador");
        stage.setScene(scene);
        stage.setWidth(800);
        stage.setHeight(600);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
