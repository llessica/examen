package productos;


public class Productos {

    private String Id;
    private String Nombre;
    private String Costo;
    private String Valor;
    private String Talla;
    private String CantMin;
    private String CantMax;
    private String Genero;

    public Productos(String Id, String Nombre, String Costo, String Valor,
            String Talla, String CantMin, String CantMax, String Genero) {

        this.Id = Id;
        this.Nombre = Nombre;
        this.Costo = Costo;
        this.Valor = Valor;
        this.Talla = Talla;
        this.CantMin = CantMin;
        this.CantMax = CantMax;
        this.Genero = Genero;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCosto() {
        return Costo;
    }

    public void setCosto(String Costo) {
        this.Costo = Costo;
    }

    public String getValor() {
        return Valor;
    }

    public void setValor(String Valor) {
        this.Valor = Valor;
    }

    public String getTalla() {
        return Talla;
    }

    public void setTalla(String Talla) {
        this.Talla = Talla;
    }

    public String getCantMin() {
        return CantMin;
    }

    public void setCantMin(String CantMin) {
        this.CantMin = CantMin;
    }

    public String getCantMax() {
        return CantMax;
    }

    public void setCantMax(String CantMax) {
        this.CantMax = CantMax;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    @Override
    public String toString() {
        return Id + "/ " + Nombre + "  " + "/ " + Costo + "   " + "/ "
                + Valor + "   " + "/ " + Talla + " " + "/ " + CantMin + "  "
                + "/ " + CantMax + "   " + "/ " + Genero + " ";
    }
}

/*
public class Productos {

    private String Id;
    private String Nombre;
    private String Costo;
    private String Valor;
    private String Talla;
    private String CantMin;
    private String CantMax;
    private String Genero;

    public Productos(String Id, String Nombre, String Costo, String Valor,
            String Talla, String CantMin, String CantMax, String Genero) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Costo = Costo;
        this.Valor = Valor;
        this.Talla = Talla;
        this.CantMin = CantMin;
        this.CantMax = CantMax;
        this.Genero = Genero;

    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCosto() {
        return Costo;
    }

    public void setCosto(String Costo) {
        this.Costo = Costo;
    }

    public String getValor() {
        return Valor;
    }

    public void setValor(String Valor) {
        this.Valor = Valor;
    }

    public String getTalla() {
        return Talla;
    }

    public void setTalla(String Talla) {
        this.Talla = Talla;
    }

    public String getCantMin() {
        return CantMin;
    }

    public void setCantMin(String CantMin) {
        this.CantMin = CantMin;
    }

    public String getCantMax() {
        return CantMax;
    }

    public void setCantMax(String CantMax) {
        this.CantMax = CantMax;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public String toString() {
        return Id + "/ " + Nombre + "  " + "/ " +  Costo + "   " + "/ "
                + Valor + "   " + "/ " + Talla + " " + "/ " + CantMin + "  " + 
                "/ " + CantMax + "   " + "/ " + Genero + " ";
    }
}
*/
