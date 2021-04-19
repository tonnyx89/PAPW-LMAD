/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.CompraDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tonny
 */
public class EditarCarrito extends HttpServlet {

    CompraDAO datos = new CompraDAO();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String opcion = request.getParameter("pvariable");
        
        switch(opcion.toLowerCase())
        {
            case "eliminar":
            {
                int idUser = Integer.parseInt(request.getParameter("idUser"));
                int producto = Integer.parseInt(request.getParameter("idProducto"));
                
                if(datos.quitarProducto(idUser, producto)){
                       request.getRequestDispatcher("carrito.jsp?id=" + idUser ).forward(request, response);
                }
            } 
                break;
            case "update":
            {
                int idUser = Integer.parseInt(request.getParameter("idUser"));
                int cant = Integer.parseInt(request.getParameter("cantidad"));
                int producto = Integer.parseInt(request.getParameter("idProducto"));
                
                 if(datos.updateCantidad(idUser, cant, producto)){
                       request.getRequestDispatcher("carrito.jsp?id=" + idUser ).forward(request, response);
                }
            } 
                break;
            case "vaciar":
            {
                int idUser = Integer.parseInt(request.getParameter("idUser"));
                 if(datos.vaciarCarrito(idUser)){
                       request.getRequestDispatcher("carrito.jsp?id=" + idUser ).forward(request, response);
                }
            } 
                break;
            case "confirmar":
            {
                int idUser = Integer.parseInt(request.getParameter("idUser"));
                int mPago = Integer.parseInt(request.getParameter("pago"));
                 if(datos.confirmarCompra(idUser,mPago)){
                       request.getRequestDispatcher("carrito.jsp?id=" + idUser ).forward(request, response);
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
