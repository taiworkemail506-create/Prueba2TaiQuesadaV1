/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen2tqpro3;


import java.time.*;
import java.util.*;

public class AccesoService {
    private AccesoDAO dao = new AccesoDAO();

    public void registrarEntrada(String idUsuario) throws Exception {
        if (idUsuario.isEmpty()) throw new Exception("ID requerido");

        List<Acceso> accesos = dao.obtenerTodos();

        for (Acceso a : accesos) {
            if (a.getIdUsuario().equals(idUsuario) && a.getFechaSalida().equals("null")) {
                throw new Exception("Ya tiene una entrada activa");
            }
        }

        accesos.add(new Acceso(idUsuario, LocalDateTime.now().toString(), "null"));
        dao.guardarTodo(accesos);
    }

    public void registrarSalida(String idUsuario) throws Exception {
        if (idUsuario.isEmpty()) throw new Exception("ID requerido");

        List<Acceso> accesos = dao.obtenerTodos();

        for (Acceso a : accesos) {
            if (a.getIdUsuario().equals(idUsuario) && a.getFechaSalida().equals("null")) {
                a.setFechaSalida(LocalDateTime.now().toString());
                dao.guardarTodo(accesos);
                return;
            }
        }

        throw new Exception("No hay entrada previa");
    }

    public List<Acceso> historial(String idUsuario) throws Exception {
        List<Acceso> accesos = dao.obtenerTodos();
        List<Acceso> resultado = new ArrayList<>();

        for (Acceso a : accesos) {
            if (a.getIdUsuario().equals(idUsuario)) {
                resultado.add(a);
            }
        }
        return resultado;
    }

    public long calcularTiempoTotal(String idUsuario) throws Exception {
        List<Acceso> accesos = dao.obtenerTodos();
        long totalMinutos = 0;

        for (Acceso a : accesos) {
            if (a.getIdUsuario().equals(idUsuario) && !a.getFechaSalida().equals("null")) {

                LocalDateTime entrada = LocalDateTime.parse(a.getFechaEntrada());
                LocalDateTime salida = LocalDateTime.parse(a.getFechaSalida());

                Duration duracion = Duration.between(entrada, salida);
                totalMinutos += duracion.toMinutes();
            }
        }

        return totalMinutos;
    }
}