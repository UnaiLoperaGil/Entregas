import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static final String textoVerde = "\u001B[32m";
    public static final String textoRojo = "\u001B[31m";
    public static final String resetColor = "\u001B[0m";

    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        ArrayDeHeroes heroes = new ArrayDeHeroes();
        //Se crean las armas por defecto para cada clase
        Arma armaGuerrero = new Arma("Espada Básica", 15);
        Arma armaMago = new Arma("Cetro Principiante", 5);
        Arma armaArquero = new Arma("Arco de Madera", 10);
        Arma armaAsesino = new Arma("Daga Corta", 15);
        heroes.armasG.add(armaGuerrero);
        heroes.armasM.add(armaMago);
        heroes.armasAr.add(armaArquero);
        heroes.armasAs.add(armaAsesino);
        boolean continuar = true;
        boolean numerico = false;
        int opcion = 0;

        do{
            do {
                imprimirMenu();
                try {
                    System.out.print("Seleccione una opción: ");
                    opcion = scan.nextInt();
                    numerico = true;
                } catch (InputMismatchException noNumerico) {
                    System.out.println(textoRojo + "Introduce un valor numérico" + resetColor);
                    scan.nextLine();
                }
            }while(!numerico);

            switch(opcion){
                case 1:
                    heroes.agregarHeroe();
                    break;
                case 2:
                    heroes.agregarArma();
                    break;
                case 3:
                    heroes.eliminarHeroe();
                    break;
                case 4:
                    heroes.consultarHeroe();
                    break;
                case 5:
                    heroes.listarHeroes();
                    break;
                case 0:
                    System.out.println(textoVerde + "Saliendo del programa..." + resetColor);
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no considerada");
            }
        }while(continuar);

    }

    public static void imprimirMenu(){
        System.out.println("+--------------------------------+");
        System.out.println("|         Menú Principal         |");
        System.out.println("+--------------------------------+");
        System.out.println("|     1 - Añadir nuevo Héroe     |");
        System.out.println("|     2 - Añadir nueva Arma      |");
        System.out.println("|     3 - Eliminar Héroe         |");
        System.out.println("|     4 - Consultar Héroe        |");
        System.out.println("|     5 - Listar Héroes          |");
        System.out.println("|     0 - Salir del programa     |");
        System.out.println("+--------------------------------+");
    }
}