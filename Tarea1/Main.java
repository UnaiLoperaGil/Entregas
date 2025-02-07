package Tarea1;

import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TelefonoMovil movil = new TelefonoMovil("654321993");
        boolean continuar = true;
        int opcion;
        imprimirMenu();

        while(continuar) {
            System.out.println("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 0:
                    continuar = false;
                    break;
                case 1:
                    movil.printContacts();
                    break;
                case 2:
                    System.out.println("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.println("Telefono: ");
                    String numero = scanner.nextLine();
                    Contacto nuevo = new Contacto(nombre,numero);
                    movil.addNewContact(nuevo);
                    break;
                case 3:
                    System.out.println("Nombre a actualizar: ");
                    String actualizar = scanner.nextLine();
                    Contacto actual = movil.queryContact(actualizar);
                    if(actual!=null) {
                        System.out.println("Actualización del nombre: ");
                        String actualizacionNombre = scanner.nextLine();
                        System.out.println("Actualización del número: ");
                        String actualizacionNumero = scanner.nextLine();
                        Contacto nuevoContacto = new Contacto(actualizacionNombre, actualizacionNumero);
                        movil.updateContact(actual, nuevoContacto);
                    }
                    else{
                        System.err.println("ERROR Contacto no encontrado");
                    }
                    break;
                case 4:
                    System.out.println("Introduce el nombre a eliminar: ");
                    String eliminar = scanner.nextLine();
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
                    System.out.println("Introduce el nombre que quieres buscar: ");
                    String buscar = scanner.nextLine();
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
                    System.out.println("Introduce el teléfono que quieres buscar: ");
                    String buscarTelefono = scanner.nextLine();
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
                    System.out.println("Hay " + contador + " contactos");
                    break;
            }
        }
    }

    public static void imprimirMenu() {
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
}
