/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.CuentaUsuarios;
import java.util.ArrayList;

/**
 *
 * @author POWER
 */
public class ArrayListCuenta implements ICuenta{
    
     private ArrayList<CuentaUsuarios> cuentas = new ArrayList<>();

    @Override
    public boolean agregarCuenta(CuentaUsuarios cuenta) {
        return cuentas.add(cuenta);
    }

    public ArrayList<CuentaUsuarios> getCuentas() {
        return cuentas;
    }

    public void setCuentas(ArrayList<CuentaUsuarios> cuentas) {
        this.cuentas = cuentas;
    }
    

    @Override
    public CuentaUsuarios obtenerCuenta(String username) {
        for (CuentaUsuarios cuenta : cuentas) {
            if (cuenta.username.equals(username)) {
                return cuenta;
            }
        }
        return null;
    }

    @Override
    public boolean eliminar(CuentaUsuarios cuenta) {
        
         return this.cuentas.remove(cuenta);
        
    }

}
