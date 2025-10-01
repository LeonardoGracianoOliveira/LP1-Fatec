package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Alien;
import util.CSVWriter;

public class AlienApp extends Application {

    @Override
    public void start(Stage stage) {
        TextField racaField = new TextField();
        racaField.setPromptText("Raça");

        TextField planetaField = new TextField();
        planetaField.setPromptText("Planeta de Origem");

        TextField dnaField = new TextField();
        dnaField.setPromptText("DNA");

        Button enviarBtn = new Button("Enviar");
        enviarBtn.setOnAction(e -> {
            String raca = racaField.getText();
            String planeta = planetaField.getText();
            int dna = Integer.parseInt(dnaField.getText());

            Alien alien = new Alien(raca, planeta, dna);
            CSVWriter.salvar("Alien," + alien.toString());

            racaField.clear();
            planetaField.clear();
            dnaField.clear();

            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Alien salvo com sucesso!");
            alert.show();
        });

        VBox root = new VBox(10, racaField, planetaField, dnaField, enviarBtn);
        root.setStyle("-fx-padding: 20");
        Scene scene = new Scene(root, 300, 250);
        stage.setTitle("Cadastro Alien");
        stage.setScene(scene);
        stage.show();
    }
}