/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import persistencia.IEmprendimiento;
import entidades.Emprendimiento;
import entidades.Producto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author POWER
 */
public class MapEmprendimiento implements IEmprendimiento{
    private final Map<String, Emprendimiento> emprendimientos = new HashMap<>();

     @Override
    public boolean agregarEmprendimiento(Emprendimiento emprendimiento) {
        emprendimientos.put(emprendimiento.getNombreEmprendimiento(), emprendimiento);
        return true;
    }

    @Override
    public Emprendimiento buscarEmprendimientos(String nombreEmprendimiento) {
  
        return this.emprendimientos.get(nombreEmprendimiento);
}

   
}