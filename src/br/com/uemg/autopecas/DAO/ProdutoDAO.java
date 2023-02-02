/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.uemg.autopecas.DAO;

import br.com.uemg.autopecas.model.Fornecedor;
import br.com.uemg.autopecas.model.Categoria;
import br.com.uemg.autopecas.model.Fornecedor;
import br.com.uemg.autopecas.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gustavo
 */
public class ProdutoDAO {

    private final Connection connection;

    public ProdutoDAO(Connection connection) throws SQLException {

        this.connection = connection;
    }

    public void create(Produto p) throws SQLException {

        String SQL = "INSERT INTO Produto (categoria, fornecedor, descricao, custo, venda, estoque, quantidade, unidade) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        System.out.println(p);

        try (PreparedStatement statement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {

            connection.setAutoCommit(false);//desligando transação automática

            statement.setInt(1, p.getCategoria().getId());
            statement.setInt(2, p.getFornecedor().getId());
            statement.setString(3, p.getDescricao());
            statement.setFloat(4, p.getCusto());
            statement.setFloat(5, p.getVenda());
            statement.setInt(6, p.getEstoque());
            statement.setInt(7, p.getQuantidade());
            statement.setString(8, p.getUnidade());

            statement.execute();

            connection.commit();//enviando transação

            try (ResultSet result = statement.getGeneratedKeys()) {

                while (result.next()) {
                    p.setId(result.getInt(1));
                }
            }
        } catch (SQLException e) {

            connection.rollback();//transação desfeita
            System.out.println("*** ROLLBACK EXECUTADO ***");
        }
    }

    public List<Produto> read() throws SQLException {
        List<Produto> list = new ArrayList<>();
        String SQL = "SELECT * FROM Produto";

        try (PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.execute();

            ResultSet result = statement.getResultSet();

            while (result.next()) {
                Produto p = new Produto();

                p.setId(result.getInt("id"));
                p.setCategoria(
                        new Categoria(
                                result.getInt("categoria")
                        ));
                p.setFornecedor(
                        new Fornecedor(
                                result.getInt("fornecedor")
                        ));
                p.setDescricao(result.getString("descricao"));
                p.setCusto(result.getFloat("custo"));
                p.setVenda(result.getFloat("venda"));
                p.setEstoque(result.getInt("estoque"));
                p.setQuantidade(result.getInt("quantidade"));
                p.setUnidade(result.getString("unidade"));

                list.add(p);

            }
        } catch (SQLException e) {

            connection.rollback();//transação desfeita
            System.out.println("*** ROLLBACK EXECUTADO ***");
        }
        return list;
    }

    public List<Produto> read(Integer busca) throws SQLException {

        List<Produto> list = new ArrayList();

        String SQL = "SELECT * FROM Produto WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(SQL)) {

            statement.setInt(1, busca);
            statement.execute();

            ResultSet result = statement.getResultSet();

            while (result.next()) {
                Produto p = new Produto();

                p.setId(result.getInt("id"));
                p.setCategoria(
                        new Categoria(
                                result.getInt("categoria")
                        ));
                p.setFornecedor(
                        new Fornecedor(
                                result.getInt("fornecedor")
                        ));
                p.setDescricao(result.getString("descricao"));
                p.setCusto(result.getFloat("custo"));
                p.setVenda(result.getFloat("venda"));
                p.setEstoque(result.getInt("estoque"));
                p.setQuantidade(result.getInt("quantidade"));
                p.setUnidade(result.getString("unidade"));

                list.add(p);

            }
        } catch (SQLException e) {

            connection.rollback();//transação desfeita
            System.out.println("*** ROLLBACK EXECUTADO ***");
        }
        return list;
    }

    public List<Produto> read(String busca) throws SQLException {

        List<Produto> list = new ArrayList();

        String SQL = "SELECT * FROM Produto WHERE nome LIKE ?";

        try (PreparedStatement statement = connection.prepareStatement(SQL)) {

            statement.setString(1, "%" + busca + "%");
            statement.execute();

            ResultSet result = statement.getResultSet();

            while (result.next()) {
                Produto p = new Produto();

                p.setId(result.getInt("id"));
                p.setCategoria(
                        new Categoria(
                                result.getInt("categoria")
                        ));
                p.setFornecedor(
                        new Fornecedor(
                                result.getInt("fornecedor")
                        ));
                p.setDescricao(result.getString("descricao"));
                p.setCusto(result.getFloat("custo"));
                p.setVenda(result.getFloat("venda"));
                p.setEstoque(result.getInt("estoque"));
                p.setQuantidade(result.getInt("quantidade"));
                p.setUnidade(result.getString("unidade"));

                list.add(p);
            }
        } catch (SQLException e) {

            connection.rollback();//transação desfeita
            System.out.println("*** ROLLBACK EXECUTADO ***");
        }

        return list;
    }

    public void update(Produto p) throws SQLException {

        String SQL = "UPDATE Produto SET categoria = ?, fornecedor = ?, descricao = ?, custo = ?, venda = ?, estoque = ?, quantidade = ?, unidade = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {

            connection.setAutoCommit(false);//desligando transação automática

            statement.setInt(1, p.getCategoria().getId());
            statement.setInt(2, p.getFornecedor().getId());
            statement.setString(3, p.getDescricao());
            statement.setFloat(4, p.getCusto());
            statement.setFloat(5, p.getVenda());
            statement.setInt(6, p.getEstoque());
            statement.setInt(7, p.getQuantidade());
            statement.setString(8, p.getUnidade());
            statement.setInt(9, p.getId());

            statement.execute();

            connection.commit();//enviando transação

            try (ResultSet result = statement.getGeneratedKeys()) {

                while (result.next()) {
                    p.setId(result.getInt(1));
                }
            }
        } catch (SQLException e) {

            connection.rollback();//transação desfeita
            System.out.println("*** ROLLBACK EXECUTADO ***");
        }
    }

    public void delete(Produto p) throws SQLException {

        String SQL = "DELETE FROM Produto WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(SQL)) {

            connection.setAutoCommit(false);//desligando transação automática

            statement.setInt(1, p.getId());

            statement.execute();

            System.out.println("REGISTROS DELETADOS: " + statement.getUpdateCount());

            connection.commit();//enviando transação

        } catch (SQLException e) {

            connection.rollback();//transação desfeita
            System.out.println("*** ROLLBACK EXECUTADO ***");
        }
    }
}
