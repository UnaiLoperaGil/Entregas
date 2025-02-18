package Tarea2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Album> albumes = new ArrayList<>();
        Album album1 = new Album("Nombre1", "Artista1");
        Album album2 = new Album("Nombre2", "Artista2");

        LinkedList<Cancion> lista1 = new LinkedList<>();

        album1.addSong("Titulo1", 3.42);
        album1.addSong("Titulo2", 2.37);
        album2.addSong("Titulo3", 3.12);
        album2.addSong("Titulo4", 3.31);

        albumes.add(album1);
        albumes.add(album2);

        album1.addInOrder(lista1, album1.canciones.get(1));
        album2.addInOrder(lista1, album2.canciones.get(0));
        album1.addInOrder(lista1, album1.canciones.get(0));
        album2.addInOrder(lista1, album2.canciones.get(1));


        printLista(lista1);

        playList(lista1, albumes);
    }

    public static void printLista(LinkedList<Cancion> lista){
        ListIterator<Cancion> it = lista.listIterator();
        int i = 1;
        while(it.hasNext()){
            System.out.println(i + ". " + it.next());
            i++;
        }
    }

    public static void playList(LinkedList<Cancion> lista, ArrayList<Album> albumes){
        Scanner scan = new Scanner(System.in);
        boolean continuar = true;
        ListIterator<Cancion> it = lista.listIterator();

        if(lista.isEmpty()){
            System.out.println("La lista de reproducción está vacía");
            continuar = false;
        }
        else{
            System.out.println("Reproduciendo " + it.next());
        }

        boolean haciaAdelante = true;
        boolean valido;
        while(continuar){
            System.out.println(" ");
            menu();
            int opcion = 0;
            do {
                try {
                    System.out.println("Introduce la opción: ");
                    opcion = scan.nextInt();
                    valido = true;
                }catch(InputMismatchException noNumerico){
                    System.err.println("El valor introducido no es numérico");
                    scan.nextLine();
                    valido = false;
                }
            }while(!valido);

            switch(opcion){
                case 0:
                    System.out.println("Saliendo de la lista de reproducción");
                    continuar = false;
                    break;
                case 1:
                    if(!haciaAdelante){
                        if(it.hasNext()){
                            it.next();
                        }
                        haciaAdelante = true;
                    }
                    if(it.hasNext()){
                        System.out.println("Reproduciendo " + it.next());
                    }
                    else{
                        System.out.println("Es la última canción");
                    }
                    break;
                case 2:
                    if(haciaAdelante){
                        if (it.hasPrevious()){
                            it.previous();
                        }
                        haciaAdelante = false;
                    }
                    if(it.hasPrevious()){
                        System.out.println("Reproduciendo " + it.previous());
                    }
                    else{
                        System.out.println("Es la primera canción");
                    }
                    break;
                case 3:
                    if (!haciaAdelante) {
                        if (it.hasNext()) {
                            System.out.println("Reproduciendo " + it.next());
                            it.previous();
                        }
                        else{
                            System.out.println("Reproduciendo " + it.previous());
                        }
                    }
                    else {
                        if (it.hasPrevious()) {
                            System.out.println("Reproduciendo " + it.previous());
                            it.next();
                        }
                        else{
                            System.out.println("Reproduciendo " + it.next());
                        }
                    }
                    break;
                case 4:
                    System.out.println("Las canciones que están en la lista de reproducción son: ");
                    printLista(lista);
                    break;
                case 5:
                    try {
                        if (!lista.isEmpty()) {
                            it.remove();
                            System.out.println("Se ha eliminado la canción de la lista correctamente");
                            if (it.hasNext()) {
                                System.out.println("Reproduciendo " + it.next());
                            } else {
                                System.out.println("Reproduciendo " + it.previous());
                                haciaAdelante = false;
                            }
                        }
                    }catch(NoSuchElementException noCanciones){
                        System.err.println("Se ha eliminado la última canción de la lista");
                    }
                    if(lista.isEmpty()){
                        System.out.println("La lista de canciones está vacía");
                    }
                    break;
                case 6:
                    int numeroAlbumes = imprimirAlbumes(albumes);
                    int opcionAlbum = 0;
                    do {
                        try {
                            System.out.println("Selecciona el album del que quieres ver las canciones");
                            opcionAlbum = scan.nextInt();
                            if(opcionAlbum>numeroAlbumes || opcionAlbum<=0){
                                System.err.println("Album introducido no válido");
                            }
                        } catch (InputMismatchException noNumero) {
                            System.err.println("Valor introducido no numérico");
                        }
                    }while(opcionAlbum>numeroAlbumes || opcionAlbum<=0);
                    imprimirCancionesAlbum(albumes.get(opcionAlbum-1));
                    break;
                default:
                    System.err.println("Opción no válida");

            }

        }
    }

    public static void menu(){
        System.out.println(
                "0 – Salir de la lista de reproducción\n" +
                "1 – Reproducir siguiente canción en la lista\n" +
                "2 – Reproducir la canción previa de la lista\n" +
                "3 – Repetir la canción actual\n" +
                "4 – Imprimir la lista de canciones en la playlist\n" +
                "5 - Eliminar la canción actual\n" +
                "6 - Imprimir canciones por albúm");
    }

    public static int imprimirAlbumes(ArrayList<Album> albumes){
        System.out.println("Los albumes disponibles son: ");
        int contador = 0;
        for(int i = 0; i<albumes.size(); i++){
            System.out.println((i+1) + ". " + albumes.get(i).nombre);
            contador++;
        }
        return contador;
    }

    public static void imprimirCancionesAlbum(Album album){
        for(int i=0; i<album.canciones.size(); i++){
            System.out.println((i+1) + ". " + album.canciones.get(i).getTitulo());
        }
    }
}
