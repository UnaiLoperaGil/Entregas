import java.util.InputMismatchException;
import java.util.Scanner;

public class Asesino extends Heroe{
    protected int sigilo;

    public Asesino(String tipo) {
        super(tipo);
        Scanner scan = new Scanner(System.in);
        boolean numerico = false;
        do{
            try{
                System.out.print("Sigilo: ");
                this.sigilo = scan.nextInt();
                if(this.sigilo<=0){
                    System.out.println(textoRojo + "ERROR, el sigilo debe ser mayor que 0" + resetColor);
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

    public void asesinar(){
        System.out.println("El asesino " + this.nombre + " ha asesinado desde las sombras con éxito");
    }

    @Override
    public String getClase(){
        return "Asesino";
    }

    @Override
    public int getAtributo() {
        System.out.print("    Sigilo: ");
        return sigilo;
    }

    public void setSigilo(int sigilo) {
        this.sigilo = sigilo;
    }
}
