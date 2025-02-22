import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ArrayDeHeroes {
    public static final String textoVerde = "\u001B[32m";
    public static final String textoRojo = "\u001B[31m";
    public static final String resetColor = "\u001B[0m";

    protected ArrayList<Heroe> heroes = new ArrayList<>();
    protected ArrayList<Arma> armasG = new ArrayList<>();
    protected ArrayList<Arma> armasM = new ArrayList<>();
    protected ArrayList<Arma> armasAr = new ArrayList<>();
    protected ArrayList<Arma> armasAs = new ArrayList<>();

    public void agregarHeroe(){
        Scanner scan = new Scanner(System.in);
        boolean valido;
        int clase = 0;
        boolean error;
        do {
            error = false;
            try {
                System.out.println("¿Qué tipo de héroe deseas añadir?");
                System.out.println("1: Guerrero/a");
                System.out.println("2: Mago/a");
                System.out.println("3: Arquero/a");
                System.out.println("4: Asesino/a");
                System.out.print("Elige una subopción: ");
                clase = scan.nextInt();
                valido = true;
            }catch(InputMismatchException noNumero){
                System.out.println(textoRojo + "Introduce una opción numérica" + resetColor);
                error = true;
                valido = false;
                scan.nextLine();
            }


            switch(clase){
                case 1:
                    Guerrero guerrero = new Guerrero("Guerrero/a");
                    if(buscarHeroe(guerrero.getNombre()) != -1) {
                        System.out.println(textoRojo + "ERROR, el héroe ya existe" + resetColor);
                    }
                    else{
                        seleccionarArma(guerrero.nombre, guerrero, armasG);
                        heroes.add(guerrero);
                    }
                    break;
                case 2:
                    Mago mago = new Mago("Mago/a");
                    if(buscarHeroe(mago.getNombre()) != -1){
                        System.out.println(textoRojo + "ERROR, el héroe ya existe" + resetColor);
                    }
                    else {
                        seleccionarArma(mago.nombre, mago, armasM);
                        heroes.add(mago);
                    }
                    break;
                case 3:
                    Arquero arquero = new Arquero("Arquero/a");
                    if(buscarHeroe(arquero.getNombre()) != -1){
                        System.out.println(textoRojo + "ERROR, el héroe ya existe" + resetColor);
                    }
                    else {
                        seleccionarArma(arquero.nombre, arquero, armasAr);
                        heroes.add(arquero);
                    }
                    break;
                case 4:
                    Asesino asesino = new Asesino("Asesino/a");
                    if(buscarHeroe(asesino.getNombre()) != -1){
                        System.out.println(textoRojo + "ERROR, el héroe ya existe" + resetColor);
                    }
                    else {
                        seleccionarArma(asesino.nombre, asesino, armasAs);
                        heroes.add(asesino);
                    }
                    break;
                default:
                    if(!error) {
                        System.out.println(textoRojo + "ERROR, el tipo de héroe no existe" + resetColor);
                    }
                    valido = false;
                    break;
            }
        }while(!valido);
    }

    public void agregarArma() {
        Scanner scan = new Scanner(System.in);
        boolean valido;
        int clase = 0;
        do {
            try {
                System.out.println("¿Para qué clase quieres añadir un arma?");
                System.out.println("1: Guerrero/a");
                System.out.println("2: Mago/a");
                System.out.println("3: Arquero/a");
                System.out.println("4: Asesino/a");
                System.out.print("Elige una subopción: ");
                clase = scan.nextInt();
                valido = true;
            } catch (InputMismatchException noNumero) {
                System.out.println(textoRojo + "Introduce una opción numérica" + resetColor);
                clase = 0;
                valido = false;
                scan.nextLine();
            }
            switch(clase){
                case 0:
                    break;
                case 1:
                    Arma armaG = new Arma();
                    armasG.add(armaG);
                    break;
                case 2:
                    Arma armaM = new Arma();
                    armasM.add(armaM);
                    break;
                case 3:
                    Arma armaAr = new Arma();
                    armasAr.add(armaAr);
                    break;
                case 4:
                    Arma armaAs = new Arma();
                    armasAs.add(armaAs);
                    break;
                default:
                    System.out.println(textoRojo + "Opción no válida" + resetColor);
                    break;
            }
        }while(!valido);
    }

    public void seleccionarArma(String nombre, Heroe heroe, ArrayList<Arma> armas){
        Scanner scan = new Scanner (System.in);
        boolean numerico = false;
        boolean masArmas = false;
        int opcion = 0;
        int seleccion = 0;
        do {
            do {
                try {
                    System.out.println("Selecciona un arma para " + nombre + " :");
                    for (int i = 0; i < armas.size(); i++) {
                        System.out.println((i + 1) + ". " + armas.get(i).nombreArma + " (Daño: " + armas.get(i).danyo + ")");
                    }
                    System.out.println("Elige una subopción: ");
                    opcion = scan.nextInt();
                    if (opcion < 1 || opcion > armas.size()) {
                        System.out.println(textoRojo + "ERROR, la elección no es válida" + resetColor);
                    } else {
                        numerico = true;
                    }
                } catch (InputMismatchException noNumerico) {
                    System.out.println(textoRojo + "Introduce una opción numérica" + resetColor);
                    scan.nextLine();
                }
            } while (!numerico);
            numerico = false;
            Arma elegida = armas.get(opcion - 1);
            heroe.setArmaEspecial(elegida);
            seleccion = 0;
            do {
                try {
                    System.out.println("¿Deseas darle otra arma al héroe?");
                    System.out.println("1. Si");
                    System.out.println("2. No");
                    System.out.println("Introduce una opción: ");
                    seleccion = scan.nextInt();
                    if(seleccion<1 || seleccion>2){
                        System.out.println(textoRojo + "ERROR, elección no válida" + resetColor);
                    }
                    else {
                        numerico = true;
                    }
                }catch(InputMismatchException noNumerico){
                    System.out.println(textoRojo + "Introduce una opción numérica" + resetColor);
                    scan.nextLine();
                }
            }while(!numerico);
            if(seleccion == 1){
                masArmas = true;
            }
            else{
                masArmas = false;
            }
        }while(masArmas);
    }

    public void eliminarHeroe(){
        Scanner scan = new Scanner (System.in);
        String eliminar;
        System.out.println("Introduce el nombre del héroe que quieres echar del gremio: ");
        eliminar = scan.nextLine();
        if(buscarHeroe(eliminar) == -1){
            System.out.println(textoRojo + "ERROR, héroe no encontrado" + resetColor);
        }
        else{
            heroes.remove(buscarHeroe(eliminar));
            System.out.println(textoVerde + "Se ha echado al héroe correctamente" + resetColor);
        }
    }

    private int buscarHeroe(Heroe heroe){
        for (int i = 0; i < this.heroes.size(); i++){
            if(this.heroes.get(i).equals(heroe)){
                return i;
            }
        }
        return -1;
    }

    private int buscarHeroe(String nombre){
        for(int i = 0; i<heroes.size(); i++){
            if(heroes.get(i).getNombre().equalsIgnoreCase(nombre)){
                return i;
            }
        }
        return -1;
    }

    public void consultarHeroe(){
        Scanner scan = new Scanner(System.in);
        String nombre;
        System.out.print("Introduce el nombre del héroe del cuál quieres consultar sus estadísticas: ");
        nombre = scan.nextLine();
        if(buscarHeroe(nombre) == -1){
            System.out.println(textoRojo + "ERROR, héroe no encontrado" + resetColor);
        }
        else{
            System.out.println(" ");
            System.out.println(textoVerde + "Héroe encontrado, sus datos son: " + resetColor);
            System.out.println("Nombre: " + heroes.get(buscarHeroe(nombre)).getNombre());
            System.out.println("Clase: " + heroes.get(buscarHeroe(nombre)).getClase());
            System.out.println("Nivel: " + heroes.get(buscarHeroe(nombre)).getNivel());
            System.out.println("Puntos de vida: " + heroes.get(buscarHeroe(nombre)).getPuntosVida());
            heroes.get(buscarHeroe(nombre)).getArmaEspecial();
            System.out.println(" ");
        }
    }

    public void listarHeroes(){
        if (this.heroes.isEmpty()){
            System.out.println(textoRojo + "ERROR, no hay héroes en el gremio" + resetColor);
        }
        else {
            System.out.println("+------------------------------------------+");
            System.out.println("|       Listado de heroes del gremio       |");
            System.out.println("+------------------------------------------+");
            for (int i = 0; i < this.heroes.size(); i++) {
                System.out.println((i + 1) + ".  Nombre: " + this.heroes.get(i).getNombre());
                System.out.println("    Clase: " + this.heroes.get(i).getClase());
                System.out.println("    Nivel: " + this.heroes.get(i).getNivel());
                System.out.println("    Puntos de vida: " + this.heroes.get(i).getPuntosVida());
                System.out.println(this.heroes.get(i).getAtributo());
                heroes.get(i).getArmaEspecial();
                System.out.println("--------------------------------------------");
            }
        }
    }
}
