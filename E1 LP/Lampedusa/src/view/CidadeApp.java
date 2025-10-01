package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Cidade;
import util.CSVWriter;

public class CidadeApp extends Application {

    @Override
    public void start(Stage stage) {
        TextField nomeField = new TextField();
        nomeField.setPromptText("Nome da Cidade");

        TextField siglaField = new TextField();
        siglaField.setPromptText("Sigla");

        TextField populacaoField = new TextField();
        populacaoField.setPromptText("População");

        Button enviarBtn = new Button("Enviar");
        enviarBtn.setOnAction(e -> {
            try {
                String nome = nomeField.getText();
                String sigla = siglaField.getText();
                int populacao = Integer.parseInt(populacaoField.getText());

                Cidade cidade = new Cidade(nome, sigla, populacao);
                CSVWriter.salvar("Cidade," + cidade.toString());

                nomeField.clear();
                siglaField.clear();
                populacaoField.clear();

                new Alert(Alert.AlertType.INFORMATION, "Cidade salva com sucesso!").show();
            } catch (NumberFormatException ex) {
                new Alert(Alert.AlertType.ERROR, "População inválida! Digite um número inteiro.").show();
            }
        });

        VBox root = new VBox(10, nomeField, siglaField, populacaoField, enviarBtn);
        root.setStyle("-fx-padding: 20");
        Scene scene = new Scene(root, 300, 250);

        stage.setTitle("Cadastro Cidade");
        stage.setScene(scene);
        stage.show();
    }
}
