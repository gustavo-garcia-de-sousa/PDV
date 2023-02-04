package br.com.uemg.autopecas.model;

import br.com.uemg.autopecas.controller.ConnectionFactory;

import br.com.uemg.autopecas.DAO.ProdutoDAO;
import br.com.uemg.autopecas.model.Categoria;
import br.com.uemg.autopecas.model.Fornecedor;
import br.com.uemg.autopecas.model.Pessoa;

import br.com.uemg.autopecas.model.Produto;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author gustavo
 */
public class TesteProduto {

    public static void main(String[] args) throws SQLException {

        try (Connection connection = new ConnectionFactory().getConnection()) {

            ProdutoDAO dao = new ProdutoDAO(connection);
            Produto p = new Produto();

            p.setId(0);

            p.setDescricao("descricao");

            dao.create(p);

            List<Produto> list = dao.read();

            list.stream().forEach(x -> System.out.println(x));

            //fd.delete(f);
            //dao.update(p);
            list = dao.read();

            list.stream().forEach(x -> System.out.println(x));
        }

    }
}
