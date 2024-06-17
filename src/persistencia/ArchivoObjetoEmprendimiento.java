/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.Emprendimiento;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author POWER
 */
public class ArchivoObjetoEmprendimiento implements IEmprendimiento{
    private File archivo;
    private FileOutputStream aEscritura;
    private FileInputStream aLectura;
    
    public ArchivoObjetoEmprendimiento(String name){
        this.archivo = new File(name);
    }
    
    public ArchivoObjetoEmprendimiento(){
        this("emprendimientos.obj");
    }
    
    
    
    private IEmprendimiento leer(){
        
        IEmprendimiento coleccion = null;
        if(!this.archivo.exists()){
            return new ArrayListEmprendimiento();
        }
        ObjectInputStream ois = null;
        try {
            this.aLectura = new FileInputStream(this.archivo);
            ois = new ObjectInputStream(this.aLectura);
            coleccion = (IEmprendimiento)ois.readObject();
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
    
    private void guardar(IEmprendimiento coleccion){
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
    public boolean agregarEmprendimiento(Emprendimiento emprendimiento) {
        IEmprendimiento coleccion = this.leer();
        coleccion.agregarEmprendimiento(emprendimiento);
        this.guardar(coleccion);
        return true;
}

    @Override
    public Emprendimiento buscarEmprendimientos(String nombreEmprendimiento) {
    IEmprendimiento coleccion = this.leer();
        return coleccion.buscarEmprendimientos(nombreEmprendimiento);
 }

}
