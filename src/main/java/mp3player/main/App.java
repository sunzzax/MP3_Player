package mp3player.main;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mp3player.main.utilidades.ConexionBD;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/vistas/FXML_IniciarSesion.fxml")); // Cargo el FXML
        Scene scene = new Scene(root); // Creo la escena

        stage.setTitle("MP3_Player");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public static void main(String[] args) {
        ConexionBD.conectarBD();
        launch();

    }

}
