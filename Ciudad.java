package Ejercicio11Predicate;

public class Ciudad {
    protected String nombre;
    protected Integer habitantes;

    public Ciudad(String nombre, Integer habitantes) {
        this.nombre = nombre;
        this.habitantes = habitantes;
    }

    @Override
    public String toString() {
        return "Ciudad{" +
                "nombre='" + nombre + '\'' +
                ", habitantes=" + habitantes +
                '}';
    }
}
