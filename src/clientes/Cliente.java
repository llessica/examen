package clientes;

public class Cliente {

    private String Nombre;
    private String Apellido;
    private String Telefono;
    private String Genero;
    private String Email;
    
    //LISTAS
  

    public Cliente (String Nombre, String Apellido , String Telefono,
             String Email , String Genero) {
        
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Telefono = Telefono;
        this.Email = Email;
        this.Genero = Genero;

    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }


    public String toString() {
        return  Nombre + "  " + "/ " + Apellido + "   " + "/ "
                + Telefono + "   " + "/ " + Email + " " + "/ " + 
                Genero + " ";
    }
}


