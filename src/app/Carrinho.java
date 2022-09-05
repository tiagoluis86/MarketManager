package app;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private int valor_carrinho;
    List<String> produtos_carrinho;

    public Carrinho(int valor_carrinho, List produtos_carrinho){
        this.valor_carrinho = valor_carrinho;
        this.produtos_carrinho = produtos_carrinho;
    }


    public static Carrinho adicionarCarrinho(){
        int valor_carrinho = 0;
        List<String> produtos_carrinho = new ArrayList<>();
        return new Carrinho(valor_carrinho, produtos_carrinho);
    }

    public int getValorCarrinho(){
        return valor_carrinho;
    }

    public List getProdutosCarrinho(){
        return produtos_carrinho;
    }
    public void setValorCarrinho(int valor_carrinho){
        this.valor_carrinho = valor_carrinho;
    }

    public void exibirCarrinho() {

    }
}
