package Modelo;

public class Deporte {
    private String nombre;

    public Deporte(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Deporte{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}

