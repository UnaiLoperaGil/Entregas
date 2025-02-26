package Aviones;

import java.util.Scanner;

public class Main {

    public static final String textoVerde = "\u001B[32m";
    public static final String textoRojo = "\u001B[31m";
    public static final String resetColor = "\u001B[0m";

    public static void main(String[] args) {
        ArrayDeVuelos vuelos = new ArrayDeVuelos();
        Vuelo vuelo1 = new Vuelo("2023-01", "Valencia", "Menorca", "15-08", "Turista");
        Vuelo vuelo2 = new Vuelo("2023-02", "Valencia", "Tenerife", "20-08", "Turista");
        Vuelo vuelo3 = new Vuelo("2023-03", "París", "Valencia", "15-08", "Primera");
        Vuelo vuelo4 = new Vuelo("2023-04", "Atenas", "Valencia", "20-08", "Primera");
        vuelos.vuelos.add(vuelo1);
        vuelos.vuelos.add(vuelo2);
        vuelos.vuelos.add(vuelo3);
        vuelos.vuelos.add(vuelo4);

        Scanner scan = new Scanner(System.in);
        boolean continuar = true;
        boolean valido = false;
        int opcion;
        do{
            do{
                System.out.println(" ");
                menu();
                opcion = Validacion.pedirInt();
                if(opcion!=-1){
                    valido = true;
                }
            }while(!valido);

            System.out.println(" ");
            switch(opcion){
                case 1:
                    vuelos.imprimirVuelos();
                    break;
                case 2:
                    vuelos.buscarNumero();
                    break;
                case 3:
                    vuelos.buscarClave();
                    break;
                case 4:
                    vuelos.agregarVuelo();
                    break;
                case 5:
                    vuelos.borrarVuelo();
                    break;
                case 0:
                    System.out.println(textoVerde + "Saliendo del programa..." + resetColor);
                    continuar = false;
                    break;
                case -1:
                    break;
                default:
                    System.out.println("Opción introducida no válida");
                    break;
            }

        }while(continuar);
    }


    public static void menu(){
        System.out.println("=======================================");
        System.out.println("   VUELOS DEL AEROPUERTO DE VALENCIA   ");
        System.out.println("=======================================");
        System.out.println("1 - Imprimir todos los vuelos");
        System.out.println("2 - Buscar un número de vuelo");
        System.out.println("3 - Buscar vuelo por clave");
        System.out.println("4 - Añadir vuelo nuevo");
        System.out.println("5 - Borrar vuelo por número");
        System.out.println("0 - SALIR");
        System.out.println("----------------------------------------");
        System.out.print("Dame la opción: ");
    }
}
