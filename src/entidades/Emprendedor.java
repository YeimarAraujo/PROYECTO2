package entidades;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.ArrayList;

/**
 *
 * @author POWER
 */
public class Emprendedor extends CuentaUsuarios{
    
   private final ArrayList<Emprendimiento> emprendimientos = new ArrayList<>();

    public Emprendedor(String username, String password, String correoElectronico, String cedula, int edad) {
        super(username, password, correoElectronico, cedula, edad);
    }

    
}
