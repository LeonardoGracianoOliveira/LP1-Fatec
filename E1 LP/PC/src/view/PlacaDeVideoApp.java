package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.PlacaDeVideo;
import util.CSVWriter;

public class PlacaDeVideoApp extends Application {
    @Override
    public void start(Stage stage) {
        TextField fabricanteField = new TextField();
        fabricanteField.setPromptText("Fabricante");

        TextField linhaField = new TextField();
        linhaField.setPromptText("Linha (int)");

        TextField vramField = new TextField();
        vramField.setPromptText("vRAM (int)");

        Button enviar = new Button("Enviar");
        enviar.setOnAction(e -> {
            String fabricante = fabricanteField.getText();
            int linha = Integer.parseInt(linhaField.getText());
            int vRam = Integer.parseInt(vramField.getText());

            PlacaDeVideo placa = new PlacaDeVideo(fabricante, linha, vRam);
            CSVWriter.salvar("PlacaDeVideo," + placa.toString());

            fabricanteField.clear();
            linhaField.clear();
            vramField.clear();
        });

        VBox layout = new VBox(10, fabricanteField, linhaField, vramField, enviar);
        stage.setScene(new Scene(layout, 300, 200));
        stage.setTitle("Cadastro de Placa de Vídeo");
        stage.show();
    }
}
