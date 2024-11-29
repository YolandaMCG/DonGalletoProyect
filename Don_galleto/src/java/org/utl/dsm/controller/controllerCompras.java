/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.utl.dsm.bd.ConexionMysql;
import org.utl.dsm.model.Compras;
import org.utl.dsm.dao.ComprasDAO;
import org.utl.dsm.CQRS.ComprasCqrs;
import org.utl.dsm.viewModel.viewModel;

import java.util.List;
import java.util.Map;
import org.utl.dsm.AppService.CompraExternaAppService;

/**
 *
 * @author ycuel
 */
public class controllerCompras {

    private final ComprasCqrs cqrs = new ComprasCqrs();
    private final ComprasDAO libroDAO = new ComprasDAO();

    public int insertarLibro(Compras libro) {
        return cqrs.insertarLibro(libro); // Devuelve el código de error
    }

    public int actualizarLibro(Compras libro) {
        return cqrs.actualizarLibro(libro); // Devuelve el código de error
    }

    // Método para obtener libros 
    public List<Compras> obtenerLibros() throws Exception {
        return libroDAO.obtenerTodos();
    }

    //metodo para obtener los libros con los cors
    public List<viewModel> obtenerLibrosViewModel() throws Exception {
        List<viewModel> lstLibrosViewModel = new ArrayList<>();
        CompraExternaAppService librosExternos = new CompraExternaAppService();
        // Obtener libros de las tres APIs externas
        List<viewModel> librosApiColombia = librosExternos.apiUniversidadColombia();
        lstLibrosViewModel.addAll(librosApiColombia);

        List<viewModel> librosApiArgentina = librosExternos.apiUniversidadArgentina();
        lstLibrosViewModel.addAll(librosApiArgentina);
        
        List<viewModel> librosApiEspaña = librosExternos.apiUniversidadEspaña();
        lstLibrosViewModel.addAll(librosApiEspaña);

        // Obtener libros del DAO interno
        List<Compras> libros = libroDAO.obtenerTodos();
        for (Compras libro : libros) {
            viewModel libroViewModel = new viewModel(
                    libro.getIdLibro(),
                    libro.getNombre(),
                    libro.getAutor(),
                    libro.getGenero(),
                    libro.getImgPortada() != null ? Base64.getEncoder().encodeToString(libro.getImgPortada()) : null, // imgPortada en Base64
                    libro.getArchivo() != null ? Base64.getEncoder().encodeToString(libro.getArchivo()) : null, // archivo en Base64
                    libro.getNomUniversidad(), // nuevo campo nomUniversidad
                    libro.getEstatus()
            );
            lstLibrosViewModel.add(libroViewModel);
        }

        return lstLibrosViewModel;
    }

    //metodo para compartir publico
    public List<viewModel> obtenerLibrosViewModelPublico() throws Exception {
        List<viewModel> lstLibrosViewModel = new ArrayList<>();

        // Obtener libros del DAO interno
        List<Compras> libros = libroDAO.obtenerTodos();
        for (Compras libro : libros) {
            viewModel libroViewModel = new viewModel(
                    libro.getIdLibro(),
                    libro.getNombre(),
                    libro.getAutor(),
                    libro.getGenero(),
                    libro.getImgPortada() != null ? Base64.getEncoder().encodeToString(libro.getImgPortada()) : null, // imgPortada en Base64
                    libro.getArchivo() != null ? Base64.getEncoder().encodeToString(libro.getArchivo()) : null, // archivo en Base64
                    libro.getNomUniversidad(), // nuevo campo nomUniversidad
                    libro.getEstatus()
            );
            lstLibrosViewModel.add(libroViewModel);
        }

        return lstLibrosViewModel;
    }

    
}
