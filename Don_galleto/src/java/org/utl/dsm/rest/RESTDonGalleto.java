/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.rest;

import com.google.gson.Gson;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.PathParam; // Asegúrate de importar esto para usar @PathParam
import java.io.InputStream;
import org.utl.dsm.controller.controllerProveedor;
import org.utl.dsm.controller.controllerCompras;
import org.utl.dsm.model.Proveedor;
import org.utl.dsm.model.Compras;
import org.utl.dsm.bd.ConexionMysql;
import java.sql.SQLException;
import java.sql.SQLException;
import org.json.JSONArray;
import org.json.JSONObject;
import java.sql.*;
import java.util.UUID;
import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.utl.dsm.bd.ConexionMysql;
import org.utl.dsm.viewModel.viewModel;

/**
 *
 * @author ycuel
 */
@Path("servicios")
public class RESTDonGalleto extends Application {

    @Path("saluda")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response saluda() {
        String out = """
                    {"response":"Hola Diosito"}
                    """;
        return Response.ok(out).build();
    }



}
