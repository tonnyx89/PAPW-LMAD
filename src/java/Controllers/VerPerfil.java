/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.UsuarioDAO;
import Models.Conexion;
import Models.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tonny
 */
public class VerPerfil extends HttpServlet {


Usuario perfil ;
Conexion con = new Conexion();
Connection cnn;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int tipo = Integer.parseInt(request.getParameter("op"));
       int id = Integer.parseInt(request.getParameter("id"));
       
      switch(tipo){
          case 1: {
                    if(id > 0){
                          ResultSet rs = null;
       PreparedStatement ps = null;
        String loginUser = "CALL spVerDatosUsuario(?)";
      try{
          
           perfil = new Usuario();
             cnn = con.getConexion();
            ps = cnn.prepareStatement(loginUser);
            ps.setInt(1,id);
            
            ps.executeQuery();
                
            rs = ps.getResultSet();
               
            while(rs.next()){
             perfil.setNickname(rs.getString("nickname"));  
             perfil.setCorreo(rs.getString("email"));
             perfil.setIdUsuario(rs.getInt("idUsuario"));
             perfil.setNombre(rs.getString("nombreUsuario"));
             perfil.setApellido(rs.getString("apellidoUsuario"));
             perfil.setTelefono(rs.getLong("telefono"));
             perfil.setColonia(rs.getString("colonia"));
             perfil.setNumero(rs.getInt("numExterior"));
             perfil.setCalle(rs.getString("calle"));
             perfil.setPaisNom(rs.getString("nommbrePais"));
             perfil.setCiudadNom(rs.getString("nombreCiudad"));
             perfil.setEstadoNom(rs.getString("nombreEstado"));
                      
            } 
            
        }catch(Exception e){
           System.err.println("Error" + e);
         
       }      
                        request.setAttribute("perfil", perfil);
                        request.getRequestDispatcher("perfil.jsp?id=" + perfil.getIdUsuario()).forward(request, response);
                    }
                    else{
                        response.sendRedirect("index.jsp");
                    }
          }
            break;
          case 2:{
               if(id > 0){
                          ResultSet rs = null;
       PreparedStatement ps = null;
        String loginUser = "CALL spDatosAdmin()";
      try{
          
           perfil = new Usuario();
             cnn = con.getConexion();
            ps = cnn.prepareStatement(loginUser);
           
            ps.executeQuery();
                
            rs = ps.getResultSet();
               
            while(rs.next()){
             perfil.setNickname(rs.getString("nickname"));  
             perfil.setCorreo(rs.getString("email"));
             perfil.setIdUsuario(rs.getInt("idUsuario"));
             perfil.setNombre(rs.getString("nombreUsuario"));
             perfil.setApellido(rs.getString("apellidoUsuario"));
  
                      
            } 
            System.out.println(perfil.getNickname());
            
        }catch(Exception e){
           System.err.println("Error" + e);
         
       }      
                        request.setAttribute("perfil", perfil);
                        request.getRequestDispatcher("perfil.jsp?id=" + perfil.getIdUsuario()).forward(request, response);
                    }
                    else{
                        response.sendRedirect("Index");
                    }
          }
            break;
          default:
              break;
      }
       
    }

}
