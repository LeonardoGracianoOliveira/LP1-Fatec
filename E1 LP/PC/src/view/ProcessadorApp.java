package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Processador;
import util.CSVWriter;

public class ProcessadorApp extends Application {
    @Override
    public void start(Stage stage) {
        TextField arquiteturaField = new TextField();
        arquiteturaField.setPromptText("Arquitetura");

        TextField memoriaField = new TextField();
        memoriaField.setPromptText("Memória (int)");

        TextField geracaoField = new TextField();
        geracaoField.setPromptText("Geração (int)");

        Button enviar = new Button("Enviar");
        enviar.setOnAction(e -> {
            String arquitetura = arquiteturaField.getText();
            int memoria = Integer.parseInt(memoriaField.getText());
            int geracao = Integer.parseInt(geracaoField.getText());

            Processador processador = new Processador(arquitetura, memoria, geracao);
            CSVWriter.salvar("Processador," + processador.toString());

            arquiteturaField.clear();
            memoriaField.clear();
            geracaoField.clear();
        });

        VBox layout = new VBox(10, arquiteturaField, memoriaField, geracaoField, enviar);
        stage.setScene(new Scene(layout, 300, 200));
        stage.setTitle("Cadastro de Processador");
        stage.show();
    }
}
