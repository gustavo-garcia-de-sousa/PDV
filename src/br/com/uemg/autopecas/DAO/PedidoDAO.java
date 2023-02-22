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

        String SQL = "SELECT Pedido.id, Pedido_Produto.pedido, Pedido_Produto.produto, Pedido.cliente, Cliente.nome, Produto.descricao, Pedido.subtotal, Pedido.desconto, Pedido.total, Pedido.pagamento"
                + " FROM Pedido_Produto"
                + " INNER JOIN Pedido ON Pedido_Produto.pedido = Pedido.id"
                + " INNER JOIN Produto ON Pedido_Produto.produto = Produto.id"
                + " INNER JOIN Cliente ON Pedido.cliente = Cliente.id ";

        try (PreparedStatement statement = connection.prepareStatement(SQL)) {
            connection.setAutoCommit(false);//desligando transação automática

            statement.execute();

            ResultSet result = statement.getResultSet();

            while (result.next()) {

                Pedido p = new Pedido();

                p.setId(result.getInt("Pedido.id"));

                System.out.println(p.getId());

                Cliente cliente = new Cliente();
                cliente.setId(result.getInt("Pedido.cliente"));
                cliente.setPessoa(new Pessoa("Cliente.nome"));

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

    public List<Pedido> read(Integer busca) throws SQLException {

        List<Pedido> list = new ArrayList<>();
        String SQL = "SELECT Pedido.id, Pedido.cliente, Pedido.subtotal, Pedido.desconto, Pedido.total, Produto.pagamento FROM Pedido "
                + "INNER JOIN Cliente ON Pedido.cliente = Cliente.id WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(SQL)) {
            connection.setAutoCommit(false);//desligando transação automática

            statement.setInt(1, busca);
            statement.execute();

            ResultSet result = statement.getResultSet();

            while (result.next()) {

                Pedido p = new Pedido();

                p.setId(result.getInt("Pedido.id"));

                Cliente cliente = new Cliente();
                cliente.setId(result.getInt("Pedido.categoria"));

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

    public List<Produto> read(String busca) throws SQLException {

        List<Produto> list = new ArrayList();

        String SQL = "SELECT * FROM Produto WHERE descricao LIKE ?";

        try (PreparedStatement statement = connection.prepareStatement(SQL)) {
            connection.setAutoCommit(false);//desligando transação automática
            statement.setString(1, "%" + busca + "%");
            statement.execute();

            ResultSet result = statement.getResultSet();

            while (result.next()) {
                Produto p = new Produto();

                p.setId(result.getInt("id"));

                Categoria categoria = new Categoria();
                categoria.setId(result.getInt("categoria"));
                p.setCategoria(categoria);

                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId(result.getInt("fornecedor"));
                p.setFornecedor(fornecedor);

                p.setDescricao(result.getString("descricao"));
                p.setCusto(result.getDouble("custo"));
                p.setVenda(result.getDouble("venda"));
                p.setEstoque(result.getInt("estoque"));
                p.setQuantidade(result.getInt("quantidade"));
                p.setUnidade(result.getString("unidade"));

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

    public void update(Produto p) throws SQLException {

        String SQL = "UPDATE Produto SET categoria = ?, fornecedor = ?, descricao = ?, custo = ?, venda = ?, estoque = ?, quantidade = ?, unidade = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {

            System.out.println(p);

            statement.setInt(1, p.getCategoria().getId());
            statement.setInt(2, p.getFornecedor().getId());
            statement.setString(3, p.getDescricao());
            statement.setDouble(4, p.getCusto());
            statement.setDouble(5, p.getVenda());
            statement.setInt(6, p.getEstoque());
            statement.setInt(7, p.getQuantidade());
            statement.setString(8, p.getUnidade());
            statement.setInt(9, p.getId());

            statement.execute();

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

    public void delete(Produto p) throws SQLException {

        String SQL = "DELETE FROM Produto WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(SQL)) {

            connection.setAutoCommit(false);//desligando transação automática

            statement.setInt(1, p.getId());

            statement.execute();

            System.out.println("REGISTROS DELETADOS: " + statement.getUpdateCount());

            connection.commit();//enviando transação

        } catch (SQLException e) {

            connection.rollback();//transação desfeita
            System.out.println("*** ROLLBACK EXECUTADO ***");
            JOptionPane.showMessageDialog(null, "Transação não executada. Código: " + e);
        }
    }
}
