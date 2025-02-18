package Tarea2;

public class Cancion implements Comparable<Cancion>{
    String titulo;
    double duracion;

    public Cancion(String titulo, double duracion) {
        this.titulo = titulo;
        this.duracion = duracion;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString() {
        return titulo + " con duracion " + duracion;
    }

    @Override
    public int compareTo(Cancion o) {
        return this.titulo.compareToIgnoreCase(o.titulo);
    }
}
