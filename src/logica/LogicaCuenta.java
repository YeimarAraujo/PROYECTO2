

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import entidades.Cliente;
import entidades.CuentaUsuarios;
import entidades.Emprendedor;
import entidades.Emprendimiento;
import java.util.ArrayList;
import java.util.Scanner;
import persistencia.ArrayListCuenta;
import persistencia.ArrayListEmprendimiento;
import persistencia.ICuenta;
import persistencia.IEmprendimiento;
import presentacion.Menu;

/**
 *
 * @author POWER
 */
public class LogicaCuenta {
    private final ArrayList<CuentaUsuarios> cuentas ;
    private final ICuenta persistencia;
     private IEmprendimiento persistenciaE;
    private final Scanner scanner;
   
    public LogicaCuenta() {
        this.persistencia = new ArrayListCuenta();
        this.persistenciaE = new ArrayListEmprendimiento();
        this.cuentas = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

   

    public void login(String username, String password) {
    boolean registrado = false;
    for (CuentaUsuarios cuenta : cuentas) {
        if (cuenta.getUsername().equals(username) && cuenta.getPassword().equals(password)) {
            System.out.println("Inicio de sesión exitoso!");
            registrado = true;
            
            if (cuenta.Emprendedor()) {
                new Menu().menuEmprendedor();
            } else {
                new Menu().menuUsuario();
            }
            break; 
        }
    }
    if (!registrado) {
        System.out.println("Usuario no registrado... Favor registrarse");
    }
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
        boolean result = this.persistencia.agregarCuenta(cuenta);
    if (result) {
        cuentas.add(cuenta); 
    }
    return result;
}
    public boolean convertiraEmprendedor(String username, String password) {
for (CuentaUsuarios cuenta : cuentas) {
        if (cuenta.getUsername().equals(username) && cuenta.getPassword().equals(password) && cuenta instanceof Cliente) {
            Cliente cliente = (Cliente) cuenta;
            
            Emprendedor emprendedor = new Emprendedor(
                cliente.getUsername(),
                cliente.getPassword(),
                cliente.getCorreoElectronico(),
                cliente.getCedula(),
                cliente.getEdad()
            );
            cuentas.remove(cliente);
            cuentas.add(emprendedor);
            
            return true;
        }
    }
    return false;
}
      
}