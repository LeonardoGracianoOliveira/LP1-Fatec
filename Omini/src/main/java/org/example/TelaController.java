package org.example;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.List;

public class TelaController {

    // Portador fields
    @FXML private TextField pNome;
    @FXML private TextField pDescricao;
    @FXML private TextField pIdade;
    @FXML private TableView<Portador> pTable;
    @FXML private TableColumn<Portador, String> pColNome;
    @FXML private TableColumn<Portador, String> pColDescricao;
    @FXML private TableColumn<Portador, Integer> pColIdade;

    // Alien fields
    @FXML private TextField aRaca;
    @FXML private TextField aNome;
    @FXML private TextField aDna;
    @FXML private TableView<Alien> aTable;
    @FXML private TableColumn<Alien, String> aColRaca;
    @FXML private TableColumn<Alien, String> aColNome;
    @FXML private TableColumn<Alien, Integer> aColDna;

    // Relogio fields
    @FXML private TextField rCor;
    @FXML private TextField rNome;
    @FXML private TextField rVersao;
    @FXML private TableView<Relogio> rTable;
    @FXML private TableColumn<Relogio, String> rColCor;
    @FXML private TableColumn<Relogio, String> rColNome;
    @FXML private TableColumn<Relogio, Integer> rColVersao;

    private final PortadorRepository portRepo = new PortadorRepository();
    private final AlienRepository alienRepo = new AlienRepository();
    private final RelogioRepository relRepo = new RelogioRepository();

    @FXML
    public void initialize() {
        // Portador table setup
        pColNome.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getNome()));
        pColDescricao.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getDescricao()));
        pColIdade.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getIdade()).asObject());
        refreshPortadores();

        // Alien table setup
        aColRaca.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getRaca()));
        aColNome.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getNome()));
        aColDna.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getDna()).asObject());
        refreshAliens();

        // Relogio table setup
        rColCor.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getCor()));
        rColNome.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getNome()));
        rColVersao.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getVersao()).asObject());
        refreshRelogios();

        // row selection to populate form (portador)
        pTable.getSelectionModel().selectedItemProperty().addListener((obs, oldV, newV) -> {
            if (newV != null) {
                pNome.setText(newV.getNome());
                pDescricao.setText(newV.getDescricao());
                pIdade.setText(String.valueOf(newV.getIdade()));
            }
        });

        aTable.getSelectionModel().selectedItemProperty().addListener((obs, oldV, newV) -> {
            if (newV != null) {
                aRaca.setText(newV.getRaca());
                aNome.setText(newV.getNome());
                aDna.setText(String.valueOf(newV.getDna()));
            }
        });

        rTable.getSelectionModel().selectedItemProperty().addListener((obs, oldV, newV) -> {
            if (newV != null) {
                rCor.setText(newV.getCor());
                rNome.setText(newV.getNome());
                rVersao.setText(String.valueOf(newV.getVersao()));
            }
        });
    }

    // --- Portador actions ---
    @FXML public void onCreatePortador() {
        try {
            Portador p = new Portador(pNome.getText(), pDescricao.getText(), Integer.parseInt(pIdade.getText()));
            if (portRepo.create(p)) {
                refreshPortadores(); clearPortadorFields();
            } else alert("Erro ao inserir Portador.");
        } catch (Exception e) { alert("Entrada inválida: " + e.getMessage()); }
    }

    @FXML public void onUpdatePortador() {
        try {
            Portador p = new Portador(pNome.getText(), pDescricao.getText(), Integer.parseInt(pIdade.getText()));
            if (portRepo.update(p)) { refreshPortadores(); } else alert("Nenhuma linha atualizada.");
        } catch (Exception e) { alert("Entrada inválida: " + e.getMessage()); }
    }

    @FXML public void onDeletePortador() {
        if (portRepo.deleteByName(pNome.getText())) { refreshPortadores(); clearPortadorFields(); }
        else alert("Erro ao deletar Portador.");
    }

    @FXML public void onClearPortador() { clearPortadorFields(); }

    private void refreshPortadores() {
        List<Portador> list = portRepo.readAll();
        pTable.setItems(FXCollections.observableArrayList(list));
    }

    private void clearPortadorFields() {
        pNome.clear(); pDescricao.clear(); pIdade.clear();
    }

    // --- Alien actions ---
    @FXML public void onCreateAlien() {
        try {
            Alien a = new Alien(aRaca.getText(), aNome.getText(), Integer.parseInt(aDna.getText()));
            if (alienRepo.create(a)) { refreshAliens(); clearAlienFields(); }
            else alert("Erro ao inserir Alien.");
        } catch (Exception e) { alert("Entrada inválida: " + e.getMessage()); }
    }

    @FXML public void onUpdateAlien() {
        try {
            Alien a = new Alien(aRaca.getText(), aNome.getText(), Integer.parseInt(aDna.getText()));
            if (alienRepo.update(a)) { refreshAliens(); } else alert("Nenhuma linha atualizada.");
        } catch (Exception e) { alert("Entrada inválida: " + e.getMessage()); }
    }

    @FXML public void onDeleteAlien() {
        if (alienRepo.deleteByName(aNome.getText())) { refreshAliens(); clearAlienFields(); }
        else alert("Erro ao deletar Alien.");
    }

    @FXML public void onClearAlien() { clearAlienFields(); }

    private void refreshAliens() {
        List<Alien> list = alienRepo.readAll();
        aTable.setItems(FXCollections.observableArrayList(list));
    }

    private void clearAlienFields() {
        aRaca.clear(); aNome.clear(); aDna.clear();
    }

    // --- Relogio actions ---
    @FXML public void onCreateRelogio() {
        try {
            Relogio r = new Relogio(rCor.getText(), rNome.getText(), Integer.parseInt(rVersao.getText()));
            if (relRepo.create(r)) { refreshRelogios(); clearRelogioFields(); }
            else alert("Erro ao inserir Relógio.");
        } catch (Exception e) { alert("Entrada inválida: " + e.getMessage()); }
    }

    @FXML public void onUpdateRelogio() {
        try {
            Relogio r = new Relogio(rCor.getText(), rNome.getText(), Integer.parseInt(rVersao.getText()));
            if (relRepo.update(r)) { refreshRelogios(); } else alert("Nenhuma linha atualizada.");
        } catch (Exception e) { alert("Entrada inválida: " + e.getMessage()); }
    }

    @FXML public void onDeleteRelogio() {
        if (relRepo.deleteByName(rNome.getText())) { refreshRelogios(); clearRelogioFields(); }
        else alert("Erro ao deletar Relógio.");
    }

    @FXML public void onClearRelogio() { clearRelogioFields(); }

    private void refreshRelogios() {
        List<Relogio> list = relRepo.readAll();
        rTable.setItems(FXCollections.observableArrayList(list));
    }

    private void clearRelogioFields() {
        rCor.clear(); rNome.clear(); rVersao.clear();
    }

    private void alert(String msg) {
        new Alert(Alert.AlertType.INFORMATION, msg).showAndWait();
    }
}