package Actividad3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Ubicacion> ubicaciones = new HashMap<>();

    public static void main(String[] args) {

        Ubicacion clase = new Ubicacion(0,"Estás sentado en la clase de programación");
        Ubicacion montana = new Ubicacion(1,"Estás en la cima de una montaña");
        Ubicacion playa = new Ubicacion(2,"Estás bañándote en la playa");
        Ubicacion edificio = new Ubicacion(3,"Estás dentro de un edificio muy alto");
        Ubicacion puente = new Ubicacion(4, "Estás de pie en un puente");
        Ubicacion bosque = new Ubicacion(5, "Estás en un bosque");

        ubicaciones.put(0, clase);
        ubicaciones.put(1, montana);
        ubicaciones.put(2, playa);
        ubicaciones.put(3, edificio);
        ubicaciones.put(4, puente);
        ubicaciones.put(5, bosque);

        ubicaciones.get(1).addExit("N", 5);
        ubicaciones.get(1).addExit("O", 2);
        ubicaciones.get(1).addExit("S", 4);
        ubicaciones.get(1).addExit("E", 3);

        ubicaciones.get(2).addExit("N", 5);

        ubicaciones.get(3).addExit("O", 1);

        ubicaciones.get(4).addExit("N", 1);
        ubicaciones.get(4).addExit("O", 2);

        ubicaciones.get(5).addExit("S", 1);
        ubicaciones.get(5).addExit("O", 2);

        int actual = 1;
        boolean pressedQ = false;
        String direccion;
        do{
            System.out.println(" ");
            System.out.println(ubicaciones.get(actual).getDescripcion());
            showExits(ubicaciones.get(actual));
            direccion = askDirection(ubicaciones.get(actual));
            if(direccion.equalsIgnoreCase("q")){
                System.out.println(" ");
                System.out.println(ubicaciones.get(0).getDescripcion());
                pressedQ = true;
            }
            else{
                actual = ubicaciones.get(actual).getExits().get(direccion);

            }
        }while(!pressedQ);
    }

    public static void showExits(Ubicacion ubicacion){
        System.out.print("Tus salidas válidas son ");
        for(String key : ubicacion.exits.keySet()){
            System.out.print(key + " ");
        }
    }

    public static String askDirection(Ubicacion ubicacion){
        Scanner scan = new Scanner(System.in);
        String direccion;
        boolean valido = false;
        do {
            System.out.println(" ");
            System.out.print("Introduce una salida válida: ");
            direccion = scan.nextLine().toUpperCase();
            if(direccion.length()!=1){
                System.out.println("Longitud incorrecta");
            }
            else if(!compareDirection(direccion,ubicacion)){
                System.out.println("No puede ir en esa dirección");
            }
            else{
                valido = true;
            }
        }while(!valido);
        return direccion;
    }

    public static boolean compareDirection(String direccion, Ubicacion ubicacion){
        for(String key : ubicacion.exits.keySet()){
            if(direccion.equalsIgnoreCase(key)){
                return true;
            }
        }
        return false;
    }
}
