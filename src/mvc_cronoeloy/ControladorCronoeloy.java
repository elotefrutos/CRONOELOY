/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc_cronoeloy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;

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

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Evento: " + e.getActionCommand());
        switch (e.getActionCommand()) {
            case "Ajustes":
                // Mostrar la ventana de configuración
                ventanaConfig.setVisible(true);
                ventanaConfig.addActionListenerBtnOk(event -> {
                    String titulo = ventanaConfig.getTextoFieldTitulo();
                    datos.setVTituloPrincipal(titulo);
                    ventanaPrincipal.setTitle(titulo); // Actualizar el título
                    System.out.println("Título actualizado: " + titulo);
                    ventanaConfig.dispose();
                });
                ventanaConfig.addActionListenerBtnCancel(event -> {
                    ventanaConfig.dispose();
                });
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