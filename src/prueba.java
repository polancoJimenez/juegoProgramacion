import java.util.Random;
import java.util.Scanner;

// clase padre
class atributos {
    String nombre;
    int salud;
    int ataque;
    int defensa;

    // metodo para que ambos puedan recibir daño
    public void recibirDaño(int daño) {
        int dañoReal = daño - this.defensa;
        if (dañoReal > 0) {
            this.salud -= dañoReal;
        }
        if (this.salud < 0) {
            this.salud = 0;  // evita que la salud se tome como un valor negativo
        }
    }

    // metodo para que ambos puedan atacar
    public int ataque() {
        return this.ataque;
    }
}

// subclase para darle los atributos al heroe
class Heroe extends atributos {
    public Heroe(String nombre, int salud, int ataque, int defensa) {
        this.nombre = nombre;
        this.salud = salud;
        this.ataque = ataque;
        this.defensa = defensa;
    }

    // metodo para que solo el heroe pueda defenderse
    public void defendiendo() {
        this.defensa += 5; //este metodo hace que el heroe aumente su vida al defenderse 
        System.out.println(this.nombre + " se defiende, aumentando su defensa en 5 puntos.");
    }
}

// esta es una subclase para darle atributos al enemigo
class enemigo extends atributos {
    private Random aleatorio = new Random();

    public enemigo(String nombre, int salud, int ataque, int defensa) {
        this.nombre = nombre;
        this.salud = salud;
        this.ataque = ataque;
        this.defensa = defensa;
    }

    // este metodo es para que el valor del ataque sea aleatorio
    public int ataqueAleatorio() {
        return this.ataque + aleatorio.nextInt(6);  // esto es para darle un valor extra al ataque
    }
}

// aqui ya se inicializa el juego
public class prueba {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Heroe doom = new Heroe("DOOM", 100, 25, 10);
        enemigo hank = new enemigo("HANK", 80, 20, 8);

        System.out.println("¡Comienza la batalla entre " + doom.nombre + " y " + hank.nombre + "!\n");

        while (doom.salud > 0 && hank.salud > 0) {
            // se muestra el estado de ambos personajes
            System.out.println("Salud de " + doom.nombre + ": " + doom.salud);
            System.out.println("Salud de " + hank.nombre + ": " + hank.salud);
            System.out.println("¿Qué quieres hacer?");
            System.out.println("1. Atacar");
            System.out.println("2. Defenderse");
            System.out.print("escoge que hacer: ");
            int eleccion = scanner.nextInt();

            switch (eleccion) {
                case 1:
                    // el heroe ataca al enemigo
                    int danoHeroe = doom.ataque();
                    System.out.println(doom.nombre + " ataca a " + hank.nombre + " causando " + danoHeroe + " puntos de daño.");
                    hank.recibirDaño(danoHeroe);
                    break;
                case 2:
                    // el heroe se defiende del enemigo
                    doom.defendiendo();
                    break;
                default:
                    System.out.println("Opción inválida. Intenta nuevamente.");
                    continue;
            }

            // si el enemigo tiene vida, sigue con los ataques
            if (hank.salud > 0) {
                int danoEnemigo = hank.ataqueAleatorio();
                System.out.println(hank.nombre + " ataca a " + doom.nombre + " causando " + danoEnemigo + " puntos de daño.");
                doom.recibirDaño(danoEnemigo);
            }

            System.out.println();
        }

        // se imprime en final de la batalla
        if (doom.salud > 0) {
            System.out.println("¡" + doom.nombre + " ha ganado la batalla!");
        } else {
            System.out.println("¡" + hank.nombre + " ha ganado la batalla!");
        }

        scanner.close();
    }
}
