/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final_eduardo_barahona;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eduar
 */
public class Garaje {

    private List<Carro> carros;
    private Carro carroSeleccionado;

    public Garaje() {
        carros = new ArrayList<>();
        // Carros de ejemplo
        carros.add(new Carro("Ferrari LaFerrari", "Ferrari", "LaFerrari", 2015, 800, 350, 0));
        carros.add(new Carro("Lamborghini Huracan", "Lamborghini", "Huracan", 2020, 620, 330, 0));
        carros.add(new Carro("BMW M4", "BMW", "M4", 2005, 478, 324, 0));
    }

    public Carro obtenerCarro(String nombre) {
        for (Carro carro : carros) {
            if (carro.getNombre().equals(nombre)) {
                return carro;
            }
        }
        return null;
    }
    
    public List<Carro> obtenerTodosLosCarros() {
        return carros;
    }
    
    // Método para establecer el carro seleccionado
    public void setCarroSeleccionado(Carro carro) {
        this.carroSeleccionado = carro;
    }

    // Método para obtener el carro seleccionado
    public Carro getCarroSeleccionado() {
        return carroSeleccionado;
    }


}