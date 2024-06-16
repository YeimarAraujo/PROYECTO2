/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.util.ArrayList;

/**
 *
 * @author POWER
 */
public class Emprendimiento {
    
    protected String nombreEmprendimiento;
    private String nit;
    private String direccion;
    protected final ArrayList<Producto> productos = new ArrayList<>();

    public Emprendimiento(String nombreEmprendimiento, String nit, String direccion) {
        this.nombreEmprendimiento = nombreEmprendimiento;
        this.nit = nit;
        this.direccion = direccion;
    }

    public String getNombreEmprendimiento() {
        return nombreEmprendimiento;
    }

    public void setNombreEmprendimiento(String nombreEmprendimineto) {
        this.nombreEmprendimiento = nombreEmprendimineto;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
  

    @Override
    public String toString() {
   
        return  
                " \nNombreEmprendimiento : " + nombreEmprendimiento + 
                " \nNit : " + nit +
                " \nDireccion : " + direccion ;
    }
    
    
}

