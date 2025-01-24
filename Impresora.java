public class Impresora {
    private int nivelToner;
    private int paginasImpresas;
    private boolean dobleCara; //0 no, 1 si

    public Impresora(int nivelToner, int paginasImpresas, boolean dobleCara) {
        this.nivelToner = nivelToner;
        this.paginasImpresas = paginasImpresas;
        this.dobleCara = dobleCara;
    }

    public int getNivelToner() {
        return nivelToner;
    }

    public int getPaginasImpresas() {
        return paginasImpresas;
    }

    public boolean isDobleCara() {
        return dobleCara;
    }

    public int incrementarToner(int cantidad){
        if(cantidad<0 || cantidad>100){
            return -1;
        }
        else if(cantidad + this.nivelToner > 100){
            return -1;
        }
        else{
            this.nivelToner = cantidad+this.nivelToner;
            return cantidad+this.nivelToner;
        }
    }

    public void imprimirPagina(int imprimir){
        if(this.dobleCara && imprimir%2!=0){
            System.out.println("Se va a imprimir " + ((imprimir/2)+1) + " páginas");
            this.paginasImpresas = this.paginasImpresas+(imprimir/2)+1;

        }
        else if(this.dobleCara && imprimir%2==0){
            System.out.println("Se va a imprimir " + ((imprimir/2)) + " páginas");
            this.paginasImpresas = this.paginasImpresas+(imprimir/2);
        }
        else if(!this.dobleCara){
            System.out.println("Se va a imprimir " + (imprimir) + " páginas");
            this.paginasImpresas = this.paginasImpresas+imprimir;
        }


    }

}
