package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Pacientes {

    private int DNI;
    private String Nombre;
    private String Domicilio;
    private String Mail;
    private String sexo;
    private int Edad;


    public Pacientes(int dni, String nombre, String domicilio, String mail, String sexo, int edad) {
        this.DNI = dni;
        this.Nombre = nombre;
        this.Domicilio = domicilio;
        this.Mail = mail;
        this.sexo = sexo;
        this.Edad = edad;
    }


    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }
}
