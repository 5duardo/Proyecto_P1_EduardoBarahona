/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final_eduardo_barahona;

import javax.swing.*;
import java.util.*;
import java.util.Timer;

public class Carrera {
    private Garaje garaje;
    private JLabel carroCarrera1; // Para BMW
    private JLabel carroCarrera2; // Para Lamborghini
    private JLabel carroCarrera3; // Para Ferrari
    private Timer timer;
    private Random random;

    public Carrera(Garaje garaje, JLabel carroCarrera1, JLabel carroCarrera2, JLabel carroCarrera3) {
        this.garaje = garaje;
        this.carroCarrera1 = carroCarrera1;
        this.carroCarrera2 = carroCarrera2;
        this.carroCarrera3 = carroCarrera3;
        this.random = new Random();
    }

    public void empezar() {
        Carro carroSeleccionado = garaje.getCarroSeleccionado(); // Obtener el carro seleccionado desde el garaje

        if (carroSeleccionado == null) {
            JOptionPane.showMessageDialog(null, "Por favor, selecciona un carro antes de iniciar la carrera.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(null, "Carro seleccionado: " + carroSeleccionado.getNombre(), "Carro Seleccionado", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "3", "Carrera", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "2", "Carrera", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "1", "Carrera", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "Comienza!!", "Carrera", JOptionPane.INFORMATION_MESSAGE);

        List<Carro> carros = new ArrayList<>(garaje.obtenerTodosLosCarros());
        
        // Ocultar todos los JLabels primero
        carroCarrera1.setVisible(false);
        carroCarrera2.setVisible(false);
        carroCarrera3.setVisible(false);
        

        mostrarCarrosAleatorios(carros);
        iniciarTemporizador(carros);

    }

    private void mostrarCarrosAleatorios(List<Carro> carros) {
        List<Carro> seleccionados = new ArrayList<>();
        while (seleccionados.size() < 3) {
            Carro carroAleatorio = carros.get(random.nextInt(carros.size()));
            if (!seleccionados.contains(carroAleatorio)) {
                seleccionados.add(carroAleatorio);
            }
        }

        // Mostrar carros uno por uno
        mostrarImagenTemporal(seleccionados.get(0), carroCarrera1, 2000, () -> {
            mostrarImagenTemporal(seleccionados.get(1), carroCarrera2, 2000, () -> {
                mostrarImagenTemporal(seleccionados.get(2), carroCarrera3, 2000, null);
            });
        });
    }

    private void mostrarImagenTemporal(Carro carro, JLabel label, int tiempo, Runnable siguienteAccion) {
        label.setText(carro.getNombre()); // Mostrar el nombre del carro
        label.setVisible(true); // Hacer visible el JLabel

        // Temporizador para ocultar la imagen después de un tiempo
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (siguienteAccion != null) {
                    siguienteAccion.run(); // Ejecutar la siguiente acción si existe
                }
            }
        }, tiempo); // Tiempo en milisegundos
    }

    private void iniciarTemporizador(List<Carro> carros) {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                mostrarResultados(carros);
            }
        }, 5000); // Espera 5 segundos antes de mostrar resultados
    }

    private void mostrarResultados(List<Carro> carros) {
        int[] tiempos = new int[carros.size()];
        for (int i = 0; i < tiempos.length; i++) {
            tiempos[i] = random.nextInt(10) + 1; // Simular tiempos aleatorios de carrera
        }

        // Determinar el ganador y el orden manualmente
        int ganadorIndex = 0;
        for (int i = 1; i < tiempos.length; i++) {
            if (tiempos[i] < tiempos[ganadorIndex]) {
                ganadorIndex = i; // Actualizar el índice del ganador
            }
        }

        // Crear el mensaje de resultados
        StringBuilder resultMessage = new StringBuilder("El ganador es: " + carros.get(ganadorIndex).getNombre() + "\n");
        for (int i = 0; i < tiempos.length; i++) {
            resultMessage.append(carros.get(i).getNombre())
                         .append(" llegó en: ")
                         .append(tiempos[i])
                         .append(" segundos\n");
        }

        JOptionPane.showMessageDialog(null, resultMessage.toString(), "Resultados de la Carrera", JOptionPane.INFORMATION_MESSAGE);
        
        // Mostrar la imagen del carro ganador primero
        mostrarImagenGanador(carros.get(ganadorIndex), carros, tiempos);
        actualizarDinero(carros.get(ganadorIndex));
    }

    private void mostrarImagenGanador(Carro ganador, List<Carro> carros, int[] tiempos) {

        // Mostrar solo el ganador
        if (ganador.getNombre().equals("BMW")) {
            carroCarrera1.setVisible(true);
        } else if (ganador.getNombre().equals("Lamborghini")) {
            carroCarrera2.setVisible(true);
        } else if (ganador.getNombre().equals("Ferrari")) {
            carroCarrera3.setVisible(true);
        }

        // Esperar un momento antes de mostrar los demás carros
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                mostrarLosOtrosCarros(carros, tiempos);
            }
        }, 2000); // Espera 2 segundos antes de mostrar los demás carros
    }

    private void mostrarLosOtrosCarros(List<Carro> carros, int[] tiempos) {
        // Mostrar los carros restantes uno por uno
        for (int i = 0; i < carros.size(); i++) {
            Carro carro = carros.get(i);
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    if (carro.getNombre().equals("BMW")) {
                        carroCarrera1.setVisible(true);
                    } else if (carro.getNombre().equals("Lamborghini")) {
                        carroCarrera2.setVisible(true);
                    } else if (carro.getNombre().equals("Ferrari")) {
                        carroCarrera3.setVisible(true);
                    }
                }
            }, i * 2000); // Muestra cada carro con un retraso
        }
    }

    private void actualizarDinero(Carro ganador) {
        Carro carroSeleccionado = garaje.getCarroSeleccionado(); // Obtener el carro seleccionado desde el garaje
        if (ganador.getNombre().equals(carroSeleccionado.getNombre())) {
            Pantalla.setDinero(Pantalla.getDinero() + 100000);
            JOptionPane.showMessageDialog(null, "Felicidades, ganaste 100,000 por ganar", "Ganancia", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Pantalla.setDinero(Pantalla.getDinero() + 20000);
            JOptionPane.showMessageDialog(null, "Perdiste pero ganaste 20,000 por participar", "Ganancia", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}