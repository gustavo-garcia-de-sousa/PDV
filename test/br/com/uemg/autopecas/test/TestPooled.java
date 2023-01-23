/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.uemg.autopecas.test;

import br.com.uemg.autopecas.controller.ConnectionFactory;
import java.sql.SQLException;

/**
 *
 * @author gustavo
 */
public class TestPooled {

    public static void main(String[] args) throws SQLException {
        ConnectionFactory connection = new ConnectionFactory();

        for (int i = 1; i < 12; i++) {
            connection.getConnection();
            System.out.println(i);
        }

    }

}
