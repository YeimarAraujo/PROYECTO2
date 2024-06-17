/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import entidades.CuentaUsuarios;
import java.util.ArrayList;
import presentacion.Menu;

/**
 *
 * @author POWER
 */
public class LogicaUsuario {
    private final ArrayList<CuentaUsuarios> cuentas ;

    public LogicaUsuario() {
         this.cuentas = new ArrayList<>();
    }
    
    public void login(String username, String password) {
    boolean registrado = false;
    for (CuentaUsuarios cuenta : cuentas) {
        if (cuenta.getUsername().equals(username) && cuenta.getPassword().equals(password)) {
            System.out.println("Inicio de sesión exitoso!");
            registrado = true;
            
            if (cuenta.Emprendedor()) {
                new Menu().menuEmprendedor();
                break;
            } 
            
            if(cuenta.Cliente()){
                new Menu().menuUsuario();
                break;
            }
            break; 
        }
    }
    if (!registrado) {
        System.out.println("Usuario no registrado... Favor registrarse");
    }
}
}
