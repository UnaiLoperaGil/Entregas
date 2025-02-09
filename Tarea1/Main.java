package Tarea1;

import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

//AÑADIR FUNCION BUSQUEDA POR CLAVE (11.) PONER POR QUE CAMPO QUIERES BUSCAR Y QUE BUSQUE POR ESE CAMPO

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TelefonoMovil movil = new TelefonoMovil("654321993");
        boolean continuar = true;
        int opcion = 0;
        boolean opcionValida = false;

        while(continuar) {
            do {
                try {
                    System.out.println(" ");
                    imprimirMenu();
                    System.out.println("Elige una opción: ");
                    opcion = scanner.nextInt();
                    scanner.nextLine();
                    opcionValida = true;
                } catch (InputMismatchException opcionNoNumerica) {
                    System.err.println("ERROR, la opción introducida no es numérica");
                    opcionValida = false;
                    scanner.nextLine();
                }
            }while(!opcionValida);

            switch (opcion) {
                case 0:
                    continuar = false;
                    break;
                case 1:
                    movil.printContacts();
                    break;
                case 2:
                    String nombre;
                    do {
                        System.out.println("Nombre: ");
                        nombre = scanner.nextLine();
                    }while(!validarNombre(nombre));
                    String numero;
                    do {
                        System.out.println("Telefono: ");
                        numero = scanner.nextLine();
                    }while(!validarTelefono(numero));
                    Contacto nuevo = new Contacto(nombre,numero);
                    movil.addNewContact(nuevo);
                    break;
                case 3:
                    String actualizar;
                    do {
                        System.out.println("Nombre a actualizar: ");
                        actualizar = scanner.nextLine();
                    }while(!validarNombre(actualizar));
                    Contacto actual = movil.queryContact(actualizar);
                    if(actual!=null) {
                        String actualizacionNombre;
                        do {
                            System.out.println("Actualización del nombre: ");
                            actualizacionNombre = scanner.nextLine();
                        }while(!validarNombre(actualizacionNombre));
                        String actualizacionNumero;
                        do {
                            System.out.println("Actualización del número: ");
                            actualizacionNumero = scanner.nextLine();
                        }while(!validarTelefono(actualizacionNumero));
                        Contacto nuevoContacto = new Contacto(actualizacionNombre, actualizacionNumero);
                        movil.updateContact(actual, nuevoContacto);
                    }
                    else{
                        System.err.println("ERROR Contacto no encontrado");
                    }
                    break;
                case 4:
                    String eliminar;
                    do {
                        System.out.println("Introduce el nombre a eliminar: ");
                        eliminar = scanner.nextLine();
                    }while(!validarNombre(eliminar));
                    Contacto eliminarContacto = movil.queryContact(eliminar);
                    if(eliminarContacto!=null) {
                        movil.removeContact(eliminarContacto);
                        System.out.println("Se ha eliminado el contacto correctamente");
                    }
                    else{
                        System.err.println("ERROR No se ha podido eliminar el contacto");
                    }
                    break;
                case 5:
                    String buscar;
                    do {
                        System.out.println("Introduce el nombre que quieres buscar: ");
                        buscar = scanner.nextLine();
                    }while(!validarNombre(buscar));
                    int encontrado = movil.findContact(buscar);
                    if(encontrado >= 0){
                        System.out.println("La información del contacto es la siguiente: ");
                        System.out.println("Contacto: " + movil.myContacts.get(encontrado).getName());
                        System.out.println("Teléfono: " + movil.myContacts.get(encontrado).getPhoneNumber());
                    }
                    else {
                        System.err.println("ERROR Contacto no encontrado");
                    }
                    break;
                case 6:
                    imprimirMenu();
                    break;
                case 7:
                    Collections.sort(movil.myContacts);
                    System.out.println("Se han ordenado los contactos");
                    break;
                case 8:
                    String buscarTelefono;
                    do {
                        System.out.println("Introduce el teléfono que quieres buscar: ");
                        buscarTelefono = scanner.nextLine();
                    }while(!validarTelefono(buscarTelefono));
                    int encontrarTelefono = movil.findContactPhone(buscarTelefono);
                    if(encontrarTelefono >= 0){
                        System.out.println("La información del contacto es la siguiente: ");
                        System.out.println("Contacto: " + movil.myContacts.get(encontrarTelefono).getName());
                        System.out.println("Teléfono: " + movil.myContacts.get(encontrarTelefono).getPhoneNumber());
                    }
                    else{
                        System.err.println("ERROR Contacto no encontrado");
                    }
                    break;
                case 9:
                    movil.myContacts.clear();
                    System.out.println("Se han eliminado todos los contactos correctamente");
                    break;
                case 10:
                    int contador = 0;
                    for(int i = 0; i < movil.myContacts.size(); i++){
                        contador++;
                    }
                    System.out.println("Hay " + contador + " contacto(s)");
                    break;
                default:
                    System.err.println("ERROR, el número introducido no está considerado en el menú");
                    break;
            }
        }
    }

    public static void imprimirMenu() {
        System.out.println("*************************************");
        System.out.println("*   PROGRAMA MANEJO DE CONTACTOS    *");
        System.out.println("*************************************");
        System.out.println("0 - Salir");
        System.out.println("1 - Imprimir contactos");
        System.out.println("2 - Agregar nuevo contacto");
        System.out.println("3 - Actualizar contacto existente");
        System.out.println("4 - Eliminar contacto");
        System.out.println("5 - Buscar contacto por nombre");
        System.out.println("6 - Imprimir menú");
        System.out.println("7 - Ordenar por nombre");
        System.out.println("8 - Buscar contacto por teléfono");
        System.out.println("9 - Borrar todos los contactos");
        System.out.println("10 - Cantidad de contactos en la lista");
    }

    public static boolean validarTelefono(String numero){
        if(numero.length()!=9){
            System.err.println("Longitud Errónea (Debe contener 9 dígitos)");
            return false;
        }
        if(!numero.matches("\\d+")){ //Con esta expresión regular se comprueba que el String solo contiene valores númericos
            System.err.println("El teléfono no está conformado por valores númericos");
            return false;
        }
        return true;
    }

    public static boolean validarNombre(String nombre){
        if (nombre == null || nombre.isEmpty()) {
            System.err.println("El nombre no puede estar vacío.");
            return false;
        }
        if (Character.isDigit(nombre.charAt(0))) {
            System.err.println("El nombre no puede empezar con un número.");
            return false;
        }
        return true;
    }
}
