/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cargo;
import Modelo.Pelicula;
import Modelo.Persona;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class GestionDato {
    
    private List<Persona> personaList;
    private List<Pelicula> peliculaList;
    private List<Cargo> cargoList;

    public GestionDato(List<Persona> personaList, List<Pelicula> peliculaList, List<Cargo> cargoList) {
        this.personaList = personaList;
        this.peliculaList = peliculaList;
        this.cargoList = cargoList;
    }

    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    public List<Pelicula> getPeliculaList() {
        return peliculaList;
    }

    public void setPeliculaList(List<Pelicula> peliculaList) {
        this.peliculaList = peliculaList;
    }

    public List<Cargo> getCargoList() {
        return cargoList;
    }

    public void setCargoList(List<Cargo> cargoList) {
        this.cargoList = cargoList;
    }
    
    
    //////////////////////////////////////////////////////////
    
    
    public boolean persistPeliculaList(List<Pelicula> peliculaList) throws Exception
    {
        boolean retorno=true;
        File directorio=new File("C:/Pelicula");
        System.out.print((directorio.getPath()));
        if(!directorio.exists())
        {
            directorio.mkdir();
        }
        for(Pelicula pel:peliculaList)
        {
            try
            {
               FileOutputStream ae=new   FileOutputStream("C:/Pelucla/DatosPelicula.txt",true);
               DataOutputStream escritura= new DataOutputStream (ae);
               escritura.writeUTF(pel.getNombrePelicula());
               escritura.writeUTF(pel.getGenero());
               escritura.writeInt(pel.getHorasAlquiler());
               escritura.close();
               retorno=true;
            }catch(EOFException e1)
            {
                retorno=false;
            }
        }
        
        return retorno;
    }
    
    public List<Pelicula> leePelicula() throws Exception
    {
        List<Pelicula> peli = new ArrayList<Pelicula>();
        try
        {
            FileInputStream ae=new   FileInputStream("C:/Pelicula/DatosPelicula.txt");
            DataInputStream lectura= new DataInputStream (ae);
            
            while(true)
            {
                String nombrePeli=lectura.readUTF();
                String genero=lectura.readUTF();
                int horasAlquiler=lectura.readInt();
               
                
                Pelicula pel=new Pelicula(nombrePeli,genero,horasAlquiler);
                peli.add(pel);
               
               
            }
           
        }catch(EOFException e1)
        {
            
        }
        
           return peli;
     
    }
    
    /////////////////////////////////////////////////////////////////////////////
    
    
    public boolean persistCargoList(List<Cargo> cargoList) throws Exception
    {
        boolean retorno=true;
        File directorio=new File("C:/Cargo");
        System.out.print((directorio.getPath()));
        if(!directorio.exists())
        {
            directorio.mkdir();
        }
        for(Cargo c:cargoList)
        {
            try
            {
               FileOutputStream ae=new   FileOutputStream("C:/Cargo/DatosCargo.txt",true);
               DataOutputStream escritura= new DataOutputStream (ae);
               escritura.writeUTF(c.getPersona().getNombrePersona());
               escritura.writeUTF(c.getPelicula().getNombrePelicula());
               escritura.writeDouble(c.getPago());
               escritura.close();
               retorno=true;
            }catch(EOFException e1)
            {
                retorno=false;
            }
        }
        
        return retorno;
    }
    
    public List<Cargo> leeCargo() throws Exception
    {
        List<Cargo> cargo = new ArrayList<Cargo>();
        try
        {
            FileInputStream ae=new   FileInputStream("C:/Cargo/DatosCargo.txt");
            DataInputStream lectura= new DataInputStream (ae);
            
            while(true)
            {
                String nombrePer=lectura.readUTF();
                String nombrePel=lectura.readUTF();
                int pago=lectura.readInt();
                
                for (Persona p:personaList) 
                {
                    if (nombrePer.equals(p.getNombrePersona()))
                    {
                        for (Pelicula pel:peliculaList) 
                        {
                            if (nombrePel.equals(pel.getNombrePelicula()))
                            {
                                Cargo c = new Cargo(p,pel,pago);
                                cargo.add(c);
                                  
                            }
                        }
                    }
                }
            
            }
            
        }catch(EOFException e1)
        {
            
        }
        
        return cargo;
    }
    
    
    public boolean addPersona(Persona p)
    {
        boolean retorno;
        retorno=this.personaList.add(p);
        return retorno;
    }
    
    public boolean addPeiluca(Pelicula pel)
    {
        boolean retorno;
        retorno=this.peliculaList.add(pel);
        return retorno;
    }
    
    public boolean addCargo(Cargo c)
    {
        boolean retorno;
        retorno=this.cargoList.add(c);
        return retorno;
    }
    
    
}
