public class ArmaDecorator extends PersonajeDecorator {
    private int danoExtra;

    public ArmaDecorator(IPersonaje personaje, int danoExtra) {
        super(personaje);
        this.danoExtra = danoExtra;
    }

    @Override
    public void atacar(IPersonaje oponente) {
        super.atacar(oponente);
        System.out.println(super.getNombre() + " usa su arma y causa " + danoExtra + " puntos de daño adicional!");
        oponente.recibirDano(danoExtra);
    }
    
    @Override
    public String getNombre() {
        return super.getNombre() + " (Equipado con Arma)";
    }
}
