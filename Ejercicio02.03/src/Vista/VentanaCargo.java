/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.EventoCargo;
import Controlador.GestionDato;
import Modelo.Cargo;
import Modelo.Pelicula;
import Modelo.Persona;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class VentanaCargo extends JInternalFrame{
    
    private List<JLabel> etiList;
    private List<JTextField> txtList;
    private JButton boton;
    private JButton boton2;
    private JPanel panelGuardar;
    private JPanel panelInicial;
    private JPanel panelVer;
    private GestionDato gestionDato;
    private Object[][] datos;
    private Object[] encabezado;
    private DefaultTableModel modeloTabla;
    private JTable tabla;
    private JScrollPane scroll;
    private JComboBox combo1;
    private JComboBox combo2;
    
    public VentanaCargo(GestionDato gestionDato){
        super("Registro Cargo", true, true, true, true);
        this.setSize(500, 300);
        this.gestionDato = gestionDato;
        this.iniciaComponente();
    }
    
    public void iniciaComponente(){
        
        this.etiList = new ArrayList<JLabel>();
        this.etiList.add(new JLabel("Pago"));
        this.etiList.add(new JLabel("Nombre Persona"));
        this.etiList.add(new JLabel("Nombre Pelicula"));
        
        this.txtList = new ArrayList<JTextField>();
        this.txtList.add(new JTextField(10));
        
        this.boton= new JButton("Guardar");
        this.boton2= new JButton("Limpiar");
   
        this.boton.addActionListener(new EventoCargo(this));
        this.boton2.addActionListener(new EventoCargo(this));
        
        this.encabezado = new Object[3];
        this.encabezado[0]="Pago";
        this.encabezado[1]="Persona";
        this.encabezado[2]="Pelicula";
       
        this.datos = cargaDatosTabla(this.gestionDato.getCargoList().size(),3);
        this.modeloTabla = new DefaultTableModel(this.datos,this.encabezado);
        this.tabla = new JTable(modeloTabla);
        this.scroll = new JScrollPane(this.tabla);
        
        LayoutManager disenio = new GridLayout(5, 2);
        LayoutManager disenio2 = new GridLayout(2, 1);
        this.panelVer= new JPanel(new BorderLayout());
	this.panelGuardar = new JPanel(disenio);
	this.panelInicial = new JPanel(disenio2);
        
        this.panelGuardar.add(this.etiList.get(0));
        this.panelGuardar.add(this.txtList.get(0));
        
        this.panelGuardar.add(this.etiList.get(2));
        this.combo1=new JComboBox();
        this.cargarCombo1();
        this.panelGuardar.add(this.combo1);
        
        this.panelGuardar.add(this.etiList.get(1));
        this.combo2=new JComboBox();
        this.cargarCombo2();
        this.panelGuardar.add(this.combo2);
       
	this.panelVer.add(this.scroll, BorderLayout.CENTER);
	this.panelGuardar.add(this.boton);
        this.panelGuardar.add(this.boton2);
	this.panelInicial.add(this.panelGuardar);
	this.panelInicial.add(this.panelVer);
        this.panelVer.add(this.scroll, BorderLayout.CENTER);
        this.add(panelInicial);
    }
    
    public Object[][]cargaDatosTabla(int h,int w)
    {
        Object[][]retorno=new Object[h][w];
        int i=0;
        for(Cargo c:this.gestionDato.getCargoList())
        {
           retorno[i][0]=c.getPersona().getNombrePersona();
           retorno[i][1]=c.getPelicula().getNombrePelicula();
           retorno[i][2]=c.getPago();
           i++;
        }
        
        return retorno;
           
    }
    public void cargarCombo1(){
        this.combo1.removeAllItems();
        for(Persona p: this.gestionDato.getPersonaList())
        {
            this.combo1.addItem(p.getNombrePersona());
        }
    }
    
    public void cargarCombo2(){
        this.combo2.removeAllItems();
        for(Pelicula pe: this.gestionDato.getPeliculaList())
        {
            this.combo2.addItem(pe.getNombrePelicula());
        }
    }

    public List<JLabel> getEtiList() {
        return etiList;
    }

    public void setEtiList(List<JLabel> etiList) {
        this.etiList = etiList;
    }

    public List<JTextField> getTxtList() {
        return txtList;
    }

    public void setTxtList(List<JTextField> txtList) {
        this.txtList = txtList;
    }

    public JButton getBoton() {
        return boton;
    }

    public void setBoton(JButton boton) {
        this.boton = boton;
    }

    public JButton getBoton2() {
        return boton2;
    }

    public void setBoton2(JButton boton2) {
        this.boton2 = boton2;
    }

    public JPanel getPanelGuardar() {
        return panelGuardar;
    }

    public void setPanelGuardar(JPanel panelGuardar) {
        this.panelGuardar = panelGuardar;
    }

    public JPanel getPanelInicial() {
        return panelInicial;
    }

    public void setPanelInicial(JPanel panelInicial) {
        this.panelInicial = panelInicial;
    }

    public JPanel getPanelVer() {
        return panelVer;
    }

    public void setPanelVer(JPanel panelVer) {
        this.panelVer = panelVer;
    }

    public GestionDato getGestionDato() {
        return gestionDato;
    }

    public void setGestionDato(GestionDato gestionDato) {
        this.gestionDato = gestionDato;
    }

    public Object[][] getDatos() {
        return datos;
    }

    public void setDatos(Object[][] datos) {
        this.datos = datos;
    }

    public Object[] getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(Object[] encabezado) {
        this.encabezado = encabezado;
    }

    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }

    public void setModeloTabla(DefaultTableModel modeloTabla) {
        this.modeloTabla = modeloTabla;
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }

    public JComboBox getCombo1() {
        return combo1;
    }

    public void setCombo1(JComboBox combo1) {
        this.combo1 = combo1;
    }

    public JComboBox getCombo2() {
        return combo2;
    }

    public void setCombo2(JComboBox combo2) {
        this.combo2 = combo2;
    }
    
    
}

