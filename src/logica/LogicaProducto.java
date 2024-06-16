/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import entidades.Producto;
import java.util.ArrayList;
import persistencia.ArrayListProducto;
import persistencia.IProducto;

/**
 *
 * @author POWER
 */
public class LogicaProducto {
       private final IProducto persistencia;
       private final ArrayList<Producto> productos;
        
    public LogicaProducto() {
      this.persistencia = new ArrayListProducto();
       this.productos = new ArrayList<>();
    }
    
public Producto crearProducto(String nombreProducto, float precio, int cod){
    return new Producto(nombreProducto, precio, cod);
}


public boolean registrarProducto(Producto producto){
    boolean result = this.persistencia.agregarProducto(producto);
    if (result) {
        productos.add(producto); 
}
    return result;
}       

    public Producto buscarporNombre(String nombreProducto){
        return this.persistencia.buscarPorNombre(nombreProducto);
    }
    
    public Producto buscarporCodigo(int codigo){
        return this.persistencia.buscarPorCodigo(codigo);
    }
 
}
