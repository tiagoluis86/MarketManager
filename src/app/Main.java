package app;
import java.util.ArrayList;
import java.util.Scanner;
import app.User;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        User admin = new User("admin", "admin");
        Map<String, String> users = new HashMap<String, String>();
        String admin_name = admin.getUser();
        String admin_senha = admin.getSenha();
        users.put(admin_name, admin_senha);
        System.out.println(users);

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

                System.out.println("Inserido: ");
                System.out.println(usuario.getClass());
                System.out.println(senha.getClass());
                System.out.println("Esperado: ");
                System.out.println(admin_name.getClass());
                System.out.println(admin_senha.getClass());

                if (usuario.equals(admin_name)  && senha.equals(admin_senha)) {
                    System.out.println("ACCESS GRANTED AS ADMIN");
                }
                else {
                    System.out.println("INVALID CREDENTIALS");
                }

            }
            else if (login == 2){
                break;
                /* fazer a criação de novo usuario           */
            }
            else {
                break;
            }


            /* Menu principal */
            System.out.println("MAKET MANAGER 2022");
            System.out.println("O que você deseja fazer?");
            System.out.println("1 - Ver produtos e estoque / Nova Compra 2 - Ver clientes 3 - Sair");
        }

    }
}
