/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Conexion;
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
public class EditarArticulo extends HttpServlet {
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
        
                String nom = (String) request.getParameter("nombreA");
                String desc = (String) request.getParameter("descripcionA");
                double prec = Double.parseDouble(request.getParameter("precioA"));
                int unid = Integer.parseInt(request.getParameter("unidadesA"));
                double descu = Double.parseDouble(request.getParameter("descuentoA"));
                
                int id = Integer.parseInt(request.getParameter("id"));
       
       
         
       try{
           cnn = con.getConexion();
           String query = "CALL spEditarArticulo(?,?,?,?,?,?); ";
           pst = cnn.prepareStatement(query);
           pst.setInt(1, id);
           pst.setString(2, nom);
           pst.setString(3,desc);
           pst.setDouble(4,prec);
           pst.setInt(5, unid);
           pst.setDouble(6, descu);
           
           pst.executeQuery();
           
           request.getRequestDispatcher("detalle.jsp?idProducto=" + id).forward(request, response);
       }
       catch(Exception e){
           
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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

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

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
