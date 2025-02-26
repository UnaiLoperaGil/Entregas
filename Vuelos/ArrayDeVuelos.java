package Aviones;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayDeVuelos {

    public static final String textoVerde = "\u001B[32m";
    public static final String textoRojo = "\u001B[31m";
    public static final String resetColor = "\u001B[0m";

    protected ArrayList<Vuelo> vuelos = new ArrayList<>();

    public void imprimirVuelos() {
        if (vuelos.isEmpty()) {
            System.out.println(textoRojo + "ERROR, No hay datos de vuelos" + resetColor);
        } else {
            System.out.println("DATOS DE LOS VUELOS:");
            for (int i = 0; i < vuelos.size(); i++) {
                System.out.println(vuelos.get(i).toString());
            }
        }
    }

    public void buscarNumero(){
        Scanner scan = new Scanner(System.in);
        String buscar;
        System.out.println("BUSCAR VUELO POR Nº: ");
        if(vuelos.isEmpty()){
            System.out.println(textoRojo + "ERROR, No hay datos de vuelos" + resetColor);
        }
        else {
            System.out.print("Número de vuelo: ");
            buscar = scan.nextLine();
            int buscado = encontrarVuelo(buscar);
            if(buscado == -1){
                System.out.println(textoRojo + "ERROR, No se ha encontrado el vuelo" + resetColor);
            }
            else{
                System.out.println("Datos del vuelo: ");
                System.out.println(vuelos.get(buscado).toString());
            }
        }
    }

    public void buscarClave(){
        Scanner scan = new Scanner(System.in);
        System.out.println("BUSCAR VUELO POR CLAVE: ");
        System.out.print("Clave: ");
        String clave = scan.nextLine().toUpperCase();
        if(!Claves.claveValida(clave)){
            System.out.println(textoRojo + "ERROR, Clave inexistente" + resetColor);
        }
        else{
            System.out.print("Valor: ");
            String valor = scan.nextLine();

            boolean encontrado = false;

            System.out.println(" ");
            switch(clave){
                case "NUMERO":
                    for(int i = 0; i<vuelos.size(); i++){
                        if(vuelos.get(i).getNumero().equalsIgnoreCase(valor)){
                            System.out.println("Datos del vuelo: ");
                            System.out.println(vuelos.get(i));
                            System.out.println(" ");
                            encontrado = true;
                        }
                    }
                    break;
                case "ORIGEN":
                    for(int i = 0; i<vuelos.size(); i++){
                        if(vuelos.get(i).getOrigen().equalsIgnoreCase(valor)){
                            System.out.println("Datos del vuelo: ");
                            System.out.println(vuelos.get(i));
                            System.out.println(" ");
                            encontrado = true;
                        }
                    }
                    break;
                case "DESTINO":
                    for(int i = 0; i<vuelos.size(); i++){
                    if(vuelos.get(i).getDestino().equalsIgnoreCase(valor)){
                        System.out.println("Datos del vuelo: ");
                        System.out.println(vuelos.get(i));
                        System.out.println(" ");
                        encontrado = true;
                    }
                }
                    break;
                case "DIA":
                    for(int i = 0; i<vuelos.size(); i++){
                        if(vuelos.get(i).getDia().equalsIgnoreCase(valor)){
                            System.out.println("Datos del vuelo: ");
                            System.out.println(vuelos.get(i));
                            System.out.println(" ");
                            encontrado = true;
                        }
                    }
                    break;
                case "CLASE":
                    for(int i = 0; i<vuelos.size(); i++){
                        if(vuelos.get(i).getClase().equalsIgnoreCase(valor)){
                            System.out.println("Datos del vuelo: ");
                            System.out.println(vuelos.get(i));
                            System.out.println(" ");
                            encontrado = true;
                        }
                    }
                    break;
            }
            if(!encontrado){
                System.out.println(textoRojo + "No existen datos para " + clave.toLowerCase() + " = " + valor + resetColor);
            }
        }
    }

    public void agregarVuelo(){
        Scanner scan = new Scanner(System.in);
        Vuelo agregar = new Vuelo();
        System.out.println("AÑADIR NUEVO VUELO: ");
        System.out.print("Número: ");
        agregar.numero = scan.nextLine();
        System.out.print("Origen: ");
        agregar.origen = scan.nextLine();
        System.out.print("Destino: ");
        agregar.destino = scan.nextLine();
        System.out.print("Día (dd-mm): ");
        agregar.dia = scan.nextLine();
        System.out.print("Clase: ");
        agregar.clase = scan.nextLine();
        vuelos.add(agregar);
        System.out.println(textoVerde + "Vuelo añadido a la lista" + resetColor);
    }

    public void borrarVuelo(){
        Scanner scan = new Scanner (System.in);
        String eliminar;
        System.out.println("BORRAR VUELO: ");
        if (vuelos.isEmpty()) {
            System.out.println(textoRojo + "ERROR, No hay datos de vuelos" + resetColor);
        } else {
            System.out.print("Número de vuelo: ");
            eliminar = scan.nextLine();
            int eliminado = encontrarVuelo(eliminar);
            if(eliminado == -1){
                System.out.println(textoRojo + "ERROR, No se ha encontrado el vuelo" + resetColor);
            }
            else{
                System.out.println(textoVerde + "Vuelo nº " + eliminar + " eliminado" + resetColor);
                vuelos.remove(eliminado);
            }
        }
    }

    public int encontrarVuelo(String numero){
        for(int i = 0; i<vuelos.size(); i++){
            if(vuelos.get(i).getNumero().equalsIgnoreCase(numero)){
                return i;
            }
        }
        return -1;
    }
}
