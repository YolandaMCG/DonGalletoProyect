/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.viewModel;

import org.utl.dsm.model.Compras;
import java.util.Map;

/**
 *
 * @author ycuel
 */
public class viewModel {

    private int idLibros;
    private String nomLibros;
    private String nomAutor;
    private String tipoG;
    private String imgPortada;
    private String documentoPdf;
    private String nomUniversidad;
    private String estatus;

    public viewModel() {
    }

    public viewModel(int idLibros, String nomLibros, String nomAutor, String tipoG, String imgPortada, String documentoPdf, String nomUniversidad, String estatus) {
        this.idLibros = idLibros;
        this.nomLibros = nomLibros;
        this.nomAutor = nomAutor;
        this.tipoG = tipoG;
        this.imgPortada = imgPortada;
        this.documentoPdf = documentoPdf;
        this.nomUniversidad = nomUniversidad;
        this.estatus = estatus;
    }

    public int getIdLibros() {
        return idLibros;
    }

    public void setIdLibros(int idLibros) {
        this.idLibros = idLibros;
    }

    public String getNomLibros() {
        return nomLibros;
    }

    public void setNomLibros(String nomLibros) {
        this.nomLibros = nomLibros;
    }

    public String getNomAutor() {
        return nomAutor;
    }

    public void setNomAutor(String nomAutor) {
        this.nomAutor = nomAutor;
    }

    public String getTipoG() {
        return tipoG;
    }

    public void setTipoG(String tipoG) {
        this.tipoG = tipoG;
    }

    public String getImgPortada() {
        return imgPortada;
    }

    public void setImgPortada(String imgPortada) {
        this.imgPortada = imgPortada;
    }

    public String getDocumentoPdf() {
        return documentoPdf;
    }

    public void setDocumentoPdf(String documentoPdf) {
        this.documentoPdf = documentoPdf;
    }

    public String getNomUniversidad() {
        return nomUniversidad;
    }

    public void setNomUniversidad(String nomUniversidad) {
        this.nomUniversidad = nomUniversidad;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

 

}
