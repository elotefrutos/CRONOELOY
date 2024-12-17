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
import java.io.File;

/**
 * Ventana de configuración (JDialog).
 */
public class MiVentanaConfig extends JDialog {
    private JButton btnOk;
    private JButton btnCancel;
    private JButton btnSeleccionarIcono;
    private File iconoSeleccionado;

    public MiVentanaConfig(JFrame parent, boolean modal) {
        super(parent, "Configuración", modal);
        setSize(400, 300);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        // Panel de botones
        JPanel panelBotones = new JPanel();
        btnOk = new JButton("Ok");
        btnCancel = new JButton("Cancelar");
        btnSeleccionarIcono = new JButton("Seleccionar Icono");

        panelBotones.add(btnSeleccionarIcono);
        panelBotones.add(btnOk);
        panelBotones.add(btnCancel);

        add(panelBotones, BorderLayout.SOUTH);

        // Acciones
        btnSeleccionarIcono.addActionListener(e -> seleccionarIcono());
    }

    /**
     * Abre un JFileChooser para seleccionar un archivo de imagen como icono.
     */
    private void seleccionarIcono() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccionar un icono");
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Imágenes (*.jpg, *.png, *.gif)", "jpg", "png", "gif"));

        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            iconoSeleccionado = fileChooser.getSelectedFile();
            JOptionPane.showMessageDialog(this, "Icono seleccionado: " + iconoSeleccionado.getName());
        }
    }

    /**
     * Devuelve el archivo de imagen seleccionado.
     */
    public File getIconoSeleccionado() {
        return iconoSeleccionado;
    }

    /**
     * Métodos para añadir listeners a los botones OK y Cancel.
     */
    public void addActionListenerBtnOk(ActionListener listener) {
        btnOk.addActionListener(listener);
    }

    public void addActionListenerBtnCancel(ActionListener listener) {
        btnCancel.addActionListener(listener);
    }
}