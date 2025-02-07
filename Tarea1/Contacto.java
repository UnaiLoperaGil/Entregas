package Tarea1;

public class Contacto implements Comparable<Contacto>{
    private String name;
    private String phoneNumber;

    public Contacto(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int compareTo(Contacto contacto) {
        int resultado = this.getName().compareToIgnoreCase(contacto.getName());

        if(resultado == 0){
            resultado = this.getPhoneNumber().compareTo(contacto.getPhoneNumber());
        }
        return resultado;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static Contacto createContact(String nombre, String numeroTelefono){
        Contacto contacto = new Contacto(nombre,numeroTelefono);
        return contacto;
    }
}
