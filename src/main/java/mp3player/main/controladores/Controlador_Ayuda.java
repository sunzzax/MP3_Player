/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mp3player.main.controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import mp3player.main.utilidades.AbrirVentanasUtil;

/**
 * FXML Controller class
 *
 * @author kira
 */
public class Controlador_Ayuda implements Initializable {

    @FXML
    private Button btnVolverInicioSesion;

    @FXML
    private void pulsarBtnVolverInicioSesion(ActionEvent event) {
        AbrirVentanasUtil.cerrarVentanaActual(btnVolverInicioSesion);
        AbrirVentanasUtil.abrirVentana("/vistas/FXML_IniciarSesion.fxml", "MP3_Player");
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
