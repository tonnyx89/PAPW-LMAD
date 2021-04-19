/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Conexion;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author tonny
 */
@MultipartConfig(fileSizeThreshold=1024*1024*10,maxFileSize=1024*1024*150, maxRequestSize=1024*1024*1024)
public class NuevoArticulo extends HttpServlet {

 
  
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
       
        String nom = (String) request.getParameter("nombreA");
       String desc = (String) request.getParameter("descripcionA");
       double prec = Double.parseDouble(request.getParameter("precioA"));
       int unid = Integer.parseInt(request.getParameter("unidadesA"));
       double descu = Double.parseDouble(request.getParameter("descuentoA"));
       int cat = Integer.parseInt(request.getParameter("categorias"));
       
   
      Part video = request.getPart("videos");
       
     
       
      
       
       

       
       
       
       String path = request.getServletContext().getRealPath("/");
        File fileSaveDir = new File(path + "videosArticulo");
        if(!fileSaveDir.exists()){
            fileSaveDir.mkdir();
        }
        
         String contentType = video.getContentType();
         String videoName = video.getName() + System.currentTimeMillis() + ".mp4";
         String save = "videosArticulo/" + videoName;
         
         
         video.write(path + "videosArticulo/" +  videoName);
       
       
          Conexion con = new Conexion();
             Connection cnn;
            PreparedStatement pst;
            ResultSet rs;
       
       try{
           cnn = con.getConexion();
           String query = "CALL spNuevoArticulo(?,?,?,?,?); ";
           pst = cnn.prepareStatement(query);
           pst.setString(1, nom);
           pst.setString(2,desc);
           pst.setDouble(3,prec);
           pst.setInt(4, unid);
           pst.setDouble(5, descu);
           
             rs = pst.executeQuery();
           int idNArt = 0;
           
           while(rs.next()){
             idNArt =  rs.getInt("idp");
           }
         
           if(idNArt > 0){
              cnn = con.getConexion();
           String spAdd = "CALL spCategoriasNuevoArticulo(?,?)";
           pst = cnn.prepareStatement(spAdd);
           pst.setInt(1, cat );
           pst.setInt(2, idNArt);         
            pst.execute();
            
             cnn = con.getConexion();
         spAdd = "CALL spVideosNuevoArticulo(?,?,?)";
           pst = cnn.prepareStatement(spAdd);
           pst.setString(1, save );
           pst.setString(2, contentType );
           pst.setInt(3, idNArt);         
            pst.execute();
            
            
              Part img1 = request.getPart("imagenOne");    
           InputStream isOne = img1.getInputStream();
           cnn = con.getConexion();
           spAdd = "call spImagenesNuevoArticulo(?,?,?)"; 
            pst = cnn.prepareStatement(spAdd);
            pst.setInt(1, idNArt);
            pst.setBlob(2, isOne);
            pst.setString(3, "image/png");
            pst.execute();
            
             Part img2 = request.getPart("imagenTwo");  
            InputStream isTwo = img2.getInputStream();
           cnn = con.getConexion();
           spAdd = "CALL spImagenesNuevoArticulo(?,?,?)"; 
            pst = cnn.prepareStatement(spAdd);
            pst.setInt(1, idNArt);
            pst.setBlob(2, isTwo);
            pst.setString(3, "image/png");
            pst.execute(); 
            
            Part img3 = request.getPart("imagenThree");
             InputStream isThree = img3.getInputStream();
           cnn = con.getConexion();
           spAdd = "CALL spImagenesNuevoArticulo(?,?,?);"; 
            pst = cnn.prepareStatement(spAdd);
            pst.setInt(1, idNArt);
            pst.setBlob(2, isThree);
            pst.setString(3, "image/png");
            pst.execute();  
         
            
           }
           
            request.getRequestDispatcher("AdministradorArticulos.jsp").forward(request,response);
           
       }
        catch(Exception e){
            
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */


}
