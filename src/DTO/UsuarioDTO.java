package DTO;

public class UsuarioDTO {
        private String DNI;
        private String Nombre;
        private String Domicilio;
        private String Mail;
        private Integer Edad;
        private String password;

        private String rol;

        public UsuarioDTO(String DNI, String Nombre, String Domicilio, String mail, int Edad, String password, String rol) {

            this.DNI = DNI;
            this.Nombre = Nombre;
            this.Domicilio = Domicilio;
            this.Mail = mail;
            this.Edad = Edad;
            this.password = password;
            this.rol = rol;
        }

        public String getDNI() {
            return DNI;
        }

        public void setDNI(String DNI) {
            this.DNI = DNI;
        }


        public String getRol() {
            return rol;
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
        public String getEdadString() {
            return String.valueOf(Edad);
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

        public void setRol(String rol) {
            this.rol = rol;
        }
    }


