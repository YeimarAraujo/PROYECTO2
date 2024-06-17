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
public class ArrayListReseña implements IReseña{
     private ArrayList<Reseña> reseñas = new ArrayList<>();

    @Override
    public boolean agregarReseña(Reseña reseña) {
      return  reseñas.add(reseña);
    }

    @Override
    public ArrayList<Reseña> obtenerReseñas() {
        return reseñas; }
}
