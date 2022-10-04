package app;
import app.TableData;
import java.util.List;

public class ProdutosData implements TableData {
    private static final int COL_NOME = 0;
    private static final int COL_PRECO = 1;
    private static final int COL_ESTOQUE = 2;


    private List<Produto> produtos;

    public ProdutosData(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public int getRows() {
        return produtos.size();
    }

    @Override
    public int getCols() {
        return 4;
    }

    @Override
    public Object get(int row, int col) {
        Produto produto = produtos.get(row);
        switch (col) {
            case COL_NOME: return produto.getNome();
            case COL_PRECO: return String.format("%.2f", produto.getPreco());
            case COL_ESTOQUE: return String.format("%.2f", produto.getEstoque());
        }
        throw new IllegalStateException("Coluna inválida: " + col);
    }

    @Override
    public String getTitle(int col) {
        switch (col) {
            case COL_NOME: return "Produto";
            case COL_PRECO: return "Preço";
            case COL_ESTOQUE: return "Estoque";

        }
        throw new IllegalStateException("Coluna inválida: " + col);
    }

    @Override
    public int getWidth(int col) {
        return col == COL_NOME ? 20 : 7;
    }
}