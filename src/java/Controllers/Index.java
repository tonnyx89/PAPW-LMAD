/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.ArticuloDAO;
import Models.Articulo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tonny
 */
public class Index extends HttpServlet {

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         List<Articulo> MasVendidos, Nuevos, Ofertas, MasVistos, Destacados;
        ArticuloDAO busqueda = new ArticuloDAO();
        
        MasVendidos = busqueda.IndexLandscape(5);
        Nuevos = busqueda.IndexLandscape(1);
        Ofertas = busqueda.IndexLandscape(2);
        MasVistos = busqueda.IndexLandscape(3);
        Destacados = busqueda.IndexLandscape(4);
        
        System.out.println(Nuevos);
        request.setAttribute("vendidos", MasVendidos);
        request.setAttribute("nuevos", Nuevos);
        request.setAttribute("ofertas", Ofertas);
        request.setAttribute("vistos", MasVistos);
        request.setAttribute("destacados", Destacados);
        request.getRequestDispatcher("index.jsp").forward(request, response);

  
  }
  
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
      
    }
    
    
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
