import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Lineas {
    protected String id; //Tiene que ser alfanumérico de tanaño máximo 3
    protected LinkedHashMap<Paradas, Integer> paradas; //El integer será el tiempo de la parada

    public Lineas(String id) {
        this.id = id;
        this.paradas = new LinkedHashMap();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<Paradas, Integer> getParadas() {
        return paradas;
    }

    public void setParadas(LinkedHashMap<Paradas, Integer> paradas) {
        this.paradas = paradas;
    }
}
