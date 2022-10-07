package app;
import app.TableData;
import java.util.List;
import app.User;
import app.Main;
import java.util.Map;

public class UsersData implements TableData {
    private static final int COL_NOME = 0;
    private static final int COL_SENHA = 1;

    /*private Map<String, String> users;*/
    private List<User> username;


    public UsersData(List<User> username){
        this.username = username;
    }

    @Override
    public int getRows() {
        return username.size();
    }

    @Override
    public int getCols() {
        return 2;
    }

    @Override
    public Object get(int row, int col) {
        User username_data = username.get(row);
            {
                switch (col) {
                    case COL_NOME:
                        return username_data.getUser();
                    case COL_SENHA:
                        return username_data.getSenha();
                }
            }

        throw new IllegalStateException("Coluna inválida: " + col);
    }

    @Override
    public String getTitle(int col) {
        switch (col) {
            case COL_NOME: return "Usuário";
            case COL_SENHA: return "Senha";
        }
        throw new IllegalStateException("Coluna inválida: " + col);
    }

    @Override
    public int getWidth(int col) {
        return col == COL_NOME ? 20 : 7;
    }

}