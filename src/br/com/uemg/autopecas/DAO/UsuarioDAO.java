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
public class UsuarioDAO {

    private final Connection connection;
    private Usuario usuario;

    public UsuarioDAO(Connection connection) throws SQLException {

        this.connection = connection;
    }

    public void create(Usuario u) throws SQLException {

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

    public List<Usuario> read() throws SQLException {

        List<Usuario> list = new ArrayList<>();
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

    public void update(Usuario u) throws SQLException {

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

    public void delete(Usuario u) throws SQLException {

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

        String SQL = "SELECT nome, senha, cargo FROM Usuario where nome = ? AND senha = ?";
        try (PreparedStatement statement = connection.prepareStatement(SQL)) {

            connection.setAutoCommit(false);//desligando transação automática

            statement.setString(1, u.getNome());
            statement.setString(2, u.getSenha());

            statement.execute();

            connection.commit();//enviando transação

            ResultSet result = statement.getResultSet();

            while (result.next()) {

                System.out.println(result.getString("cargo"));

                u.setNome(result.getString("nome"));
                u.setCargo(result.getString("cargo"));
                
                setUsuario(u);

                return true;
            }

        } catch (SQLException e) {

            connection.rollback();//transação desfeita
            System.out.println("*** ROLLBACK EXECUTADO ***");
            JOptionPane.showMessageDialog(null, "Transação não executada. Código: " + e);
        }
        return false;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
