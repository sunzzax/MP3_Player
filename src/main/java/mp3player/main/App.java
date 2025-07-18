package mp3player.main;

import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
import mp3player.main.utilidades.AbrirVentanasUtil;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        AbrirVentanasUtil.abrirVentana("/vistas/FXML_IniciarSesion.fxml", "MP3_Player");
    }

    public static void main(String[] args) {
        launch();
    }

}