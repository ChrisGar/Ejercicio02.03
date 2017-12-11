/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author USER
 */
public class Pelicula 
{
    String nombrePelicula;
    String genero;
    int horasAlquiler;

    public Pelicula(String nombrePelicula, String genero, int horasAlquiler) {
        this.nombrePelicula = nombrePelicula;
        this.genero = genero;
        this.horasAlquiler = horasAlquiler;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getHorasAlquiler() {
        return horasAlquiler;
    }

    public void setHorasAlquiler(int horasAlquiler) {
        this.horasAlquiler = horasAlquiler;
    }
    
    
    
}
