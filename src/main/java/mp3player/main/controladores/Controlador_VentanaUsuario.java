/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mp3player.main.controladores;

import mp3player.main.utilidades.BuscadorCancionesUtil;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import mp3player.main.DAO.CancionDAO;
import mp3player.main.modelos.Modelo_Cancion;
import mp3player.main.modelos.Modelo_Usuario;
import mp3player.main.utilidades.BuscadorFavoritosUtil;

/**
 * FXML Controller class
 *
 * @author kira
 */
public class Controlador_VentanaUsuario implements Initializable {

    @FXML
    private ComboBox<String> cmbFiltrar;
    @FXML
    private TextField txfBuscar, txfFavoritos;

    private CancionDAO dao;
    
    @FXML
    private ListView<Modelo_Cancion> listViewCanciones, listViewCancionesFavoritas;

    //Método que controla el botón de añadir canciones a la lista de favoritos
    @FXML
    private void añadirFavoritos(ActionEvent event) {
        Modelo_Cancion cancionSeleccionada = listViewCanciones.getSelectionModel().getSelectedItem();
        if (cancionSeleccionada != null && !listViewCancionesFavoritas.getItems().contains(cancionSeleccionada)) {
            int idUsuario = Modelo_Usuario.getUsuarioActual().getID();
            int idCancion = cancionSeleccionada.getID();
            dao.insertarFavoritos(idUsuario, idCancion);
            // En vez de añadir directamente, recargo la lista desde la BD para evitar duplicados
            List<Modelo_Cancion> cancionesFavoritas = BuscadorFavoritosUtil.buscarCancionesFavoritas(txfFavoritos);
            listViewCancionesFavoritas.getItems().setAll(cancionesFavoritas);
        } else if(cancionSeleccionada == null) {
            System.out.println("Selecciona una canción para añadir a favoritos");
        }
        
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dao = new CancionDAO();
        BuscadorCancionesUtil.añadirElementos(cmbFiltrar);

        // Actualiza las listas cuando cambia el texto del buscador principal o favoritos
        txfBuscar.textProperty().addListener((obs, antiguoValor, nuevoValor) -> actualizarListas());
        txfFavoritos.textProperty().addListener((obs, antiguoValor, nuevoValor) -> actualizarListas());
        // Actualiza la lista cuando se cambia la opción del ComboBox
        cmbFiltrar.setOnAction(event -> actualizarListas());

        // Carga inicial de las listas
        actualizarListas();

    }

    private void actualizarListas() {
        // Actualiza la lista de busqueda
        List<Modelo_Cancion> canciones = BuscadorCancionesUtil.buscarCanciones(txfBuscar, cmbFiltrar);
        // JavaFX invoca internamente el método toString() de cada objeto para obtener la representación 
        // en texto que se verá en la lista.
        // Eso hace que cada objeto Modelo_Cancion se muestre así en el ListView:
        // Whatsup - DJ Pepe (Pop)
        
        // Actualiza la lista de busqueda favoritos
        List<Modelo_Cancion> cancionesFavoritas = BuscadorFavoritosUtil.buscarCancionesFavoritas(txfFavoritos);

        listViewCanciones.getItems().setAll(canciones);
        listViewCancionesFavoritas.getItems().setAll(cancionesFavoritas);
    }

}
