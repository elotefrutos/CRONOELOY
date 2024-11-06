package mvc_cronoeloy;

import javax.swing.*;
import java.awt.*;

public class VistaCronoEloy extends JFrame {
    private JLabel labelImagen;
    private JLabel labelMensaje;

    public VistaCronoEloy() {
        setTitle("Ventana Principal - CRONOELOY");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Configurar el layout
        setLayout(new BorderLayout());

        // Creamos y agregamos un JLabel para el mensaje de bienvenida
        labelMensaje = new JLabel("Bienvenido al Proyecto CRONOELOY", SwingConstants.CENTER);
        add(labelMensaje, BorderLayout.NORTH);

        // Crear y agregar un JLabel con una imagen
        labelImagen = new JLabel();
        labelImagen.setHorizontalAlignment(SwingConstants.CENTER);

        // Cargar la imagen
        ImageIcon icono = new ImageIcon("bienvenida.png");
        labelImagen.setIcon(icono);

        add(labelImagen, BorderLayout.CENTER);
    }

    public void actualizarMensaje(String mensaje) {
        labelMensaje.setText(mensaje);
    }
}