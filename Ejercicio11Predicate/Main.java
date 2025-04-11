package Ejercicio11Predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Ciudad> ciudades = new ArrayList<>();
        ciudades.add(new Ciudad("Elche", 1000000));
        ciudades.add(new Ciudad("Alicante", 4000000));
        ciudades.add(new Ciudad("Madrid", 200000));
        ciudades.add(new Ciudad("Barcelona", 1000));
        ciudades.add(new Ciudad("EValencia", 50000000));
        ciudades.add(new Ciudad("Sevilla", 1200));
        ciudades.add(new Ciudad("Murcia", 230000000));
        ciudades.add(new Ciudad("Pamplona", 12000));
        ciudades.add(new Ciudad("Lugo", 5000));
        ciudades.add(new Ciudad("Granada", 8000000));
        Predicate<Ciudad> p1 = ciudad -> ciudad.nombre.startsWith("E") && ciudad.habitantes > 100000;

        filtrarCiudades(ciudades, p1);
    }

    public static void filtrarCiudades(List<Ciudad> ciudades, Predicate<Ciudad> p1) {
        ciudades.stream().filter(p1).forEach(n -> System.out.println(n.toString()));
    }
}
