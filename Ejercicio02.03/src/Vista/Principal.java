/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.GestionDato;
import Modelo.Cargo;
import Modelo.Pelicula;
import Modelo.Persona;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class Principal {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        List<Persona> pL = new ArrayList<Persona>();
        List<Pelicula> peL = new ArrayList<Pelicula>();
        List<Cargo> cL = new ArrayList<Cargo>();
        
        Persona p=new Persona("Pablo Argudo","010456789",19);
        Persona p2=new Persona("Jose Moreira","010156880",35);
        
        Pelicula pe=new Pelicula("Los indescentes","Drama",101);
        Pelicula pe2=new Pelicula("Batalla de Honor","Accion",102);
       
        pL.add(p);
        pL.add(p2);
        
        peL.add(pe);
        peL.add(pe2);
       
        
        GestionDato gD = new GestionDato(pL, peL,cL);
        VentanaPrincipal v = new VentanaPrincipal("Archivos Binarios",gD);
        v.setVisible(true);
    }
}
