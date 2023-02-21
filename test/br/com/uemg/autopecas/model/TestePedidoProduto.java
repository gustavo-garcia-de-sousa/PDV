package br.com.uemg.autopecas.model;

import br.com.uemg.autopecas.DAO.PedidoProdutoDAO;
import br.com.uemg.autopecas.controller.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author gustavo
 */
public class TestePedidoProduto {

    public static void main(String[] args) throws SQLException {

        try (Connection connection = new ConnectionFactory().getConnection()) {
            PedidoProdutoDAO dao = new PedidoProdutoDAO(connection);

            PedidoProduto pp = new PedidoProduto(0,
                    new Pedido(1), new Produto(1), 10, 20.0, 5.0, 15.0);

            //dao.create(pp);
            
        }
        
        

    }

}
