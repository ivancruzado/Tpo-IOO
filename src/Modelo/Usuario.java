package Modelo;
enum rol{
    Administrador,
    Recepcionista,
    Laboratorista;
}

public class Usuario {
    private String DNI;
    private String Nombre;
    private String Domicilio;
    private String Mail;
    private int Edad;
    private String Password;

    private String Rol;
    private String dni;


    // es un enum con tres valores: Administrador, Recepcionista, Laboratorista


    public Usuario(String DNI, String nombre, String domicilio, String mail, Integer edad, String password, String rol) {

         dni = DNI;
         Nombre = nombre;
         Domicilio = domicilio;
         Mail = mail;
         Edad = edad;
         Password = password;
         Rol = rol;

    }
        public String getDNI () {
            return this.dni;
        }

        public void setDNI (String DNI){
            this.dni = DNI;
        }

        public String getNombre () {
            return Nombre;
        }

        public void setNombre (String nombre){
            Nombre = nombre;
        }

        public String getDomicilio () {
            return Domicilio;
        }

        public void setDomicilio (String domicilio){
            Domicilio = domicilio;
        }

        public String getMail () {
            return Mail;
        }

        public void setMail (String mail){
            Mail = mail;
        }

        public int getEdad () {
            return Edad;
        }

        public void setEdad ( int edad){
            Edad = edad;
        }

        public String getPassword () {
            return Password;
        }

        public String getRol () {
            return Rol;
        }

        public void setPassword (String password){
            this.Password = password;
        }

}
