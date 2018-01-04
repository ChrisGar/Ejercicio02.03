/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Cargo;
import Modelo.Pelicula;
import Modelo.Persona;
import libreria.GestionDato;

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
        
       
       
        
        GestionDato  gD = new GestionDato(pL, peL, cL, 0);
        VentanaPrincipal v = new VentanaPrincipal("Archivos Binarios",gD);
        v.setVisible(true);
    }
}
