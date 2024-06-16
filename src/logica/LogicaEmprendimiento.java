/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;


import entidades.Emprendimiento;
import entidades.Producto;
import java.util.ArrayList;
import persistencia.ArrayListEmprendimiento;
import persistencia.IEmprendimiento;

/**
 *
 * @author POWER
 */
public class LogicaEmprendimiento {
    private final ArrayList<Emprendimiento> emprendimientos;
    private IEmprendimiento persistencia;

    public LogicaEmprendimiento() {
        this.persistencia = new ArrayListEmprendimiento();
        this.emprendimientos = new ArrayList<>();
      
    }
    public Emprendimiento crearEmprendimiento(String nombreEmprendimiento, String nit, String direccion){
        return new Emprendimiento(nombreEmprendimiento, nit, direccion);
    }
    
    public boolean registrarEmprendimento(Emprendimiento emprendimiento){
        boolean result = this.persistencia.agregarEmprendimiento(emprendimiento);
    if (result) {
        emprendimientos.add(emprendimiento); 
}
    return result;
    }
    public Emprendimiento buscarEmprendimiento(String nombreEmprendimiento){
        return this.persistencia.buscarEmprendimientos(nombreEmprendimiento);
    }
   
}