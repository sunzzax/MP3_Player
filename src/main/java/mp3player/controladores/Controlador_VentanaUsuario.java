/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mp3player.controladores;

import mp3player.main.utilidades.VentanaUsuarioBuscadorUtil;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author kira
 */
public class Controlador_VentanaUsuario implements Initializable {
    
    @FXML
    private ComboBox<String> cmbFiltrar;
    
    private VentanaUsuarioBuscadorUtil buscador;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        buscador = new VentanaUsuarioBuscadorUtil();
        buscador.setComboBox(cmbFiltrar);
        buscador.añadirElementos();
    }

}
