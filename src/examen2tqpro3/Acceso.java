/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen2tqpro3;


public class Acceso {
    private final String idUsuario;
    private final String fechaEntrada;
    private String fechaSalida;

    public Acceso(String idUsuario, String fechaEntrada, String fechaSalida) {
        this.idUsuario = idUsuario;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
    }

    public String toFile() {
        return idUsuario + ";" + fechaEntrada + ";" + fechaSalida;
    }

    public static Acceso fromFile(String linea) {
        String[] d = linea.split(";");
        return new Acceso(d[0], d[1], d[2]);
    }

    public String getIdUsuario() { return idUsuario; }
    public String getFechaEntrada() { return fechaEntrada; }
    public String getFechaSalida() { return fechaSalida; }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
}