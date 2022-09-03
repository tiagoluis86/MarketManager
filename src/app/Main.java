package app;
import java.util.ArrayList;
import java.util.Scanner;
import app.User;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        /*Define o usuário admin e a lista com todos os users*/
        User admin = new User("admin", "admin");
        Map<String, String> users = new HashMap<String, String>();
        String admin_name = admin.getUser();
        String admin_senha = admin.getSenha();
        users.put(admin_name, admin_senha);
        System.out.println(users);

        /*Define alguns produtos para povoar a base*/
        Produto arroz = new Produto("arroz", 10, 50);
        Produto feijao = new Produto("feijão", 5, 40);
        Produto cerveja = new Produto("cerveja", 3, 100);
        Produto cafe = new Produto("café", 15, 50);
        Produto leite = new Produto("leite", 7, 50);

        Map<String, Integer> lista_preco = new HashMap<String, Integer>();
        lista_preco.put(arroz.getNome(), arroz.getPreco());
        lista_preco.put(feijao.getNome(), feijao.getPreco());
        lista_preco.put(cerveja.getNome(), cerveja.getPreco());
        lista_preco.put(cafe.getNome(), cafe.getPreco());
        lista_preco.put(leite.getNome(), leite.getPreco());

        Map<String, Integer> lista_estoque = new HashMap<String, Integer>();
        lista_estoque.put(arroz.getNome(), arroz.getEstoque());
        lista_estoque.put(feijao.getNome(), feijao.getEstoque());
        lista_estoque.put(cerveja.getNome(), cerveja.getEstoque());
        lista_estoque.put(cafe.getNome(), cafe.getEstoque());
        lista_estoque.put(leite.getNome(), leite.getEstoque());

        /*Define alguns clientes para povoar a base*/

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
            System.out.println("1 - Fazer compras 2 - Ver clientes (Only Admin) 3 - Trocar usuário 4 - Sobre 5 - Sair");
            int menu = userEntry.nextInt();


            /* PARTE DE COMPRAS PROPRIAMENTE DITA */
            if (menu == 1){
                System.out.println("Nome do produto / Preço");
                System.out.println(lista_preco);
                System.out.println("Nome do produto / Quantidade em estoque");
                System.out.println(lista_estoque);
                System.out.println("1 - Adicionar ao carrinho 2 - Finalizar compra 3 - Cancelar e sair");


            }


            /* Clientes */
            else if (menu == 2){
                System.out.println("Nome do cliente / Telefone / Endereço");
            }

            /* Outras funcionalidades */
            else if (menu == 3){
                System.out.println("Voltando à tela de login...");
            }
            else if (menu == 4){
                System.out.println("MARKET MANAGER 2022");
                System.out.println("Feito por Tiago Luis Custódio");
                System.out.println("tiagoluis86@outlook.com / 41 987485610");
            }
            else{
                break;
            }

        }

    }
}
