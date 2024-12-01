/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final_eduardo_barahona;

/**
 *
 * @author eduar
 */
public class MejoraCarro {
    
     // Metodo para mejorar el nivel del motor
    public void mejorarMotor(Carro carro, int incremento) {
        int nuevoNivel = carro.getNivelMotor() + incremento;
        System.out.printf("Mejorando el motor de %s: %d -> %d%n", carro.getNombre(), carro.getNivelMotor(), nuevoNivel);
        setNivelMotor(carro, nuevoNivel);
    }

    // Metodo para mejorar la velocidad máxima
    public void mejorarVelocidadMaxima(Carro carro, int incremento) {
        int nuevaVelocidad = carro.getVelocidadMaxima() + incremento;
        System.out.printf("Mejorando la velocidad máxima de %s: %d km/h -> %d km/h%n", carro.getNombre(), carro.getVelocidadMaxima(), nuevaVelocidad);
        setVelocidadMaxima(carro, nuevaVelocidad);
    }

    // Metodo para mejorar el nivel de nitro
    public void mejorarNitro(Carro carro, int incremento) {
        int nuevoNitro = carro.getNivelNitro() + incremento;
        System.out.printf("Mejorando el nivel de nitro de %s: %d -> %d%n", carro.getNombre(), carro.getNivelNitro(), nuevoNitro);
        setNivelNitro(carro, nuevoNitro);
    }

    // Metodos para actualizar los atributos del carro
    private void setNivelMotor(Carro carro, int nuevoNivelMotor) {
        carro = new Carro(carro.getNombre(), carro.getMarca(), carro.getModelo(), carro.getAño(),
                nuevoNivelMotor, carro.getVelocidadMaxima(), carro.getNivelNitro());
    }

    private void setVelocidadMaxima(Carro carro, int nuevaVelocidadMaxima) {
        carro = new Carro(carro.getNombre(), carro.getMarca(), carro.getModelo(), carro.getAño(),
                carro.getNivelMotor(), nuevaVelocidadMaxima, carro.getNivelNitro());
    }

    private void setNivelNitro(Carro carro, int nuevoNivelNitro) {
        carro = new Carro(carro.getNombre(), carro.getMarca(), carro.getModelo(), carro.getAño(),
                carro.getNivelMotor(), carro.getVelocidadMaxima(), nuevoNivelNitro);
    }
    
}
