/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc_cronoeloy;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;

/**
 *
 * @author dam2
 */
public class ControladorCronoeloy implements ActionListener {
    private ModeloCronoeloy datos;
    private VistaCronoeloy ventanaPrincipal;
    private VPresentacion ventanaPresentacion;
    private MiVentanaConfig ventanaConfig;

    public ControladorCronoeloy(ModeloCronoeloy datos, VistaCronoeloy ventanaPrincipal) {
        this.datos = datos;
        this.ventanaPrincipal = ventanaPrincipal;
        this.ventanaPresentacion = new VPresentacion();
        this.ventanaConfig = new MiVentanaConfig(ventanaPrincipal, true);
        configurarListenersVentanaConfig();
        arranque();
    }

    public void arranque() {
        mostrarVentanaPresentacion();
        configurarVentanaPrincipal();
    }

    private void mostrarVentanaPresentacion() {
        ventanaPresentacion.mostrarPorTiempo(3000, () -> {
            SwingUtilities.invokeLater(() -> {
                ventanaPrincipal.setVisible(true);
                // Establecer el título de la ventana principal al cargar
                ventanaPrincipal.setTitle(datos.getVTituloPrincipal());
            });
        });
    }

    private void configurarVentanaPrincipal() {
        cargarDatosGuardados();
        // Agregar listeners
        ventanaPrincipal.addActionListenerBtnConf(this);
        ventanaPrincipal.addActionListenerBtnAñadirReunion(this);
        ventanaPrincipal.addActionListenerBtnAñadirDiaTrabajo(this);
    }

    private void cargarDatosGuardados() {
        System.out.println("Cargando datos guardados...");
    }
    
    private void configurarListenersVentanaConfig() {
        // Listener del botón OK
        ventanaConfig.addActionListenerBtnOk(event -> {
            File iconoFile = ventanaConfig.getIconoSeleccionado();
            if (iconoFile != null) {
                // Cambiar el icono de la ventana principal
                ImageIcon icono = new ImageIcon(iconoFile.getAbsolutePath());
                ventanaPrincipal.setIconImage(icono.getImage());
                JOptionPane.showMessageDialog(ventanaPrincipal, "Icono cambiado correctamente.");
                System.out.println("Se cambio el icono de la aplicación");
            } else {
                JOptionPane.showMessageDialog(ventanaPrincipal, "No se seleccionó ningún icono.");
            }
            ventanaConfig.dispose(); // Cierra la ventana de configuración
        });

        // Listener del botón Cancelar
        ventanaConfig.addActionListenerBtnCancel(event -> {
            ventanaConfig.dispose();
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Evento: " + e.getActionCommand());
        switch (e.getActionCommand()) {
            case "Ajustes":
                ventanaConfig.setVisible(true);
                break;
            case "Añadir Reunión":
                System.out.println("Añadiendo reunión...");
                break;
            case "Añadir Día de Trabajo":
                System.out.println("Añadiendo día de trabajo...");
                break;
            case "Salir":
                System.out.println("Saliendo de la aplicación...");
                System.exit(0);
                break;
            default:
                System.out.println("Evento desconocido.");
        }
    }
}