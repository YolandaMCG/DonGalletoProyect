/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.bd;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ycuel
 */
public class ConexionMysql {

    Connection conn;

    public Connection open() {
        String user = "yolanda";
        String password = "1234";
        String url = "jdbc:mysql://127.0.0.1:3306/libreria2";
        String parametros = "?useSSL=false&useUnicode=true&characterEncoding=utf-8"; //cambiar registro para el otro en el url 

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url + parametros, user, password);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void close() {
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException();
            }
        }
    }

}
