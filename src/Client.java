//Clase que contiene  la informacion del cliente
public class Client {
     private String Nombre;
     private String Apellido;
     private String Telefono;
     private String Email;
     private String Direccion;
     private String borndate;
     private String Apodo;
     private Integer id;
    public Client(String name, String lastName, String phone, String email, String address, String borndate, String apodo, Integer id) {
        this.Nombre = name;
        this.Apellido = lastName;
        this.Telefono = phone;
        this.Email = email;
        this.Direccion = address;
        this.borndate = borndate;
        this.Apodo = apodo;
        this.id = id;
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

    public String getEmail() {
         return Email;
    }

    public void setEmail(String email) {
         this.Email = email;
    }

    public String getDireccion() {
         return Direccion;
    }

    public void setDireccion(String Direccion) {
         this.Direccion = Direccion;
    }

    public String getBorndate() {
         return borndate;
    }

    public void setBorndate(String borndate) {
         this.borndate = borndate;
    }

    public String getApodo() {
         return Apodo;
    }

    public void setApodo(String Apodo) {
         this.Apodo = Apodo;
    }

    public Integer getId() {
         return id;
    }

    public void setId(Integer id) {
         this.id = id;
    }

}
