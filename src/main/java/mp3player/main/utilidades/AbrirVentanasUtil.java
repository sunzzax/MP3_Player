/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mp3player.main.utilidades;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author kira
 */
public class AbrirVentanasUtil {

    
    // Plantilla para abrir ventanas FXML
    
    public static void abrirVentana(String rutaFXML, String tituloVentana) {
        try {
            Parent root = FXMLLoader.load(AbrirVentanasUtil.class.getResource(rutaFXML));
            Scene escena = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle(tituloVentana);
            stage.setScene(escena);
            stage.centerOnScreen();
            stage.show();
        } catch (IOException e) {
            System.err.println("Error al abrir ventana: " + rutaFXML);
            e.printStackTrace();
        }
    }

    public static void cerrarVentanaActual(Node nodoCualquiera) {
        Stage stage = (Stage) nodoCualquiera.getScene().getWindow();
        stage.close();
    }
}
