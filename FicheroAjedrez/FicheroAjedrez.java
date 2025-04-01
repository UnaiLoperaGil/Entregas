import Ejercicio9.Empleado;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FicheroAjedrez {
    public static void main(String[] args) {
        ArrayList<String> alojados = leerJugadores();
        ArrayList<String> formateado = formatear(alojados);
        escribirJugadores(formateado);
    }

    public static void escribirJugadores(ArrayList<String> alojados){
        try{
        FileWriter fw = new FileWriter("C:\\Users\\2lope\\Desktop\\Ficheros\\alojados.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write("Lista de jugadores alojados en Hotel Melià");
        bw.newLine();
        bw.write("Ranking        Nombre");
        bw.newLine();
        bw.write("------------------------------------------------------");
        bw.newLine();
            for (String alojado : alojados) {
                bw.write(alojado);
                bw.newLine();
            }
            bw.close();
            fw.close();
        }catch (IOException e){
            System.out.println("ERROR");
        }
    }

    public static ArrayList<String> leerJugadores() {
        ArrayList<String> alojados = new ArrayList<>();
        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader("C:\\Users\\2lope\\Desktop\\Ficheros\\jugadores.txt");
            br = new BufferedReader(fr);
            String cadena;
            String hotel;

            while ((cadena = br.readLine()) != null) {
                hotel = separarCadena(cadena);
                if(buscarH(hotel)){
                    //System.out.println(cadena);
                    alojados.add(cadena);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: Archivo no encontrado - " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de lectura - " + e.getMessage());
        } finally {
            try {
                if (br != null) br.close(); // Primero cerramos BufferedReader
                if (fr != null) fr.close(); // Luego cerramos FileReader
            } catch (IOException e) {
                System.out.println("Error al cerrar el archivo - " + e.getMessage());
            }
        }
        return alojados;
    }

    public static int encontrarSeparador(String cadena){
        int contador = 0;
        for (int i = 0; i < cadena.length(); i++){
            if(cadena.charAt(i)==';'){
                contador++;
            }
            if(contador == 7){
                return i;
            }
        }
        return 0;
    }

    public static String separarCadena(String cadena){
        int posicion = encontrarSeparador(cadena);
        return cadena.substring(posicion+1);
    }

    public static boolean buscarH(String subcadena){
        for(int i = 0; i < subcadena.length(); i++){
            if(subcadena.charAt(i) == 'H'){
                return true;
            }
        }
        return false;
    }

    public static ArrayList<String> formatear(ArrayList<String> alojados){
        ArrayList<String> formateado = new ArrayList<>();
            for (String alojado : alojados) {
                String[] datos = alojado.split(";");
                int ranking = Integer.parseInt(datos[0]);
                String nombre = datos[2];
                formateado.add(String.format("%4d  -- %s\n", ranking, nombre));
            }
        return formateado;
    }
}
