package br.com.uemg.autopecas.DAO;

import br.com.uemg.autopecas.model.Fornecedor;
import br.com.uemg.autopecas.model.Fornecedor;
import br.com.uemg.autopecas.model.Pessoa;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gustavo
 */
public class FornecedorDAO implements CRUD {

    private final Connection connection;

    public FornecedorDAO(Connection connection) throws SQLException {

        this.connection = connection;
    }

    @Override
    public void create(Object object) throws SQLException {
        Fornecedor f = (Fornecedor) object;//casting
        String SQL = "INSERT INTO Fornecedor (tipo, inscricao, nome, apelido, nascimento, logradouro, bairro, cidade, uf, cep, contato, email, responsavel) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {

            connection.setAutoCommit(false);//desligando transação automática

            statement.setString(1, f.getPessoa().getTipo());
            statement.setString(2, f.getPessoa().getInscricao());
            statement.setString(3, f.getPessoa().getNome());
            statement.setString(4, f.getPessoa().getApelido());
            statement.setString(5, f.getPessoa().getNascimento());
            statement.setString(6, f.getPessoa().getLogradouro());
            statement.setString(7, f.getPessoa().getBairro());
            statement.setString(8, f.getPessoa().getCidade());
            statement.setString(9, f.getPessoa().getUf());
            statement.setString(10, f.getPessoa().getCEP());
            statement.setString(11, f.getContato());
            statement.setString(12, f.getEmail());
            statement.setString(13, f.getResponsavel());

            statement.execute();

            connection.commit();//enviando transação

            try (ResultSet result = statement.getGeneratedKeys()) {

                while (result.next()) {
                    f.setId(result.getInt(1));
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
        String SQL = "SELECT * FROM Fornecedor";

        try (PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.execute();

            ResultSet result = statement.getResultSet();

            while (result.next()) {
                Fornecedor f = new Fornecedor();

                f.setId(result.getInt("id"));
                f.setPessoa(
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

                list.add(f);

            }
        }
        return list;
    }

    @Override
    public void update(Object object) throws SQLException {
        Fornecedor f = (Fornecedor) object;//casting
        String SQL = "UPDATE Fornecedor SET tipo = ?, inscricao = ?, nome = ?, apelido = ?, nascimento = ?, logradouro = ?, bairro = ?, cidade = ?, uf = ?, cep = ?, contato = ?, email =?, responsavel = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {

            connection.setAutoCommit(false);//desligando transação automática

            statement.setString(1, f.getPessoa().getTipo());
            statement.setString(2, f.getPessoa().getInscricao());
            statement.setString(3, f.getPessoa().getNome());
            statement.setString(4, f.getPessoa().getApelido());
            statement.setString(5, f.getPessoa().getNascimento());
            statement.setString(6, f.getPessoa().getLogradouro());
            statement.setString(7, f.getPessoa().getBairro());
            statement.setString(8, f.getPessoa().getCidade());
            statement.setString(9, f.getPessoa().getUf());
            statement.setString(10, f.getPessoa().getCEP());
            statement.setString(11, f.getContato());
            statement.setString(12, f.getEmail());
            statement.setString(13, f.getResponsavel());
            statement.setInt(14, f.getId());

            statement.execute();

            connection.commit();//enviando transação

            try (ResultSet result = statement.getGeneratedKeys()) {

                while (result.next()) {
                    f.setId(result.getInt(1));
                }
            }
        } catch (SQLException e) {

            connection.rollback();//transação desfeita
            System.out.println("*** ROLLBACK EXECUTADO ***");
        }
    }

    @Override
    public void delete(Object object) throws SQLException {
        Fornecedor f = (Fornecedor) object;

        String SQL = "DELETE FROM Fornecedor WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(SQL)) {

            connection.setAutoCommit(false);//desligando transação automática

            statement.setInt(1, f.getId());

            statement.execute();

            System.out.println("REGISTROS DELETADOS: " + statement.getUpdateCount());

            connection.commit();//enviando transação

        } catch (SQLException e) {

            connection.rollback();//transação desfeita
            System.out.println("*** ROLLBACK EXECUTADO ***");
        }
    }

}
