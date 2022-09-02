package app;
import java.util.ArrayList;
import java.util.Scanner;
import app.User;
import java.util.HashMap;
import java.util.Map;
import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

public class Main {
    public static void main(String[] args) {

        User admin = new User("admin", "admin");
        Map<String, String> users = admin.getList();
        users.put(admin);
        System.out.println(admin);

        while(true) {
            Scanner userEntry = new Scanner(System.in);


            /* invocar o login */
            System.out.println("1 - Já sou cadastrado 2 - Fazer novo cadastro, 3 - Sair : ");
            int login = userEntry.nextInt();

            if (login == 1) {
                System.out.println("Insira seu usuário: ");
                String usuario = userEntry.next();

                System.out.println("Insira sua senha: ");
                String senha = userEntry.next();




            }
            else if (login == 2){
                break;
                /* fazer a criação de novo usuario           */
            }
            else {
                break;
            }


            /* Menu principal */
        }

    }
}
