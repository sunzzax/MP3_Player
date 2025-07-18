/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mp3player.main.controladores;

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
        // Se activa cuando se escribe algo es un addListener y llama al 
        // método actualizarLista()
        // obs es el objeto que esta observando por ejemplo la propiedad del texto TextField
        // oldVal es el valor anterior al cambio
        // newVal es el nuevo valor después del cambio
        /*
        Imagina que tienes un TextField y el usuario escribe dentro de él:

        Primero está vacío: ""

        El usuario escribe una letra: ahora es "a"

        Entonces:

        oldVal será ""

        newVal será "a"

        Y si luego el usuario escribe "ab":

        oldVal será "a"

        newVal será "ab"
         */
        txfBuscar.textProperty().addListener((obs, oldVal, newVal) -> actualizarLista());
        // Esto se ejecuta cuando el usuario cambia la selección del Combobox y
        // llama a actualizarLista()
        
        cmbFiltrar.setOnAction(event -> actualizarLista());

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
