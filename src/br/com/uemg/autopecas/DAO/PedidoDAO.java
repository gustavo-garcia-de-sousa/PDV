package br.com.uemg.autopecas.DAO;

import br.com.uemg.autopecas.model.Categoria;
import br.com.uemg.autopecas.model.Cliente;
import br.com.uemg.autopecas.model.Fornecedor;
import br.com.uemg.autopecas.model.Pedido;
import br.com.uemg.autopecas.model.Pessoa;
import br.com.uemg.autopecas.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gustavo
 */
public class PedidoDAO {

    private final Connection connection;

    public PedidoDAO(Connection connection) throws SQLException {

        this.connection = connection;
    }

    public int next() throws SQLException {

        String SQL = "SELECT COALESCE(MAX(ID), 0) + 1 AS PROXIMO_REGISTRO FROM Pedido";

        try (PreparedStatement statement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {

            connection.setAutoCommit(false);//desligando transação automática

            statement.execute();

            connection.commit();//enviando transação

            ResultSet result = statement.getResultSet();

            while (result.next()) {

                return result.getInt(1);

            }

            return 0;

        } catch (SQLException e) {

            connection.rollback();//transação desfeita
            System.out.println("*** ROLLBACK EXECUTADO ***");
            JOptionPane.showMessageDialog(null, "Transação não executada. Código: " + e);

            System.out.println("*** EXCEÇÃO: ***");
            System.out.println(e);
            System.out.println("*** EXCEÇÃO ***");
        }

        return 0;

    }

    public void create(Pedido p) throws SQLException {

        String SQL = "INSERT INTO Pedido (cliente, subtotal, desconto, total, pagamento) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {

            connection.setAutoCommit(false);//desligando transação automática

            statement.setObject(1, p.getCliente().getId());
            statement.setDouble(2, p.getSubtotal());
            statement.setDouble(3, p.getDesconto());
            statement.setDouble(4, p.getTotal());
            statement.setString(5, p.getPagamento());

            statement.execute();

            connection.commit();//enviando transação

            System.out.println(p);

            try (ResultSet result = statement.getGeneratedKeys()) {

                while (result.next()) {
                    p.setId(result.getInt(1));
                }
            }
        } catch (SQLException e) {

            connection.rollback();//transação desfeita
            System.out.println("*** ROLLBACK EXECUTADO ***");
            JOptionPane.showMessageDialog(null, "Transação não executada. Código: " + e);
        }
    }

    public List<Pedido> read() throws SQLException {

        List<Pedido> list = new ArrayList<>();

        String SQL = "SELECT Pedido.id, Pedido.cliente, Cliente.nome, Pedido.subtotal, Pedido.desconto, Pedido.total, Pedido.pagamento, Pedido.data"
                + " FROM Pedido"
                + " INNER JOIN Cliente ON Pedido.cliente = Cliente.id ";

        try (PreparedStatement statement = connection.prepareStatement(SQL)) {
            connection.setAutoCommit(false);//desligando transação automática

            statement.execute();

            ResultSet result = statement.getResultSet();

            while (result.next()) {

                Pedido p = new Pedido();

                p.setId(result.getInt("Pedido.id"));

                Cliente cliente = new Cliente();
                cliente.setId(result.getInt("Pedido.cliente"));
                cliente.setPessoa(new Pessoa(result.getString("Cliente.nome")));

                p.setCliente(cliente);

                p.setSubtotal(result.getDouble("Pedido.subtotal"));
                p.setDesconto(result.getDouble("Pedido.desconto"));
                p.setTotal(result.getDouble("Pedido.total"));
                p.setPagamento(result.getString("Pedido.pagamento"));
                p.setData(result.getDate("Pedido.data"));

                list.add(p);

                connection.commit();//enviando transação
            }
        } catch (SQLException e) {

            connection.rollback();//transação desfeita
            System.out.println("*** ROLLBACK EXECUTADO ***");
            JOptionPane.showMessageDialog(null, "Transação não executada. Código: " + e);
        }
        return list;
    }

    public List<Pedido> read(Integer busca) throws SQLException {

        List<Pedido> list = new ArrayList<>();
        String SQL = "SELECT Pedido_Produto.pedido, Pedido.cliente, Cliente.nome, Pedido.pagamento, Pedido.subtotal, Pedido.desconto, Pedido.total, Pedido_Produto.produto, Produto.descricao, Produto.venda, Pedido_Produto.quantidade, Pedido_Produto.desconto\n"
                + "FROM Pedido_Produto \n"
                + "INNER JOIN Pedido ON Pedido_Produto.pedido = Pedido.id \n"
                + "INNER JOIN Produto ON Pedido_Produto.produto = Produto.id\n"
                + "INNER JOIN Cliente ON Pedido.cliente = Cliente.id\n"
                + "WHERE Pedido.id = ?";

        try (PreparedStatement statement = connection.prepareStatement(SQL)) {
            connection.setAutoCommit(false);//desligando transação automática

            statement.setInt(1, busca);
            statement.execute();

            ResultSet result = statement.getResultSet();

            while (result.next()) {

                Pedido p = new Pedido();

                p.setId(result.getInt("Pedido_Produto.pedido"));

                Cliente cliente = new Cliente();
                cliente.setId(result.getInt("Pedido.cliente"));
                cliente.setPessoa(new Pessoa(result.getString("Cliente.nome")));

                p.setCliente(cliente);

                p.setSubtotal(result.getDouble("Pedido.subtotal"));
                p.setDesconto(result.getDouble("Pedido.desconto"));
                p.setTotal(result.getDouble("Pedido.total"));
                p.setPagamento(result.getString("Pedido.pagamento"));

                list.add(p);

                connection.commit();//enviando transação
            }

        } catch (SQLException e) {

            connection.rollback();//transação desfeita
            System.out.println("*** ROLLBACK EXECUTADO ***");
            JOptionPane.showMessageDialog(null, "Transação não executada. Código: " + e);
        }
        return list;
    }

}
