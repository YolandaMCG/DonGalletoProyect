/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.utl.dsm.bd.ConexionMysql;
import org.utl.dsm.model.Compras;

/**
 *
 * @author ycuel
 */
public class ComprasDAO {

    public boolean insertar(Compras libro) throws Exception {
        try (Connection conn = new ConexionMysql().open()) {
            String query = "INSERT INTO libros (nombre, autor, genero, estatus, archivo, imgPortada) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, libro.getNombre());
            ps.setString(2, libro.getAutor());
            ps.setString(3, libro.getGenero());
            ps.setString(4, libro.getEstatus());
            ps.setBytes(5, libro.getArchivo());
            ps.setBytes(6, libro.getImgPortada());

            int rowsInserted = ps.executeUpdate();
            return rowsInserted > 0;
        }
    }

    
    public List<Compras> obtenerTodos() throws Exception {
        try (Connection conn = new ConexionMysql().open()) {
            String query = "SELECT id_libro, nombre, autor, genero, estatus, archivo, imgPortada, universidad FROM libros";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            List<Compras> listaLibros = new ArrayList<>();
            while (rs.next()) {
                Compras libro = new Compras();
                libro.setIdLibro(rs.getInt("id_libro"));
                libro.setNombre(rs.getString("nombre"));
                libro.setAutor(rs.getString("autor"));
                libro.setGenero(rs.getString("genero"));
                libro.setEstatus(rs.getString("estatus"));
                libro.setNomUniversidad(rs.getString("universidad"));
                libro.setArchivo(rs.getBytes("archivo"));
                libro.setImgPortada(rs.getBytes("imgPortada")); // Asignación de imgPortada

                listaLibros.add(libro);
            }
            return listaLibros;
        }
    }

    public boolean actualizar(Compras libro) throws Exception {
        try (Connection conn = new ConexionMysql().open()) {
            String query;
            if (libro.getArchivo() != null && libro.getImgPortada() != null) {
                query = "UPDATE libros SET nombre=?, autor=?, genero=?, estatus=?, archivo=?, imgPortada=? WHERE id_libro=?";
            } else if (libro.getArchivo() != null) {
                query = "UPDATE libros SET nombre=?, autor=?, genero=?, estatus=?, archivo=? WHERE id_libro=?";
            } else if (libro.getImgPortada() != null) {
                query = "UPDATE libros SET nombre=?, autor=?, genero=?, estatus=?, imgPortada=? WHERE id_libro=?";
            } else {
                query = "UPDATE libros SET nombre=?, autor=?, genero=?, estatus=? WHERE id_libro=?";
            }
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, libro.getNombre());
            ps.setString(2, libro.getAutor());
            ps.setString(3, libro.getGenero());
            ps.setString(4, libro.getEstatus());
            if (libro.getArchivo() != null && libro.getImgPortada() != null) {
                ps.setBytes(5, libro.getArchivo());
                ps.setBytes(6, libro.getImgPortada());
                ps.setInt(7, libro.getIdLibro());
            } else if (libro.getArchivo() != null) {
                ps.setBytes(5, libro.getArchivo());
                ps.setInt(6, libro.getIdLibro());
            } else if (libro.getImgPortada() != null) {
                ps.setBytes(5, libro.getImgPortada());
                ps.setInt(6, libro.getIdLibro());
            } else {
                ps.setInt(5, libro.getIdLibro());
            }

            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        }
    }
}
