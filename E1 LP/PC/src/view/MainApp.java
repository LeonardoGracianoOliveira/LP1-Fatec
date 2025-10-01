package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) {
        Button computadorBtn = new Button("Computador");
        computadorBtn.setOnAction(e -> new ComputadorApp().start(new Stage()));

        Button processadorBtn = new Button("Processador");
        processadorBtn.setOnAction(e -> new ProcessadorApp().start(new Stage()));

        Button placaBtn = new Button("Placa de Vídeo");
        placaBtn.setOnAction(e -> new PlacaDeVideoApp().start(new Stage()));

        VBox layout = new VBox(15, computadorBtn, processadorBtn, placaBtn);
        stage.setScene(new Scene(layout, 300, 200));
        stage.setTitle("Sistema PC");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
