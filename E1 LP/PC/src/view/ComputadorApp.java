package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Computador;
import util.CSVWriter;

public class ComputadorApp extends Application {
    @Override
    public void start(Stage stage) {
        TextField tamanhoField = new TextField();
        tamanhoField.setPromptText("Tamanho (double)");

        TextField marcaField = new TextField();
        marcaField.setPromptText("Marca");

        TextField corField = new TextField();
        corField.setPromptText("Cor");

        Button enviar = new Button("Enviar");
        enviar.setOnAction(e -> {
            double tamanho = Double.parseDouble(tamanhoField.getText());
            String marca = marcaField.getText();
            String cor = corField.getText();

            Computador computador = new Computador(tamanho, marca, cor);
            CSVWriter.salvar("Computador," + computador.toString());

            tamanhoField.clear();
            marcaField.clear();
            corField.clear();
        });

        VBox layout = new VBox(10, tamanhoField, marcaField, corField, enviar);
        stage.setScene(new Scene(layout, 300, 200));
        stage.setTitle("Cadastro de Computador");
        stage.show();
    }
}
