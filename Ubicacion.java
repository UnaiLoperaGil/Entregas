package Actividad3;

import java.util.HashMap;
import java.util.Map;

public class Ubicacion {
    protected int id;
    protected String descripcion;
    protected Map<String, Integer> exits;

    public Ubicacion(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
        this.exits = new HashMap<>();
        this.exits.put("Q", 0);
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Map<String, Integer> getExits() {
        return exits;
    }

    public void addExit(String direccion, int idUbicacion){
        exits.put(direccion, idUbicacion);
    }
}
