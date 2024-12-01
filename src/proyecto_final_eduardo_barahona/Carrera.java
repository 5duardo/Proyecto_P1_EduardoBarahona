/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final_eduardo_barahona;

/**
 *
 * @author eduar
 */
import javax.swing.*;
import java.util.*;
import java.util.Timer;

public class Carrera {
    
    private Garaje garaje;
    private JLabel CarroCarrera1;
    private JLabel CarroCarrera2;
    private JLabel CarroCarrera3;
    private Timer timer;
    private Random random;
    
    public Carrera(Garaje garaje, JLabel CarroCarrera1, JLabel CarroCarrera2, JLabel CarroCarrera3) {
        this.garaje = garaje;
        this.CarroCarrera1 = CarroCarrera1;
        this.CarroCarrera2 = CarroCarrera2;
        this.CarroCarrera3 = CarroCarrera3;
        this.random = new Random();
    }

    public void empezar() {

        JOptionPane.showMessageDialog(null, "La Carrera ha comenzado", "Carrera", JOptionPane.INFORMATION_MESSAGE);
        
        // Obtener los carros del garaje
        Map<String, Carro> carros = garaje.obtenerTodosLosCarros();
        
        // Iniciar el temporizador para simular la carrera
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                mostrarResultados(carros);
            }
        }, 5000); 

  
        mostrarCarrosAleatorios(carros);
    }

    private void mostrarCarrosAleatorios(Map<String, Carro> carros) {
        // Simula la carrera mostrando los carros aleatoriamente
        int randomTime1 = random.nextInt(5) + 1; 
        int randomTime2 = random.nextInt(5) + 1;
        int randomTime3 = random.nextInt(5) + 1;


        Timer carTimer = new Timer();
        
        // Mostrar los carros al azar despue de un pequeño retraso
        carTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                // Muestra el primer carro     
                CarroCarrera1.setVisible(true);
            }
        }, randomTime1 * 1000);
        
        carTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                // Muestra el segundo carro   
                CarroCarrera2.setVisible(true); 
            }
        }, randomTime2 * 1000); 
        
        carTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                // Muestra el tercer carro     
                CarroCarrera3.setVisible(true); 
            }
        }, randomTime3 * 1000);
    }

    private void mostrarResultados(Map<String, Carro> carros) {
   
    List<Carro> listaCarros = new ArrayList<>(carros.values());
    
    // Genera tiempos aleatorios para cada carro
    int[] tiempos = new int[listaCarros.size()];
    for (int i = 0; i < tiempos.length; i++) {
        tiempos[i] = random.nextInt(10) + 1;
    }
    
    //el carro ganador (el que tiene el menor tiempo)
    int winnerIndex = 0;
    for (int i = 1; i < tiempos.length; i++) {
        if (tiempos[i] < tiempos[winnerIndex]) {
            winnerIndex = i;
        }
    }

    //mensaje con los resultados
    StringBuilder resultMessage = new StringBuilder("El ganador es: " + listaCarros.get(winnerIndex).getNombre() + "\n");
    for (int i = 0; i < listaCarros.size(); i++) {
        resultMessage.append(listaCarros.get(i).getNombre())
                     .append(" llegó en: ")
                     .append(tiempos[i])
                     .append(" segundos\n");
    }

    JOptionPane.showMessageDialog(null, resultMessage.toString(), "Resultados de la Carrera", JOptionPane.INFORMATION_MESSAGE);
}

}
