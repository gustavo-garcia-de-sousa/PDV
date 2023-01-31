package br.com.uemg.autopecas.test;

import br.com.uemg.autopecas.controller.ConnectionFactory;
import br.com.uemg.autopecas.DAO.FornecedorDAO;
import br.com.uemg.autopecas.model.Fornecedor;
import br.com.uemg.autopecas.model.Pessoa;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author gustavo
 */
public class TesteFornecedor {

    public static void main(String[] args) throws SQLException {

        try (Connection connection = new ConnectionFactory().getConnection()) {

            FornecedorDAO fd = new FornecedorDAO(connection);
            Fornecedor f = new Fornecedor(
                    0,
                    null,
                    "34 9895-3133",
                    "contato@dominio.com.br",
                    "GUSTAVO GARCIA DE SOUSA");

            f.setPessoa(
                    new Pessoa(
                            "CNPJ",
                            "32368873000148",
                            "QUEIROZ CONTABILIDADE",
                            "QUEIROZ SERVICOS CONTABEIS, CONSULTORIA E AUDITORIA EIRELI",
                            "01/07/2019",
                            "RUA PRUDENTE DE MORAIS, 316",
                            "CENTRO",
                            "FRUTAL",
                            "MG",
                            "32000-058"));

            //fd.create(f);
            //Fornecedor f = new Fornecedor(2);
            List<Fornecedor> list = fd.read();

            list.stream().forEach(x -> System.out.println(x));

            //fd.delete(f);
            f.setResponsavel("WEVERTON FURTADO");

            fd.update(f);

            list = fd.read();

            list.stream().forEach(x -> System.out.println(x));
        }

    }
}
