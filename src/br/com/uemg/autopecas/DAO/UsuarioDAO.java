/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.uemg.autopecas.DAO;

import br.com.uemg.autopecas.controller.ConnectionFactory;
import br.com.uemg.autopecas.model.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gustavo
 */
public class UsuarioDAO implements CRUD {

    private final Connection connection;

    public UsuarioDAO(Connection connection) throws SQLException {

        this.connection = connection;
    }

    @Override
    public void create(Object object) throws SQLException {

        Usuario u = (Usuario) object;//casting
        String SQL = "INSERT INTO Usuario (nome, senha) VALUES (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, u.getNome());
            statement.setString(2, u.getSenha());

            statement.execute();

            try (ResultSet result = statement.getGeneratedKeys()) {

                while (result.next()) {
                    u.setCodigo(result.getInt(1));
                }
            }
        }
    }

    @Override
    public List<Object> read() throws SQLException {

        List<Object> list = new ArrayList<>();
        String SQL = "SELECT * FROM Usuario";

        try (PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.execute();

            ResultSet result = statement.getResultSet();

            while (result.next()) {
                Usuario u = new Usuario();
                u.setCodigo(result.getInt("codigo"));
                u.setNome(result.getString("nome"));
                u.setSenha(result.getString("senha"));
                list.add(u);

            }
        }
        return list;

    }

    @Override
    public void update(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
