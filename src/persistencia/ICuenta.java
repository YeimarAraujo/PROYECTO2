/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import entidades.CuentaUsuarios;

/**
 *
 * @author POWER
 */
public interface ICuenta {
     boolean agregarCuenta(CuentaUsuarios cuenta);     
    CuentaUsuarios obtenerCuenta(String username);
    boolean validarPassword(String username, String password);
}
