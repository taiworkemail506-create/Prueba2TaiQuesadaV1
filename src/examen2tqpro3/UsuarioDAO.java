/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen2tqpro3;


import examen2tqpro3.Usuario;
import java.io.*;
import java.util.*;


public class UsuarioDAO {
    private final String archivo = "usuarios.txt";

    public List<Usuario> obtenerTodos() throws IOException {
        List<Usuario> lista = new ArrayList<>();
        File file = new File(archivo);

        if (!file.exists()) return lista;

        BufferedReader br = new BufferedReader(new FileReader(file));
        String linea;

        while ((linea = br.readLine()) != null) {
            lista.add(Usuario.fromFile(linea));
        }
        br.close();
        return lista;
    }

    public void guardar(Usuario usuario) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true));
        bw.write(usuario.toFile());
        bw.newLine();
        bw.close();
    }

    public void sobrescribir(List<Usuario> usuarios) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
        for (Usuario u : usuarios) {
            bw.write(u.toFile());
            bw.newLine();
        }
        bw.close();
    }
}