package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Portador;
import util.CSVWriter;

public class PortadorApp extends Application {

    @Override
    public void start(Stage stage) {
        TextField nomeField = new TextField();
        nomeField.setPromptText("Nome");

        TextField idadeField = new TextField();
        idadeField.setPromptText("Idade");

        TextField aparenciaField = new TextField();
        aparenciaField.setPromptText("Aparência");

        Button enviarBtn = new Button("Enviar");
        enviarBtn.setOnAction(e -> {
            try {
                String nome = nomeField.getText();
                int idade = Integer.parseInt(idadeField.getText());
                String aparencia = aparenciaField.getText();

                Portador portador = new Portador(nome, idade, aparencia);
                CSVWriter.salvar("Portador," + portador.toString());

                nomeField.clear();
                idadeField.clear();
                aparenciaField.clear();

                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Portador salvo com sucesso!");
                alert.show();
            } catch (NumberFormatException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Idade inválida! Digite um número inteiro.");
                alert.show();
            }
        });

        VBox root = new VBox(10, nomeField, idadeField, aparenciaField, enviarBtn);
        root.setStyle("-fx-padding: 20");
        Scene scene = new Scene(root, 300, 250);
        stage.setTitle("Cadastro Portador");
        stage.setScene(scene);
        stage.show();
    }
}