import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class CuerpoCeleste {
    protected enum TipoCuerpoCeleste {
        ESTRELLA, PLANETA, PLANETA_ENANO, LUNA, COMETA, ASTEROIDE
    }
    private String nombre;
    private double periodoOrbital;
    private Set<CuerpoCeleste> satelites;
    private TipoCuerpoCeleste tipoCuerpo;

    public CuerpoCeleste(String nombre, double periodoOrbital, TipoCuerpoCeleste tipoCuerpo) {
        this.nombre = nombre;
        this.periodoOrbital = periodoOrbital;
        this.tipoCuerpo = tipoCuerpo;
        this.satelites = new HashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public double getPeriodoOrbital() {
        return periodoOrbital;
    }

    public TipoCuerpoCeleste getTipoCuerpo() {
        return tipoCuerpo;
    }

    public Set<CuerpoCeleste> getSatelites() {
        return satelites;
    }

    public boolean addSatelite (CuerpoCeleste cuerpo){
        return this.satelites.add(cuerpo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CuerpoCeleste that = (CuerpoCeleste) o;
        return Double.compare(periodoOrbital, that.periodoOrbital) == 0 && Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, periodoOrbital, satelites, tipoCuerpo);
    }

    @Override
    public String toString() {
        return this.nombre + ", " + this.tipoCuerpo + ", " + this.periodoOrbital;
    }

    public void showSatelites(){
        System.out.println("Satélites: ");
        for (CuerpoCeleste satelite : this.satelites){
            System.out.println(satelite);
        }
    }
}
