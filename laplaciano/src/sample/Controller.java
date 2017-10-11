package sample;

import gradiente.Gradiente;
import laplaciano.Algoritmo;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Button abrirArquivo;

    private Algoritmo algoritmo;

    private Gradiente gradiente;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private ImageView binaria;

    @FXML
    private ImageView rotulada;

    @FXML
    private Label binariaTxt;

    @FXML
    private Label rotuladaTxt;

    @FXML
    private Label quantidadeTxt;

    @FXML
    private void seletorArquivo() throws IOException {
        Stage mainStage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Abrir Arquivo");
        boolean b = fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Imagem", "*.png", "*.jpg", "*.jpeg"));
        File selectedFile = fileChooser.showOpenDialog(mainStage);
        if (selectedFile != null) {
            System.out.println("Arquivo Enviado para Interpolação.");
            this.algoritmo = new Algoritmo(selectedFile);
            this.algoritmo.aplicarLaplaciano();
            this.gradiente = new Gradiente(selectedFile);
            this.gradiente.aplicarSobel();
        }

    }

}