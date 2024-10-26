import java.util.Random;
import java.util.Scanner;

public class Game {

    // Clase Heroe
    static class Heroe {
        private int ataque;
        private int defensa;
        private int salud = 100;
        private boolean defendiendo = false;

        public Heroe(int ataque, int defensa) {
            this.ataque = ataque;
            this.defensa = defensa;
        }

        public int getSalud() {
            return salud;
        }

        public void recibirDanio(int danio) {
            if (defendiendo) {
                danio -= defensa / 2; // Reduce el daño a la mitad si se defiende
                System.out.println("¡El Héroe se defiende! Daño reducido a " + danio);
                defendiendo = false; // Resetea la defensa después de usarla
            }
            int danioReal = Math.max(0, danio);
            salud = Math.max(0, salud - danioReal);
            System.out.println("Salud del Héroe: " + salud);
        }

        public void atacar(Villano villano) {
            System.out.println("¡El Héroe ataca al Villano!");
            villano.recibirDanio(ataque);
        }

        public void defender() {
            defendiendo = true;
            System.out.println("¡El Héroe se está defendiendo!");
        }
    }

    // Clase Villano
    static class Villano {
        private int ataque;
        private int defensa;
        private int salud = 100;
        private boolean defendiendo = false;

        public Villano(int ataque, int defensa) {
            this.ataque = ataque;
            this.defensa = defensa;
        }

        public int getSalud() {
            return salud;
        }

        public void recibirDanio(int danio) {
            if (defendiendo) {
                danio -= defensa / 2; // Reduce el daño a la mitad si se defiende
                System.out.println("¡El Villano se defiende! Daño reducido a " + danio);
                defendiendo = false; // Resetea la defensa después de usarla
            }
            int danioReal = Math.max(0, danio);
            salud = Math.max(0, salud - danioReal);
            System.out.println("Salud del Villano: " + salud);
        }

        public void atacar(Heroe heroe) {
            System.out.println("¡El Villano ataca al Héroe!");
            heroe.recibirDanio(ataque);
        }

        public void defender() {
            defendiendo = true;
            System.out.println("¡El Villano se está defendiendo!");
        }
    }

    public static void main(String[] args) {
        Heroe heroe = new Heroe(15, 5);
        Villano villano = new Villano(12, 6);
        Scanner escaner = new Scanner(System.in);
        Random aleatorio = new Random();

        // Asignación aleatoria de personaje al usuario
        boolean usuarioEsHeroe = aleatorio.nextBoolean();
        String personajeUsuario = usuarioEsHeroe ? "Héroe" : "Villano";
        System.out.println("¡Felicidades! Has ganado el puesto de " + personajeUsuario + ". ¡Buena suerte!");
        System.out.println("¡Comienza la batalla!");

        while (heroe.getSalud() > 0 && villano.getSalud() > 0) {
            System.out.println("Elige una acción:");
            System.out.println("1. " + personajeUsuario + " ataca");
            System.out.println("2. " + personajeUsuario + " se defiende");

            int eleccion = escaner.nextInt();
            if (eleccion == 1) {
                if (usuarioEsHeroe) {
                    heroe.atacar(villano);
                    if (villano.getSalud() > 0) villano.atacar(heroe);
                } else {
                    villano.atacar(heroe);
                    if (heroe.getSalud() > 0) heroe.atacar(villano);
                }
            } else if (eleccion == 2) {
                if (usuarioEsHeroe) {
                    heroe.defender();
                    if (villano.getSalud() > 0) villano.atacar(heroe);
                } else {
                    villano.defender();
                    if (heroe.getSalud() > 0) heroe.atacar(villano);
                }
            } else {
                System.out.println("Opción inválida. Por favor, selecciona 1 o 2.");
            }

            System.out.println("----------------------------");

            if (heroe.getSalud() == 0 || villano.getSalud() == 0) {
                break;
            }
        }

        System.out.println(heroe.getSalud() > 0 ? "¡El Héroe ha ganado!" : "¡El Villano ha ganado!");
        escaner.close();
    }
}
