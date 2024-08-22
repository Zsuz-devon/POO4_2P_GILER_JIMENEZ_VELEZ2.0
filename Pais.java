package Modelo;

public class Pais {
    private String nombre;
    private int oro;
    private int plata;
    private int bronce;


    public Pais(String nombre, int oro, int plata, int bronce){
        this.nombre = nombre;
        this.oro = oro;
        this.plata = plata;
        this.bronce = bronce;
    }

    public String getNombre() {
        return nombre;
    }

    public int getOro(){ return oro; }

    public int getPlata(){ return plata; }

    public int getBronce(){ return bronce; }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    @Override
    public String toString() {
        return "Pais{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
