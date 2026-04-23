import java.util.Scanner;

public class JuegoLucha {
    private IPersonaje jugador1;
    private IPersonaje jugador2;

    public JuegoLucha(IPersonaje j1, IPersonaje j2) {
        this.jugador1 = j1;
        this.jugador2 = j2;
    }

    public void iniciarPelea() {
        System.out.println("La pelea comienza entre " + jugador1.getNombre() + " y " + jugador2.getNombre());
        
        while (jugador1.estaVivo() && jugador2.estaVivo()) {
            turno(jugador1, jugador2);
            if (jugador2.estaVivo()) {
                turno(jugador2, jugador1);
            }
        }
        
        if (jugador1.estaVivo()) {
            System.out.println(jugador1.getNombre() + " ha ganado la pelea.");
        } else {
            System.out.println(jugador2.getNombre() + " ha ganado la pelea.");
        }
    }

    private void turno(IPersonaje atacante, IPersonaje defensor) {
        System.out.println("\n--- Turno de " + atacante.getNombre() + " ---");
        System.out.println("Puntos de vida de " + defensor.getNombre() + ": " + defensor.getPuntosDeVida());
        atacante.atacar(defensor);
        System.out.println(defensor.getNombre() + " ahora tiene " + defensor.getPuntosDeVida() + " puntos de vida.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Introduce el nombre del jugador 1: ");
        String nombre1 = scanner.nextLine();
        System.out.print("Introduce el nombre del jugador 2: ");
        String nombre2 = scanner.nextLine();

        // Implementación del patrón: Creamos personajes base
        IPersonaje j1 = new PersonajeBase(nombre1);
        IPersonaje j2 = new PersonajeBase(nombre2);

        // Decoramos dinámicamente al jugador 1 con un arma que da 15 de daño extra
        System.out.println("¡" + nombre1 + " ha encontrado una espada mágica!");
        j1 = new ArmaDecorator(j1, 15);

        JuegoLucha juego = new JuegoLucha(j1, j2);
        juego.iniciarPelea();
        
        scanner.close();
    }
}
