 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


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
       /*
       try
       {
           if (e.getSource().equals(this.ventanaCargo.getBoton()))
           {
           
                int pago= Integer.parseInt(this.ventanaCargo.getTxtList().get(0).getText());
                pago=pago;
                String persona=this.ventanaCargo.getCombo1().getSelectedItem().toString();
                persona=persona;
                String pelicula=this.ventanaCargo.getCombo2().getSelectedItem().toString();
          
           
                for(Persona p:this.ventanaCargo.getGestionDato().getPersonaList())
                {
               
                    if(persona.equals(p.getNombrePersona()))
                    {
                  
                        for(Pelicula peli:this.ventanaCargo.getGestionDato().getPeliculaList())
                        {
                            if(pelicula.equals(peli.getNombrePelicula()))
                            {
                                Cargo c=new Cargo(p,peli,pago);
                                JOptionPane.showMessageDialog(this.ventanaCargo,"Guardado");
                                ventanaCargo.getGestionDato().getCargoList().add(c);
                                this.ventanaCargo.getGestionDato().persistCursoList(this.ventanaCargo.getGestionDato().getCargoList());  
                            }
                            this.ventanaCargo.getGestionDato().leeCargo;
                        }
                    }
                }
                
                for (int k = 0; k < this.ventanaCargo.getGd().getCargoList().size(); k++) {
                    if (codigoCargo == this.ventanaCargo.getGd().getCargoList().get(k).getCargo().getCodigo()) {
                        throw new ExcepcionDatoRepetido("Cargo repetido");
                    }
                }
               
          
           }
           
           Object[][]datosCargo=this.ventanaCargo.cargaDatosTabla(this.ventanaCargo.getGestionDato().getCargoList().size(),3);
           this.ventanaCargo.setDatos(datosCargo);
           this.ventanaCargo.getModeloTabla().setDataVector(this.ventanaCargo.getDatos(), this.ventanaCargo.getEncabezado());
       
       } catch (NumberFormatException ex) 
       {
         JOptionPane.showMessageDialog(this.ventanaCargo, "Mal ingreso de datos");
       } catch (ExcepcionDatoRepetido ex) 
        {
            JOptionPane.showMessageDialog(this.ventanaCargo, "Cargo repetido");
        }
     */   
    }
}

       
       
           