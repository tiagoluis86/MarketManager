package app;
import app.TableData;
import java.util.List;
import app.User;
import app.Main;
import java.util.Map;



public class ComprasData implements TableData{

    private static final int COL_NOME = 0;
    private static final int COL_CARRINHO = 1;
    private static final int COL_VALOR = 2;

    /*private Map<String, String> users;*/
    private List<Carrinho> compradata;


    public ComprasData(List<Carrinho> compradata){
        this.compradata = compradata;
    }

    @Override
    public int getRows() {
        return compradata.size();
    }

    @Override
    public int getCols() {
        return 3;
    }

    @Override
    public Object get(int row, int col) {
        Carrinho compra_data = compradata.get(row);
        {
            switch (col) {
                case COL_NOME:
                    return compra_data.getUser();
                case COL_CARRINHO:
                    return compra_data.getProdutosCarrinho();
                case COL_VALOR:
                    return compra_data.getValorCarrinho();
            }
        }

        throw new IllegalStateException("Coluna inválida: " + col);
    }

    @Override
    public String getTitle(int col) {
        switch (col) {
            case COL_NOME: return "Usuário";
            case COL_CARRINHO: return "Conteúdo da compra";
            case COL_VALOR: return "Valor da compra";
        }
        throw new IllegalStateException("Coluna inválida: " + col);
    }

    @Override
    public int getWidth(int col) {
        return col == COL_NOME ? 20 : 7;
    }


}
