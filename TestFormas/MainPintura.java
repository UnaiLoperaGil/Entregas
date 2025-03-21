package Polimorfismo;

public class MainPintura {
    public static void main(String[] args) {
        Pintura pintura = new Pintura(250);
        Forma rectangulo = new Rectangulo(20,35);
        Forma esfera = new Esfera(15);
        Forma cilindro = new Cilindro(10,30);

        System.out.println(pintura.calcularPintura(rectangulo));
        System.out.println(pintura.calcularPintura(esfera));
        System.out.println(pintura.calcularPintura(cilindro));
    }
}
