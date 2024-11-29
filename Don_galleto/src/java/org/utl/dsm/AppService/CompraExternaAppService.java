/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.AppService;

import org.utl.dsm.viewModel.viewModel;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 *
 * @author ycuel
 */
public class CompraExternaAppService {

    private List<viewModel> getAllApiPublica(String apiUrl) {
        List<viewModel> libros = new ArrayList<>();
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int status = con.getResponseCode();
            if (status == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                StringBuilder content = new StringBuilder();
                String line;
                while ((line = in.readLine()) != null) {
                    content.append(line);
                }
                in.close();
                Gson gson = new Gson();
                Type listType = new TypeToken<List<viewModel>>() {
                }.getType();
                libros = gson.fromJson(content.toString(), listType);
            } else {
                System.out.println("Error en la solicitud a " + apiUrl + ": " + status);
            }
            con.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return libros;
    }

    public List<viewModel> apiUniversidadColombia() {
        return getAllApiPublica("http://10.16.21.29:8080/ProyectoLibreria/api/libros/getAllPM");
    }

    public List<viewModel> apiUniversidadArgentina() {
        return getAllApiPublica("http://10.16.7.205:8080/ArquitecturaDeSoftware/api/librosP/getAllLibrosPublico");
    }

    public List<viewModel> apiUniversidadEspaña() {
        return getAllApiPublica("http://10.16.25.251:8080/UniversidadComplutensedeMadrid/api/LibrosGet/getAllPublico");
    }

}
