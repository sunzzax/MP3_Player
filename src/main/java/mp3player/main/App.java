package mp3player.main;

import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
import mp3player.main.utilidades.AbrirVentanasFXML;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        AbrirVentanasFXML.abrirVentana("/vistas/FXML_IniciarSesion.fxml", "MP3_Player");
    }

    public static void main(String[] args) {
        launch();
    }

}


/*
1. Buscador + Filtro
FXML: FXML_Buscador.fxml

Controlador: Controlador_Buscador.java

2. Lista de canciones
FXML: FXML_ListaCanciones.fxml

Controlador: Controlador_ListaCanciones.java

3. Controles de reproducción
FXML: FXML_Controles.fxml

Controlador: Controlador_Controles.java
*/