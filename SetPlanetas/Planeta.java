public class Planeta extends CuerpoCeleste {
    public Planeta(String nombre, double periodoOrbital) {
        super(nombre, periodoOrbital, TipoCuerpoCeleste.PLANETA);
    }

    @Override
    public boolean addSatelite(CuerpoCeleste cuerpo) {
        if (cuerpo.getTipoCuerpo().equals(TipoCuerpoCeleste.LUNA)) {
            return super.addSatelite(cuerpo);
        }
        else{
            return false;
        }
    }
}
