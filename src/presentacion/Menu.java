/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import entidades.CuentaUsuarios;
import persistencia.ICuenta;
import entidades.Emprendimiento;
import java.util.Scanner;
import logica.LogicaCuenta;
import logica.LogicaEmprendimiento;
import persistencia.IEmprendimiento;

/**
 *
 * @author POWER
 */
public class Menu {
    private int opcion;
    private int opcion2;
    private int opcion3;
    private final Scanner scanner;
    private ICuenta cuentas;
     private IEmprendimiento emprendimientos;
    LogicaCuenta logicaCuenta = new LogicaCuenta();
    LogicaEmprendimiento logicaEmprendimiento = new LogicaEmprendimiento();

    public Menu() {
        this.scanner = new Scanner(System.in);
    }
    
    public void ejecutarMenu(){
        
         
        do {
            System.out.println("         MENU                ");
            System.out.println("-----------------------------");
            System.out.println("1. Inicar Sesion             ");
            System.out.println("2. Registrarse               ");
            System.out.println("5. Salir                     ");
            System.out.println("-----------------------------");
            System.out.print("Seleccione: ");
            
            this.opcion = this.scanner.nextInt();

            this.controlOpcion();

        } while (this.opcion != 3);

} 
 
    public void controlOpcion(){
            switch (this.opcion) {
            case 1: inicioSesion();
                    break;
            case 2: registrarse();
                    break;
            case 3: break;
            default: System.out.println("!! La opcion no es valida, intente nuevamente ¡¡\n");

        }
    }
    public void menuUsuario(){
        do {
            System.out.println("         MENU USUARIO               ");
            System.out.println("------------------------------------");
            System.out.println("1. Buscar producto             ");
            System.out.println("2. Buscar emprendimiento       ");
            System.out.println("3. Convertirse en emprendedor  ");
            System.out.println("4. Salir                       ");
            System.out.println("------------------------------------");
            System.out.print("Seleccione: ");
            
            this.opcion2 = this.scanner.nextInt();

            this.controlMenuUsuario();

        } while (this.opcion2 != 4);
    }

    public void menuEmprendedor(){
        do {
            System.out.println("         MENU EMPRENDEDOR               ");
            System.out.println("------------------------------------");
            System.out.println("1. Crear emprendimiento       ");
            System.out.println("2. Agregar Producto           ");
            System.out.println("3. Buscar producto             ");
            System.out.println("4. Buscar emprendimiento       ");
            System.out.println("5. Salir                       ");
            System.out.println("------------------------------------");
            System.out.print("Seleccione: ");
            
            this.opcion3 = this.scanner.nextInt();

            this.controlMenuEmprendedor();

        } while (this.opcion3 != 5);
    }
    public void controlMenuEmprendedor(){
        switch(this.opcion3){
            case 1:  ;
                break;
            case 2: logicaEmprendimiento.agregarProducto();
                break;
            case 3: logicaEmprendimiento.buscarProducto();
                break;
            case 4: logicaCuenta.buscarEmprendimiento();
                break;
            case 5: break;
            default : System.out.println("!! La opcion no es valida, intente nuevamente ¡¡\n");
        }
    }
  
    public void controlMenuUsuario(){
        switch(this.opcion2){
            case 1: logicaEmprendimiento.buscarProducto();
                break;
            case 2: logicaCuenta.buscarEmprendimiento();
                break;
            case 3: convertirEmprendedor();
                break;
            case 4: break;
            default : System.out.println("!! La opcion no es valida, intente nuevamente ¡¡\n");
    }
}
    private void inicioSesion(){
        System.out.print("Ingrese su nombre de usuario: ");
        String username = scanner.nextLine();
        scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String password = scanner.nextLine();
        this.logicaCuenta.login(username, password);
 
                
        
    }
    private void registrarse(){
        CuentaUsuarios cuenta = null;
        System.out.println("            REGISTRO               ");
        System.out.println("-----------------------------------");
        System.out.println("Por favor ingrese la siguiente información para registrarse:");
        System.out.print("Nombre de usuario: ");
        String username = scanner.nextLine();
        scanner.nextLine();
        System.out.print("Contraseña: ");
        String password = scanner.nextLine();
        System.out.print("Correo electrónico: ");
        String correoElectronico = scanner.nextLine();
        System.out.print("Número de identificación: ");
        String cedula = scanner.nextLine();
        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); 
        
        int tipo;
        do {
            System.out.printf("Tipo de cuenta: ");
            System.out.printf("\n1 - Cliente ");
            System.out.printf("\n2 - Emprendedor\n");
            tipo = this.scanner.nextInt();
        } while (tipo != 1 && tipo != 2);
       cuenta = this.logicaCuenta.crearCuenta(username, password, correoElectronico, cedula, edad, tipo);
       this.logicaCuenta.registrar(cuenta);


        System.out.println("");
    System.out.println("Registro exitoso!");
    }
    public void convertirEmprendedor(){
        System.out.println("         CONVERTIR A EMPRENDEDOR               ");
        System.out.println("-----------------------------------");
        System.out.print("Nombre de usuario: ");
        String username = scanner.nextLine();
        System.out.print("Contraseña: ");
        String password = scanner.nextLine();
        System.out.print("Correo electrónico: ");
        
        this.logicaCuenta.convertiraEmprendedor(username, password);
    }
    public void crearEmprendimiento(){
        Emprendimiento emprendimiento = null;
        System.out.println("       CREAR EMPRENDIMIENTO               ");
        System.out.println("-----------------------------------");
 
        System.out.print("Nombre del emprendimiento : ");
        String nombreEmprendimiento = scanner.nextLine();
        System.out.print("NIT : ");
        String nit = scanner.nextLine();
        System.out.print("Cumple con punto fisico? (1-SI / 2-NO) ");
        int tipo = scanner.nextInt();
        
        if(tipo == 1){
            System.out.print("Direccion : ");
        String direccion = scanner.nextLine();
        }
        if(tipo == 2){
            String direccion = ("SIN DIRECCION");
        }
           
        this.logicaEmprendimiento.crearEmprendimiento(emprendimiento);
        
    }
}