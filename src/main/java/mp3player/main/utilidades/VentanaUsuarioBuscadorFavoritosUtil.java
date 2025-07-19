/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mp3player.main.utilidades;

import java.util.List;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import mp3player.main.DAO.CancionDAO;
import mp3player.main.modelos.Modelo_Cancion;

/**
 *
 * @author kira
 */
public class VentanaUsuarioBuscadorFavoritosUtil {

    
    public static List<Modelo_Cancion> buscarCancionesFavoritas(TextField buscadorFavoritos) {
        String titulo = "%" + buscadorFavoritos.getText().trim() + "%";
        CancionDAO dao = new CancionDAO();
        return dao.buscarCancionesFavoritas(titulo);
    }
}
