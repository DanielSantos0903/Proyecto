package ejemplo1.com.proyecto.Modelos;

public class Municipios {

    private String NombreMunicipio;
    private String Descripcion;
    private int Fotos;
    private String RutaAsociada;

    public  Municipios(){}

    public Municipios(String nombreMunicipio , int fotos) {
        NombreMunicipio = nombreMunicipio;
        Fotos = fotos;

    }

    public String getNombreMunicipio() {
        return NombreMunicipio;
    }

    public void setNombreMunicipio(String nombreMunicipio) {
        NombreMunicipio = nombreMunicipio;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public int getFotos() {
        return Fotos;
    }

    public void setFotos(int fotos) {
        Fotos = fotos;
    }

    public String getRutaAsociada() {
        return RutaAsociada;
    }

    public void setRutaAsociada(String rutaAsociada) {
        RutaAsociada = rutaAsociada;
    }

}
