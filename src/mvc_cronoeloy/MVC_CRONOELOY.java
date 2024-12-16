/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mvc_cronoeloy;

/**
 *
 * @author dam2
 */
public class MVC_CRONOELOY {

    /**
     * Es el metodo principal del proyecto
     * @param args eL array de cadenas-palabras que captura el programa
     */
    public static void main(String[] args) {
        //TODAS LAS ACCIONES CON UN SOUT DESCRIBIENDO LO QUE HACE
        //BLOQUE DE ARGUMENTOS
        System.out.println("Iniciando CRONOELOY...");
        ModeloCronoeloy datos = new ModeloCronoeloy();
        VistaCronoeloy ventana = new VistaCronoeloy();
        ControladorCronoeloy controlador = new ControladorCronoeloy(datos, ventana);

        
    }
    
}
