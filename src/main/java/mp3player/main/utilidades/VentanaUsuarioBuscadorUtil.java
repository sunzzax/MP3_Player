/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mp3player.main.utilidades;

import java.util.List;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import mp3player.main.DAO.CancionDAO;
import mp3player.main.modelos.Modelo_Cancion;

/**
 * FXML Controller class
 *
 * @author kira
 */
public class VentanaUsuarioBuscadorUtil {

    //Este método estático añade los generos al combobox de la ventana de usuario que
    // habiamos recibido en setComboBox
    public static void añadirElementos(ComboBox<String> comboBoxFiltrar) {
        if (comboBoxFiltrar != null) {
            comboBoxFiltrar.getItems().addAll("Todos", "Phonk", "Clasica", "Electronica", "Pop", "Jersey");
            comboBoxFiltrar.setValue("Todos");
        }
    }

    public static List<Modelo_Cancion> buscarCanciones(TextField buscador, ComboBox<String> cbxGenero) {
        String texto = "%" + buscador.getText().trim() + "%";
        String genero = cbxGenero.getValue();

        CancionDAO dao = new CancionDAO();
        return dao.buscarCanciones(texto, genero);
    }

}
