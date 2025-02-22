import java.util.InputMismatchException;
import java.util.Scanner;

public class Mago extends Heroe{
    protected int mana;

    public Mago(String tipo) {
        super(tipo);
        Scanner scan = new Scanner(System.in);
        boolean numerico = false;
        do{
            try{
                System.out.print("Mana: ");
                this.mana = scan.nextInt();
                if(this.mana<=0){
                    System.out.println(textoRojo + "ERROR, el mana debe ser mayor que 0" + resetColor);
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

    public void hechizar(){
        System.out.println("El mago " + this.nombre + " ha lanzado un hechizo con éxito");
    }

    @Override
    public String getClase(){
        return "Mago";
    }

    @Override
    public int getAtributo() {
        System.out.print("    Mana: ");
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }
}
