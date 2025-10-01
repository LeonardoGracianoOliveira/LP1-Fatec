package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {
        Button alienBtn = new Button("Alien");
        alienBtn.setOnAction(e -> new AlienApp().start(new Stage()));

        Button portadorBtn = new Button("Portador");
        portadorBtn.setOnAction(e -> new PortadorApp().start(new Stage()));

        Button relogioBtn = new Button("Relógio");
        relogioBtn.setOnAction(e -> new RelogioApp().start(new Stage()));

        VBox root = new VBox(10, alienBtn, portadorBtn, relogioBtn);
        root.setStyle("-fx-padding: 20");

        Scene scene = new Scene(root, 300, 150);
        stage.setTitle("Omnitrix App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}