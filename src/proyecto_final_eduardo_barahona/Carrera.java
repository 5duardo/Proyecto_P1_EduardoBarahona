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

    //Constructor de la clase Carrera.
    public Carrera(Garaje garaje, JLabel carroCarrera1, JLabel carroCarrera2, JLabel carroCarrera3) {
        this.garaje = garaje;
        this.carroCarrera1 = carroCarrera1;
        this.carroCarrera2 = carroCarrera2;
        this.carroCarrera3 = carroCarrera3;
        this.random = new Random();
    }

    public void empezar() {
        Carro carroSeleccionado = garaje.getCarroSeleccionado();

        if (carroSeleccionado == null) {
            JOptionPane.showMessageDialog(null, "Por favor, selecciona un carro antes de iniciar la carrera.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(null, "Carro seleccionado: " + carroSeleccionado.getNombre(), "Carro Seleccionado", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "3...2...1... ¡Go!", "Carrera", JOptionPane.INFORMATION_MESSAGE);

        List<Carro> carros = new ArrayList<>(garaje.obtenerTodosLosCarros());

        carroCarrera1.setVisible(false);
        carroCarrera2.setVisible(false);
        carroCarrera3.setVisible(false);

        mostrarCarrosAleatorios(carros);
        iniciarCarrera(carros);
    }

    //Selecciona y muestra tres carros aleatorios.
    private void mostrarCarrosAleatorios(List<Carro> carros) {
        Set<Carro> seleccionados = new HashSet<>();
        while (seleccionados.size() < 3) {
            seleccionados.add(carros.get(random.nextInt(carros.size())));
        }

        List<Carro> listaSeleccionados = new ArrayList<>(seleccionados);
        mostrarCarroUnoPorUno(listaSeleccionados);
    }

    //Muestra cada carro seleccionado con un retraso.
    private void mostrarCarroUnoPorUno(List<Carro> seleccionados) {
        Timer mostrarTimer = new Timer();
        int delay = 0;

        for (int i = 0; i < seleccionados.size(); i++) {
            Carro carro = seleccionados.get(i);
            JLabel label = obtenerLabelPorCarro(carro);

            mostrarTimer.schedule(new TimerTask() {
                @Override
                public void run() {
                    label.setText(carro.getNombre());
                    label.setVisible(true);
                }
            }, delay);

            delay += 2000;
        }
    }

    //Retorna el JLabel asociado al nombre del carro.
    private JLabel obtenerLabelPorCarro(Carro carro) {
        switch (carro.getNombre()) {
            case "BMW M4":
                return carroCarrera1;
            case "Lamborghini Huracan":
                return carroCarrera2;
            case "Ferrari LaFerrari":
                return carroCarrera3;
            default:
                throw new IllegalArgumentException("Carro no reconocido: " + carro.getNombre());
        }
    }

    //Inicia el temporizador para la carrera.
    private void iniciarCarrera(List<Carro> carros) {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                mostrarResultados(carros);
            }
        }, 6000);
    }

    //Muestra los resultados de la carrera y calcula la suma de tiempos recursivamente.
    private void mostrarResultados(List<Carro> carros) {
        int[] tiempos = new int[carros.size()];
        for (int i = 0; i < tiempos.length; i++) {
            tiempos[i] = random.nextInt(10) + 1;
        }

        int ganadorIndex = obtenerGanador(tiempos);
        Carro ganador = carros.get(ganadorIndex);

        StringBuilder resultados = new StringBuilder("El ganador es: " + ganador.getNombre() + "\n");
        for (int i = 0; i < tiempos.length; i++) {
            resultados.append(carros.get(i).getNombre())
                    .append(" llegó en: ")
                    .append(tiempos[i])
                    .append(" segundos\n");
        }

        int sumaTiempos = sumarTiemposRecursivamente(tiempos, 0);
        resultados.append("\nSuma total de los tiempos: ").append(sumaTiempos).append(" segundos");

        JOptionPane.showMessageDialog(null, resultados.toString(), "Resultados de la Carrera", JOptionPane.INFORMATION_MESSAGE);
        mostrarGanador(ganador);
        actualizarDinero(ganador);
    }


    //Encuentra el índice del carro ganador (el de menor tiempo).
    private int obtenerGanador(int[] tiempos) {
        int ganadorIndex = 0;
        for (int i = 1; i < tiempos.length; i++) {
            if (tiempos[i] < tiempos[ganadorIndex]) {
                ganadorIndex = i;
            }
        }
        return ganadorIndex;
    }

    //Muestra el carro ganador en pantalla.
    private void mostrarGanador(Carro ganador) {
        carroCarrera1.setVisible(ganador.getNombre().equals("BMW M4"));
        carroCarrera2.setVisible(ganador.getNombre().equals("Lamborghini Huracan"));
        carroCarrera3.setVisible(ganador.getNombre().equals("Ferrari LaFerrari"));
    }

    //Actualiza el dinero del jugador dependiendo del resultado.
    private void actualizarDinero(Carro ganador) {
        Carro carroSeleccionado = garaje.getCarroSeleccionado();
        int ganancia = ganador.getNombre().equals(carroSeleccionado.getNombre()) ? 200000 : 50000;

        Pantalla.setDinero(Pantalla.getDinero() + ganancia);
        String mensaje = ganador.getNombre().equals(carroSeleccionado.getNombre())
                ? "¡Felicidades, ganaste 200,000 por ganar!"
                : "Perdiste, pero ganaste 50,000 por participar.";
        JOptionPane.showMessageDialog(null, mensaje, "Ganancia", JOptionPane.INFORMATION_MESSAGE);
    }

    //Metodo recursivo que suma los tiempos de llegada de los carros
    private int sumarTiemposRecursivamente(int[] tiempos, int index) {
        if (index == tiempos.length) {
            return 0;
        }
        return tiempos[index] + sumarTiemposRecursivamente(tiempos, index + 1);
    }
}
