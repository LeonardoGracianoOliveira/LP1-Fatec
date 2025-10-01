package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Narrador;
import util.CSVWriter;

public class NarradorApp extends Application {
    @Override
    public void start(Stage stage) {
        TextField nomeField = new TextField();
        nomeField.setPromptText("Nome");

        TextField idadeField = new TextField();
        idadeField.setPromptText("Idade (int)");

        TextField aparenciaField = new TextField();
        aparenciaField.setPromptText("Aparência");

        Button enviar = new Button("Enviar");
        enviar.setOnAction(e -> {
            String nome = nomeField.getText();
            int idade = Integer.parseInt(idadeField.getText());
            String aparencia = aparenciaField.getText();

            Narrador narrador = new Narrador(nome, idade, aparencia);
            CSVWriter.salvar("Narrador," + narrador.toString());

            nomeField.clear();
            idadeField.clear();
            aparenciaField.clear();
        });

        VBox layout = new VBox(10, nomeField, idadeField, aparenciaField, enviar);
        stage.setScene(new Scene(layout, 300, 200));
        stage.setTitle("Cadastro de Narrador");
        stage.show();
    }
}
