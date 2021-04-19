/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Articulo;
import DAO.ArticuloDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tonny
 */
public class Buscador extends HttpServlet {

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

        String param = request.getParameter("buscar");
        
         
        List<Articulo> resultados;
        ArticuloDAO busqueda;
        switch(param){
            case "todos":
            {
               
                 busqueda = new ArticuloDAO();
                 resultados = busqueda.resultados("", 0,"","", 3);
                 request.setAttribute("productos", resultados );
                 request.setAttribute("keyword", param);
                 request.getRequestDispatcher("result.jsp?busqueda=" + param).forward(request, response);
            }
                break;
            case "cat":
            {
                 int id = Integer.parseInt(request.getParameter("id"));
             
                 busqueda = new ArticuloDAO();
                 resultados = busqueda.resultados(param, id,"","", 2);
                 request.setAttribute("productos", resultados );
                 request.setAttribute("keyword", param);
                 request.getRequestDispatcher("result.jsp?busqueda=" + param).forward(request, response);
            }
                break;
               case "fecha":
            {
                 
                 String inicio = request.getParameter("desde");
                 String fin = request.getParameter("hasta");
             
                 busqueda = new ArticuloDAO();
                 resultados = busqueda.resultados(param, 0,inicio,fin, 4);
                 request.setAttribute("productos", resultados );
                 request.setAttribute("keyword", param);
                 request.getRequestDispatcher("result.jsp?busqueda=" + param).forward(request, response);
            }
                break;
            default:
            {
                
                 busqueda = new ArticuloDAO();
                 resultados = busqueda.resultados(param, 0,"","", 1);
                 request.setAttribute("productos", resultados );
                 request.setAttribute("keyword", param);
                 request.getRequestDispatcher("result.jsp?busqueda=" + param).forward(request, response);
            }
                break;
                
        }


        
                 
            
       
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
