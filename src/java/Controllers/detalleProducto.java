/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Articulo;
import java.io.IOException;
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
public class detalleProducto extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");

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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        int producto = Integer.parseInt(request.getParameter("idProducto"));
        
        
        PreparedStatement pst = null;
        ResultSet rs = null;
          Articulo detalle = new Articulo();
        
        String spAdd = "CALL spVerDetallesArticulo(?)";
        try {
          
            pst = detalle.getConexion().prepareStatement(spAdd);
            pst.setInt(1, producto);
            
            pst.executeQuery();
                
               rs = pst.getResultSet();
               
               while(rs.next()){
                detalle.setIdArticulo( rs.getInt("idArticulo"));
                detalle.setNombre(rs.getString("nombreArticulo"));
                detalle.setDescripcion(rs.getString("descripcion"));
                detalle.setPrecio(rs.getDouble("precio"));
                detalle.setDescuento(rs.getDouble("descuento"));
                detalle.setUnidades(rs.getInt("unidades"));
                detalle.setVisitas(rs.getInt("visitas"));
                detalle.setPromValoraciones(rs.getFloat("valoracion"));
               
               }
               
               request.setAttribute("producto", detalle);
               request.getRequestDispatcher("detalle.jsp?idProducto=" + detalle.getIdArticulo()).forward(request, response);
                 
            
            
         }catch(Exception e){
           System.err.println("Error" + e);
         
       }finally{
           try{
               if(detalle.getConexion()!=null) detalle.getConexion().close();
               if(pst != null) pst.close();
           }catch(Exception e){
               System.err.println("Error" + e);
           }
       }       
        
    }


    
}
