import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Heroe {
    public static final String textoVerde = "\u001B[32m";
    public static final String textoRojo = "\u001B[31m";
    public static final String resetColor = "\u001B[0m";

    protected String nombre;
    protected int nivel;
    protected int puntosVida;
    protected ArrayList<Arma> armaEspecial = new ArrayList<>();

    public Heroe(String tipo){
        Scanner scan = new Scanner(System.in);
        boolean numerico = false;
        do {
            System.out.print("Nombre del " + tipo + ": ");
            this.nombre = scan.nextLine();
            if(this.nombre.isEmpty()){
                System.out.println(textoRojo + "ERROR, el nombre está vacío" + resetColor);
            }
        }while(this.nombre.isEmpty());
        do {
            try {
                System.out.print("Nivel: ");
                this.nivel = scan.nextInt();
                if(this.nivel<1){
                    System.out.println(textoRojo + "ERROR, el nivel debe ser mayor que 0" + resetColor);
                }
                else {
                    numerico = true;
                }
            }catch(InputMismatchException noNumero){
                System.out.println(textoRojo + "Introduce una opción numérica" + resetColor);
                scan.nextLine();
            }
        }while(!numerico);
        numerico = false;
        do {
            try {
                System.out.print("Puntos de Vida: ");
                this.puntosVida = scan.nextInt();
                if(this.puntosVida<=0){
                    System.out.println(textoRojo + "ERROR, los puntos de vida deben ser mayor que 0" + resetColor);
                }
                else{
                    numerico = true;
                }
            }catch(InputMismatchException noNumero){
                System.out.println(textoRojo + "Introduce una opción numérica" + resetColor);
                numerico = false;
                scan.nextLine();
            }
        }while(!numerico);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }

    public String getClase(){
        return "";
    }

    public int getAtributo(){
        return 0;
    }

    public void getArmaEspecial() {
        System.out.println("    Listado de Armas: ");
         for(int i = 0; i< armaEspecial.size(); i++){
             System.out.println("     " + (i+1) + "." + armaEspecial.get(i));
         }
    }

    public void setArmaEspecial(Arma armaNueva) {
        this.armaEspecial.add(armaNueva);
    }
}
