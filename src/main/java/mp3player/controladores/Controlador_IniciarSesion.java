/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mp3player.controladores;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mp3player.main.DAO.UsuarioDAO;

/**
 * FXML Controller class
 *
 * @author kira
 */
public class Controlador_IniciarSesion implements Initializable {

    @FXML
    private Button btnAyuda, btnEntrar;

    @FXML
    private TextField txfUsuario;

    @FXML
    private PasswordField pwfContraseña;

    private UsuarioDAO usuarioDAO;

    @FXML
    private void pulsarBtnAyuda(ActionEvent event) {
        try {
            // Obtengo el stage actual para cerrar la ventana en la cual se encuentra el botón
            Stage stageActual = (Stage) btnAyuda.getScene().getWindow();
            stageActual.close(); // Cierro la ventana de iniciar sesion

            Parent root = FXMLLoader.load(getClass().getResource("/vistas/FXML_Ayuda.fxml")); // Cargo el FXML

            Scene sceneAyuda = new Scene(root); // Creo la nueva escenea con la vista del FXML

            Stage stageNueva = new Stage(); // creo un nuevo stage y lo configuro
            stageNueva.setTitle("MP3_Player"); // le doy un titulo a la ventana
            stageNueva.setScene(sceneAyuda); // le paso la scene a cargar
            stageNueva.centerOnScreen(); // Centro la ventana en la ventana

            stageNueva.show(); // Muestro la ventana de ayuda

        } catch (IOException ex) {
            System.err.println("Error al intentar cargar la ventana de ayuda: "
                    + ex.getMessage());
        }

    }

    @FXML
    private void pulsarBtnEntrar(ActionEvent event) {

        try {

            String usuario = txfUsuario.getText();
            String contraseña = pwfContraseña.getText();

            if (usuario.isEmpty() || contraseña.isEmpty()) {
                System.out.println("Los campos no pueden estar vacios.");
            } else {
                                                                                                // por ahora dejarlo asi
                String tipoUsuario = usuarioDAO.validarCredenciales(usuario, contraseña);

                // Compruebo si se encuentra en la base de datos
                if (tipoUsuario != null) {
                    System.out.println("Bienvenido. Acceso concedido como " + tipoUsuario);
                    if (tipoUsuario.equals("usuario")) {
                        try {
                            // Obtengo el stage actual para cerrar la ventana en la cual se encuentra el botón
                            Stage stageActual = (Stage) btnEntrar.getScene().getWindow();
                            stageActual.close(); // Cierro la ventana de iniciar sesion

                            Parent root = FXMLLoader.load(getClass().getResource("/vistas/FXML_VentanaUsuario.fxml")); // Cargo el FXML

                            Scene sceneAyuda = new Scene(root); // Creo la nueva escenea con la vista del FXML

                            Stage stageNueva = new Stage(); // creo un nuevo stage y lo configuro
                            stageNueva.setTitle("MP3_Player"); // le doy un titulo a la ventana
                            stageNueva.setScene(sceneAyuda); // le paso la scene a cargar
                            stageNueva.centerOnScreen(); // Centro la ventana en la ventana

                            stageNueva.show(); // Muestro la ventana de usuario

                        } catch (IOException ex) {
                            System.err.println("Error al intentar cargar la ventana de ayuda: "
                                    + ex.getMessage());
                        }
                    } else if (tipoUsuario.equals("administrador")) {
                        try {
                            // Obtengo el stage actual para cerrar la ventana en la cual se encuentra el botón
                            Stage stageActual = (Stage) btnEntrar.getScene().getWindow();
                            stageActual.close(); // Cierro la ventana de iniciar sesion

                            Parent root = FXMLLoader.load(getClass().getResource("/vistas/FXML_VentanaAdministrador.fxml")); // Cargo el FXML

                            Scene sceneAyuda = new Scene(root); // Creo la nueva escenea con la vista del FXML

                            Stage stageNueva = new Stage(); // creo un nuevo stage y lo configuro
                            stageNueva.setTitle("MP3_Player"); // le doy un titulo a la ventana
                            stageNueva.setScene(sceneAyuda); // le paso la scene a cargar
                            stageNueva.centerOnScreen(); // Centro la ventana en la ventana

                            stageNueva.show(); // Muestro la ventana de administrador

                        } catch (IOException ex) {
                            System.err.println("Error al intentar cargar la ventana de ayuda: "
                                    + ex.getMessage());
                        }
                    } else {
                        System.out.println("Usuario o contraseña incorrectos.");
                    }
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace(); // imprime el error
        }

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        usuarioDAO = new UsuarioDAO();        // Creamos el DAO para acceder a la base de datos si es necesario
    }

}
