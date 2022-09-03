package app;

import java.util.Map;

public class Produto {
    private String nome;
    private int preco;
    private int estoque;

    private Map<String, Integer> lista_preco;
    private Map<String, Integer> lista_estoque;

    public Produto(String nome, int preco, int estoque){
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public String getNome(){
        return nome;
    }

    public int getPreco(){
        return preco;
    }

    public int getEstoque(){
        return estoque;
    }

    public void setEstoque(){
        this.estoque = estoque;
    }

    public Map<String, Integer> getLista_preco() {
        return lista_preco;
    }
    public Map<String, Integer> getLista_estoque() {
        return lista_estoque;
    }

    /*métodos*/
    public void buscarProduto(){

    }
    public void listarProduto(){

    }

}
