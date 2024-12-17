package mvc_cronoeloy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class VistaCronoeloy extends JFrame {
    private JPanel panelCentral;

    public VistaCronoeloy() {
        setTitle("Ventana Principal");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Menú
        JMenuBar menuBar = new JMenuBar();
        JMenu menuArchivo = new JMenu("Archivo");
        
        // Elementos del menú
        JMenuItem itemAjustes = new JMenuItem("Ajustes");
        JMenuItem itemAñadirReunion = new JMenuItem("Añadir Reunión");
        JMenuItem itemAñadirDiaTrabajo = new JMenuItem("Añadir Día de Trabajo");
        JMenuItem itemSalir = new JMenuItem("Salir");

        // Agregar elementos al menú
        menuArchivo.add(itemAñadirReunion);
        menuArchivo.add(itemAñadirDiaTrabajo);
        menuArchivo.add(itemAjustes);
        menuArchivo.add(itemSalir);
        menuBar.add(menuArchivo);
        setJMenuBar(menuBar);

        // Panel central
        panelCentral = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Cargar y dibujar la imagen de fondo
                Image fondo = new ImageIcon("fondo.jpg").getImage();
                g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
            }
        };
        panelCentral.setLayout(new BorderLayout());
        add(panelCentral, BorderLayout.CENTER);

        // Listeners
         itemSalir.addActionListener(e -> {
            System.out.println("Saliendo de la aplicación..."); // Mensaje en consola al salir
            System.exit(0);
        });
    }
    

    public void addActionListenerBtnConf(ActionListener listener) {
        ((JMenuItem) getJMenuBar().getMenu(0).getItem(2)).addActionListener(listener); // Ajustes
    }

    public void addActionListenerBtnAñadirReunion(ActionListener listener) {
        ((JMenuItem) getJMenuBar().getMenu(0).getItem(0)).addActionListener(listener); // Añadir Reunión
    }

    public void addActionListenerBtnAñadirDiaTrabajo(ActionListener listener) {
        ((JMenuItem) getJMenuBar().getMenu(0).getItem(1)).addActionListener(listener); // Añadir Día de Trabajo
    }
}