package Aviones;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Validacion {

    public static final String textoVerde = "\u001B[32m";
    public static final String textoRojo = "\u001B[31m";
    public static final String resetColor = "\u001B[0m";

    public static int pedirInt(){
        int devolver;
        Scanner scan = new Scanner(System.in);
        try{
            devolver = scan.nextInt();
            return devolver;
        }catch(InputMismatchException noNumerico){
            System.out.println(textoRojo + "Introduce un valor númerico" + resetColor);
            return -1;
        }
    }
}
