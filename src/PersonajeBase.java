import java.util.Random;

public class PersonajeBase implements IPersonaje {
    private String nombre;
    private int puntosDeVida;
    private final int MAX_DANO = 30;
    private final int MIN_DANO = 10;

    public PersonajeBase(String nombre) {
        this.nombre = nombre;
        this.puntosDeVida = 100;
    }

    @Override
    public void atacar(IPersonaje oponente) {
        Random rand = new Random();
        int dano = rand.nextInt((MAX_DANO - MIN_DANO) + 1) + MIN_DANO;
        System.out.println(this.getNombre() + " ataca a " + oponente.getNombre() + " causando " + dano + " puntos de daño base.");
        oponente.recibirDano(dano);
    }

    @Override
    public void recibirDano(int dano) {
        this.puntosDeVida -= dano;
        if (this.puntosDeVida < 0) this.puntosDeVida = 0;
    }

    @Override
    public boolean estaVivo() {
        return this.puntosDeVida > 0;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public int getPuntosDeVida() {
        return this.puntosDeVida;
    }
}
