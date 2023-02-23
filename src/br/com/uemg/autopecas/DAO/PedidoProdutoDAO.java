package br.com.uemg.autopecas.DAO;

import br.com.uemg.autopecas.model.Categoria;
import br.com.uemg.autopecas.model.Cliente;
import br.com.uemg.autopecas.model.Fornecedor;
import br.com.uemg.autopecas.model.Pedido;
import br.com.uemg.autopecas.model.PedidoProduto;
import br.com.uemg.autopecas.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gustavo
 */
public class PedidoProdutoDAO {

    private final Connection connection;

    public PedidoProdutoDAO(Connection connection) throws SQLException {

        this.connection = connection;
    }

    public void create(PedidoProduto pp) throws SQLException {

        String SQL = "INSERT INTO Pedido_Produto (pedido, produto, quantidade, subtotal, desconto, total) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {

            connection.setAutoCommit(false);//desligando transação automática

            statement.setObject(1, pp.getPedido().getId());
            statement.setObject(2, pp.getProduto().getId());
            statement.setInt(3, pp.getQuantidade());
            statement.setDouble(4, pp.getSubtotal());
            statement.setDouble(5, pp.getDesconto());
            statement.setDouble(6, pp.getTotal());

            statement.execute();

            connection.commit();//enviando transação

            try (ResultSet result = statement.getGeneratedKeys()) {

                while (result.next()) {
                    pp.setId(result.getInt(1));
                }
            }
        } catch (SQLException e) {

            connection.rollback();//transação desfeita
            System.out.println("*** ROLLBACK EXECUTADO ***");
            JOptionPane.showMessageDialog(null, "Transação não executada. Código: " + e);
        }
    }

    public List<PedidoProduto> read(Integer busca) throws SQLException {

        List<PedidoProduto> list = new ArrayList<>();
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

                PedidoProduto p = new PedidoProduto();

                p.setId(result.getInt("Pedido_Produto.pedido"));
                p.setProduto(new Produto());
                p.getProduto().setVenda(result.getDouble("Produto.venda"));
                p.getProduto().setDescricao(result.getString("Produto.descricao"));
p.setDesconto(Double.NaN);
                

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
