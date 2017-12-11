/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VentanaPelicula;


/**
 *
 * @author USUARIO
 */
public class EventoPelicula implements ActionListener{
    
    private VentanaPelicula ventana;
    private GestionDato gD;

    public EventoPelicula(VentanaPelicula ventana) {
        this.ventana = ventana;
    }

    public VentanaPelicula getVentana() {
        return ventana;
    }

    public void setVentana(VentanaPelicula ventana) {
        this.ventana = ventana;
    }

    public GestionDato getgD() {
        return gD;
    }

    public void setgD(GestionDato gD) {
        this.gD = gD;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }
    
}
