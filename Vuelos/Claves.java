package Aviones;

public enum Claves {
    NUMERO, ORIGEN, DESTINO, DIA, CLASE;

    public static boolean claveValida(String clave) {
        Claves[] claves = Claves.values();
        for (int i = 0; i < claves.length; i++) {
            if (claves[i].name().equalsIgnoreCase(clave)) {
                return true;
            }
        }
        return false;
    }
}
