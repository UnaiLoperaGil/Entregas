import java.util.InputMismatchException;
import java.util.Scanner;

public class Arma {
    public static final String textoVerde = "\u001B[32m";
    public static final String textoRojo = "\u001B[31m";
    public static final String resetColor = "\u001B[0m";

    protected String nombreArma;
    protected int danyo;

    public Arma(String nombreArma, int danyo) {
        this.nombreArma = nombreArma;
        this.danyo = danyo;
    }

    public Arma() {
        Scanner scan = new Scanner(System.in);
        boolean numerico = false;
        do {
            System.out.print("Introduce el nombre del arma que quieres crear: ");
            this.nombreArma = scan.nextLine();
            if(this.nombreArma.isEmpty()){
                System.out.println(textoRojo + "ERROR, el nombre está vacío" + resetColor);
            }
        }while(this.nombreArma.isEmpty());
        do {
            try {
                System.out.print("Introduce el daño que inflige el arma: ");
                this.danyo = scan.nextInt();
                if(this.danyo<=0){
                    System.out.println(textoRojo + "ERROR, el daño debe ser mayor que 0" + resetColor);
                }
                else{
                    numerico = true;
                }
            }catch(InputMismatchException noNumerico){
                System.out.println(textoRojo + "Introduce una opción numérica" + resetColor);
                scan.nextLine();
            }
        }while(!numerico);
        System.out.println(textoVerde + "Arma creada correctamente" + resetColor);
    }

    @Override
    public String toString() {
        return nombreArma + " (Daño: " + danyo + ")";
    }
}
