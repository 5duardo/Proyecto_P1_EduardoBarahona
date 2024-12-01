/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final_eduardo_barahona;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author eduar
 */
public class Garaje {
    

    private HashMap<String, Carro> carros;

    public Garaje() {
        carros = new HashMap<>();
        //carros de ejemplo
        carros.put("Ferrari LaFerrari", new Carro("Ferrari LaFerrari", "Ferrari", "LaFerrari", 2015, 800, 350, 5));
        carros.put("Ferrari 599", new Carro("Ferrari 599", "Ferrari", "599", 2006, 620, 330, 4));
        carros.put("Ferrari F40", new Carro("Ferrari F40", "Ferrari", "F40", 1987, 478, 324, 3));
    }

    public Carro obtenerCarro(String nombre) {
        return carros.get(nombre);
    }
    
    public Map<String, Carro> obtenerTodosLosCarros() {
        return carros;
    }
}