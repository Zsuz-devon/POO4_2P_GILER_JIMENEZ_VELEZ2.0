package Modelo;

public class Atleta {
    private String nombre;
    private String genero;
    private String medalla;
    private String deporte;
    private String pais;

    // Constructor
    public Atleta(String nombre, String genero, String medalla, String deporte, String pais) {
        this.nombre = nombre;
        this.genero = genero;
        this.medalla = medalla;
        this.deporte = deporte;
        this.pais = pais;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getGenero() {
        return genero;
    }

    public String getMedalla() {
        return medalla;
    }

    public String getDeporte() {
        return deporte;
    }

    public String getPais() {
        return pais;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setMedalla(String medalla) {
        this.medalla = medalla;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    // Método para obtener una representación en String del objeto
    @Override
    public String toString() {
        return nombre + ", " + genero + ", " + medalla + ", " + deporte + ", " + pais;
    }
}