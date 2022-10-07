package app;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import app.User;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        /*Define o usuário admin e a lista com todos os users*/
        User admin = new User("admin", "admin");

        Map<String, String> users = new HashMap<String, String>();
        UsersData userdata = new UsersData(users);

        String admin_name = admin.getUser();
        String admin_senha = admin.getSenha();
        users.put(admin_name, admin_senha);

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

        List<String> codigo_produto = new ArrayList<>();
        codigo_produto.add(arroz.getNome());
        codigo_produto.add(feijao.getNome());
        codigo_produto.add(cerveja.getNome());
        codigo_produto.add(cafe.getNome());
        codigo_produto.add(leite.getNome());


        /*Define alguns clientes para povoar a base
        Clientes joao = new Clientes("João da Silva", "joaodasilva@gmail.com");
        Clientes maria = new Clientes("Maria de Menezes Conceição", "conceicaomaria@bol.com.br");
        Clientes sergio = new Clientes("Sergio Aparecido", "sergiao@yahoo.com,br");
        Clientes rosangela = new Clientes("Rosangela da Cunha", "rooocunha@ig.com.br");
        Clientes israel = new Clientes("Israel Matos", "israelmatos@netsite.com.br");

        Map<String, String> lista_clientes = new HashMap<String, String>();
        lista_clientes.put(joao.getNome(), joao.getEmail());
        lista_clientes.put(maria.getNome(), maria.getEmail());
        lista_clientes.put(sergio.getNome(), sergio.getEmail());
        lista_clientes.put(rosangela.getNome(), rosangela.getEmail());
        lista_clientes.put(israel.getNome(), israel.getEmail());*/

        while (true) {
            Scanner userEntry = new Scanner(System.in);
            String usuario;
            String senha;

            /* invocar o login */
            System.out.println("MARKET MANAGER 2022");
            System.out.println("1 - Fazer login 2 - Criar novo cadastro 3 - Sair: ");
            int login = userEntry.nextInt();

            if (login == 1) {
                System.out.println("Insira seu usuário: ");
                usuario = userEntry.next();

                System.out.println("Insira sua senha: ");
                senha = userEntry.next();

                if (usuario.equals(admin_name) && senha.equals(admin_senha)) {
                    System.out.println("ACESSO DE ADMINISTRADOR PERMITIDO");
                } else if (users.containsKey(usuario)) {


                    if (users.containsValue(senha)) {
                        System.out.printf("Acesso permitido. Bem vindo %s ao ", usuario);

                    }
                   else {
                        System.out.println("Dados de login inválidos");
                        continue;
                    }


                } else {
                    System.out.println("Dados de login inválidos");
                    continue;
                }
            }

            else if (login == 2) {
                    /* fazer a criação de novo usuario           */

                    System.out.println("Insira seu usuário: ");
                    String novo_usuario = userEntry.next();

                    System.out.println("Insira sua senha: ");
                    String nova_senha = userEntry.next();

                    User user = User.createUser(novo_usuario, nova_senha);

                    users.put(novo_usuario, nova_senha);
                    System.out.printf("Novo usuário cadastrado: %s ", novo_usuario);
                    System.out.println(users);
                    continue;


                } else {
                    break;
                }

                /* Menu principal */
                System.out.println("MARKET MANAGER 2022");
                System.out.printf("Sessão aberta para o usuário %s\n", usuario);
                System.out.println("O que você deseja fazer?");
                System.out.println("1 - Fazer compras 2 - Ver clientes (Somente Admin) 3 - Trocar usuário 4 - Sobre 5 - Sair");
                int menu = userEntry.nextInt();


                /* PARTE DE COMPRAS PROPRIAMENTE DITA */
                if (menu == 1) {

                    /*cria o objeto carrinho*/
                    Carrinho carrinho = Carrinho.adicionarCarrinho();
                    int valor_compra = carrinho.getValorCarrinho();
                    carrinho.setUser(usuario);
                    System.out.printf("Carrinho aberto para o usuário: %s \n", carrinho.getUser());

                    while (true) {
                        System.out.printf("Preços: %s \n", lista_preco);
                        System.out.printf("Estoque: %s:\n", lista_estoque);
                        System.out.println("Digite o código do produto para adicionar ao carrinho:");
                        int index = 0;
                        for (String s : codigo_produto)
                            System.out.println((index++) + ": " + s);
                        int adicionar_produto = userEntry.nextInt();


                        //Verifica se o produto digitado contém correspondente na lista_preco e atualiza o valor da compra na tela

                        if (lista_preco.containsKey(codigo_produto.get(adicionar_produto))) {
                            Object value = lista_preco.get(codigo_produto.get(adicionar_produto));
                            System.out.println("Adicionou ao carrinho: " + codigo_produto.get(adicionar_produto) + "\npreço do item: " + value + " reais.");
                            int valor_adicionado = (Integer) value;
                            valor_compra = valor_compra + valor_adicionado;
                            System.out.println("Valor parcial da compra: ");
                            System.out.printf(valor_compra + " reais \n");
                        }

                        //Adiciona o produto no carrinho
                        carrinho.getProdutosCarrinho();
                        carrinho.produtos_carrinho.add(codigo_produto.get(adicionar_produto));

                        System.out.println("Conteúdo do seu carrinho: ");
                        System.out.println(carrinho.produtos_carrinho); // mostra os produtos do carrinho


                        //Segue para próximo item da compra ou finaliza
                        System.out.printf("1 - Seguir adicionando 2 - Finalizar compra 3 - Cancelar compra");
                        int continuarcompra = userEntry.nextInt();

                        if (continuarcompra == 1) {
                            System.out.println("Adicione o próximo produto");
                        } else if (continuarcompra == 2) {
                            System.out.println("------------------------------------------------------------");
                            System.out.printf("Compra finalizada para o usuário: %s \n", carrinho.getUser());
                            System.out.println("Sua compra deu um total de:");
                            System.out.println(valor_compra + " reais");
                            System.out.println("Conteúdo do carrinho:");
                            System.out.println(carrinho.produtos_carrinho);
                            System.out.println("------------------------------------------------------------");
                            break;
                        } else {
                            System.out.println("Compra cancelada");
                            break;
                        }
                    }
                }


                /* Clientes */
                else if (menu == 2) {

                    System.out.println("Usuários cadastrados e senhas:");

                    Table tabela_users =new Table(new UsersData(users));
                    tabela_users.print();
                }

                /* Outras funcionalidades */
                else if (menu == 3) {
                    System.out.println("Voltando à tela de login...");
                } else if (menu == 4) {
                    System.out.println("MARKET MANAGER 2022");
                    System.out.println("Feito por Tiago Luis Custódio");
                    System.out.println("tiagoluis86@outlook.com / 41 987485610");
                } else {
                    break;
                }

            }

        }
    }

