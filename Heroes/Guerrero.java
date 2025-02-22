import java.util.InputMismatchException;
import java.util.Scanner;

public class Guerrero extends Heroe{
    protected int fuerza;

    public Guerrero(String tipo) {
        super(tipo);
        Scanner scan = new Scanner(System.in);
        boolean numerico = false;
        do{
            try{
                System.out.print("Fuerza: ");
                this.fuerza = scan.nextInt();
                if(this.fuerza <= 0){
                    System.out.println(textoRojo + "ERROR, la fuerza debe tener un valor mayor que 0" + resetColor);
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

    public void atacar(){
        System.out.println("El guerrero " + this.nombre + " ha atacado con éxito");
    }

    @Override
    public String getClase(){
        return "Guerrero";
    }

    @Override
    public int getAtributo() {
        System.out.print("    Fuerza: ");
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }
}
