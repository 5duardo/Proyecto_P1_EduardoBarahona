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
        carros.put("Ferrari LaFerrari", new Carro("Ferrari LaFerrari", "Ferrari", "LaFerrari", 2015, 800, 350, 0));
        carros.put("Lamborghini Huracan", new Carro("Lamborghini Huracan", "Huracan", "Huracan", 2006, 620, 330, 0));
        carros.put("BMW M4", new Carro("BMW M4", "BMW", "M4", 1987, 478, 324, 0));
    }

    public Carro obtenerCarro(String nombre) {
        return carros.get(nombre);
    }
    
    public Map<String, Carro> obtenerTodosLosCarros() {
        return carros;
    }
}