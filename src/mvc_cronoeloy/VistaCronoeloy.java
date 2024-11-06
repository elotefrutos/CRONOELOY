package mvc_cronoeloy;

import javax.swing.*;
import java.awt.*;

public class VistaCronoeloy extends JFrame {
    private JLabel labelMensaje;

    public VistaCronoeloy() {
        setTitle("Ventana Principal - CRONOELOY");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear un fondo personalizado con la clase FondoPanel
        FondoPanel panelFondo = new FondoPanel("C:\\Users\\dam2\\Documents\\NetBeansProjects\\DESARROLLO DE INTERFACES\\MVC_CRONOELOY\\fondo.jpg");
        panelFondo.setLayout(new BorderLayout()); 
        add(panelFondo, BorderLayout.CENTER);

        // Crear y agregar el JLabel para el mensaje de bienvenida centrado
        labelMensaje = new JLabel("Bienvenido a tu calendario CRONOELOY", SwingConstants.CENTER);
        labelMensaje.setFont(new Font("Arial", Font.BOLD, 24)); // Ajuste del tamaño del texto
        labelMensaje.setForeground(Color.BLACK); // Color del texto para que contraste con el fondo
        panelFondo.add(labelMensaje, BorderLayout.CENTER); // Añadir el mensaje sobre la imagen
    }

    public void actualizarMensaje(String mensaje) {
        labelMensaje.setText(mensaje);
    }

    // Clase personalizada para el fondo
    class FondoPanel extends JPanel {
        private Image imagen;

        // Constructor que recibe la ruta de la imagen
        public FondoPanel(String rutaImagen) {
            imagen = new ImageIcon(rutaImagen).getImage();
        }

        // Sobreescribir paintComponent para dibujar la imagen
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Dibujar la imagen escalada al tamaño del panel
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
