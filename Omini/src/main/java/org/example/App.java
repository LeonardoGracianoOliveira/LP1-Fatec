package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Database.init(); // garante criação das tabelas
        FXMLLoader loader = new FXMLLoader(App.class.getResource("tela.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setTitle("Omintrix - CRUD");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}