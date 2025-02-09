package Tarea1;

import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Contacto contacto = (Contacto) obj;
        return Objects.equals(name, contacto.name) &&
                Objects.equals(phoneNumber, contacto.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNumber);
    }
}
