/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import cobranca_varredura.HttpExemplo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Json;
import java.lang.Object;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Type;
import modelo.Usuario;
/**
 *
 * @author zezek
 */
public class JsonDAO {
    
    
    public void verificar_login(String login,String senha){
        Usuario u = new Usuario();
        u.setLogin(login);
        u.setSenha(senha);
}

    /**
     *
     * @throws Exception
     */
    public void requisicao(String login, String senha) throws Exception{
        HttpExemplo http = new HttpExemplo();
                String chamadaWS;
                Usuario u = new Usuario();
                chamadaWS = "http://localhost:8080/WebService/webresources/WS/"
                        +"Usuario/get/"+login+"/"+senha;
 		String json = http.getSendGet(chamadaWS);
                Gson g = new Gson();
                
                
                Type usuarioType = new TypeToken<Usuario>() {}.getType();
                
                u = g.fromJson(json, usuarioType);
                System.out.println(u.getLogin()+" e id "+u.getId());
                
        }
    public void upload(){
    }
}

