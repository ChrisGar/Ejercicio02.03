/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author USER
 */
public class ExcepcionDatoRepetido extends Exception{

    public ExcepcionDatoRepetido(String datoRepetido) {
        super(datoRepetido);
        
    }
}
