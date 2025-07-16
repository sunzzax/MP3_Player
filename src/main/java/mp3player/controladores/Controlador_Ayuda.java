/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mp3player.controladores;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author kira
 */
public class Controlador_Ayuda implements Initializable {

    @FXML
    private Button btnVolverInicioSesion;

    @FXML
    private void pulsarBtnVolverInicioSesion(ActionEvent event) {
        try {
            // Obtengo el stage actual para cerrar la ventana en la cual se encuentra el botón
            Stage stageActual = (Stage) btnVolverInicioSesion.getScene().getWindow();
            stageActual.close(); // Cierro la ventana de iniciar sesion

            Parent root = FXMLLoader.load(getClass().getResource("/vistas/FXML_IniciarSesion.fxml")); // Cargo el FXML

            Scene sceneAyuda = new Scene(root); // Creo la nueva escenea con la vista del FXML

            Stage stageNueva = new Stage(); // creo un nuevo stage y lo configuro
            stageNueva.setTitle("MP3_Player"); // le doy un titulo a la ventana
            stageNueva.setScene(sceneAyuda); // le paso la scene a cargar
            stageNueva.centerOnScreen(); // Centro la ventana en la ventana

            stageNueva.show(); // Muestro la ventana de ayuda

        } catch (IOException ex) {
            System.err.println("Error al intentar cargar la ventana de iniciar sesión: "
                    + ex.getMessage());
        }

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
