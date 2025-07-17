/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mp3player.main.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import mp3player.main.utilidades.ConexionBD;

/**
 *
 * @author kira
 */
public class UsuarioDAO {

    public UsuarioDAO() {
    }
                                                        // por ahora dejarlo asi
    public String validarCredenciales(String usuario, String contraseña) {

        String tipo = null;
        String sql = "SELECT * FROM usuario WHERE usuario = ? AND contraseña = ?";

        try (Connection con = ConexionBD.conectarBD(); PreparedStatement pstm = con.prepareStatement(sql)) {

            pstm.setString(1, usuario); // añade a sql en la posicion 1 a usuario
            pstm.setString(2, contraseña); // añade en la posicion2 a contraseña

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
