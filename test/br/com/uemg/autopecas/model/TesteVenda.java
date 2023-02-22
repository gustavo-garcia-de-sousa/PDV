package br.com.uemg.autopecas.model;

import br.com.uemg.autopecas.controller.ConnectionFactory;
import java.sql.Connection;
import br.com.uemg.autopecas.DAO.PedidoDAO;
import java.util.List;

/**
 *
 * @author gustavo
 */
public class TesteVenda {

    public static void main(String[] args) {

        Pedido p = new Pedido(0,
                new Cliente(11),
                100.0,
                0.0,
                100.0,
                "À VISTA"
        );

        try (Connection connection = new ConnectionFactory().getConnection()) {

            PedidoDAO dao = new PedidoDAO(connection);

            //dao.create(p);
            for (Pedido pedido : dao.read()) {
                
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
