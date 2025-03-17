import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Paradas parada1 = new Paradas(1, "Centre-Doctor Caro", "Doctor Caro");
        Paradas parada2 = new Paradas(2, "Vicente Blasco Ibáñez", "Vicente Blasco Ibáñez, 22");
        Paradas parada3 = new Paradas(3, "Vicente Blasco Ibáñez", "Vicente Blasco Ibáñez, 80");
        Paradas parada4 = new Paradas(4, "Inem Carrús", "Inem Carrús");
        Paradas parada5 = new Paradas(5, "Pedro Moreno Sastre", "Pedro Moreno Sastre, 62");
        Paradas parada6 = new Paradas(6, "Pedro Moreno Sastre", "Pedro Moreno Sastre, 80");
        Paradas parada7 = new Paradas(7, "Pedro Moreno Sastre", "Pedro Moreno Sastre, 102");
        Paradas parada71 = new Paradas(71, "Jorge Juan-Reina Victoria", "Jorge Juan - Reina Victoria");
        Paradas parada335 = new Paradas(335, "Gabriel Miró", "Gabriel Miró");
        Paradas parada346 = new Paradas(346, "Passeig de Germanles", "Passeig de Germanles");
        Paradas parada347 = new Paradas(347, "Federico G. Lorca - Asilo", "Federico G. Lorca - Asilo");
        Paradas parada115 = new Paradas(115, "Centre-Avg. C. Valenciana", "Centre-Avg.C Valencia");
        Paradas parada89 = new Paradas(89, "Avinguda Llibertat", "Avinguda Llibertat, 11");
        Paradas parada90 = new Paradas(90, "Renfe-Parc Municipal", "Renfe-Parc Municipal");
        Paradas parada117 = new Paradas(117, "Virgen de la Cabeza - Ll. del Pensionista", "Virgen de la Cabeza - Ll. del Pensionista");
        Paradas parada56 = new Paradas(56, "Cristóbal Sanz", "Cristobal Sanz");

        ArrayList<Paradas> paradas = new ArrayList<>();
        paradas.add(parada1);
        paradas.add(parada2);
        paradas.add(parada3);
        paradas.add(parada4);
        paradas.add(parada5);
        paradas.add(parada6);
        paradas.add(parada7);
        paradas.add(parada71);
        paradas.add(parada335);
        paradas.add(parada346);
        paradas.add(parada347);
        paradas.add(parada115);
        paradas.add(parada89);
        paradas.add(parada90);
        paradas.add(parada117);
        paradas.add(parada56);

        Lineas lineaA = new Lineas("A");
        lineaA.getParadas().put(parada1, 75);
        lineaA.getParadas().put(parada2, 60);
        lineaA.getParadas().put(parada3, 40);
        lineaA.getParadas().put(parada4, 50);
        lineaA.getParadas().put(parada5, 80);

        Lineas lineaI = new Lineas("I");
        lineaI.getParadas().put(parada3, 50);
        lineaI.getParadas().put(parada71, 100);
        lineaI.getParadas().put(parada335, 70);
        lineaI.getParadas().put(parada346, 50);
        lineaI.getParadas().put(parada347, 120);

        Lineas lineaJ = new Lineas("J");
        lineaJ.getParadas().put(parada115, 125);
        lineaJ.getParadas().put(parada2, 75);
        lineaJ.getParadas().put(parada89, 40);
        lineaJ.getParadas().put(parada90, 80);
        lineaJ.getParadas().put(parada117, 40);

        Lineas lineaF = new Lineas("F");
        lineaF.getParadas().put(parada115, 125);
        lineaF.getParadas().put(parada2, 45);
        lineaF.getParadas().put(parada56, 40);
        lineaF.getParadas().put(parada89, 75);
        lineaF.getParadas().put(parada90, 70);

        ArrayList<Lineas> lineas = new ArrayList<>();
        lineas.add(lineaA);
        lineas.add(lineaJ);
        lineas.add(lineaF);
        lineas.add(lineaI);

        int inicial;
        String linea;
        int ultima;
        boolean encontrada = false;
        do {
            System.out.print("Elige parada inicial: ");
            inicial = scan.nextInt();
            encontrada = encontrarParada(inicial, paradas);
            if (!encontrada) {
                System.out.println("Numero de parada no válido");
            } else {
                System.out.println("Has elegido " + queryParada(inicial, paradas).getNombre());
            }
        }while(!encontrada);
        encontrada = false;
        do{
            System.out.print("Linea de bus: ");
            linea = scan.next().toUpperCase();
            encontrada = encontrarLinea(linea, lineas);
            if(!encontrada){
                System.out.println("Linea no válida");
            }
        }while(!encontrada);
        do{
            System.out.print("Parada final: ");
            ultima = scan.nextInt();
            encontrada = encontrarParada(ultima, paradas);
            if(!encontrada){
                System.out.println("Parada no válida");
            } else{
                System.out.println("Has elegido " + queryParada(ultima, paradas).getNombre());
            }
        }while(!encontrada);
    }

    public static boolean encontrarParada(int numero, ArrayList<Paradas> paradas){
        for(Paradas parada : paradas){
            if(parada.getNumero() == numero){
                return true;
            }
        }
        return false;
    }

    public static boolean encontrarLinea(String lineaI, ArrayList<Lineas> lineas){
        for(Lineas linea : lineas){
            if(linea.getId().equalsIgnoreCase(lineaI)){
                return true;
            }
        }
        return false;
    }

    public static Paradas queryParada(int numero, ArrayList<Paradas> paradas){
        for(Paradas parada : paradas){
            if(parada.getNumero() == numero){
                return parada;
            }
        }
        return null;
    }
}
