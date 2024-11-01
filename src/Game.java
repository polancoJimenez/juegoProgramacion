//referencia
import java.util.Random;
import java.util.Scanner;

// Clase principal del juego
public class Game {
    // Atributos del héroe y enemigo
    private String nombreHeroe;
    private int saludHeroe;
    private int ataqueHeroe;
    private int defensaHeroe;

    private String nombreEnemigo;
    private int saludEnemigo;
    private int ataqueEnemigo;
    private int defensaEnemigo;

    private Random aleatorio;
    private Scanner scanner;

    // Constructor del juego
    public Game() {
        this.nombreHeroe = "DOOM";
        this.saludHeroe = 100;
        this.ataqueHeroe = 25;
        this.defensaHeroe = 10;

        this.nombreEnemigo = "HANK";
        this.saludEnemigo = 80;
        this.ataqueEnemigo = 20;
        this.defensaEnemigo = 8;

        this.aleatorio = new Random();
        this.scanner = new Scanner(System.in);
    }

    // Método para ejecutar el juego
    public void iniciarJuego() {
        System.out.println("¡Bienvenido al juego!");
        System.out.println("¡Comienza la batalla entre " + nombreHeroe + " y " + nombreEnemigo + "!\n");

        while (saludHeroe > 0 && saludEnemigo > 0) {
            mostrarEstado();
            int opcion = elegirAccion();

            switch (opcion) {
                case 1:
                    atacarEnemigo();
                    break;
                case 2:
                    defenderHeroe();
                    break;
                default:
                    System.out.println("Opción inválida. Intenta nuevamente.");
                    continue;
            }

            if (saludEnemigo > 0) {
                atacarHeroe();
            }
            System.out.println();
        }

        mostrarResultado();
    }

    // Método para mostrar el estado de ambos personajes
    private void mostrarEstado() {
        System.out.println("Salud de " + nombreHeroe + ": " + saludHeroe);
        System.out.println("Salud de " + nombreEnemigo + ": " + saludEnemigo);
    }

    // Método para elegir acción
    private int elegirAccion() {
        System.out.println("¿Qué quieres hacer?");
        System.out.println("1. Atacar");
        System.out.println("2. Defenderse");
        System.out.print("Elige una opción: ");
        return scanner.nextInt();
    }

    // Método para atacar al enemigo
    private void atacarEnemigo() {
        System.out.println(nombreHeroe + " ataca a " + nombreEnemigo);
        int dano = ataqueHeroe - defensaEnemigo;
        if (dano < 0) dano = 0; // Evita que el daño sea negativo
        saludEnemigo -= dano;
        System.out.println(nombreEnemigo + " recibe " + dano + " puntos de daño.");
    }

    // Método para defenderse
    private void defenderHeroe() {
        defensaHeroe += 5;  // Aumenta la defensa temporalmente
        System.out.println(nombreHeroe + " se defiende, aumentando su defensa en 5 puntos.");
    }

    // Método para que el enemigo ataque al héroe
    private void atacarHeroe() {
        System.out.println(nombreEnemigo + " ataca a " + nombreHeroe);
        int dano = ataqueEnemigo - defensaHeroe;
        if (dano < 0) dano = 0; // Evita que el daño sea negativo
        saludHeroe -= dano;
        System.out.println(nombreHeroe + " recibe " + dano + " puntos de daño.");
    }

    // Método para mostrar el resultado final
    private void mostrarResultado() {
        if (saludHeroe > 0) {
            System.out.println("¡" + nombreHeroe + " ha ganado la batalla!");
        } else {
            System.out.println("¡" + nombreEnemigo + " ha ganado la batalla!");
        }
    }

    // Método principal
    public static void main(String[] args) {
        Game juego = new Game();
        juego.iniciarJuego();
    }
}
