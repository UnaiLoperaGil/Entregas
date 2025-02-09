package Tarea1;

import java.util.ArrayList;

public class TelefonoMovil{
    String myNumber;
    ArrayList<Contacto> myContacts;

    public TelefonoMovil(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    public boolean addNewContact(Contacto contacto){
        if(!this.myContacts.contains(contacto)){
            this.myContacts.add(contacto);
            return true;
        }
        else{
            System.err.println("El contacto que quieres introducir ya existe");
            return false;
        }
    }

    public boolean updateContact(Contacto antiguo, Contacto nuevo){
        if(this.myContacts.contains(antiguo) && !this.myContacts.contains(nuevo)){
            int index = this.myContacts.indexOf(antiguo);
            this.myContacts.set(index,nuevo);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean removeContact(Contacto contacto){
        if(this.myContacts.contains(contacto)){
            this.myContacts.remove(contacto);
            return true;
        }
        else{
            return false;
        }
    }

    public int findContact(Contacto contacto){
        if(this.myContacts.contains(contacto)){
            return this.myContacts.indexOf(contacto);
        }
        else{
            return -1;
        }
    }

    public int findContact(String nombre){
        for(int i = 0; i < this.myContacts.size(); i++){
            if(this.myContacts.get(i).getName().equalsIgnoreCase(nombre)){
                return i;
            }
        }
        return -1;
    }

    public int findContactPhone(String telefono){
        for(int i = 0; i < this.myContacts.size(); i++){
            if(this.myContacts.get(i).getPhoneNumber().equals(telefono)){
                 return i;
            }
        }
        return -1;
    }

    public Contacto queryContact(String nombre){
        int index = findContact(nombre);
        if(index >= 0) {
            return this.myContacts.get(index);
        }
        else{
            return null;
        }
    }

    public void printContacts(){
        System.out.println("Lista de Contactos: ");
        for(int i = 0; i < this.myContacts.size(); i++){
            System.out.println((i+1) + ". " + this.myContacts.get(i).getName() + " --> " + this.myContacts.get(i).getPhoneNumber());
        }
    }
}
