/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen2tqpro3;


public class Usuario {
    private final String id;
    private final String nombre;
    private final String rol;

    public Usuario(String id, String nombre, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.rol = rol;
    }

    public String toFile() {
        return id + ";" + nombre + ";" + rol;
    }

    public static Usuario fromFile(String linea) {
        String[] datos = linea.split(";");
        return new Usuario(datos[0], datos[1], datos[2]);
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getRol() { return rol; }
}