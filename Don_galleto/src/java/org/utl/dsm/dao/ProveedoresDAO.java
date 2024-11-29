/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.utl.dsm.bd.ConexionMysql;
import org.utl.dsm.model.Proveedor;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author ycuel
 */
public class ProveedoresDAO {

    public String validar(String user, String password) throws SQLException {
        String query = "SELECT rol FROM usuario WHERE user = ? AND password = ?";
        ConexionMysql conexion = new ConexionMysql();
        Connection conn = conexion.open();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String rol = null;

        try {
            stmt = conn.prepareStatement(query);
            stmt.setString(1, user);
            stmt.setString(2, password);

            rs = stmt.executeQuery();
            if (rs.next()) {
                rol = rs.getString("rol");  // Obtener el rol del usuario
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            conexion.close();
        }
        return rol;
    }

    ///insert
    public boolean insertar(Proveedor usuario) throws SQLException {
        String query = "INSERT INTO usuario (user, password, rol, estatus) VALUES (?, ?, ?, ?)";
        try (Connection conn = new ConexionMysql().open(); PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, usuario.getUser());
            ps.setString(2, usuario.getPassword());
            ps.setString(3, usuario.getRol());
            ps.setString(4, "activo");
            return ps.executeUpdate() > 0;
        }
    }

    public boolean actualizar(Proveedor usuario) throws SQLException {
        String query = "UPDATE usuario SET user = ?, password = ?, rol = ? WHERE idUsuario = ?";
        try (Connection conn = new ConexionMysql().open(); PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, usuario.getUser());
            ps.setString(2, usuario.getPassword());
            ps.setString(3, usuario.getRol());
            ps.setInt(4, usuario.getIdUsuario());
            return ps.executeUpdate() > 0;
        }
    }

    public boolean cambiarEstatus(int idUsuario, String estatus) throws SQLException {
        String query = "UPDATE usuario SET estatus = ? WHERE idUsuario = ?";
        try (Connection conn = new ConexionMysql().open(); PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, estatus);
            ps.setInt(2, idUsuario);
            return ps.executeUpdate() > 0;
        }
    }

    public List<Proveedor> obtenerTodos() throws Exception {
        try (Connection conn = new ConexionMysql().open()) {
            String query = "SELECT idUsuario, user, password, rol, estatus FROM usuario";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            List<Proveedor> listaUsuarios = new ArrayList<>();
            while (rs.next()) {
                Proveedor usuario = new Proveedor();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setUser(rs.getString("user"));
                usuario.setPassword(rs.getString("password"));
                usuario.setRol(rs.getString("rol"));
                usuario.setEstatus(rs.getString("estatus"));
                listaUsuarios.add(usuario);
            }
            return listaUsuarios;
        }
    }

}
