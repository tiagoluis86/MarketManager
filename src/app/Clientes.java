package app;

public class Clientes {

    String nome;
    String email;


    //constructor
    public Clientes(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }


    //getters and setters
    public String getNome(){
        return nome;
    }
    public String getEmail(){
        return email;
    }


}
