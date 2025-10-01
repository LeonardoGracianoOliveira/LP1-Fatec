package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Barco;
import util.CSVWriter;

public class BarcoApp extends Application {

    @Override
    public void start(Stage stage) {
        TextField materialField = new TextField();
        materialField.setPromptText("Material");

        TextField tamanhoField = new TextField();
        tamanhoField.setPromptText("Tamanho");

        TextField pesoField = new TextField();
        pesoField.setPromptText("Peso");

        Button enviarBtn = new Button("Enviar");
        enviarBtn.setOnAction(e -> {
            try {
                String material = materialField.getText();
                double tamanho = Double.parseDouble(tamanhoField.getText());
                double peso = Double.parseDouble(pesoField.getText());

                Barco barco = new Barco(material, tamanho, peso);
                CSVWriter.salvar("Barco," + barco.toString());

                materialField.clear();
                tamanhoField.clear();
                pesoField.clear();

                new Alert(Alert.AlertType.INFORMATION, "Barco salvo com sucesso!").show();
            } catch (NumberFormatException ex) {
                new Alert(Alert.AlertType.ERROR, "Tamanho/Peso inválidos! Digite números.").show();
            }
        });

        VBox root = new VBox(10, materialField, tamanhoField, pesoField, enviarBtn);
        root.setStyle("-fx-padding: 20");
        Scene scene = new Scene(root, 300, 250);

        stage.setTitle("Cadastro Barco");
        stage.setScene(scene);
        stage.show();
    }
}
