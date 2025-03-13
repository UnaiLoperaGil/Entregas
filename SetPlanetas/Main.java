import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static Map<String,CuerpoCeleste> sistemaSolar = new HashMap<>();
    public static Set<CuerpoCeleste> planetas = new HashSet<>();

    public static void main(String[] args) {
        CuerpoCeleste mercurio = new Planeta("Mercurio", 88);
        sistemaSolar.put(mercurio.getNombre(), mercurio);
        planetas.add(mercurio);

        CuerpoCeleste venus = new Planeta("Venus", 225);
        sistemaSolar.put(venus.getNombre(), venus);
        planetas.add(venus);

        CuerpoCeleste tierra = new Planeta("La Tierra", 365);
        sistemaSolar.put(tierra.getNombre(), tierra);
        planetas.add(tierra);

        CuerpoCeleste marte = new Planeta("Marte", 687);
        sistemaSolar.put(marte.getNombre(), marte);
        planetas.add(marte);

        CuerpoCeleste jupiter = new Planeta("Jupiter", 4332);
        sistemaSolar.put(jupiter.getNombre(), jupiter);
        planetas.add(jupiter);

        CuerpoCeleste saturno = new Planeta("Saturno", 10759);
        sistemaSolar.put(saturno.getNombre(), saturno);
        planetas.add(saturno);

        CuerpoCeleste urano = new Planeta("Urano", 30660);
        sistemaSolar.put(urano.getNombre(), urano);
        planetas.add(urano);

        CuerpoCeleste neptuno = new Planeta("Neptuno", 165);
        sistemaSolar.put(neptuno.getNombre(), neptuno);
        planetas.add(neptuno);

        CuerpoCeleste pluton = new PlanetaEnano("Pluton", 248);
        sistemaSolar.put(pluton.getNombre(), pluton);
        planetas.add(pluton);

        CuerpoCeleste luna = new Luna("Luna", 27);
        tierra.addSatelite(luna);

        CuerpoCeleste deimos = new Luna("Deimos", 1.3);
        marte.addSatelite(deimos);

        CuerpoCeleste phobos = new Luna("Phobos", 0.3);
        marte.addSatelite(phobos);

        CuerpoCeleste io = new Luna("Io", 1.8);
        jupiter.addSatelite(io);

        CuerpoCeleste europa = new Luna("Europa", 3.5);
        jupiter.addSatelite(europa);

        CuerpoCeleste ganymede = new Luna("Ganymede", 7.1);
        jupiter.addSatelite(ganymede);

        CuerpoCeleste callisto = new Luna("Callisto", 16.7);
        jupiter.addSatelite(callisto);

        for (Object planeta : planetas){
            System.out.println(planeta);
        }

        System.out.println(sistemaSolar.get("Marte").getNombre());

        sistemaSolar.get("Marte").showSatelites();


        Set<CuerpoCeleste> lunas = new HashSet<>();

        for (CuerpoCeleste planeta : planetas){
            lunas.addAll(planeta.getSatelites());
        }

        System.out.println(lunas);

        CuerpoCeleste pluton2 = new PlanetaEnano("Pluton", 884);
        sistemaSolar.put(pluton2.getNombre(), pluton2);
        planetas.add(pluton2);
    }
}
