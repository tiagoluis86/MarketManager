package app;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private int valor_carrinho;
    private String user;
    List<String> produtos_carrinho;

    public Carrinho(int valor_carrinho, String user, List produtos_carrinho){
        this.valor_carrinho = valor_carrinho;
        this.user = user;
        this.produtos_carrinho = produtos_carrinho;
    }


    public static Carrinho adicionarCarrinho(){
        int valor_carrinho = 0;
        String user = "";
        List<String> produtos_carrinho = new ArrayList<>();
        return new Carrinho(valor_carrinho, user, produtos_carrinho);
    }

    public int getValorCarrinho(){
        return valor_carrinho;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user){
        this.user = user;
    }

    public List getProdutosCarrinho(){
        return produtos_carrinho;
    }
    public void setValorCarrinho(int valor_carrinho){
        this.valor_carrinho = valor_carrinho;
    }

}
