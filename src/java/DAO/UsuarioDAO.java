/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Conexion;
import Models.Usuario;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author tonny
 */
public class UsuarioDAO {
    Conexion con = new Conexion();
    Connection cnn;
    PreparedStatement ps;
    ResultSet rs;
    public Usuario actual = new Usuario();

    
   public Usuario Login(String nickname, String Password){
   
        ResultSet rs = null;
       PreparedStatement ps = null;
        String loginUser = "CALL spLoginUser(?,?)";
      try{
          actual = new Usuario();
           
             cnn = con.getConexion();
            ps = cnn.prepareStatement(loginUser);
            ps.setString(1,nickname);
            ps.setString(2, Password);
            
            ps.executeQuery();
                
            rs = ps.getResultSet();
               
            while(rs.next()){
             actual.setNickname(rs.getString("nickname"));  
             actual.setCorreo(rs.getString("email"));
             actual.setIdUsuario(rs.getInt("idUsuario"));
                      
            } 
     
        }catch(Exception e){
           System.err.println("Error" + e);
        
       }finally{
           try{
               if(con.getConexion()!=null) con.getConexion().close();
               if(ps != null) ps.close();
           }catch(Exception e){
               System.err.println("Error" + e);
           }
       }       
        return actual;
    }
    
   public void verImagen(int id, HttpServletResponse response){
        String query = "SELECT avatar FROM usuario WHERE idUsuario = ? LIMIT 1";
        InputStream is = null;
        OutputStream os = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        response.setContentType("image/*");
        try{
            os = response.getOutputStream();
            cnn = con.getConexion();
            ps = cnn.prepareStatement(query); 
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                is = rs.getBinaryStream("avatar");
            }
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream (os);
            int i = 0;
            while((i = bis.read())!= -1){
                bos.write(i);
            }
            
        }catch(Exception e){

        }
    }
   
   public boolean nuevoUsuario(Usuario nuevo, Part file){
         boolean add = false;
       
       
       PreparedStatement pst = null;
       try{
           cnn = con.getConexion();
           InputStream is = file.getInputStream();
           
           String spAdd = "CALL spNuevoUsuario(?,?,?,?,?,?,?,?,?,?,?,?,?)";
           pst = cnn.prepareStatement(spAdd);
           pst.setString(1, nuevo.getNombre());
           pst.setString(2,nuevo.getApellido());
           pst.setString(3, nuevo.getNickname());
           pst.setString(4, nuevo.getCorreo());
           pst.setString(5, nuevo.getPassword());
           pst.setLong(6, nuevo.getTelefono());
           pst.setBlob(7,is);
          //pst.setBinaryStream(7,fs,(int)file.length());
        //   pst.setBytes(7, nuevo.getAvatar());
           pst.setString(8, nuevo.getCalle());
           pst.setInt(9, nuevo.getNumero());
           pst.setString(10, nuevo.getColonia());
           pst.setInt(11, nuevo.getCiudad());
           pst.setInt(12, nuevo.getEstado());
           pst.setInt(13,nuevo.getPais());
           


              
              
           if(pst.executeUpdate() == 1){
               add = true;
           }
           
           pst.close();
           
       }catch(Exception e){
           System.err.println("Error" + e);
       }finally{
           try{
               if(con.getConexion()!=null) con.getConexion().close();
               if(pst != null) pst.close();
           }catch(Exception e){
               System.err.println("Error" + e);
           }
       }
       
       
       return add;
   }
   
   

}
