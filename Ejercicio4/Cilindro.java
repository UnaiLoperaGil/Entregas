public class Cilindro extends Forma{
    protected double radio;
    protected double altura;

    public Cilindro(double radio, double altura) {
        super("Cilindro");
        this.radio = radio;
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Cilindro{" +
                "radio=" + radio +
                ", altura=" + altura +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    @Override
    public double area(){
        return Math.PI*this.radio*this.radio*this.altura;
    }
}
