package ejemplo1.com.proyecto.Modelos;

public class Ruta {

    private String NombreRuta;
    private String Descripcion;
    private int RutaFoto;

    public Ruta(){

    }

    public Ruta(String nombreRuta, String descripcion, int rutaFoto) {
        NombreRuta = nombreRuta;
        Descripcion = descripcion;
        RutaFoto = rutaFoto;
    }

    public String getNombreRuta() {
        return NombreRuta;
    }

    public void setNombreRuta(String nombreRuta) {
        NombreRuta = nombreRuta;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public int getFotoRuta() {
        return RutaFoto;
    }

    public void setFotoRuta(int fotoRuta) {
        RutaFoto = fotoRuta;
    }
}
