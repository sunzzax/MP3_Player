/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mp3player.main.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mp3player.main.modelos.Modelo_Usuario;
import mp3player.main.utilidades.ConexionBD;

/**
 *
 * @author kira
 */
public class UsuarioDAO {

    public UsuarioDAO() {
    }

    public String validarCredenciales(Modelo_Usuario usuario) {

        String tipo = null;
        String sql = "SELECT * FROM usuario WHERE usuario = ? AND contraseña = ?";

        try (Connection con = ConexionBD.conectarBD(); PreparedStatement pstm = con.prepareStatement(sql)) {

            pstm.setString(1, usuario.getUsuario()); // añade a sql en la posicion 1 a usuario
            pstm.setString(2, usuario.getContraseña()); // añade en la posicion2 a contraseña

            ResultSet resultado = pstm.executeQuery(); // ejecuta la consulta

            if (resultado.next()) {
                tipo = resultado.getString("tipo"); // almacena el valor de tipo
            }

        } catch (SQLException ex) {
            System.err.println("Error al intentar validar las credenciales.");
        }

        return tipo; // devuelve o usuario/administrador/null

    }

}
