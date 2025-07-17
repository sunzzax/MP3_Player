/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mp3player.main.modelos;

/**
 *
 * @author kira
 */
public class Modelo_Cancion {
    // contiene todos los datos del reproductor (lista de canciones, canción actual, etc.).
    // recuerda declarar en los fxml fx:include.

    private int ID;
    private String titulo;
    private String artista;
    private String genero;
    private String archivo;

    public Modelo_Cancion(int ID, String titulo, String artista, String genero, String archivo) {
        this.ID = ID;
        this.titulo = titulo;
        this.artista = artista;
        this.genero = genero;
        this.archivo = archivo;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

}
