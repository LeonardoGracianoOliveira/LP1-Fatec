package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Rio;
import util.CSVWriter;

public class RioApp extends Application {

    @Override
    public void start(Stage stage) {
        TextField nomeField = new TextField();
        nomeField.setPromptText("Nome");

        TextField cepField = new TextField();
        cepField.setPromptText("CEP");

        TextField profundidadeField = new TextField();
        profundidadeField.setPromptText("Profundidade");

        Button enviarBtn = new Button("Enviar");
        enviarBtn.setOnAction(e -> {
            try {
                String nome = nomeField.getText();
                int cep = Integer.parseInt(cepField.getText());
                double profundidade = Double.parseDouble(profundidadeField.getText());

                Rio rio = new Rio(nome, cep, profundidade);
                CSVWriter.salvar("Rio," + rio.toString());

                nomeField.clear();
                cepField.clear();
                profundidadeField.clear();

                new Alert(Alert.AlertType.INFORMATION, "Rio salvo com sucesso!").show();
            } catch (NumberFormatException ex) {
                new Alert(Alert.AlertType.ERROR, "CEP ou Profundidade inválidos!").show();
            }
        });

        VBox root = new VBox(10, nomeField, cepField, profundidadeField, enviarBtn);
        root.setStyle("-fx-padding: 20");
        Scene scene = new Scene(root, 300, 250);

        stage.setTitle("Cadastro Rio");
        stage.setScene(scene);
        stage.show();
    }
}