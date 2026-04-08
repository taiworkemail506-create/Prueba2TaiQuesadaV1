/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen2tqpro3;


import examen2tqpro3.*;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VentanaPrincipal extends JFrame {

    private UsuarioService usuarioService = new UsuarioService();
    private AccesoService accesoService = new AccesoService();

    private JTextField txtId, txtNombre, txtRol;
    private JTextArea area;

    public VentanaPrincipal() {
        setTitle("Sistema Control de Acceso");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JPanel panelTop = new JPanel(new GridLayout(3, 2));

        panelTop.add(new JLabel("ID:"));
        txtId = new JTextField();
        panelTop.add(txtId);

        panelTop.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelTop.add(txtNombre);

        panelTop.add(new JLabel("Rol:"));
        txtRol = new JTextField();
        panelTop.add(txtRol);

        add(panelTop, BorderLayout.NORTH);

        area = new JTextArea();
        add(new JScrollPane(area), BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new GridLayout(2, 4));

        JButton btnRegistrar = new JButton("Registrar");
        JButton btnEntrada = new JButton("Entrada");
        JButton btnSalida = new JButton("Salida");
        JButton btnListar = new JButton("Listar");
        JButton btnHistorial = new JButton("Historial");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnTiempo = new JButton("Tiempo Total");

        panelBotones.add(btnRegistrar);
        panelBotones.add(btnEntrada);
        panelBotones.add(btnSalida);
        panelBotones.add(btnListar);
        panelBotones.add(btnHistorial);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnTiempo);

        add(panelBotones, BorderLayout.SOUTH);

        btnRegistrar.addActionListener(e -> registrarUsuario());
        btnEntrada.addActionListener(e -> registrarEntrada());
        btnSalida.addActionListener(e -> registrarSalida());
        btnListar.addActionListener(e -> listarUsuarios());
        btnHistorial.addActionListener(e -> mostrarHistorial());
        btnEliminar.addActionListener(e -> eliminarUsuario());
        btnTiempo.addActionListener(e -> calcularTiempo());
    }

    private void registrarUsuario() {
        try {
            Usuario u = new Usuario(txtId.getText(), txtNombre.getText(), txtRol.getText());
            usuarioService.registrar(u);
            area.setText("Usuario registrado");
        } catch (Exception ex) {
            area.setText("Error: " + ex.getMessage());
        }
    }

    private void registrarEntrada() {
        try {
            accesoService.registrarEntrada(txtId.getText());
            area.setText("Entrada registrada");
        } catch (Exception ex) {
            area.setText("Error: " + ex.getMessage());
        }
    }

    private void registrarSalida() {
        try {
            accesoService.registrarSalida(txtId.getText());
            area.setText("Salida registrada");
        } catch (Exception ex) {
            area.setText("Error: " + ex.getMessage());
        }
    }

    private void listarUsuarios() {
        try {
            List<Usuario> lista = usuarioService.listar();
            area.setText("");
            for (Usuario u : lista) {
                area.append(u.getId() + " - " + u.getNombre() + " - " + u.getRol() + "\n");
            }
        } catch (Exception ex) {
            area.setText("Error: " + ex.getMessage());
        }
    }

    private void mostrarHistorial() {
        try {
            List<Acceso> lista = accesoService.historial(txtId.getText());
            area.setText("");
            for (Acceso a : lista) {
                area.append("Entrada: " + a.getFechaEntrada() +
                        " | Salida: " + a.getFechaSalida() + "\n");
            }
        } catch (Exception ex) {
            area.setText("Error: " + ex.getMessage());
        }
    }

    private void eliminarUsuario() {
        try {
            usuarioService.eliminar(txtId.getText());
            area.setText("Usuario eliminado");
        } catch (Exception ex) {
            area.setText("Error: " + ex.getMessage());
        }
    }

    private void calcularTiempo() {
        try {
            long minutos = accesoService.calcularTiempoTotal(txtId.getText());
            area.setText("Tiempo total: " + minutos + " minutos");
        } catch (Exception ex) {
            area.setText("Error: " + ex.getMessage());
        }
    }
}