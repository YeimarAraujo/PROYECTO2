/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author POWER
 */
public abstract class CuentaUsuarios {
     public String username;
    protected String password;
    protected String correoElectronico;
    protected String cedula;
    protected int edad;

    public CuentaUsuarios(String username, String password, String correoElectronico, String cedula, int edad) {
        this.username = username;
        this.password = password;
        this.correoElectronico = correoElectronico;
        this.cedula = cedula;
        this.edad = edad;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
    @Override
    public String toString() {
        return "CuentaUsuarios{" + "username=" + username + ", password=" + password + ", correoElectronico=" + correoElectronico + ", cedula=" + cedula + ", edad=" + edad + '}';
    }
    
    
    
    public boolean validarPassword(String password) {
        return this.password.equals(password);
        
    }

    public boolean Emprendedor() {
    return this instanceof Emprendedor;
}
    
}
