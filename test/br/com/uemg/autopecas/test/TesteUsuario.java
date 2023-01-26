/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.uemg.autopecas.test;

import br.com.uemg.autopecas.controller.ConnectionFactory;
import br.com.uemg.autopecas.DAO.UsuarioDAO;
import br.com.uemg.autopecas.model.EnumUsuario;
import br.com.uemg.autopecas.model.Usuario;
import br.com.uemg.autopecas.model.Vendedor;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author gustavo
 */
public class TesteUsuario {

    public static void main(String[] args) throws SQLException {

        try (Connection connection = new ConnectionFactory().getConnection()) {

            UsuarioDAO ud = new UsuarioDAO(connection);
            Usuario u = new Vendedor();

            //u.create(new Usuario("CEDAN", "1234"));
            List<Object> list = ud.read();
            list.stream().forEach(x -> System.out.println(x));
            u.setId(6);
            u.setNome("THAYSA");
            u.setSenha("1303");
            u.setCargo(EnumUsuario.CAIXA);
            ud.update(u);
            //ud.delete(u);
            list = ud.read();
            list.stream().forEach(x -> System.out.println(x));

        }

    }
}
