/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mp3player.main.modelos;

/**
 *
 * @author kira
 */
public class Modelo_Usuario {

    private int ID;
    private String usuario, contraseña, tipo;
    private static Modelo_Usuario usuarioActual;

    // Constructor sin parámetros OBLIGATORIO
    /*JavaFX lo necesita para crear el controlador 
    automáticamente al cargar el FXML*/
    public Modelo_Usuario() {
    }

    // Constructor con parámetros
    public Modelo_Usuario(int ID, String usuario, String contraseña, String tipo) {
        this.ID = ID;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.tipo = tipo;
    }

    // Getters y Setters
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public static Modelo_Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public static void setUsuarioActual (Modelo_Usuario usuario) {
        usuarioActual = usuario;
    }
    
}
