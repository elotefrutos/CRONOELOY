/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc_cronoeloy;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author dam2
 */
public class VPresentacion extends JFrame {
      public VPresentacion() {
        setTitle("Cargando CRONOELOY...");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Cargando...", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        add(label, BorderLayout.CENTER);
    }

    /**
     * Muestra la ventana durante un tiempo determinado.
     * @param milisegundos Tiempo en milisegundos antes de cerrar la ventana.
     * @param onClose Runnable que se ejecutará al cerrar la ventana.
     */
    public void mostrarPorTiempo(int milisegundos, Runnable onClose) {
        setVisible(true);
        
        // Usar javax.swing.Timer para evitar problemas de concurrencia
        javax.swing.Timer timer = new javax.swing.Timer(milisegundos, e -> {
            setVisible(false);
            dispose();
            onClose.run();
        });
        timer.setRepeats(false); // Solo ejecutar una vez
        timer.start();
    }
}

