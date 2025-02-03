package Ejercicio7;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        estudiantes.add(new Estudiante("Patri",12,170));
        estudiantes.add(new Estudiante("Manuel",43,173));
        estudiantes.add(new Estudiante("Javier",72,189));
        estudiantes.add(new Estudiante("Alicia",52,168));
        estudiantes.add(new Estudiante("Alberto", 35, 189));

        imprimirArray(estudiantes);
        System.out.println(" ");
        Collections.sort(estudiantes);
        imprimirArray(estudiantes);


    }

    public static void imprimirArray(ArrayList<Estudiante> estudiantes){
        for(Estudiante estudiante:estudiantes){
            System.out.println(estudiante.toString());
        }
    }


}
