 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Modelo.Cargo;
import Modelo.Pelicula;
import Modelo.Persona;
import Vista.VentanaCargo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class EventoCargo implements ActionListener 
{
    private VentanaCargo ventanaCargo;
    private GestionDato gD;

    public EventoCargo(VentanaCargo ventanaCargo) {
        this.ventanaCargo = ventanaCargo;
    }

    public VentanaCargo getVentanaCargo() {
        return ventanaCargo;
    }

    public void setVentanaCargo(VentanaCargo ventanaCargo) {
        this.ventanaCargo = ventanaCargo;
    }

    public GestionDato getgD() {
        return gD;
    }

    public void setgD(GestionDato gD) {
        this.gD = gD;
    }
    
   
    
    public void actionPerformed(ActionEvent e) 
    
    {
       
       try
       {
           if (e.getSource().equals(this.ventanaCargo.getBoton()))
           {
           
                int codigo= Integer.parseInt(this.ventanaCargo.getTxtList().get(0).getText());
                
                int pago= Integer.parseInt(this.ventanaCargo.getTxtList().get(1).getText());
               
                String persona=this.ventanaCargo.getCombo1().getSelectedItem().toString();
                
                String pelicula=this.ventanaCargo.getCombo2().getSelectedItem().toString();
                
                for (Cargo c:this.ventanaCargo.getGestionDato().getCargoList()) 
                {
                    if ((codigo == c.getCodigo())&& (pelicula.equals(c.getPelicula().getNombrePelicula())) && (persona.equals(c.getPersona().getNombrePersona())))
                    {
                        throw new ExcepcionDatoRepetido("Cargo repetido");
                    }
                }
          
           
                for(Persona p:this.ventanaCargo.getGestionDato().getPersonaList())
                {
               
                    if(persona.equals(p.getNombrePersona()))
                    {
                  
                        for(Pelicula peli:this.ventanaCargo.getGestionDato().getPeliculaList())
                        {
                            if(pelicula.equals(peli.getNombrePelicula()))
                            {
                                Cargo c=new Cargo(codigo,p,peli,pago);
                                JOptionPane.showMessageDialog(this.ventanaCargo,"Guardado");
                                ventanaCargo.getGestionDato().getCargoList().add(c);
                                try {  
                                    this.ventanaCargo.getGestionDato().persistCargoList(this.ventanaCargo.getGestionDato().getCargoList());
                                } catch (Exception ex) {
                                    //Logger.getLogger(EventoCargo.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            try {
                                this.ventanaCargo.getGestionDato().leeCargo();
                            } catch (Exception ex) {
                               // Logger.getLogger(EventoCargo.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
               
           }
           
           Object[][]datosCargo=this.ventanaCargo.cargaDatosTabla(this.ventanaCargo.getGestionDato().getCargoList().size(),4);
           this.ventanaCargo.setDatos(datosCargo);
           this.ventanaCargo.getModeloTabla().setDataVector(this.ventanaCargo.getDatos(), this.ventanaCargo.getEncabezado());
       
       } catch (NumberFormatException ex) 
       {
         JOptionPane.showMessageDialog(this.ventanaCargo, "Mal ingreso de datos");
       } catch (ExcepcionDatoRepetido ex) 
        {
            JOptionPane.showMessageDialog(this.ventanaCargo, "Cargo repetido");
        }
     
    }
}

       
       
           