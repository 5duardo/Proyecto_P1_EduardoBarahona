/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final_eduardo_barahona;

/**
 *
 * @author eduar
 */
public class Carro {
    public String nombre;
    public String marca;
    public String modelo;
    public int año;
    public int nivelMotor;      
    public int velocidadMaxima; 
    public int nivelNitro;     

    public Carro(String nombre, String marca, String modelo, int año, int nivelMotor, int velocidadMaxima, int nivelNitro) {
        this.nombre = nombre;
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.nivelMotor = nivelMotor;
        this.velocidadMaxima = velocidadMaxima;
        this.nivelNitro = nivelNitro;
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public int getAño() { return año; }
    public int getNivelMotor() { return nivelMotor; }
    public int getVelocidadMaxima() { return velocidadMaxima; }
    public int getNivelNitro() { return nivelNitro; }

    @Override
    public String toString() {
        return String.format("%s %s %s (%d) - Nivel Motor: %d, Velocidad Máxima: %d km/h, Nivel Nitro: %d",
                marca, modelo, nombre, año, nivelMotor, velocidadMaxima, nivelNitro);
    }
    
    public void setNivelMotor(int nivelMotor) {
    this.nivelMotor = nivelMotor;
}

public void setVelocidadMaxima(int velocidadMaxima) {
    this.velocidadMaxima = velocidadMaxima;
}

public void setNivelNitro(int nivelNitro) {
    this.nivelNitro = nivelNitro;
}

}


    
