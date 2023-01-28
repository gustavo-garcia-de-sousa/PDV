package br.com.uemg.autopecas.test;

import br.com.uemg.autopecas.DAO.ClienteDAO;
import br.com.uemg.autopecas.controller.ConnectionFactory;
import br.com.uemg.autopecas.model.Cliente;
import br.com.uemg.autopecas.model.Pessoa;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author gustavo
 */
public class TesteCliente {
    
    public static void main(String[] args) throws SQLException {
        
        try (Connection connection = new ConnectionFactory().getConnection()) {
            
            ClienteDAO cd = new ClienteDAO(connection);
            
            Cliente c = new Cliente(
                    0,
                    null,
                    "34 9895-3133",
                    "contato@dominio.com.br"
            );
            
            c.setPessoa(
                    new Pessoa(
                            "CPF",
                            "12912912975",
                            "GUSTAVO GARCIA DE SOUSA",
                            "GUSTAVO GARCIA DE SOUSA",
                            "09/09/2005",
                            "RUA JOAO RAIMUNDO, 1211",
                            "NOVA ESPERANCA",
                            "FRUTAL",
                            "MG",
                            "32000-072"));

            //cd.create(c);
            Cliente cc = new Cliente();
            System.out.println();
            cc.setId(4);
            
            List<Cliente> list = cd.read(cc.getId());
            list.stream().forEach(x -> System.out.println(x));

            //cd.delete(cc);
            cc.setPessoa(new Pessoa());
            cc.getPessoa().setApelido("GUSTAVO GARCIA");
            
            cd.update(cc);

            //list = cd.read();
            list.stream().forEach(x -> System.out.println(x));
        }
        
    }
}
