package Ejercicios;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;


public class EjerciciosPredicate {
    public static void main(String[] args) {
        //Ejercicio 1
        Predicate<Integer> p1 = n -> n > 100;
        System.out.println(p1.test(70));

        //Ejercicio 2
        Predicate<Integer> p2 = n -> n > 100;
        Predicate<Integer> p21 = n -> n < 300;
        Predicate<Integer> c221 = p2.and(p21);
        System.out.println(c221.test(500));

        //Ejercicio 3
        Predicate<Integer> p3 = n -> n > 100;
        Predicate<Integer> p32 = n -> n < 50;
        Predicate<Integer> c332 = p3.or(p32);
        System.out.println(c332.test(120));

        //Ejercicio 4
        Predicate<Integer> p4 = n -> n != 100;
        System.out.println(p4.test(100));

        //Ejercicio 5
        BiPredicate<String, String> p5 = (s1, s2) -> s1.equalsIgnoreCase(s2);
        System.out.println(p5.test("hello", "world"));

        //Ejercicio 6
        List<Integer> lista = Arrays.asList(1, 22, 3, 4, 5, 26, 7, 28, 9, 10);
        Predicate<Integer> p6 = n -> n > 25;
        Predicate<Integer> p7 = n -> n < 30;
        Predicate<Integer> c67 = p6.and(p7);
        lista.stream().filter(c67).forEach(n -> System.out.println(n));

        //Ejercicio 7
        Predicate<Integer> p8 = n -> n == 22;
        System.out.println(lista.stream().filter(p8).count());

        //Ejercicio 8
        List<String> lista2 = Arrays.asList("amigos", "bueno", "cueva", "drenaje", "edificio", "farmacia", "pentagono");
        Predicate<String> p9 = s -> s.startsWith("a");
        Predicate<String> p10 = s -> s.length() == 5;
        Predicate<String> c910 = p9.or(p10);
        lista2.stream().filter(c910).forEach(s -> System.out.println(s));

        //Ejercicio 9
        Predicate<String> p11 = s -> !s.startsWith("p");
        lista2.stream().filter(p11).forEach(s -> System.out.println(s));
    }

}
