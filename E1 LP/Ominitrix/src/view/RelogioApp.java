package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Relogio;
import util.CSVWriter;

public class RelogioApp extends Application {

    @Override
    public void start(Stage stage) {
        TextField corField = new TextField();
        corField.setPromptText("Cor");

        TextField versaoField = new TextField();
        versaoField.setPromptText("Versão");

        TextField nomeField = new TextField();
        nomeField.setPromptText("Nome");

        Button enviarBtn = new Button("Enviar");
        enviarBtn.setOnAction(e -> {
            try {
                String cor = corField.getText();
                int versao = Integer.parseInt(versaoField.getText());
                String nome = nomeField.getText();

                Relogio relogio = new Relogio(cor, versao, nome);
                CSVWriter.salvar("Relogio," + relogio.toString());

                corField.clear();
                versaoField.clear();
                nomeField.clear();

                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Relógio salvo com sucesso!");
                alert.show();
            } catch (NumberFormatException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Versão inválida! Digite um número inteiro.");
                alert.show();
            }
        });

        VBox root = new VBox(10, corField, versaoField, nomeField, enviarBtn);
        root.setStyle("-fx-padding: 20");
        Scene scene = new Scene(root, 300, 250);
        stage.setTitle("Cadastro Relógio");
        stage.setScene(scene);
        stage.show();
    }
}