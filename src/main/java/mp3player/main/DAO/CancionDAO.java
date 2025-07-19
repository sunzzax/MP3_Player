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
import java.util.logging.Level;
import java.util.logging.Logger;
import mp3player.main.modelos.Modelo_Cancion;
import mp3player.main.modelos.Modelo_Usuario;
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

    // Método para buscar canciones las canciones favoritas por titulo
    public List<Modelo_Cancion> buscarCancionesFavoritas(String titulo) {
        List<Modelo_Cancion> listaCancionesFavoritas = new ArrayList<>();

        // Verifico si hay texto para filtrar por título
        boolean filtrar = titulo != null && !titulo.trim().isEmpty();

        // Obtener el ID del usuario actual
        int idUsuario = Modelo_Usuario.getUsuarioActual().getID();

        // Definimos la consulta SQL según si hay filtro o no
        String sql;
        if (filtrar) {
            sql = "SELECT c.* FROM canciones c "
                    + "JOIN favoritos f ON c.ID = f.id_cancion "
                    + "WHERE f.id_usuario = ? AND c.titulo LIKE ? "
                    + "ORDER BY c.titulo ASC";
        } else {
            sql = "SELECT c.* FROM canciones c "
                    + "JOIN favoritos f ON c.ID = f.id_cancion "
                    + "WHERE f.id_usuario = ? "
                    + "ORDER BY c.titulo ASC";
        }

        try (Connection con = ConexionBD.conectarBD(); PreparedStatement pstm = con.prepareStatement(sql)) {
            if (filtrar) {
                // Si se filtra, primero el ID del usuario y luego el texto con comodines
                pstm.setInt(1, idUsuario);
                pstm.setString(2, "%" + titulo + "%");
            } else {
                // Si no se filtra, solo se usa el ID del usuario
                pstm.setInt(1, idUsuario);
            }

            // Ejecutamos la consulta
            ResultSet resultado = pstm.executeQuery();

            // Recorremos los resultados y los añadimos a la lista
            while (resultado.next()) {
                Modelo_Cancion cancion = new Modelo_Cancion(
                        resultado.getInt("id"),
                        resultado.getString("titulo"),
                        resultado.getString("artista"),
                        resultado.getString("genero"),
                        resultado.getString("archivo")
                );
                listaCancionesFavoritas.add(cancion);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return listaCancionesFavoritas;
    }

    //Método para añadir canciones a la lista de favoritos
    public void insertarFavoritos(int idUsuario, int idCancion) {
        String sql = "INSERT OR IGNORE INTO favoritos (id_usuario, id_cancion) VALUES (?,?)";

        try (Connection con = ConexionBD.conectarBD(); PreparedStatement pstm = con.prepareStatement(sql)) {
            if (con != null) {
                pstm.setInt(1, idUsuario);
                pstm.setInt(2, idCancion);

                pstm.executeUpdate(); // Aplica los cambios

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

}
