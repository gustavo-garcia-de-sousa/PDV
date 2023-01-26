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

            System.out.println(f.getPessoa().getCEP());

            statement.setString(1, f.getPessoa().getTipo());
            statement.setObject(2, f.getPessoa().getInscricao());
            statement.setString(3, f.getPessoa().getNome());
            statement.setObject(4, f.getPessoa().getApelido());
            statement.setObject(5, f.getPessoa().getNascimento());
            statement.setObject(6, f.getPessoa().getLogradouro());
            statement.setObject(7, f.getPessoa().getBairro());
            statement.setObject(8, f.getPessoa().getCidade());
            statement.setObject(9, f.getPessoa().getUf());
            statement.setObject(10, f.getPessoa().getCEP());
            statement.setObject(11, f.getContato());
            statement.setObject(12, f.getEmail());
            statement.setObject(13, f.getResponsavel());

            statement.execute();

            connection.commit();//enviando transação

            try (ResultSet result = statement.getGeneratedKeys()) {

                while (result.next()) {
                    f.setId(result.getInt(1));
                }
            }
        } catch (SQLException e) {

            connection.rollback();//transação desfeita
            System.out.println("rollback executado");
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Object object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
