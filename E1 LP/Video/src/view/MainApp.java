package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) {
        Button narradorBtn = new Button("Narrador");
        narradorBtn.setOnAction(e -> new NarradorApp().start(new Stage()));

        Button historiaBtn = new Button("História");
        historiaBtn.setOnAction(e -> new HistoriaApp().start(new Stage()));

        Button personagemBtn = new Button("Personagem");
        personagemBtn.setOnAction(e -> new PersonagemApp().start(new Stage()));

        VBox layout = new VBox(15, narradorBtn, historiaBtn, personagemBtn);
        stage.setScene(new Scene(layout, 300, 200));
        stage.setTitle("Sistema Video");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}