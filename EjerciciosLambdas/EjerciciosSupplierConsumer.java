package Ejercicios;

import java.time.LocalTime;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class EjerciciosSupplierConsumer {
    public static void main(String[] args) {
        // Ejercicio 1
        Consumer<String> print = s -> System.out.println(s);

        print.accept("Estoy en clase de programación");

        //Ejercicio 2
        List<Integer> nums = new ArrayList<>();
        Consumer<Integer> numero = integer -> System.out.println(integer);
        for(int i = 1; i <= 10; i++){
            nums.add(i);
        }
        nums.forEach(numero);

        //Ejercicio 3
        List<String> palabras = new ArrayList<>();
        Consumer<String> palabra = p -> System.out.println(p.charAt(p.length()-1));
        for(int i = 1; i <= 10; i++){
            palabras.add("Hola");
        }
        palabras.forEach(palabra);

        //Ejercicio 4
        Supplier<String> variable = () -> "Java es un lenguaje de programación";
        String frase = variable.get();
        System.out.println(frase);

        //Ejercicio 5
        Supplier<Double> random = () -> Math.random();
        Double numeroD = random.get();
        System.out.println(numeroD);

        //Ejercicio 6
        Supplier<HashMap<String, String>> crearMapa = () -> new HashMap();
        HashMap<String, String> mapaT = crearMapa.get();
        mapaT.put("Uno", "Dos");
        mapaT.put("Tres", "Cuatro");
        System.out.println(mapaT);

        //Ejercicio 7
        BiConsumer<Integer,Integer> multiplica = (integer, integer2) -> System.out.println(integer*integer2);
        multiplica.accept(-9,7);

        //Ejercicio 8
        BiConsumer<Integer,Integer> suma = (integer, integer2) -> System.out.println(integer + integer2);
        BiConsumer<Integer,Integer> resta = (integer, integer2) -> System.out.println(integer - integer2);
        BiConsumer<Integer,Integer> dividir = (integer, integer2) -> System.out.println(integer / integer2);
        suma.accept(13,7);
        resta.accept(9,7);
        dividir.accept(14,2);

        //Ejercicio 9
        calculator(2,5, multiplica);
        calculator(5,8, suma);
        calculator(18, 3, dividir);

        //Ejercicio 10
        Map<Integer,String> mapa = new LinkedHashMap<>();
        mapa.put(1,"uno");
        mapa.put(2,"dos");
        mapa.put(3,"tres");
        mapa.put(4,"cuatro");
        mapa.put(5,"cinco");
        //BiConsumer<Integer,String> printer = (i, s) -> System.out.println("Clave: " + i + " Valor: " + s);
        mapa.forEach((integer, s) -> System.out.println("Clave: " + integer + " Valor: " + s));

        //Ejercicio 11
        Supplier<LocalTime> horaActual = () -> LocalTime.now();
        LocalTime ahora = horaActual.get();
        System.out.println(ahora);

        //Ejercicio 12
        Supplier<Programador> generarTodo = () -> new Programador("Nombre", 12, null);
        Programador programador1 = generarTodo.get();

        //Ejercicio 13
        Supplier<Programador> generarNombre = () -> new Programador("NombreSolo");
        Programador programador2 = generarNombre.get();

        //Ejercicio 14
        Programador prueba1 = fabricaProgramadores(generarTodo, horaActual);
        Programador prueba2 = fabricaProgramadores(generarNombre, horaActual);
        System.out.println(prueba1);
        System.out.println(prueba2);

    }
    //Ejercicio 9
    public static void calculator(int n1, int n2, BiConsumer operacion){
        operacion.accept(n1,n2);
    }

    //Ejercicio 14
    public static Programador fabricaProgramadores(Supplier<Programador> generar, Supplier<LocalTime> horaActual){
        Programador programadorCreado = generar.get();
        if(programadorCreado.getSalario() == 0 && programadorCreado.fechaInicio == null){
            programadorCreado.setSalario(50000);
            programadorCreado.setFechaInicio(horaActual.get());
        }
        return programadorCreado;
    }
}
