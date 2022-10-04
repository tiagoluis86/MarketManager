package app;
import app.TableData;
import java.util.List;
import app.User;
import app.Main;
import java.util.Map;

public class UsersData implements TableData {
    private static final int COL_NOME = 0;
    private static final int COL_SENHA = 1;

    private Map<String, String> users;

    public UsersData(Map<String, String> users) {
        this.users = users;
    }

    @Override
    public int getRows() {
        return users.size();
    }

    @Override
    public int getCols() {
        return 2;
    }

    @Override
    public Object get(int row, int col) {
        for (Map.Entry<String, String> entry : users.entrySet())
            {
            switch (col) {
                case COL_NOME:
                    return entry.getKey();
                case COL_SENHA:
                    return users.entrySet();
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