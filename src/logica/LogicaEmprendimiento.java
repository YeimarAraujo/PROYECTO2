/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;


import entidades.Emprendimiento;
import entidades.Producto;
import entidades.Reseña;
import java.util.ArrayList;
import java.util.Scanner;
import persistencia.ArrayListEmprendimiento;
import persistencia.IEmprendimiento;

/**
 *
 * @author POWER
 */
public class LogicaEmprendimiento {
    private final ArrayList<Producto> productos;
    private IEmprendimiento persistencia;
    private int op;
    private final Scanner scanner;

    public LogicaEmprendimiento() {
        this.persistencia = new ArrayListEmprendimiento();
        this.productos = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }
    public boolean crearEmprendimiento(Emprendimiento emprendimiento){
        return this.persistencia.agregarEmprendimiento(emprendimiento);
    }

    public void agregarProducto() {
        System.out.println("Ingrese el nombre del producto:");
        String nombreProducto = scanner.nextLine();
        System.out.println("Ingrese el precio del producto:");
        float precio = scanner.nextFloat();
        scanner.nextLine();
        System.out.println("Ingrese el codigo del producto:");
        int codigo = scanner.nextInt();
        scanner.nextLine();
        
        Producto producto = new Producto(nombreProducto, precio, codigo);
        productos.add(producto); 
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
            
            this.op = this.scanner.nextInt();
           
          switch (this.op) {
            case 1:this.buscarPorNombre();
                    break;
            case 2:this.buscarPorCodigo();
                    break;
            case 3: break;
            default : System.out.println("!! La opcion no es valida, intente nuevamente ¡¡\n");
 
         
    }
  }
   public void buscarPorNombre() {
    System.out.print("Ingrese el nombre del producto: ");
    String nombreProducto = scanner.nextLine();
     scanner.nextLine();
    Producto productoEncontrado = null;

    for (Producto producto : productos) {
        if (producto.getNombreProducto() == nombreProducto) {
            productoEncontrado = producto;
            System.out.println("Producto encontrado: " + producto);
            break; 
        }
    }

    if (productoEncontrado == null) {
        System.out.println("Producto no encontrado.");
        return; 
    }

    mostrarOpcionesReseña(productoEncontrado);
}

public void buscarPorCodigo() {
    System.out.print("Ingrese el codigo del producto: ");
    int codigoProducto = scanner.nextInt();
    scanner.nextLine(); 
    Producto productoEncontrado = null;

    for (Producto producto : productos) {
        if (producto.getCod() == codigoProducto) {
            productoEncontrado = producto;
            System.out.println("Producto encontrado: " + producto);
            break;
        }
    }

    if (productoEncontrado == null) {
        System.out.println("Producto no encontrado.");
        return; 
    }

    mostrarOpcionesReseña(productoEncontrado);
}

private void mostrarOpcionesReseña(Producto producto) {
    System.out.println("                   ");
    System.out.println("1. Agregar reseña");
    System.out.println("2. Mostrar reseñas");
    System.out.println("3. Volver");
    int accion = scanner.nextInt();
    scanner.nextLine(); // Consume newline

    switch (accion) {
        case 1:
            System.out.print("Ingrese su reseña: ");
            String comentario = scanner.nextLine();

            Reseña nuevaReseña = new Reseña(comentario);
            producto.agregarReseña(nuevaReseña);
            System.out.println("Reseña agregada exitosamente.");
            break;
        case 2:
            System.out.println("Reseñas del producto:");
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