/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.VentanaCargo;
import Vista.VentanaPelicula;
import Vista.VentanaPersona;
import libreria.GestionDato;
import Vista.VentanaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



/**
 *
 * @author USUARIO
 */
public class EventoVentanaPrincipal implements ActionListener{
    
    private VentanaPrincipal ventana;
    

    public EventoVentanaPrincipal(VentanaPrincipal ventana) {
        this.ventana = ventana;
    }

    public VentanaPrincipal getVentana() {
        return ventana;
    }

    public void setVentana(VentanaPrincipal ventana) {
        this.ventana = ventana;
    }

    public GestionDato getgD() {
        return gD;
    }

    public void setgD(GestionDato gD) {
        this.gD = gD;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
      
         if (e.getSource().equals(this.ventana.getMenuItemList().get(0))) {
            VentanaPersona vP = new VentanaPersona(this.ventana.getgD());
            vP.setVisible(true);
            this.ventana.getEscritorio().add(vP);
        }
        if (e.getSource().equals(this.ventana.getMenuItemList().get(1))) {
            VentanaPelicula vPe = new VentanaPelicula(this.ventana.getgD());
            vPe.setVisible(true);
            this.ventana.getEscritorio().add(vPe);
        }

        if (e.getSource().equals(this.ventana.getMenuItemList().get(2))) {
            VentanaCargo vC = new VentanaCargo(this.ventana.getgD());
            vC.setVisible(true);
            this.ventana.getEscritorio().add(vC);
        }
        
    }
    
}
