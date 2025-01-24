public class Rectangulo extends Forma{
    protected double longitud;
    protected double ancho;

    public Rectangulo(double longitud, double ancho) {
        super("Rectangulo");
        this.longitud = longitud;
        this.ancho = ancho;
    }

    @Override
    public double area(){
        return this.longitud*this.ancho;
    }
}
