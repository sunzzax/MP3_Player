package mp3player.main;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mp3player.main.utilidades.AbrirVentanasFXML;
import mp3player.main.utilidades.ConexionBD;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        AbrirVentanasFXML.abrirVentana("/vistas/FXML_IniciarSesion.fxml", "MP3_Player");
    }

    public static void main(String[] args) {
        ConexionBD.conectarBD();
        launch();

    }

}
