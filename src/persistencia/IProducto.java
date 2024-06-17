/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.Producto;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author POWER
 */
public interface IProducto extends Serializable {
    boolean agregarProducto(Producto producto);
    Producto buscarPorNombre(String nombreProducto);
    Producto buscarPorCodigo(int codigo);
    ArrayList<Producto> obtenerProductos();
    
}
