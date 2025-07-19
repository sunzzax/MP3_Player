/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mp3player.main.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import mp3player.main.modelos.Modelo_Usuario;
import mp3player.main.utilidades.ConexionBD;

/**
 *
 * @author kira
 */
public class UsuarioDAO {

    public UsuarioDAO() {
    }

    // En vez de devolver String (el tipo de usuario), devuelve Modelo_Usuario completo
    public Modelo_Usuario validarCredenciales(String usuario, String contraseña) {
        // Aquí haces la consulta a la base de datos
        String sql = "SELECT * FROM usuario WHERE usuario = ? AND contraseña = ?";
        try (Connection conn = ConexionBD.conectarBD(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, usuario);
            pstmt.setString(2, contraseña);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("ID");
                usuario = rs.getString("usuario");
                contraseña = rs.getString("contraseña");
                String tipo = rs.getString("tipo");
                return new Modelo_Usuario(id, usuario, contraseña, tipo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
