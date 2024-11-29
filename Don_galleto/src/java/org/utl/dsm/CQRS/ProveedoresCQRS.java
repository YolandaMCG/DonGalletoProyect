/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.CQRS;

import org.utl.dsm.dao.ProveedoresDAO;
import org.utl.dsm.model.Proveedor;

/**
 *
 * @author ycuel
 */
public class ProveedoresCQRS {

    private final ProveedoresDAO usuarioDAO = new ProveedoresDAO();

    public int insertarUsuario(Proveedor usuario) {
        int error = validarUsuario(usuario);
        if (error != 0) {
            return error;
        }
        try {
            usuarioDAO.insertar(usuario);
            return 0;
        } catch (Exception e) {
            return 5;
        }
    }

    public int actualizarUsuario(Proveedor usuario) {
        int error = validarUsuario(usuario);
        if (error != 0) {
            return error;
        }
        try {
            usuarioDAO.actualizar(usuario);
            return 0;
        } catch (Exception e) {
            return 6;
        }
    }

    public int cambiarEstatus(int idUsuario, String estatus) {
        try {
            return usuarioDAO.cambiarEstatus(idUsuario, estatus) ? 0 : 7;
        } catch (Exception e) {
            return 8;
        }
    }

    private int validarUsuario(Proveedor usuario) {
        if (usuario.getUser() == null || usuario.getUser().isEmpty()) {
            return 1;
        }
        if (usuario.getPassword() == null || usuario.getPassword().isEmpty()) {
            return 2;
        }
        if (usuario.getRol() == null || usuario.getRol().isEmpty()) {
            return 3;
        }
        return 0;
    }
}
