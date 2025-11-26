package controller;

import dao.AlienDao;
import dao.PortadorDao;
import dao.RelogioDao;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Alien;
import model.Portador;
import model.Relogio;

import java.util.List;
import java.util.Optional;

public class MainController {

    @FXML private ComboBox<String> cbClass;
    @FXML private TextField tf1, tf2, tf3;
    @FXML private Button btnCreate, btnUpdate, btnDelete, btnRefresh, btnClear;
    @FXML private TableView<Object> table;
    @FXML private TableColumn<Object, Object> colId, colA, colB, colC;
    @FXML private Label lblStatus;

    private AlienDao alienDao = new AlienDao();
    private RelogioDao relogioDao = new RelogioDao();
    private PortadorDao portadorDao = new PortadorDao();

    private ObservableList<Object> data = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        cbClass.getItems().addAll("Alien", "Relogio", "Portador");
        cbClass.getSelectionModel().selectFirst();
        setupTable();
        cbClass.setOnAction(e -> refreshTable());
        table.getSelectionModel().selectedItemProperty().addListener((obs, old, sel) -> onTableSelect(sel));
        btnCreate.setOnAction(e -> handleCreate());
        btnUpdate.setOnAction(e -> handleUpdate());
        btnDelete.setOnAction(e -> handleDelete());
        btnRefresh.setOnAction(e -> refreshTable());
        btnClear.setOnAction(e -> clearFields());
        refreshTable();
    }

    private void setupTable() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colA.setCellValueFactory(new PropertyValueFactory<>("nome")); // default
        colB.setCellValueFactory(new PropertyValueFactory<>("planetaDeOrigem")); // default for Alien
        colC.setCellValueFactory(new PropertyValueFactory<>("dna")); // default for Alien
        table.setItems(data);
    }

    private void onTableSelect(Object sel) {
        if (sel == null) {
            clearFields();
            return;
        }
        if (sel instanceof Alien) {
            Alien a = (Alien) sel;
            tf1.setText(a.getNome());
            tf2.setText(a.getPlanetaDeOrigem());
            tf3.setText(String.valueOf(a.getDna()));
        } else if (sel instanceof Relogio) {
            Relogio r = (Relogio) sel;
            tf1.setText(r.getModelo());
            tf2.setText(r.getCor());
            tf3.setText(String.valueOf(r.getVersao()));
        } else if (sel instanceof Portador) {
            Portador p = (Portador) sel;
            tf1.setText(p.getNome());
            tf2.setText(p.getAparencia());
            tf3.setText(String.valueOf(p.getIdade()));
        }
    }

    private void refreshTable() {
        data.clear();
        String cls = cbClass.getValue();
        lblStatus.setText("Carregando: " + cls);
        new Thread(() -> {
            try {
                if ("Alien".equals(cls)) {
                    List<Alien> list = alienDao.findAll();
                    Platform.runLater(() -> {
                        colA.setCellValueFactory(new PropertyValueFactory<>("nome"));
                        colB.setCellValueFactory(new PropertyValueFactory<>("planetaDeOrigem"));
                        colC.setCellValueFactory(new PropertyValueFactory<>("dna"));
                        data.addAll(list);
                        lblStatus.setText("Pronto");
                    });
                } else if ("Relogio".equals(cls)) {
                    List<Relogio> list = relogioDao.findAll();
                    Platform.runLater(() -> {
                        colA.setCellValueFactory(new PropertyValueFactory<>("modelo"));
                        colB.setCellValueFactory(new PropertyValueFactory<>("cor"));
                        colC.setCellValueFactory(new PropertyValueFactory<>("versao"));
                        data.addAll(list);
                        lblStatus.setText("Pronto");
                    });
                } else if ("Portador".equals(cls)) {
                    List<Portador> list = portadorDao.findAll();
                    Platform.runLater(() -> {
                        colA.setCellValueFactory(new PropertyValueFactory<>("nome"));
                        colB.setCellValueFactory(new PropertyValueFactory<>("aparencia"));
                        colC.setCellValueFactory(new PropertyValueFactory<>("idade"));
                        data.addAll(list);
                        lblStatus.setText("Pronto");
                    });
                }
            } catch (Exception ex) {
                Platform.runLater(() -> lblStatus.setText("Erro: " + ex.getMessage()));
                ex.printStackTrace();
            }
        }).start();
    }

    private void handleCreate() {
        String cls = cbClass.getValue();
        try {
            if ("Alien".equals(cls)) {
                Alien a = new Alien(tf1.getText().trim(), tf2.getText().trim(), Integer.parseInt(tf3.getText().trim()));
                alienDao.create(a);
            } else if ("Relogio".equals(cls)) {
                Relogio r = new Relogio(tf1.getText().trim(), tf2.getText().trim(), Integer.parseInt(tf3.getText().trim()));
                relogioDao.create(r);
            } else if ("Portador".equals(cls)) {
                Portador p = new Portador(tf1.getText().trim(), tf2.getText().trim(), Integer.parseInt(tf3.getText().trim()));
                portadorDao.create(p);
            }
            refreshTable();
            clearFields();
            lblStatus.setText("Criado com sucesso");
        } catch (Exception e) {
            lblStatus.setText("Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void handleUpdate() {
        Object sel = table.getSelectionModel().getSelectedItem();
        if (sel == null) {
            lblStatus.setText("Selecione um registro para atualizar");
            return;
        }
        try {
            if (sel instanceof Alien) {
                Alien a = (Alien) sel;
                a.setNome(tf1.getText().trim());
                a.setPlanetaDeOrigem(tf2.getText().trim());
                a.setDna(Integer.parseInt(tf3.getText().trim()));
                alienDao.update(a);
            } else if (sel instanceof Relogio) {
                Relogio r = (Relogio) sel;
                r.setModelo(tf1.getText().trim());
                r.setCor(tf2.getText().trim());
                r.setVersao(Integer.parseInt(tf3.getText().trim()));
                relogioDao.update(r);
            } else if (sel instanceof Portador) {
                Portador p = (Portador) sel;
                p.setNome(tf1.getText().trim());
                p.setAparencia(tf2.getText().trim());
                p.setIdade(Integer.parseInt(tf3.getText().trim()));
                portadorDao.update(p);
            }
            refreshTable();
            lblStatus.setText("Atualizado com sucesso");
        } catch (Exception e) {
            lblStatus.setText("Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void handleDelete() {
        Object sel = table.getSelectionModel().getSelectedItem();
        if (sel == null) {
            lblStatus.setText("Selecione um registro para deletar");
            return;
        }
        Alert conf = new Alert(Alert.AlertType.CONFIRMATION, "Confirma exclusão?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> res = conf.showAndWait();
        if (res.isEmpty() || res.get() != ButtonType.YES) return;

        try {
            if (sel instanceof Alien) {
                alienDao.delete(((Alien) sel).getId());
            } else if (sel instanceof Relogio) {
                relogioDao.delete(((Relogio) sel).getId());
            } else if (sel instanceof Portador) {
                portadorDao.delete(((Portador) sel).getId());
            }
            refreshTable();
            clearFields();
            lblStatus.setText("Deletado com sucesso");
        } catch (Exception e) {
            lblStatus.setText("Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void clearFields() {
        tf1.clear();
        tf2.clear();
        tf3.clear();
        table.getSelectionModel().clearSelection();
    }
}
