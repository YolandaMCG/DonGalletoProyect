/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.CQRS;

import org.utl.dsm.dao.ComprasDAO;
import org.utl.dsm.model.Compras;

/**
 *
 * @author ycuel
 */
public class ComprasCqrs {

    private final ComprasDAO libroDAO = new ComprasDAO();

    public int insertarLibro(Compras libro) {
        int error = validarLibro(libro);
        if (error != 0) {
            return error; 
        }
        try {
            libroDAO.insertar(libro);
            return 0; // Éxito
        } catch (Exception e) {
            return 5; 
        }
    }

    public int actualizarLibro(Compras libro) {
        int error = validarLibro(libro);
        if (error != 0) {
            return error; // Devuelve el código de error
        }
        try {
            libroDAO.actualizar(libro);
            return 0; // Éxito
        } catch (Exception e) {
            return 6; // Error genérico de actualización
        }
    }

    private int validarLibro(Compras libro) {
        if (libro.getNombre() == null || libro.getNombre().isEmpty()) {
            return 1; // El nombre no puede estar vacío
        }
        if (libro.getNombre().length() < 5 || libro.getNombre().length() > 100) {
            return 2; // El nombre debe tener entre 5 y 100 caracteres
        }
        if (libro.getGenero() == null || libro.getGenero().isEmpty()) {
            return 3; // El género no puede estar vacío
        }
        if (libro.getGenero().length() < 5 || libro.getGenero().length() > 30) {
            return 4; // El género debe tener entre 5 y 30 caracteres
        }
        // Si todo está bien
        return 0; // Éxito
    }
}
