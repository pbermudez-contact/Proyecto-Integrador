package com.example.demo.modelo;
//@Document ser realizo el modelo o tabla en mongoDBcompas para almacenar ahi
//modelo, junto a los getters y setter, al igual que el constructor
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Document(collection = "usuarios")
public class Usuario {
    //Datos del modelo y tipo a utilizar
    @Id
    private String id;
    private String nombre;
    private String email;
    private String password;
    private String telefono;

    //contructor vacio
    public Usuario(){

    }

    //contructor con datos
    public Usuario(String id, String nombre, String email, String password, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = new BCryptPasswordEncoder().encode(password);
        this.telefono = telefono;
    }

    //getters y setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    //aplicar sifrado al realizar la la operacion del update
    public void setPassword(String password) {
        //cifrar la contraseña no importando se cambie siempre
        this.password = new BCryptPasswordEncoder().encode(password);
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
