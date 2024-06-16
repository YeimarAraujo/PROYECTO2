/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.Producto;
import java.util.ArrayList;

/**
 *
 * @author POWER
 */
public class ArrayListProducto implements IProducto{
    private final ArrayList<Producto> productos = new ArrayList<>();

    @Override
    public boolean agregarProducto(Producto producto) {
       return productos.add(producto);
    }

    @Override
    public Producto buscarPorNombre(String nombreProducto) {
       for(Producto producto: this.productos){
            if(producto.getNombreProducto().equals(nombreProducto)){
                return producto;
            }
        }
        return null;
    }

    @Override
    public Producto buscarPorCodigo(int codigo) {
            for(Producto producto: this.productos){
            if(producto.getCod()==codigo){
                return producto;
            }
        }
        return null;
    }
    @Override
    public ArrayList<Producto> obtenerProductos() {
      return productos; 
    }

    
}
