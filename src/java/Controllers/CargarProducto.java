/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.ArticuloDAO;
import Models.Articulo;
import java.io.File;
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
@MultipartConfig( fileSizeThreshold=1024*1024,
    maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
public class CargarProducto extends HttpServlet {

ArticuloDAO nuevoDAO = new ArticuloDAO();
Articulo nuevo = new Articulo();

protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nom = (String) request.getParameter("nombreA");
       String desc = (String) request.getParameter("descripcionA");
       double prec = Double.parseDouble(request.getParameter("precioA"));
       int unid = Integer.parseInt(request.getParameter("unidadesA"));
       double descu = Double.parseDouble(request.getParameter("descuentoA"));
       int cat = Integer.parseInt(request.getParameter("categorias"));
       
   
      Part video = request.getPart("videos");
       
       Part img1 = request.getPart("imagen1");
       Part img2 = request.getPart("imagen2");
       Part img3 = request.getPart("imagen3");

       
       
       
       String path = request.getServletContext().getRealPath("/");
        File fileSaveDir = new File(path + "videosArticulo");
        if(!fileSaveDir.exists()){
            fileSaveDir.mkdir();
        }
        
         String contentType = video.getContentType();
         String videoName = video.getName() + System.currentTimeMillis() + ".mp4";
         String save = "videosArticulo/" + videoName;
         video.write(path + "videosArticulo/" +  videoName);
        nuevo.setVideo(save);
         nuevo.setVideoType(contentType);
        
         
       
         nuevo.setNombre(nom);
         nuevo.setDescripcion(desc);
         nuevo.setPrecio(prec);
         nuevo.setUnidades(unid);
         nuevo.setDescuento(descu);
         nuevo.setIdCat(cat);
         
        
         
         if(nuevoDAO.agrearArticulo(nuevo)== true){
            System.out.println(nuevoDAO.a.getIdArticulo());
            nuevoDAO.agregarVideo(nuevo.getVideo(), nuevo.getVideoType(), nuevoDAO.a.getIdArticulo());
          //  request.setAttribute("producto", nuevoDAO.a);
          //  RequestDispatcher rd= getServletContext().getRequestDispatcher("./detalleProducto?idProducto=" + nuevoDAO.a.getIdArticulo()); 
          //  request.getRequestDispatcher("detalleProducto?idProducto=" + nuevoDAO.a.getIdArticulo()).forward(request, response); 
             
             if(nuevoDAO.agregarImagen(img1, nuevoDAO.a.getIdArticulo())==true){
                // response.sendRedirect("detalleProducto?idProducto=" + nuevoDAO.a.getIdArticulo());
                  if(nuevoDAO.agregarImagen(img2, nuevoDAO.a.getIdArticulo())== true){
                       if(nuevoDAO.agregarImagen(img3, nuevoDAO.a.getIdArticulo())==true){
                           
                            
       
                            
                              request.getRequestDispatcher("detalleProducto?idProducto=" + nuevoDAO.a.getIdArticulo()).forward(request, response); 
                             
                       }
                 }
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
