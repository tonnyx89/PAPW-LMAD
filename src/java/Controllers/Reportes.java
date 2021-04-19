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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tonny
 */
public class Reportes extends HttpServlet {

    Conexion con = new Conexion();
    Connection cnn;
    PreparedStatement pst;
    ResultSet rs;
    
     String [] meses = {"def","Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dic"};
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
        ArrayList<Map> compras = new ArrayList<>();
        Map <String, Object> map = new HashMap<String, Object>();
       
        String op = request.getParameter("pvariable");
        
        switch(op){
            case "compras":
            {
               
                try{
                        cnn = con.getConexion();
                        int id = Integer.parseInt(request.getParameter("idUser"));
                        String spAdd = "CALL spReporteCompras(?)";
                        pst = cnn.prepareStatement(spAdd);
                        pst.setInt(1, id);
                        
                        rs = pst.executeQuery();
                        while(rs.next()){
                           
                            map = new HashMap<String, Object>();
                            map.put("id",rs.getInt("idCompra"));
                            map.put("fecha",rs.getString("fecha"));
                            map.put("total",rs.getDouble("costoTotal"));
                            map.put("pago",rs.getString("nombreMetodoPago"));
                            compras.add(map);
                           
                        }
                        System.out.println(compras);
                        write(response, compras);
                        pst.close();

                    }catch(Exception e){
                        System.err.println("Error" + e);
                    }
            }
                break;
            case "ventas":
            {
                 try{
                        cnn = con.getConexion();
                        String spAdd = "CALL spReporteVentasGeneral()";
                        pst = cnn.prepareStatement(spAdd);
                        
                        
                        rs = pst.executeQuery();
                        while(rs.next()){
                           
                            map = new HashMap<String, Object>();
                            map.put("id",rs.getInt("idCompra"));
                            map.put("fecha",rs.getString("fecha"));
                            map.put("idUsuario",rs.getInt("idUsuario"));
                            map.put("nick",rs.getString("nickname"));
                            map.put("total",rs.getDouble("costoTotal"));
                            map.put("pago",rs.getString("nombreMetodoPago"));
                            compras.add(map);
                           
                        }
                        System.out.println(compras);
                        write(response, compras);
                        pst.close();

                    }catch(Exception e){
                        System.err.println("Error" + e);
                    }
            }
                break;
            case "mensual":
            {
                     try{
                         
                         
                        cnn = con.getConexion();
                        String spAdd = "CALL spReporteVentasMensual()";
                        pst = cnn.prepareStatement(spAdd);
                        
                        int mes= 0;
                      
                        double total =0.00;
                        
                        rs = pst.executeQuery();
                        while(rs.next()){
                           
                          
                            mes = rs.getInt("numMes");
                            for(int i=1; i<13; i++){
                                  map = new HashMap<String, Object>();
                                if(i == mes){
                                    map.put("mes",rs.getInt("numMes"));
                                    map.put("MesNombre",rs.getString("mes"));
                                    map.put("total",rs.getDouble("acumulado"));
                                    compras.add(map);
                                }
                                else{
                                    map.put("mes", i);
                                    map.put("MesNombre",meses[i]);
                                    map.put("total", 0);
                                    compras.add(map);
                                }
                                
                            }
                            
                          
                            
                           
                        }
                        System.out.println(compras);
                        write(response, compras);
                        pst.close();

                    }catch(Exception e){
                        System.err.println("Error" + e);
                    }
            
            }
                break;
            case "detalleCompra":
            {
                 try{
                        cnn = con.getConexion();
                        int id = Integer.parseInt(request.getParameter("idCompra"));
                        String spAdd = "CALL spVerDetallesCompra(?)";
                        pst = cnn.prepareStatement(spAdd);
                        pst.setInt(1, id);
                        
                        rs = pst.executeQuery();
                        while(rs.next()){
                           
                            map = new HashMap<String, Object>();
                            map.put("cant",rs.getInt("cantidad"));
                            map.put("art",rs.getString("nombreArticulo"));
                            map.put("total",rs.getDouble("importeArticulo"));
                            map.put("fecha",rs.getString("fecha"));
                            map.put("idArt",rs.getString("idArticulo"));
                            compras.add(map);
                           
                        }
                        System.out.println(compras);
                        write(response, compras);
                        pst.close();

                    }catch(Exception e){
                        System.err.println("Error" + e);
                    }
            }
                break;
            case "detalleVenta":
            {
                try{
                        cnn = con.getConexion();
                        int id = Integer.parseInt(request.getParameter("idUsuario"));
                        int venta = Integer.parseInt(request.getParameter("idVenta"));
                        String spAdd = "CALL spVerDetallesVenta(?,?)";
                        pst = cnn.prepareStatement(spAdd);
                        pst.setInt(1, id);
                        pst.setInt(2, venta);
                        
                        
                        rs = pst.executeQuery();
                        while(rs.next()){
                           
                            map = new HashMap<String, Object>();
                            map.put("cant",rs.getInt("cantidad"));
                            map.put("art",rs.getString("nombreArticulo"));
                            map.put("total",rs.getDouble("total"));
                            map.put("fecha",rs.getString("fecha"));
                            map.put("idArt",rs.getString("idArticulo"));
                            compras.add(map);
                           
                        }
                        System.out.println(compras);
                        write(response, compras);
                        pst.close();

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

    private void write(HttpServletResponse response,ArrayList<Map> map  )throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
            response.getWriter().write(new Gson().toJson(map));
    
        
    }
}

