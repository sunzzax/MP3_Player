/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mp3player.main.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mp3player.main.modelos.Modelo_Cancion;
import mp3player.main.utilidades.ConexionBD;

/**
 *
 * @author kira
 */
public class CancionDAO {

    // Método para buscar canciones por nombre y género
    public List<Modelo_Cancion> buscarCanciones(String titulo, String genero) {
        List<Modelo_Cancion> listaCanciones = new ArrayList<>();
        String sql = "SELECT * FROM canciones WHERE titulo LIKE ? AND (? = 'Todos' OR genero = ?) ORDER BY titulo ASC";

        try (Connection con = ConexionBD.conectarBD(); PreparedStatement pstm = con.prepareStatement(sql)) {
            if (con != null) {

                pstm.setString(1, titulo);
                pstm.setString(2, genero);
                pstm.setString(3, genero);

                ResultSet resultado = pstm.executeQuery();
                while (resultado.next()) {
                    Modelo_Cancion cancion = new Modelo_Cancion(
                            resultado.getInt("id"),
                            resultado.getString("titulo"),
                            resultado.getString("artista"),
                            resultado.getString("genero"),
                            resultado.getString("archivo")
                    );
                    listaCanciones.add(cancion);
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return listaCanciones;
    }

}
