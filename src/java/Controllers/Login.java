/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.UsuarioDAO;
import Models.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author tonny
 */
public class Login extends HttpServlet {

UsuarioDAO user = new UsuarioDAO();
Usuario in = new Usuario();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
            String name = request.getParameter("userName");
            String password = request.getParameter("userPassword");
            
            
            if(user.Login(name, password)!= null){
              
                in.setNickname(user.actual.getNickname());
                in.setIdUsuario(user.actual.getIdUsuario());
                in.setCorreo(user.actual.getCorreo());
                HttpSession misession= request.getSession(true);
                misession.setAttribute("usuario", in);
                 request.setAttribute("otro", in);
                //response.sendRedirect("index.jsp?activo=true");
                 request.getRequestDispatcher("/Index").forward(request, response);
                 
                //request.getRequestDispatcher("index.jsp").forward(request, response);
                
                
            }
            else{
                try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<script>alert('Error,"+  in.getNickname() +" ');</script>");
             //response.sendRedirect("index.jsp");
        }
                
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
