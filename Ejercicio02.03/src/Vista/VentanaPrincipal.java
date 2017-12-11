/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.EventoVentanaPrincipal;
import Controlador.GestionDato;
import Modelo.Cargo;
import Modelo.Pelicula;
import Modelo.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author USUARIO
 */
public class VentanaPrincipal extends JFrame{
    
    private JMenuBar menuPrincipal;
    private JDesktopPane escritorio;
    private JMenu menu1;
    private List<JMenuItem> menuItemList;
    private Persona persona;
    private Pelicula pelicula;
    private Cargo cargo;
    private GestionDato gD;
    
    public VentanaPrincipal(String titulo, GestionDato gD) {
        this.setTitle(titulo);
        this.setSize(600, 400);
        this.setDefaultCloseOperation(3);
        this.gD = gD;
        this.iniciaComponente();
    }
    
    public void iniciaComponente(){
        this.menuPrincipal = new JMenuBar();
        this.escritorio = new JDesktopPane();
        
        this.menu1 = new JMenu("Crear");
        
        this.menuItemList = new ArrayList<JMenuItem>();
        this.menuItemList.add(new JMenuItem("Persona"));
        this.menuItemList.add(new JMenuItem("Pelicula"));
        this.menuItemList.add(new JMenuItem("Cargo"));
        
        this.setContentPane(this.escritorio);
        this.setJMenuBar(menuPrincipal);

        this.menuPrincipal.add(this.menu1);
        
        this.menu1.add(this.menuItemList.get(0));
        this.menu1.add(this.menuItemList.get(1));
        this.menu1.add(this.menuItemList.get(2));
                 
        this.menuItemList.get(0).addActionListener(new EventoVentanaPrincipal(this));
        this.menuItemList.get(1).addActionListener(new EventoVentanaPrincipal(this));
        this.menuItemList.get(2).addActionListener(new EventoVentanaPrincipal(this));
        
        
     } 

    public JMenuBar getMenuPrincipal() {
        return menuPrincipal;
    }

    public void setMenuPrincipal(JMenuBar menuPrincipal) {
        this.menuPrincipal = menuPrincipal;
    }

    public JDesktopPane getEscritorio() {
        return escritorio;
    }

    public void setEscritorio(JDesktopPane escritorio) {
        this.escritorio = escritorio;
    }

    public JMenu getMenu1() {
        return menu1;
    }

    public void setMenu1(JMenu menu1) {
        this.menu1 = menu1;
    }

    public List<JMenuItem> getMenuItemList() {
        return menuItemList;
    }

    public void setMenuItemList(List<JMenuItem> menuItemList) {
        this.menuItemList = menuItemList;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public GestionDato getgD() {
        return gD;
    }

    public void setgD(GestionDato gD) {
        this.gD = gD;
    }
    
    
}
