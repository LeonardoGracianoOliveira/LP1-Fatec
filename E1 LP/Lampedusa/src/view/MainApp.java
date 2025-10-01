package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {
        Button barcoBtn = new Button("Barco");
        barcoBtn.setOnAction(e -> new BarcoApp().start(new Stage()));

        Button rioBtn = new Button("Rio");
        rioBtn.setOnAction(e -> new RioApp().start(new Stage()));

        Button cidadeBtn = new Button("Cidade");
        cidadeBtn.setOnAction(e -> new CidadeApp().start(new Stage()));

        VBox root = new VBox(10, barcoBtn, rioBtn, cidadeBtn);
        root.setStyle("-fx-padding: 20");
        Scene scene = new Scene(root, 300, 150);

        stage.setTitle("Lampedusa - Cadastro");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}