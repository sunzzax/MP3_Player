/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mp3player.controladores;

import mp3player.main.utilidades.VentanaUsuarioBuscadorUtil;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import mp3player.main.modelos.Modelo_Cancion;

/**
 * FXML Controller class
 *
 * @author kira
 */
public class Controlador_VentanaUsuario implements Initializable {

    @FXML
    private ComboBox<String> cmbFiltrar;
    @FXML
    private TextField txfBuscar;

    @FXML
    private ListView<Modelo_Cancion> listViewCanciones;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        VentanaUsuarioBuscadorUtil.añadirElementos(cmbFiltrar);

        // Actualizar la lista cuando cambia el texto o el género
        txfBuscar.textProperty().addListener((obs, oldVal, newVal) -> actualizarLista());
        cmbFiltrar.setOnAction(e -> actualizarLista());

        actualizarLista(); // Mostrar todo al iniciar

    }

    private void actualizarLista() {
        List<Modelo_Cancion> canciones = VentanaUsuarioBuscadorUtil.buscarCanciones(txfBuscar, cmbFiltrar);
        // JavaFX invoca internamente el método toString() de cada objeto para obtener la representación 
        // en texto que se verá en la lista.
        // Eso hace que cada objeto Modelo_Cancion se muestre así en el ListView:
        // Whatsup - DJ Pepe (Pop)
        listViewCanciones.getItems().setAll(canciones);
    }

}
