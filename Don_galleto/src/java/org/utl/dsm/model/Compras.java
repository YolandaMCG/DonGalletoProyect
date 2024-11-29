/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.model;

/**
 *
 * @author ycuel
 */
public class Compras {

    private int idLibro;
    private String nombre;
    private String autor;
    private String genero;
    private String estatus;
    private byte[] imgPortada;
    private byte[] archivo;
    private String nomUniversidad;

    public Compras() {
    }

    public Compras(int idLibro, String nombre, String autor, String genero, String estatus, byte[] imgPortada, byte[] archivo, String nomUniversidad) {
        this.idLibro = idLibro;
        this.nombre = nombre;
        this.autor = autor;
        this.genero = genero;
        this.estatus = estatus;
        this.imgPortada = imgPortada;
        this.archivo = archivo;
        this.nomUniversidad = nomUniversidad;
    }

    public Compras(int idLibro, String nombre, String autor, String genero, String estatus, byte[] imgPortada, byte[] archivo) {
        this.idLibro = idLibro;
        this.nombre = nombre;
        this.autor = autor;
        this.genero = genero;
        this.estatus = estatus;
        this.imgPortada = imgPortada;
        this.archivo = archivo;
    }
    
    

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public byte[] getImgPortada() {
        return imgPortada;
    }

    public void setImgPortada(byte[] imgPortada) {
        this.imgPortada = imgPortada;
    }

    public byte[] getArchivo() {
        return archivo;
    }

    public void setArchivo(byte[] archivo) {
        this.archivo = archivo;
    }

    public String getNomUniversidad() {
        return nomUniversidad;
    }

    public void setNomUniversidad(String nomUniversidad) {
        this.nomUniversidad = nomUniversidad;
    }

   

}
