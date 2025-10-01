package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Historia;
import util.CSVWriter;

public class HistoriaApp extends Application {
    @Override
    public void start(Stage stage) {
        TextField nomeField = new TextField();
        nomeField.setPromptText("Nome");

        TextField duracaoField = new TextField();
        duracaoField.setPromptText("Duração (int)");

        TextField criadorField = new TextField();
        criadorField.setPromptText("Criador");

        Button enviar = new Button("Enviar");
        enviar.setOnAction(e -> {
            String nome = nomeField.getText();
            int duracao = Integer.parseInt(duracaoField.getText());
            String criador = criadorField.getText();

            Historia historia = new Historia(nome, duracao, criador);
            CSVWriter.salvar("Historia," + historia.toString());

            nomeField.clear();
            duracaoField.clear();
            criadorField.clear();
        });

        VBox layout = new VBox(10, nomeField, duracaoField, criadorField, enviar);
        stage.setScene(new Scene(layout, 300, 200));
        stage.setTitle("Cadastro de História");
        stage.show();
    }
}
