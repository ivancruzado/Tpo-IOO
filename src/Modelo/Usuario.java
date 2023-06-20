package Modelo;

public class Usuario {
    private String DNI;
    private String Nombre;
    private String Domicilio;
    private String Mail;
    private int Edad;
    private String password;
    private String rol;

    public Usuario(String DNI, String nombre, String domicilio, String mail, int edad, String password, String rol) {

        this.DNI = DNI;
        Nombre = nombre;
        Domicilio = domicilio;
        Mail = mail;
        Edad = edad;
        this.password = password;
        this.rol = rol;
    }

    public String getDNI() {
        return DNI;
    }
    public String getRol() {
        return rol;
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
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
