/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.Reseña;
import java.util.ArrayList;

/**
 *
 * @author POWER
 */
public  interface IReseña {
    void agregarReseña(Reseña reseña);
    ArrayList<Reseña> obtenerReseñas();
}
