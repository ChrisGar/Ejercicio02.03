/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;



import Modelo.Persona;
import Vista.VentanaPersona;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



/**
 *
 * @author USUARIO
 */
public class EventoPersona implements ActionListener{
    
    private VentanaPersona ventanaPersona;

    public EventoPersona(VentanaPersona ventanaPersona) {
        this.ventanaPersona = ventanaPersona;
    }

    public VentanaPersona getVentanaPersona() {
        return ventanaPersona;
    }

    public void setVentanaPersona(VentanaPersona ventanaPersona) {
        this.ventanaPersona = ventanaPersona;
    }
   
    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        try{
            if (ae.getSource().equals(this.ventanaPersona.getBoton()))
            {
                String nombre=this.ventanaPersona.getTxtList().get(0).getText();
                nombre=nombre;
                String cedula=this.ventanaPersona.getTxtList().get(1).getText();
                cedula=cedula;
                int edad=Integer.parseInt(this.ventanaPersona.getTxtList().get(2).getText());
                edad=edad;
                Persona p=new Persona(nombre, cedula,edad);
                JOptionPane.showMessageDialog(this.ventanaPersona,"Guardado");
                ventanaPersona.getGestionDato().getPersonaList().add(p);
                try {
                    this.ventanaPersona.getGestionDato().persistPersonaList(this.ventanaPersona.getGestionDato().getPersonaList());
                } catch (Exception ex) {
                Logger.getLogger(EventoPelicula.class.getName()).log(Level.SEVERE, null, ex);
                }
                           
                                
            }
            this.ventanaPersona.getGestionDato().leePersona();
       
            Object[][]datosCurso=this.ventanaPersona.cargaDatosTabla(this.ventanaPersona.getGestionDato().getPersonaList().size(),3);
            this.ventanaPersona.setDatos(datosCurso);
            this.ventanaPersona.getModeloTabla().setDataVector(this.ventanaPersona.getDatos(), this.ventanaPersona.getEncabezado());
       
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this.ventanaPersona, "Mal ingreso de datos");
        } catch (Exception ex) {
            Logger.getLogger(EventoPelicula.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
}
