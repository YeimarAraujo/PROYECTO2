/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.Emprendimiento;
import entidades.Producto;
import java.util.ArrayList;

/**
 *
 * @author POWER
 */
public class ArrayListEmprendimiento implements IEmprendimiento{
    private final ArrayList<Emprendimiento> emprendimientos = new ArrayList<>();
    private final ArrayList<Producto> productos = new ArrayList<>();

    @Override
    public boolean agregarEmprendimiento(Emprendimiento emprendimiento) {
        return emprendimientos.add(emprendimiento);
    }

  

    @Override
     public Emprendimiento buscarEmprendimientos(String nombreEmprendimiento) {
        for (Emprendimiento emprendimiento : emprendimientos) {
            if (emprendimiento.getNombreEmprendimiento().equals(nombreEmprendimiento)) {
                return emprendimiento;
            }
        }
        return null;
     }
 
}
