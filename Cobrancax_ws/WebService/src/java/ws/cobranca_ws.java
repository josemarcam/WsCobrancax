/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.Gson;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import modelo.Usuario;
import dao.UsuarioDAO;
import static javax.ws.rs.HttpMethod.POST;
 import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;
/**
 * REST Web Service
 *
 * @author zezek
 */
@Path("WS")
public class cobranca_ws {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of cobranca_ws
     */
    public cobranca_ws() {
    }


    /**
     * Retrieves representation of an instance of ws.cobranca_ws
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
    return "retorno";
    }
    
    @GET
    @Path("Usuario/get/{login}/{senha}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getUser(@PathParam("login")String login,@PathParam("senha")String senha) {
        Usuario u = new Usuario();
        u.setLogin(login);
        u.setSenha(senha);
        UsuarioDAO dao = new UsuarioDAO();
        u = dao.buscar(u);
        
        Gson g = new Gson();
        return g.toJson(u);
        
    }
    
    
    /**
     * PUT method for updating or creating an instance of cobranca_ws
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
    @POST
    @Path("Usuario/get/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public String uploadFile(
            @FormDataParam("file") InputStream uploadedInputStream,
            @FormDataParam("file") FormDataContentDisposition fileDetail){
//        save the file object
        saveToDisk (uploadedInputStream, fileDetail);
        return "Arquivos Enviados com Sucesso!";
    }
    
    private void saveToDisk(InputStream uploadedInputStream,
            FormDataContentDisposition fileDetail){
    String uploadedFileLocation = "/Users/josemartins/Desktop"
            +fileDetail.getFileName();
        try {
            OutputStream out = new FileOutputStream(new File(uploadedFileLocation));
            int read = 0;
            byte[] bytes = new byte[1024];
            
            out = new FileOutputStream(new File(uploadedFileLocation));
            while ((read = uploadedInputStream.read(bytes)) != -1) {
                out.write(bytes,0,read);
            }
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
}
