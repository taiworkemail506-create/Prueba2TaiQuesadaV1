/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen2tqpro3;


import examen2tqpro3.Acceso;
import java.io.*;
import java.util.*;

public class AccesoDAO {
    private final String archivo = "accesos.txt";

    public List<Acceso> obtenerTodos() throws IOException {
        List<Acceso> lista = new ArrayList<>();
        File file = new File(archivo);

        if (!file.exists()) return lista;

        BufferedReader br = new BufferedReader(new FileReader(file));
        String linea;

        while ((linea = br.readLine()) != null) {
            lista.add(Acceso.fromFile(linea));
        }
        br.close();
        return lista;
    }

    public void guardarTodo(List<Acceso> accesos) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
        for (Acceso a : accesos) {
            bw.write(a.toFile());
            bw.newLine();
        }
        bw.close();
    }
}