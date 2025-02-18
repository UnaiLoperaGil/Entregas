package Tarea2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class Album {
    String nombre;
    String artista;
    ArrayList<Cancion> canciones = new ArrayList<>();

    public Album(String nombre, String artista) {
        this.nombre = nombre;
        this.artista = artista;
    }

    private Cancion findSong(String titulo) {
        for(int i=0; i<canciones.size(); i++){
            if(canciones.get(i).getTitulo().equalsIgnoreCase(titulo)) {
                return canciones.get(i);
            }
        }
        return null;
    }

    public boolean addSong(String titulo, double duracion){
        if(findSong(titulo) == null){
            Cancion agregar = new Cancion(titulo,duracion);
            canciones.add(agregar);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean addToPlayList(int numeroPista, LinkedList<Cancion> listaReproduccion){
        for(int i=0; i<canciones.size(); i++){
            if(i == numeroPista - 1){
                listaReproduccion.add(findSong(canciones.get(i).getTitulo()));
                return true;
            }
        }
        return false;
    }

    public boolean addToPlayList(String titulo, LinkedList<Cancion> listaReproduccion){
        if(findSong(titulo) != null){
            listaReproduccion.add(findSong(titulo));
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean addInOrder(LinkedList<Cancion> lista, Cancion cancion){
        ListIterator<Cancion> it = lista.listIterator();

        while(it.hasNext()){
            int comparacion = it.next().compareTo(cancion);
            if(comparacion == 0){
                System.out.println("La canción " + cancion + " ya está en la lista");
                return false;
            }
            else if(comparacion > 0){
                it.previous();
                it.add(cancion);
                return true;
            }
        }
        it.add(cancion);
        return true;
    }
}
