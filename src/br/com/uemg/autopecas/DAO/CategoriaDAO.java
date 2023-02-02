package br.com.uemg.autopecas.DAO;

import br.com.uemg.autopecas.controller.ConnectionFactory;
import br.com.uemg.autopecas.model.Categoria;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CategoriaDAO {

    private final Connection connection;

    public CategoriaDAO(Connection connection) throws SQLException {

        this.connection = connection;
    }

    public void create(Categoria c) throws SQLException {

        String SQL = "INSERT INTO Categoria (descricao) VALUES (?)";

        try (PreparedStatement statement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {

            connection.setAutoCommit(false);//desligando transação automática

            statement.setString(1, c.getDescricao());

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

    public List<Categoria> read() throws SQLException {
        List<Categoria> list = new ArrayList<>();
        String SQL = "SELECT * FROM Categoria";

        try (PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.execute();

            ResultSet result = statement.getResultSet();

            while (result.next()) {
                Categoria c = new Categoria();

                c.setId(result.getInt("id"));
                c.setDescricao(result.getString("descricao"));

                list.add(c);

            }
        } catch (SQLException e) {

            connection.rollback();//transação desfeita
            System.out.println("*** ROLLBACK EXECUTADO ***");
        }
        return list;
    }

    public List<Categoria> read(String busca) throws SQLException {

        List<Categoria> list = new ArrayList();

        String SQL = "SELECT * FROM Categoria WHERE descricao LIKE ?";

        try (PreparedStatement statement = connection.prepareStatement(SQL)) {

            statement.setString(1, "%" + busca + "%");
            statement.execute();

            ResultSet result = statement.getResultSet();

            while (result.next()) {
                Categoria c = new Categoria();

                c.setId(result.getInt("id"));
                c.setDescricao(result.getString("descricao"));

                list.add(c);
            }
        } catch (SQLException e) {

            connection.rollback();//transação desfeita
            System.out.println("*** ROLLBACK EXECUTADO ***");
        }

        return list;
    }

    public void update(Categoria c) throws SQLException {

        System.out.println("método update DAO: " + c);

        String SQL = "UPDATE Categoria SET descricao = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {

            connection.setAutoCommit(false);//desligando transação automática

            statement.setString(1, c.getDescricao());
            statement.setInt(2, c.getId());

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

    public void delete(Categoria c) throws SQLException {

        String SQL = "DELETE FROM Categoria WHERE id = ?";

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
