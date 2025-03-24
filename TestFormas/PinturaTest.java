package Polimorfismo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PinturaTest {
    @Test //Se deberia hacer otro test diferente que se llame PinturaTest para los métodos relacionados a Pintura
    public void testCalcularPintura() {
        Pintura pintura = new Pintura(10);
        Esfera esfera = new Esfera(5);
        Rectangulo rectangulo = new Rectangulo(4, 6);
        Cilindro cilindro = new Cilindro(3, 7);

        assertEquals(esfera.area() / pintura.cobertura, pintura.calcularPintura(esfera), 0.01);
        assertEquals(rectangulo.area() / pintura.cobertura, pintura.calcularPintura(rectangulo), 0.01);
        assertEquals(cilindro.area() / pintura.cobertura, pintura.calcularPintura(cilindro), 0.01);
    }
}