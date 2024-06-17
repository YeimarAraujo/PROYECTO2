package persistencia;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import entidades.CuentaUsuarios;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author POWER
 */
public class MapCuenta implements ICuenta{
    protected ICuenta icuentas;
    private final Map<String, CuentaUsuarios> cuentas = new HashMap<>();

    @Override
    public boolean agregarCuenta(CuentaUsuarios cuenta) {
         cuentas.put(cuenta.username, cuenta);
         return true;
    }

    @Override
    public CuentaUsuarios obtenerCuenta(String username) {
        return cuentas.get(username);
    }

    @Override
    public boolean eliminar(CuentaUsuarios cuenta) {
        return false;
                
               
    }

   
}
