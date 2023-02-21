package br.com.uemg.autopecas.DAO;

import br.com.uemg.autopecas.model.Pedido;
import br.com.uemg.autopecas.model.PedidoProduto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

}
