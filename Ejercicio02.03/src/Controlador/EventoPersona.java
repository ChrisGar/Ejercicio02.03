/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VentanaPersona;


/**
 *
 * @author USUARIO
 */
public class EventoPersona implements ActionListener{
    
    private VentanaPersona ventana;
    private GestionDato gD;

    public EventoPersona(VentanaPersona ventana) {
        this.ventana = ventana;
    }

    public VentanaPersona getVentana() {
        return ventana;
    }

    public void setVentana(VentanaPersona ventana) {
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
