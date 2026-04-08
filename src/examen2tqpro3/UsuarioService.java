/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen2tqpro3;


import examen2tqpro3.UsuarioDAO;
import examen2tqpro3.Usuario;
import java.util.*;

public class UsuarioService {
    private UsuarioDAO dao = new UsuarioDAO();

    public void registrar(Usuario u) throws Exception {
        List<Usuario> usuarios = dao.obtenerTodos();

        for (Usuario user : usuarios) {
            if (user.getId().equals(u.getId())) {
                throw new Exception("ID duplicado");
            }
        }
        dao.guardar(u);
    }

    public List<Usuario> listar() throws Exception {
        return dao.obtenerTodos();
    }

    public void eliminar(String id) throws Exception {
        List<Usuario> usuarios = dao.obtenerTodos();
        usuarios.removeIf(u -> u.getId().equals(id));
        dao.sobrescribir(usuarios);
    }
}