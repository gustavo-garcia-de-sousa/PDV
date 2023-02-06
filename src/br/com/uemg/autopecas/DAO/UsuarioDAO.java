package br.com.uemg.autopecas.DAO;

import br.com.uemg.autopecas.model.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gustavo
 */
public class UsuarioDAO implements CRUD {

    private final Connection connection;

    public UsuarioDAO(Connection connection) throws SQLException {

        this.connection = connection;
    }

    @Override
    public void create(Object object) throws SQLException {

        Usuario u = (Usuario) object;//casting
        String SQL = "INSERT INTO Usuario (nome, senha, cargo) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {

            connection.setAutoCommit(false);//desligando transação automática

            statement.setString(1, u.getNome());
            statement.setString(2, u.getSenha());
            statement.setObject(3, u.getCargo());

            //simulando uma Execeção
            if (u.getSenha().equals("123")) {
                throw new SQLException("Falha na transação.");
            }

            statement.execute();

            connection.commit();//enviando transação

            try (ResultSet result = statement.getGeneratedKeys()) {

                while (result.next()) {
                    u.setId(result.getInt(1));
                }
            }
        } catch (SQLException e) {

            connection.rollback();//transação desfeita
            System.out.println("*** ROLLBACK EXECUTADO ***");
        }
    }

    @Override
    public List<Object> read() throws SQLException {

        List<Object> list = new ArrayList<>();
        String SQL = "SELECT * FROM Usuario";

        try (PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.execute();

            ResultSet result = statement.getResultSet();

            while (result.next()) {
                Usuario u = new Usuario();
                u.setId(result.getInt("id"));
                u.setNome(result.getString("nome"));
                u.setSenha(result.getString("senha"));
                u.setCargo(result.getString("cargo"));
                list.add(u);

            }
        }
        return list;

    }

    @Override
    public void update(Object object) throws SQLException {
        Usuario u = (Usuario) object;//casting
        String SQL = "UPDATE Usuario SET nome = ?, senha = ?, cargo = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {

            connection.setAutoCommit(false);//desligando transação automática

            statement.setString(1, u.getNome());
            statement.setString(2, u.getSenha());
            statement.setString(3, u.getCargo());
            statement.setInt(4, u.getId());

            statement.execute();

            connection.commit();//enviando transação

            try (ResultSet result = statement.getGeneratedKeys()) {

                while (result.next()) {
                    u.setId(result.getInt(1));
                }
            }
        } catch (SQLException e) {

            connection.rollback();//transação desfeita
            System.out.println("*** ROLLBACK EXECUTADO ***");
        }
    }

    @Override
    public void delete(Object object) throws SQLException {
        Usuario u = (Usuario) object;

        String SQL = "DELETE FROM Usuario WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(SQL)) {

            connection.setAutoCommit(false);//desligando transação automática

            statement.setInt(1, u.getId());

            statement.execute();

            System.out.println("REGISTROS DELETADOS: " + statement.getUpdateCount());

            connection.commit();//enviando transação

        } catch (SQLException e) {

            connection.rollback();//transação desfeita
            System.out.println("*** ROLLBACK EXECUTADO ***");
        }

    }

    public boolean check(Usuario u) throws SQLException {

        String SQL = "SELECT * FROM Usuario where nome = ? AND senha = ?";
        try (PreparedStatement statement = connection.prepareStatement(SQL)) {

            connection.setAutoCommit(false);//desligando transação automática

            statement.setString(1, u.getNome());
            statement.setString(2, u.getSenha());

            statement.execute();

            connection.commit();//enviando transação
            ResultSet result = statement.getResultSet();

            while (result.next()) {
                return true;
            }

        } catch (SQLException e) {

            connection.rollback();//transação desfeita
            System.out.println("*** ROLLBACK EXECUTADO ***");
            JOptionPane.showMessageDialog(null, "Transação não executada. Código: " + e);
        }
        return false;
    }

}
