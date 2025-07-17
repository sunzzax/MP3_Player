/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mp3player.controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author kira
 */
public class Controlador_Buscador implements Initializable {

    // Combobox que lo utilizaré para mostrar los géneros de musica
    private ComboBox<String> comboBoxFiltrar;
    
    // Aqui guardo una referencia al ComboBox de Ventana de Usuario para usarlo
    // desde esta clase
    public void setComboBox(ComboBox<String> comboBoxFiltrar) {
        this.comboBoxFiltrar = comboBoxFiltrar;
    }
    
    //Este método añade los generos al combobox de la ventana de usuario que
    // habiamos recibido en setComboBox
    public void añadirElementos() {
        if(comboBoxFiltrar != null) {
            comboBoxFiltrar.getItems().addAll("Cualquiera, Phonk", "Clasica", "Electronica", "Pop");
        }
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
