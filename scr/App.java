import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        // Lista de materiales
        ArrayList<Material> materiales = new ArrayList<>();
        materiales.add(new Material("Apuntes Teoría de Grafos", "Estructura de Datos", 2));
        materiales.add(new Material("Ejercicios POO", "Programación II", 3));
        materiales.add(new Material("Guía de Matemática Discreta", "Matemática Discreta", 1));
        materiales.add(new Material("Resumen TGS", "Teoría General de Sistemas", 2));

        // Lista de favoritos vacía
        ArrayList<Material> favoritos = new ArrayList<>();

        // Crear ventana
        JFrame ventana = new JFrame("Buscador de Material - FITMA");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(450, 350);
        ventana.setLayout(null);

        // Crear botones
        JButton btnBuscar = new JButton("Buscar Material");
        JButton btnAñadirFavoritos = new JButton("Añadir a Favoritos");
        JButton btnVisualizar = new JButton("Visualizar Material");
        JButton btnVerFavoritos = new JButton("Ver Favoritos");

        // Posicionar botones
        btnBuscar.setBounds(100, 50, 200, 30);
        btnAñadirFavoritos.setBounds(100, 100, 200, 30);
        btnVisualizar.setBounds(100, 150, 200, 30);
        btnVerFavoritos.setBounds(100, 200, 200, 30);

        // Evento botón Buscar
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StringBuilder mensaje = new StringBuilder("📚 Materiales disponibles:\n\n");
                for (Material m : materiales) {
                    mensaje.append(m.toString()).append("\n");
                }
                JOptionPane.showMessageDialog(ventana, mensaje.toString());
            }
        });

        // Evento botón Añadir a Favoritos
        btnAñadirFavoritos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StringBuilder listaMateriales = new StringBuilder("Elige el número del material para añadir a favoritos:\n\n");
                for (int i = 0; i < materiales.size(); i++) {
                    listaMateriales.append(i + 1).append(". ").append(materiales.get(i).toString()).append("\n");
                }
                String input = JOptionPane.showInputDialog(listaMateriales.toString());
                try {
                    int opcion = Integer.parseInt(input);
                    if (opcion >= 1 && opcion <= materiales.size()) {
                        Material seleccionado = materiales.get(opcion - 1);
                        favoritos.add(seleccionado);
                        JOptionPane.showMessageDialog(ventana, "✅ Añadido a favoritos:\n" + seleccionado.toString());
                    } else {
                        JOptionPane.showMessageDialog(ventana, "❌ Número fuera de rango.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(ventana, "❌ Entrada inválida.");
                }
            }
        });

        // Evento botón Visualizar Material (puedes mejorarlo después)
        btnVisualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(ventana, "Visualizando material 👀");
            }
        });

        // Evento botón Ver Favoritos
        btnVerFavoritos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (favoritos.isEmpty()) {
                    JOptionPane.showMessageDialog(ventana, "❗ No hay materiales en favoritos.");
                } else {
                    StringBuilder listaFavoritos = new StringBuilder("📌 Tus materiales favoritos:\n\n");
                    for (int i = 0; i < favoritos.size(); i++) {
                        listaFavoritos.append(i + 1).append(". ").append(favoritos.get(i).toString()).append("\n");
                    }
                    JOptionPane.showMessageDialog(ventana, listaFavoritos.toString());
                }
            }
        });

        // Agregar botones a la ventana
        ventana.add(btnBuscar);
        ventana.add(btnAñadirFavoritos);
        ventana.add(btnVisualizar);
        ventana.add(btnVerFavoritos);

        ventana.setVisible(true);
    }
}



