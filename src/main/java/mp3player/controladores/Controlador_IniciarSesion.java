/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mp3player.controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import mp3player.main.DAO.UsuarioDAO;
import mp3player.main.utilidades.AbrirVentanasFXML;

/**
 * FXML Controller class
 *
 * @author kira
 */
public class Controlador_IniciarSesion implements Initializable {

    @FXML
    AnchorPane anchorPane;

    @FXML
    private Button btnAyuda, btnEntrar, btnMostrar;

    @FXML
    private TextField txfUsuario;

    @FXML
    private PasswordField pwfContraseña;

    @FXML
    private Label labelContraseña;

    private UsuarioDAO usuarioDAO;

    @FXML
    private void pulsarBtnAyuda(ActionEvent event) {
        AbrirVentanasFXML.cerrarVentanaActual(btnAyuda);
        AbrirVentanasFXML.abrirVentana("/vistas/FXML_Ayuda.fxml", "MP3_Player");
    }

    @FXML
    private void pulsarBtnEntrar(ActionEvent event) {

        try {

            String usuario = txfUsuario.getText();
            String contraseña = pwfContraseña.getText();

            if (usuario.isEmpty() || contraseña.isEmpty()) {
                System.out.println("Los campos no pueden estar vacios.");
            } else {
                // Por ahora solo obtenemos el tipo de usuario (usuario o administrador).
                // En el futuro se puede cambiar para devolver un objeto ModeloUsuario si hace falta más información.
                String tipoUsuario = usuarioDAO.validarCredenciales(usuario, contraseña);

                // Compruebo si se encuentra en la base de datos
                if (tipoUsuario != null) {
                    System.out.println("Bienvenido. Acceso concedido como " + tipoUsuario);

                    if (tipoUsuario.equals("usuario")) {
                        // Cierra la ventana actual usando el botón como referencia
                        AbrirVentanasFXML.cerrarVentanaActual(btnEntrar);
                        // Abre la ventana del usuario cargando el archivo FXML correspondiente
                        AbrirVentanasFXML.abrirVentana("/vistas/FXML_VentanaUsuario.fxml", "MP3_Player"); // Lo mismo pero esto es para abrir otro FXML
                    } else if (tipoUsuario.equals("administrador")) {
                        AbrirVentanasFXML.cerrarVentanaActual(btnEntrar);
                        AbrirVentanasFXML.abrirVentana("/vistas/FXML_VentanaAdministrador.fxml", "MP3_Player");

                    } else {
                        System.out.println("Usuario o contraseña incorrectos.");
                    }

                } else {
                    System.out.println("No se ha encontrado ningun registro en la base de datos");
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace(); // imprime el error
        }
    }

    private boolean mostrando = false;

    @FXML
    private void pulsarBtnMostrar(ActionEvent event) {
        if (!mostrando) {
            String mostrar = pwfContraseña.getText();
            labelContraseña.setText(mostrar);
            labelContraseña.setVisible(true);
            mostrando = true;
        } else {
            labelContraseña.setVisible(false);
            mostrando = false;
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        labelContraseña.setVisible(false); // declaramos a falso el label de mostrar la contraseña
        usuarioDAO = new UsuarioDAO();        // Creamos el DAO para acceder a la base de datos si es necesario
        Platform.runLater(() -> {
            anchorPane.requestFocus(); // Esto evita que el TextField esté marcado
        });
    }

}
