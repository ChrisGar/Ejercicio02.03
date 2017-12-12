/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Modelo.Pelicula;
import Vista.VentanaPelicula;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;



/**
 *
 * @author USUARIO
 */
public class EventoPelicula implements ActionListener{
    
    private VentanaPelicula ventanaPelicula;

    public EventoPelicula(VentanaPelicula ventanaPelicula) {
        this.ventanaPelicula = ventanaPelicula;
    }

    public VentanaPelicula getVentanaPelicula() {
        return ventanaPelicula;
    }

    public void setVentanaPelicula(VentanaPelicula ventanaPelicula) {
        this.ventanaPelicula = ventanaPelicula;
    }
    
    
    

    @Override
   public void actionPerformed(ActionEvent e) 
    {
       try{
           if (e.getSource().equals(this.ventanaPelicula.getBoton()))
           {
               String nombre=this.ventanaPelicula.getTxtList().get(0).getText();
               nombre=nombre;
               String genero=this.ventanaPelicula.getTxtList().get(1).getText();
               genero=genero;
               int horas=Integer.parseInt(this.ventanaPelicula.getTxtList().get(2).getText());
               horas=horas;
             
               
               /*
               //metodo chooser
               JFileChooser guardar = new JFileChooser();
               guardar.setApproveButtonText("Guardar");
               guardar.showOpenDialog(null);
               File archivo = new File (guardar.getSelectedFile().getAbsolutePath());
        
               int aux =0;
               BufferedWriter salida = new BufferedWriter(new FileWriter (archivo ,true));
               salida.write("Nombre " + aux);
               aux++;
               salida.newLine();
               salida.close();
               // termina el metodo chooser
             
               */

               Pelicula p=new Pelicula(nombre, genero,horas);
               JOptionPane.showMessageDialog(this.ventanaPelicula,"Guardado");
               ventanaPelicula.getGestionDato().getPeliculaList().add(p);
               try {
                   this.ventanaPelicula.getGestionDato().persistPeliculaList(this.ventanaPelicula.getGestionDato().getPeliculaList());
               } catch (Exception ex) {
                Logger.getLogger(EventoPelicula.class.getName()).log(Level.SEVERE, null, ex);
               }
                         
                                
            }
        this.ventanaPelicula.getGestionDato().leePelicula();
       
        Object[][]datosCurso=this.ventanaPelicula.cargaDatosTabla(this.ventanaPelicula.getGestionDato().getPeliculaList().size(),3);
        this.ventanaPelicula.setDatos(datosCurso);
        this.ventanaPelicula.getModeloTabla().setDataVector(this.ventanaPelicula.getDatos(), this.ventanaPelicula.getEncabezado());
       
       } catch (NumberFormatException ex) {
         JOptionPane.showMessageDialog(this.ventanaPelicula, "Mal ingreso de datos");
       } catch (Exception ex) {
            Logger.getLogger(EventoPelicula.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
    }

    
    
}
