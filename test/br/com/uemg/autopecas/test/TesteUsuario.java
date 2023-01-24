/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.uemg.autopecas.test;

import br.com.uemg.autopecas.controller.ConnectionFactory;
import br.com.uemg.autopecas.DAO.UsuarioDAO;
import br.com.uemg.autopecas.model.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author gustavo
 */
public class TesteUsuario {

    public static void main(String[] args) throws SQLException {

        try (Connection connection = new ConnectionFactory().getConnection()) {

            connection.setAutoCommit(false);//desligando o controle transacional default
            UsuarioDAO ud = new UsuarioDAO(connection);
            Usuario u = new Usuario();

            //u.create(new Usuario("CEDAN", "1234"));
            List<Object> list = ud.read();
            list.stream().forEach(x -> System.out.println(x));
            u.setCodigo(5);
            ud.delete(u);
            list.stream().forEach(x -> System.out.println(x));

        }

    }
}
