/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mp3player.main.utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author kira
 */
public class ConexionBD {

    public static Connection conectarBD() {
        try {
            // Ruta relativa a la base de datos (raíz del proyecto)
            String rutaBase = "jdbc:sqlite:base.db";
            System.out.println("Conectado a la base de datos.");
            return DriverManager.getConnection(rutaBase);
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage());

        }
        return null;
    }

}
