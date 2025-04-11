package Ejercicios;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class EjerciciosFunction {
    public static void main(String[] args) {
        //Ejercicio 1
        Function<String, Integer> contarLetras = s -> s.length();
        int letras = contarLetras.apply("Programacion");
        System.out.println(letras);

        //Ejercicio 2
        Function<Integer, Integer> potencia2  = integer -> integer*integer;
        int pot = potencia2.apply(4);
        System.out.println(pot);

        //Ejercicio 3
        System.out.println(potencia2.apply(contarLetras.apply("Programacion")));

        //Ejercicio 5
        BiFunction<Integer, Integer, Integer> suma = (integer, integer2) -> integer+integer2;
        System.out.println(suma.apply(8,7));

        //Ejercicio 6
        BiFunction<Integer,Integer,Double> potenciaNueva =(integer, integer2) -> Math.pow(integer,integer2);
        System.out.println(potenciaNueva.apply(4,3));

        //Ejercicio 7
        Function<Double, String> mostrar = numero -> "Resultado: " + numero;
        System.out.println(mostrar.apply(6.8));

        //Ejercicio 8
        System.out.println(mostrar.apply(potenciaNueva.apply(2,4)));

        //Ejercicio 9
        ejercicio9(2,4,potenciaNueva,mostrar);

        //Ejercicio 11
        List<String> lista = Arrays.asList("Hola", "Buenos", "Barcelona", "Aleatorio");

        BiFunction<String, Integer, String> comprobarLongitud = (s, integer) -> s.length() > integer ? s : null;

        for(String palabra : lista){
            System.out.println(comprobarLongitud.apply(palabra, 7));
        }

        //Ejercicio 12
        BiFunction<String, String, String> comprobarInicio = (s, s2) -> s.startsWith(s2) ? s : null;

        for(String palabra : lista){
            System.out.println(comprobarInicio.apply(palabra, "Ba"));
        }
    }

    public static void ejercicio9(int base, int exponente, BiFunction<Integer, Integer, Double> potencia, Function<Double, String> mostrar) {
        double resultado = potencia.apply(base, exponente);
        String mensaje = mostrar.apply(resultado);
        System.out.println(mensaje);
    }
}
