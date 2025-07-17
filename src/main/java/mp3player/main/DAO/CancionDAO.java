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

    // Método para obtener todos las canciones
    public List<Modelo_Cancion> obtenerCanciones() {

        List<Modelo_Cancion> listaCanciones = new ArrayList<>();
        String sql = "SELECT * FROM canciones";

        try (Connection con = ConexionBD.conectarBD(); PreparedStatement pstm = con.prepareStatement(sql)) {
            if (con != null) {
                ResultSet resultado = pstm.executeQuery();

                while (resultado.next()) {
                    Modelo_Cancion cancion = new Modelo_Cancion(resultado.getInt("id"), resultado.getString("titulo"), resultado.getString("artista"), resultado.getString("genero"), resultado.getString("archivo"));
                    listaCanciones.add(cancion);
                }
            } else {
                System.err.println("No se ha podido realizar la consulta.");
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return listaCanciones;

    }

    // Método para obtener todas las canciones por género
    public List<Modelo_Cancion> obtenerCancionesPorGenero(String genero) {

        List<Modelo_Cancion> listaCanciones = new ArrayList<>();
        String sql = "SELECT * FROM canciones WHERE genero =  ?";

        try (Connection con = ConexionBD.conectarBD(); PreparedStatement pstm = con.prepareStatement(sql)) {
            if (con != null) {
                
                pstm.setString(1, genero);
                ResultSet resultado = pstm.executeQuery();

                while (resultado.next()) {
                    Modelo_Cancion cancion = new Modelo_Cancion(resultado.getInt("id"), resultado.getString("titulo"), resultado.getString("artista"), resultado.getString("genero"), resultado.getString("archivo"));
                    listaCanciones.add(cancion);
                }
            } else {
                System.err.println("No se ha podido realizar la consulta.");
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return listaCanciones;

    }

}
