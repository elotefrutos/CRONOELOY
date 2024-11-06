/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc_cronoeloy;

/**
 *
 * @author dam2
 */
public class ControladorCronoeloy {
    private VistaCronoeloy vistaCronoEloy;
    private ModeloCronoeloy modeloCronoEloy;

    public ControladorCronoeloy(VistaCronoeloy vista, ModeloCronoeloy modelo) {
        this.vistaCronoEloy = vista;
        this.modeloCronoEloy = modelo;
        inicializarVista();
    }

    private void inicializarVista() {
    vistaCronoEloy.actualizarMensaje("Bienvenido a tu calendario CRONOELOY");

    }
}
