/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc_cronoeloy;

/**
 *
 * @author dam2
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Ventana de configuración (JDialog).
 */
public class MiVentanaConfig extends JDialog {
   private JTextField textTitulo;
    private JPanel panelCentral;

    public MiVentanaConfig(JFrame parent, boolean modal) {
        super(parent, "Configuración", modal);
        setSize(400, 300);
        setLocationRelativeTo(parent);

        panelCentral = new JPanel();
        panelCentral.setLayout(new BorderLayout());
        add(panelCentral);

        // Campos de texto
        textTitulo = new JTextField();
        panelCentral.add(new JLabel("Título:"), BorderLayout.NORTH);
        panelCentral.add(textTitulo, BorderLayout.CENTER);

        // Botones
        JPanel panelBotones = new JPanel();
        JButton btnOk = new JButton("Ok");
        JButton btnCancel = new JButton("Cancelar");
        panelBotones.add(btnOk);
        panelBotones.add(btnCancel);
        add(panelBotones, BorderLayout.SOUTH);

        btnOk.setActionCommand("Ok");
        btnCancel.setActionCommand("Cancel");
    }

    public String getTextoFieldTitulo() {
        return textTitulo.getText();
    }

    public void addActionListenerBtnOk(ActionListener listener) {
        ((JButton) ((JPanel) getContentPane().getComponent(1)).getComponent(0)).addActionListener(listener);
    }

    public void addActionListenerBtnCancel(ActionListener listener) {
        ((JButton) ((JPanel) getContentPane().getComponent(1)).getComponent(1)).addActionListener(listener);
    }
}