/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.UsuarioDAO;
import Models.Usuario;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;

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
@MultipartConfig(maxFileSize = 129417728*8)
public class RegistrarUsuario extends HttpServlet {

    UsuarioDAO daoU = new UsuarioDAO();
    Usuario nu = new Usuario();
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
      //  processRequest(request, response);
        PrintWriter out = response.getWriter();
        
        String name = request.getParameter("nombreU");
        String lastName = request.getParameter("apellidoU");
        String nick = request.getParameter("nickU");
        String mail = request.getParameter("mailU");
        String passw = request.getParameter("passU");
        String calle = request.getParameter("calleU");
        String col = request.getParameter("coloniaU");
        
       Part imagen = request.getPart("avatarU");
        
        long tel = Long.parseLong(request.getParameter("phoneU"));
        int pais = Integer.parseInt(request.getParameter("paisU"));
        int estado = Integer.parseInt(request.getParameter("estadoU"));
        int ciudad = Integer.parseInt(request.getParameter("ciudadU"));
        int num =  Integer.parseInt(request.getParameter("numeroU"));
        
        
        nu.setNombre(name);
        nu.setApellido(lastName);
        nu.setNickname(nick);
        nu.setCorreo(mail);
        nu.setPassword(passw);
        nu.setCalle(calle);
        nu.setNumero(num);
        nu.setColonia(col);
        nu.setTelefono(tel);
        nu.setPais(pais);
        nu.setEstado(estado);
        nu.setCiudad(ciudad);
        
                try{
                  if(daoU.nuevoUsuario(nu, imagen) == true){
                         out.println("<script>alert('Registro Exitoso!');</script>");
                         response.sendRedirect("Login.jsp");
                  }
                  else{
                      out.println("<script>alert('No se pudo completar el registro. Intentelo nuevamente.');</script>");
                         response.sendRedirect("Index");
                  }
                }
                catch(Exception e){
                    
                }
            
        
        
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * 
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
