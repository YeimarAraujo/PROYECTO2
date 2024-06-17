/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.Producto;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author POWER
 */
public class ArchivoObjetoProducto implements IProducto{
    private File archivo;
    private FileOutputStream aEscritura;
    private FileInputStream aLectura;
    
    public ArchivoObjetoProducto(String name){
        this.archivo = new File(name);
    }
    
    public ArchivoObjetoProducto(){
        this("Productos.obj");
    }
    
    
    
    private IProducto leer(){
        
        IProducto coleccion = null;
        if(!this.archivo.exists()){
            return new ArrayListProducto();
        }
        ObjectInputStream ois = null;
        try {
            this.aLectura = new FileInputStream(this.archivo);
            ois = new ObjectInputStream(this.aLectura);
            coleccion = (IProducto)ois.readObject();
            ois.close();
            this.aLectura.close();
            
        } catch (FileNotFoundException ex) {
            System.out.println("Error al abrir o crear archivo de lectura");
        } catch (IOException ex) {
            System.out.println("Error al crear objeto de lectura");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al leer objeto");
        }
        
        return coleccion;
    }
    
    private void guardar(IProducto coleccion){
        ObjectOutputStream oos = null;
        try {
            this.aEscritura = new FileOutputStream(this.archivo);
            oos = new ObjectOutputStream(this.aEscritura);
            oos.writeObject(coleccion);
            oos.close();
            this.aEscritura.close();
            
        } catch (FileNotFoundException ex) {
            System.out.println("Error al abrir o crear archivo de escritura");
        } catch (IOException ex) {
            System.out.println("Error al crear objeto de escritura");
        }
    }

    @Override
    public boolean agregarProducto(Producto producto) {
      IProducto coleccion = this.leer();
        coleccion.agregarProducto(producto);
        this.guardar(coleccion);
        return true;
    }

    @Override
    public Producto buscarPorNombre(String nombreProducto) {
         IProducto coleccion = this.leer();
        return coleccion.buscarPorNombre(nombreProducto);}

    @Override
    public Producto buscarPorCodigo(int codigo) {
      IProducto coleccion = this.leer();
        return coleccion.buscarPorCodigo(codigo);
    }

    @Override
    public ArrayList<Producto> obtenerProductos() {
       IProducto coleccion = this.leer();
        return coleccion.obtenerProductos();
    }
    
    
}
