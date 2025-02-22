import java.util.InputMismatchException;
import java.util.Scanner;

public class Arquero extends Heroe{
    protected int precision;

    public Arquero(String tipo) {
        super(tipo);
        Scanner scan = new Scanner(System.in);
        boolean numerico = false;
        do{
            try{
                System.out.print("Precision: ");
                this.precision = scan.nextInt();
                if(this.precision<=0){
                    System.out.println(textoRojo + "ERROR, la precision debe tener un valor mayor que 0" + resetColor);
                }
                else{
                    numerico = true;
                }
            }catch(InputMismatchException noNumerico){
                System.out.println(textoRojo + "Introduce una opción numérica" + resetColor);
                scan.nextLine();
            }
        }while(!numerico);
    }

    public void disparar(){
        System.out.println("El arquero " + this.nombre + " ha disparado una flecha con éxito");
    }

    @Override
    public String getClase(){
        return "Arquero";
    }

    @Override
    public int getAtributo() {
        System.out.print("    Precision: ");
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }
}
