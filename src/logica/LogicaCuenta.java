

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import entidades.Cliente;
import entidades.CuentaUsuarios;
import entidades.Emprendedor;
import persistencia.ArchivoObjetoCuenta;

import persistencia.ICuenta;

/**
 *
 * @author POWER
 */
public class LogicaCuenta {
    private final ICuenta persistencia;
   
    public LogicaCuenta() {
        this.persistencia = new ArchivoObjetoCuenta();

    }

    public CuentaUsuarios crearCuenta(String username, String password, String correoElectronico, String cedula, int edad, int tipo){
     
         switch (tipo) {
            case 1:
                return new Cliente(username, password, correoElectronico, cedula, edad);
               
            case 2:
                return new Emprendedor(username, password, correoElectronico, cedula, edad);
               
            default: return null;
        }
         
    }
    public boolean registrar(CuentaUsuarios cuenta) {
 
    return this.persistencia.agregarCuenta(cuenta);
}
    public boolean eliminar (CuentaUsuarios cuenta){
        
        return this.persistencia.eliminar(cuenta);
    }
    

}