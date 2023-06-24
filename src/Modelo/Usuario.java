package Modelo;
enum rol{
    Administrador,
    Recepcion,
    Laboratorista;
}

public class Usuario {
    private String DNI;
    private String Nombre;
    private String Domicilio;
    private String Mail;
    private int Edad;
    private String password;

    private String rol;


    // es un enum con tres valores: Administrador, Recepcion, Laboratorista


    public Usuario(String DNI, String nombre, String domicilio, String mail, Integer edad, String password, String rol) {

        DNI = DNI;
        Nombre = nombre;
        Domicilio = domicilio;
        Mail = mail;
        Edad = edad;
        password = password;
        rol = rol;

    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDomicilio() {
        return Domicilio;
    }

    public void setDomicilio(String domicilio) {
        Domicilio = domicilio;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    public String getPassword() {
        return this.password;
    }

    public String getRol() {
        return rol;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
