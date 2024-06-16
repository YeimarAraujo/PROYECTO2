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
public class Producto {
    public String nombreProducto;
    private float precio;
    private float cod;
    private final ArrayList<Rese�a> rese�as = new ArrayList<>();

    public Producto(String nombreProducto, float precio, float cod) {
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.cod = cod;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getCod() {
        return cod;
    }

    public void setCod(float cod) {
        this.cod = cod;
    }

    @Override
    public String toString() {
        return  "Nombre Producto : " + nombreProducto + 
                "Precio : $" + precio + 
                "Codigo : " + cod + '}';
    }

    public ArrayList<Rese�a> obtenerRese�as() {
      return rese�as;}

    public void agregarRese�a(Rese�a nuevaRese�a) {
     rese�as.add(nuevaRese�a); }
    
}
