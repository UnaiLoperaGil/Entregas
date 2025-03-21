package Polimorfismo;

public class Pintura {
    protected double cobertura;

    public Pintura(double cobertura) {
        this.cobertura = cobertura;
    }

    public double calcularPintura(Forma forma){
        return forma.area()/this.cobertura;
    }
}
