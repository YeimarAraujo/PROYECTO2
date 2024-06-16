/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.Producto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author POWER
 */
public class MapProducto implements IProducto {
    private Map<String, Producto> productos = new HashMap<>();

    @Override
    public boolean agregarProducto(Producto producto) {
       this.productos.put(producto.nombreProducto, producto);
       return true;
    }

    public Producto obtenerProducto(String nombreProducto) {
        return productos.get(nombreProducto);
    }

    @Override
    public Producto buscarPorNombre(String nombreProducto) {
        return this.productos.get(nombreProducto);
    }

    @Override
    public Producto buscarPorCodigo(int codigo) {
        return this.productos.get(codigo); }

    @Override
    public ArrayList<Producto> obtenerProductos() {
        return  new ArrayList(this.productos.values());
    }
}
