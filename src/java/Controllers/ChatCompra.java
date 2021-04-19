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
public class ChatCompra extends HttpServlet {
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
        
        ArrayList<Map> chat = new ArrayList<>();
        Map <String, Object> mensajes = new HashMap<String, Object>();
       
        String op = request.getParameter("pvariable");
        
        
         switch(op){
            case "enviar":
            {
               
                try{
                        cnn = con.getConexion();
                        int envia = Integer.parseInt(request.getParameter("idEnvia"));
                        int recibe = Integer.parseInt(request.getParameter("idRecibe"));
                        int chatId = Integer.parseInt(request.getParameter("idChat"));
                        String msg = request.getParameter("mensaje");
                       
                        String spAdd = "CALL spSendMessage(?,?,?,?)";
                        pst = cnn.prepareStatement(spAdd);
                        pst.setInt(1, envia);
                        pst.setInt(2, recibe);
                        pst.setInt(3, chatId);
                        pst.setString(4, msg);
                        
                        pst.executeQuery();
                      
                        
                        pst.close();

                    }catch(Exception e){
                        System.err.println("Error" + e);
                    }
            }
                break;
            case "ver":
            {
                 try{
                        cnn = con.getConexion();
                        int compra = Integer.parseInt(request.getParameter("compra"));
                        int usuario = Integer.parseInt(request.getParameter("usuario"));
                        String spAdd = "CALL spVerMensajes(?,?)";
                        pst = cnn.prepareStatement(spAdd);
                        pst.setInt(1, compra);
                        pst.setInt(2, usuario);
                        
                        
                        rs = pst.executeQuery();
                        while(rs.next()){
                           
                            mensajes = new HashMap<String, Object>();
                            mensajes.put("id",rs.getInt("idMensaje"));
                            mensajes.put("fecha",rs.getString("fechaMsj"));
                            mensajes.put("mensaje",rs.getString("textoMensaje"));
                            mensajes.put("envia",rs.getInt("idEnvia"));
                            mensajes.put("recibe",rs.getInt("idRecibe")); 
                             mensajes.put("chat",rs.getInt("idConversacion")); 
                        
                            chat.add(mensajes);
                           
                        }
                        System.out.println(chat);
                        write(response, chat);
                        pst.close();

                    }catch(Exception e){
                        System.err.println("Error" + e);
                    }
            }
                break;
            case "listaChats":
            {
                try{
                    int usuario = Integer.parseInt(request.getParameter("idUsuario"));
                    cnn = con.getConexion();
                    String query = "CALL spVerChats(?);";
                    pst = cnn.prepareStatement(query);
                    pst.setInt(1, usuario);
                    
                    rs = pst.executeQuery();
                    
                    while(rs.next()){
                        mensajes = new HashMap<String, Object>();
                            mensajes.put("id",rs.getInt("idChat"));
                            mensajes.put("usuario",rs.getInt("idUsuario"));
                            mensajes.put("fecha",rs.getString("fecha"));
                            mensajes.put("idCompra",rs.getInt("idCompra"));
                     
                        
                            chat.add(mensajes);
                    }
                     
                    write(response, chat);
                     System.out.println(chat);       
                }
                catch(Exception e){
                    
                }
                
            }
                break;
            case "terminar":
            {
                try{
                    int usuario = Integer.parseInt(request.getParameter("usuario"));
                    int compra = Integer.parseInt(request.getParameter("compra"));
                    double precio = Double.parseDouble(request.getParameter("precio"));
                    cnn = con.getConexion();
                    String query = "CALL spCerrarTrato(?,?,?);";
                    pst = cnn.prepareStatement(query);
                    pst.setInt(1, usuario);
                     pst.setInt(2, compra);
                      pst.setDouble(3, precio);
                      
                    rs = pst.executeQuery();
                    
                    while(rs.next()){
                        mensajes = new HashMap<String, Object>();
                            mensajes.put("flag",rs.getInt("op"));
                            
                     
                        
                            chat.add(mensajes);
                    }
                     
                    write(response, chat);
                     System.out.println(chat);       
                }
                catch(Exception e){
                    
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
     private void write(HttpServletResponse response,ArrayList<Map> map  )throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
            response.getWriter().write(new Gson().toJson(map));
    
        
    }

}
