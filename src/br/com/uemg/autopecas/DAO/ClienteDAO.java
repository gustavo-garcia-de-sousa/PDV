package br.com.uemg.autopecas.DAO;

import br.com.uemg.autopecas.model.Cliente;
import br.com.uemg.autopecas.model.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gustavo
 */
public class ClienteDAO implements CRUD {

    private final Connection connection;

    public ClienteDAO(Connection connection) throws SQLException {

        this.connection = connection;
    }

    @Override
    public void create(Object object) throws SQLException {
        Cliente c = (Cliente) object;//casting
        String SQL = "INSERT INTO Cliente (tipo, inscricao, nome, apelido, nascimento, logradouro, bairro, cidade, uf, cep, contato, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {

            connection.setAutoCommit(false);//desligando transação automática

            statement.setString(1, c.getPessoa().getTipo());
            statement.setString(2, c.getPessoa().getInscricao());
            statement.setString(3, c.getPessoa().getNome());
            statement.setString(4, c.getPessoa().getApelido());
            statement.setString(5, c.getPessoa().getNascimento());
            statement.setString(6, c.getPessoa().getLogradouro());
            statement.setString(7, c.getPessoa().getBairro());
            statement.setString(8, c.getPessoa().getCidade());
            statement.setString(9, c.getPessoa().getUf());
            statement.setString(10, c.getPessoa().getCEP());
            statement.setString(11, c.getContato());
            statement.setString(12, c.getEmail());

            statement.execute();

            connection.commit();//enviando transação

            try (ResultSet result = statement.getGeneratedKeys()) {

                while (result.next()) {
                    c.setId(result.getInt(1));
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
        String SQL = "SELECT * FROM Cliente";

        try (PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.execute();

            ResultSet result = statement.getResultSet();

            while (result.next()) {
                Cliente c = new Cliente();

                c.setId(result.getInt("id"));
                c.setPessoa(
                        new Pessoa(
                                result.getString("tipo"),
                                result.getString("inscricao"),
                                result.getString("apelido"),
                                result.getString("nome"),
                                result.getString("nascimento"),
                                result.getString("logradouro"),
                                result.getString("bairro"),
                                result.getString("cidade"),
                                result.getString("uf"),
                                result.getString("cep")
                        ));

                list.add(c);

            }
        }
        return list;
    }

    public List<Object> read(Object object) throws SQLException {
        List<Object> list = new ArrayList<>();
        Cliente c = (Cliente) object;//casting
        String SQL = "SELECT * FROM Cliente WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(SQL)) {

            statement.setInt(1, c.getId());

            statement.execute();

            ResultSet result = statement.getResultSet();

            c.setId(result.getInt("id"));
            c.setPessoa(
                    new Pessoa(
                            result.getString("tipo"),
                            result.getString("inscricao"),
                            result.getString("apelido"),
                            result.getString("nome"),
                            result.getString("nascimento"),
                            result.getString("logradouro"),
                            result.getString("bairro"),
                            result.getString("cidade"),
                            result.getString("uf"),
                            result.getString("cep")
                    ));

            list.add(c);

        }
        return list;
    }

    @Override
    public void update(Object object) throws SQLException {
        Cliente c = (Cliente) object;//casting
        String SQL = "UPDATE Cliente SET tipo = ?, inscricao = ?, nome = ?, apelido = ?, nascimento = ?, logradouro = ?, bairro = ?, cidade = ?, uf = ?, cep = ?, contato = ?, email =? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {

            connection.setAutoCommit(false);//desligando transação automática

            statement.setString(1, c.getPessoa().getTipo());
            statement.setString(2, c.getPessoa().getInscricao());
            statement.setString(3, c.getPessoa().getNome());
            statement.setString(4, c.getPessoa().getApelido());
            statement.setString(5, c.getPessoa().getNascimento());
            statement.setString(6, c.getPessoa().getLogradouro());
            statement.setString(7, c.getPessoa().getBairro());
            statement.setString(8, c.getPessoa().getCidade());
            statement.setString(9, c.getPessoa().getUf());
            statement.setString(10, c.getPessoa().getCEP());
            statement.setString(11, c.getContato());
            statement.setString(12, c.getEmail());
            statement.setInt(13, c.getId());

            statement.execute();

            connection.commit();//enviando transação

            try (ResultSet result = statement.getGeneratedKeys()) {

                while (result.next()) {
                    c.setId(result.getInt(1));
                }
            }
        } catch (SQLException e) {

            connection.rollback();//transação desfeita
            System.out.println("*** ROLLBACK EXECUTADO ***");
        }
    }

    @Override
    public void delete(Object object) throws SQLException {
        Cliente c = (Cliente) object;

        String SQL = "DELETE FROM Cliente WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(SQL)) {

            connection.setAutoCommit(false);//desligando transação automática

            statement.setInt(1, c.getId());

            statement.execute();

            System.out.println("REGISTROS DELETADOS: " + statement.getUpdateCount());

            connection.commit();//enviando transação

        } catch (SQLException e) {

            connection.rollback();//transação desfeita
            System.out.println("*** ROLLBACK EXECUTADO ***");
        }
    }
}
