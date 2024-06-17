/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.Rese�a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author POWER
 */
public class ArchivoObjetoRese�a implements IRese�a {

    private File archivo;
    private FileOutputStream aEscritura;
    private FileInputStream aLectura;
    
    public ArchivoObjetoRese�a(String name){
        this.archivo = new File(name);
    }
    
    public ArchivoObjetoRese�a(){
        this("rese�as.obj");
    }
    
    
    
    private IRese�a leer(){
        
        IRese�a coleccion = null;
        if(!this.archivo.exists()){
            return new ArrayListRese�a();
        }
        ObjectInputStream ois = null;
        try {
            this.aLectura = new FileInputStream(this.archivo);
            ois = new ObjectInputStream(this.aLectura);
            coleccion = (IRese�a)ois.readObject();
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
    
    private void guardar(IRese�a coleccion) throws IOException{
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
    public boolean agregarRese�a(Rese�a rese�a) {
        IRese�a coleccion = this.leer();
        coleccion.agregarRese�a(rese�a);
        try {
            this.guardar(coleccion);
        } catch (IOException ex) {
            Logger.getLogger(ArchivoObjetoRese�a.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public ArrayList<Rese�a> obtenerRese�as() {
     IRese�a coleccion = this.leer();
             return coleccion.obtenerRese�as();}

  

}
