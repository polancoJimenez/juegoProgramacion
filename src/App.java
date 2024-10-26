public class App {
    public static void main(String[] args) throws Exception {
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
    }
}
