package org.utl.dsm.controller;

import java.text.SimpleDateFormat;
import org.utl.dsm.model.Proveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.utl.dsm.bd.ConexionMysql;
import com.mysql.cj.jdbc.CallableStatement;
import org.utl.dsm.bd.ConexionMysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement; // Importa Statement aquí
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.utl.dsm.dao.ProveedoresDAO;
import org.utl.dsm.CQRS.ProveedoresCQRS;

/**
 *
 * @author ycuel
 */
public class controllerProveedor {

    private final ProveedoresCQRS cqrsUsuario = new ProveedoresCQRS();
    private final ProveedoresDAO usuarioDAO = new ProveedoresDAO();

    public int insertarUsuario(Proveedor usuario) {
        return cqrsUsuario.insertarUsuario(usuario);
    }

    public int actualizarUsuario(Proveedor usuario) {
        return cqrsUsuario.actualizarUsuario(usuario);
    }

    public int eliminarUsuario(int idUsuario) {
        return cqrsUsuario.cambiarEstatus(idUsuario, "inactivo");
    }

    // Método para obtener usuarios
    public List<Proveedor> obtenerUsuarios() throws Exception {
        return usuarioDAO.obtenerTodos();
    }
}
