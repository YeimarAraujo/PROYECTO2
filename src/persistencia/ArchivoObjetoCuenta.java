/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.CuentaUsuarios;
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
public class ArchivoObjetoCuenta implements ICuenta {

    private File archivo;
    private FileOutputStream aEscritura;
    private FileInputStream aLectura;
    
    public ArchivoObjetoCuenta(String username){
        this.archivo = new File(username);
    }
    
    public ArchivoObjetoCuenta(){
        this("cuentas.obj");
    }
    
    
    
    private ICuenta leer(){
        
        ICuenta coleccion = null;
        if(!this.archivo.exists()){
            return new ArrayListCuenta();
        }
        ObjectInputStream ois = null;
        try {
            this.aLectura = new FileInputStream(this.archivo);
            ois = new ObjectInputStream(this.aLectura);
            coleccion = (ICuenta)ois.readObject();
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
    
    private void guardar(ICuenta coleccion){
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
    public boolean agregarCuenta(CuentaUsuarios cuenta) {
     ICuenta coleccion = this.leer();
     coleccion.agregarCuenta(cuenta);
        this.guardar(coleccion);
        return true;
    }

    @Override
    public CuentaUsuarios obtenerCuenta(String username) {
        ICuenta coleccion = this.leer();
        return coleccion.obtenerCuenta(username);
    }

    @Override
    public boolean eliminar (CuentaUsuarios cuenta){
        ICuenta coleccion = this.leer();
         coleccion.eliminar(cuenta);
         this.guardar(coleccion);
         return true;
    }
    
}
