/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import entidades.CuentaUsuarios;
import entidades.Emprendimiento;
import entidades.Producto;
import entidades.Reseña;
import java.util.ArrayList;
import java.util.Scanner;
import logica.LogicaCuenta;
import logica.LogicaEmprendimiento;
import logica.LogicaProducto;

/**
 *
 * @author POWER
 */
public class Menu {
    private int opcion;
    private int opcion2;
    private int opcion3;
    private final Scanner scanner;
    LogicaCuenta logicaCuenta = new LogicaCuenta();
    LogicaEmprendimiento logicaEmprendimiento = new LogicaEmprendimiento();
    LogicaProducto logicaProducto = new LogicaProducto();
    public Menu() {
        this.scanner = new Scanner(System.in);
    }
    
    public void ejecutarMenu(){
        
         
        do {
            System.out.println("\n         MENU                ");
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
            System.out.println("\n         MENU USUARIO               ");
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
            System.out.println("\n         MENU EMPRENDEDOR               ");
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
            case 1: this.crearEmprendimiento();
                break;
            case 2: this.agregarProducto();
                break;
            case 3: this.buscarProducto();
                break;
            case 4: this.buscarEmprendimiento();
                break;
            case 5: break;
            default : System.out.println("!! La opcion no es valida, intente nuevamente ¡¡\n");
        }
    }
  
    public void controlMenuUsuario(){
        switch(this.opcion2){
            case 1: this.buscarProducto();
                break;
            case 2: buscarEmprendimiento();
                break;
            case 3: convertirEmprendedor();
                    opcion2 = 4;
                break;
            case 4: break;
            default : System.out.println("!! La opcion no es valida, intente nuevamente ¡¡\n");
    }
}
    private void inicioSesion(){
         System.out.println(" \n        INICIO SESION               ");
        System.out.println("-----------------------------------");
        System.out.print("Ingrese su nombre de usuario: ");
        String username = scanner.nextLine();
        scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String password = scanner.nextLine();
        this.logicaCuenta.login(username, password);
 
                
        
    }
    private void registrarse(){
        CuentaUsuarios cuenta = null;
        System.out.println(" \n           REGISTRO               ");
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
        System.out.println("\n  CONVERTIR A EMPRENDEDOR            ");
        System.out.println("-----------------------------------");
                scanner.nextLine();
        System.out.print("Nombre de usuario: ");
        String username = scanner.nextLine();
        System.out.print("Contraseña: ");
        String password = scanner.nextLine();
        
        this.logicaCuenta.convertiraEmprendedor(username, password);
    }
  public void crearEmprendimiento(){
    Emprendimiento emprendimiento = null;
    System.out.println("\n       CREAR EMPRENDIMIENTO               ");
    System.out.println("-----------------------------------");
    scanner.nextLine(); 
    System.out.print("Nombre del emprendimiento : ");
    String nombreEmprendimiento = scanner.nextLine();
    System.out.print("NIT : ");
    String nit = scanner.nextLine();
    System.out.print("Direccion : ");
    String direccion = scanner.nextLine();
   
    emprendimiento = this.logicaEmprendimiento.crearEmprendimiento(nombreEmprendimiento, nit, direccion);
    this.logicaEmprendimiento.registrarEmprendimento(emprendimiento);
    System.out.println("Registro exitoso!");
}

public void buscarEmprendimiento(){
    System.out.println("\n      BUSCAR EMPRENDIMIENTO               ");
    System.out.println("-----------------------------------");
    scanner.nextLine();
    System.out.print("Ingrese el nombre del emprendimiento: ");
    String nombreEmprendimiento = scanner.nextLine();

    Emprendimiento emprendimiento = this.logicaEmprendimiento.buscarEmprendimiento(nombreEmprendimiento);
    if (emprendimiento != null ) {
        System.out.println("Emprendimiento encontrado: \n"+ emprendimiento);
    } else {
        System.out.println("emprendimiento no encontrado."); 
    }
}
    
public void agregarProducto() {
    System.out.println("\n    AGREGAR PRODUCTO               ");
    System.out.println("-----------------------------------");
    scanner.nextLine();
   System.out.println("Ingrese el nombre del producto:");
    String nombreProducto = scanner.nextLine(); 
    System.out.println("Ingrese el precio del producto:");
    float precio = scanner.nextFloat();
    scanner.nextLine(); 
    System.out.println("Ingrese el codigo del producto:");
    int codigo = scanner.nextInt();
    scanner.nextLine(); 
    
    
    Producto producto = this.logicaProducto.crearProducto(nombreProducto, precio, codigo);
    this.logicaProducto.registrarProducto(producto);
    System.out.println("Producto creado exitosamente.");
}
  public void buscarProducto(){
            
            System.out.println("         BUSCAR PRODUCTO             ");
            System.out.println("------------------------------------");
            System.out.println("1. Buscar por nombre             ");
            System.out.println("2. Buscar por codigo       ");
            System.out.println("3. Salir       ");
            System.out.println("------------------------------------");
            System.out.print("Seleccione: ");
            
            int op = this.scanner.nextInt();
           
          switch (op) {
            case 1:this.buscarPorNombre();
                    break;
            case 2:this.buscarPorCodigo();
                    break;
            case 3: break;
            default : System.out.println("!! La opcion no es valida, intente nuevamente ¡¡\n");
 
         
    }
  }
public void buscarPorNombre() {
    System.out.println("\n  BUSCAR PRODUCTO POR NOMBRE               ");
    System.out.println("-----------------------------------");
    scanner.nextLine();
    System.out.print("Ingrese el nombre del producto: ");
    String nameProducto = scanner.nextLine();

    Producto producto = this.logicaProducto.buscarporNombre(nameProducto);
    if (producto != null) {
        System.out.println("Producto encontrado: \n" + producto);
    } else {
        System.out.println("Producto no encontrado.");
        return; 
    }

    mostrarOpcionesReseña(producto);
}

public void buscarPorCodigo() {
    System.out.println("\n  BUSCAR PRODUCTO POR CODIGO               ");
    System.out.println("-----------------------------------");
    scanner.nextLine();
    System.out.print("Ingrese el codigo del producto: ");
    int codigo = scanner.nextInt();
    scanner.nextLine();

    Producto producto = this.logicaProducto.buscarporCodigo(codigo);
    if (producto != null) {
        System.out.println("Producto encontrado: " + producto);
        
    } else {
        System.out.println("Producto no encontrado.");
        return; 
    }

    mostrarOpcionesReseña(producto);
}
private void mostrarOpcionesReseña(Producto producto) {
    System.out.println("                   ");
    System.out.println("1. Agregar reseña");
    System.out.println("2. Mostrar reseñas");
    System.out.println("3. Volver");
    System.out.println("Seleccione : ");
    int accion = scanner.nextInt();
    scanner.nextLine(); 

    switch (accion) {
        case 1:
            System.out.println("\n  AGREGAR RESEÑA               ");
            System.out.println("-----------------------------------");
            System.out.print("Ingrese su reseña: ");
            String comentario = scanner.nextLine();

            Reseña nuevaReseña = new Reseña(comentario);
            producto.agregarReseña(nuevaReseña);
            System.out.println("Reseña agregada exitosamente.");
            break;
        case 2:
            System.out.println("\n   RESEÑAS               ");
            System.out.println("-----------------------------------\n");
            ArrayList<Reseña> resenas = producto.obtenerReseñas();
            for (Reseña r : resenas) {
                System.out.println("- " + r.getComentario());
            }
            break;
        case 3:
            break;
        default:
            System.out.println("Opción no válida, intente nuevamente.");
            mostrarOpcionesReseña(producto); 
    }
}
}