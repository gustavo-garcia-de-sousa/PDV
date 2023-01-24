/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.uemg.autopecas.test;

import br.com.uemg.autopecas.controller.ConnectionFactory;
import br.com.uemg.autopecas.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gustavo
 */
public class Err {

    public static void main(String[] args) throws SQLException {
        String str1 = "java";
        String str2 = "JAVA";

        System.out.println(str1 = str2);

        try {
            System.out.println("one");
            System.exit(1);
        } catch (Exception e) {
            System.out.println("two");
        } finally {
            System.out.println("three");
        }
    }

}
