/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.Emprendimiento;
import java.io.Serializable;

/**
 *
 * @author POWER
 */
public interface IEmprendimiento extends Serializable{
    boolean agregarEmprendimiento(Emprendimiento emprendimiento);
    Emprendimiento buscarEmprendimientos(String nombreEmprendimiento);
}
