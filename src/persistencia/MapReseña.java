/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import persistencia.IReseña;
import entidades.Reseña;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author POWER
 */
public class MapReseña implements IReseña{
     private Map<String, Reseña> reseñas = new HashMap<>();

    @Override
    public boolean agregarReseña(Reseña reseña) {
        this.reseñas.put(reseña.getComentario(), reseña);
        return true;
    }

    @Override
    public ArrayList<Reseña> obtenerReseñas() {
        return (ArrayList<Reseña>) reseñas;
    }
}
