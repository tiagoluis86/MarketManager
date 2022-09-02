package app;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class User {
    private String user;
    private String senha;

    private Map<String,String> users;

    public User(String user, String senha){
        this.user = user;
        this.senha = senha;
    }


    public Map<String, String> getList() {
        return users;
    }
}
