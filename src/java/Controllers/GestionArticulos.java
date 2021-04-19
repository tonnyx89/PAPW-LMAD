/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Conexion;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tonny
 */
public class GestionArticulos extends HttpServlet {

        Conexion con = new Conexion();
    Connection cnn;
    PreparedStatement pst;
    ResultSet rs;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         ArrayList<Map> arts = new ArrayList<>();
        Map <String, Object> map = new HashMap<String, Object>();

        String param = request.getParameter("op");
        
        switch(param){
            case "ver":
            {
                try{
                        cnn = con.getConexion();
                       
                        String spAdd = "CALL spVerProductos()";
                        pst = cnn.prepareStatement(spAdd);
                       
                        
                        rs = pst.executeQuery();
                        while(rs.next()){
                           
                            map = new HashMap<String, Object>();
                            map.put("id",rs.getInt("idArticulo"));
                            map.put("nombre",rs.getString("nombreArticulo"));
                            map.put("stock",rs.getInt("unidades"));
                            map.put("precio",rs.getDouble("precio"));
                            arts.add(map);
                           
                        }
                        System.out.println(arts);
                        write(response, arts);
                       

                    }catch(Exception e){
                        System.err.println("Error" + e);
                    }
            }
            break;
            
            case "borradores":
            {
                 try{
                        cnn = con.getConexion();
                       
                        String spAdd = "CALL spVerBorradores()";
                        pst = cnn.prepareStatement(spAdd);
                       
                        
                        rs = pst.executeQuery();
                        while(rs.next()){
                           
                            map = new HashMap<String, Object>();
                            map.put("id",rs.getInt("idArticulo"));
                            map.put("nombre",rs.getString("nombreArticulo"));
                            map.put("stock",rs.getInt("unidades"));
                            map.put("precio",rs.getDouble("precio"));
                            arts.add(map);
                           
                        }
                        System.out.println(arts);
                        write(response, arts);
                     

                    }catch(Exception e){
                        System.err.println("Error" + e);
                    }
            }
                break;
            case "publicar":
            {
                 try{
                        cnn = con.getConexion();
                        int id = Integer.parseInt(request.getParameter("idArticulo"));
                        String spAdd = "CALL spPublicarProducto(?)";
                      
                        pst = cnn.prepareStatement(spAdd);
                         pst.setInt(1, id);
                        
                        pst.executeQuery();
                      

                    }catch(Exception e){
                        System.err.println("Error" + e);
                    }
            }
                break;
            case "eliminar":
            {
                 try{
                        cnn = con.getConexion();
                        int id = Integer.parseInt(request.getParameter("idArticulo"));
                        
                        String spAdd = "CALL spEliminarProducto(?)";
                        
                        pst = cnn.prepareStatement(spAdd);
                       pst.setInt(1, id);
                        
                        pst.executeQuery();
                      

                    }catch(Exception e){
                        System.err.println("Error" + e);
                    }
            }
                break;
                
            
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */


    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   private void write(HttpServletResponse response,ArrayList<Map> map  )throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
            response.getWriter().write(new Gson().toJson(map));
    
        
    }

}
