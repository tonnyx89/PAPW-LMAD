/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Articulo;
import Models.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author tonny
 */
public class CompraDAO {
    Conexion con = new Conexion();
    Connection cnn;
   

    public CompraDAO() {
    }
    
    public ArrayList<Articulo> detalleCarrito (int id){
        ArrayList<Articulo> detalle = new ArrayList();
        
        PreparedStatement pst = null;
        ResultSet rs = null;
        String spAdd = "CALL spVerCarrito(?)";
        
        try {
            cnn = con.getConexion();
            pst = cnn.prepareStatement(spAdd);
            pst.setInt(1, id);
            
            pst.executeQuery();
                
            rs = pst.getResultSet();
               
            while(rs.next()){
                Articulo d = new Articulo();
                    d.setIdArticulo(rs.getInt("idArticulo"));
                    d.setNombre(rs.getString("nombreArticulo"));
                    d.setDescuento(rs.getDouble("descuento"));
                    d.setPrecio(rs.getDouble("precio"));
                    d.setUnidades(rs.getInt("cantidad"));
                detalle.add(d);
               
            }
               
            
            
         }catch(Exception e){
           System.err.println("Error" + e);
           
           detalle = null;
         
       }finally{
           try{
               if(con.getConexion()!=null) con.getConexion().close();
               if(pst != null) pst.close();
           }catch(Exception e){
               System.err.println("Error" + e);
           }
       }  
        
        
        return detalle;
    }
    
    public int agregarACarrito(int id, int prod, int cant){
        int prods = 0;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String spAdd = "CALL spAddAlCarrito(?,?,?)";
        
        try {
            cnn = con.getConexion();
            pst = cnn.prepareStatement(spAdd);
            pst.setInt(1, prod);
            pst.setInt(2, cant);
            pst.setInt(3, id);
            
            pst.executeQuery();
                
            rs = pst.getResultSet();
               
            while(rs.next()){
               
               prods = rs.getInt("prods");
            }
               
            
            
         }catch(Exception e){
           System.err.println("Error" + e);
           
           prods = 0;
         
       }finally{
           try{
               if(con.getConexion()!=null) con.getConexion().close();
               if(pst != null) pst.close();
           }catch(Exception e){
               System.err.println("Error" + e);
           }
       }  
        
        
        
        return prods;
        
    }
    
    public boolean quitarProducto(int idU, int prod){
        boolean done = false;
             PreparedStatement pst = null;
      
        String spAdd = "CALL spElimiarArticuloCarrito(?,?)";
        
        try {
            cnn = con.getConexion();
            pst = cnn.prepareStatement(spAdd);
            pst.setInt(1, idU);
            pst.setInt(2, prod);
          
            
            pst.execute();
            done = true;
            
            
         }catch(Exception e){
           System.err.println("Error" + e);
         
          done = false;
       }
        
        
        return done;
    }
    
    public boolean updateCantidad(int idUser, int cantidad, int idProducto)
    {
       boolean done = false;
             PreparedStatement pst = null;
      
        String spAdd = "CALL spActualizarUnidadesCarrito(?,?,?)";
        
        try {
            cnn = con.getConexion();
            pst = cnn.prepareStatement(spAdd);
            pst.setInt(1, idUser);
            pst.setInt(2, idProducto);
            pst.setInt(3, cantidad);
          
            
            pst.execute();
            done = true;
            
            
         }catch(Exception e){
           System.err.println("Error" + e);
         
          done = false;
       }
        
        
        return done;
    }
    public boolean vaciarCarrito(int id){
         boolean done = false;
             PreparedStatement pst = null;
      
        String spAdd = "CALL spVaciarCarrito(?)";
        
        try {
            cnn = con.getConexion();
            pst = cnn.prepareStatement(spAdd);
            pst.setInt(1, id);

          
            
            pst.execute();
            done = true;
            
            
         }catch(Exception e){
           System.err.println("Error" + e);
         
          done = false;
       }
        
        
        return done;
    }
    
    public boolean confirmarCompra(int user, int pago){
        boolean done = false;
             PreparedStatement pst = null;
      
        String spAdd = "CALL spConfirmarCompra(?,?)";
        
        try {
            cnn = con.getConexion();
            pst = cnn.prepareStatement(spAdd);
            pst.setInt(1, user);
            pst.setInt(2, pago);

          
            
            pst.execute();
            done = true;
            
            
         }catch(Exception e){
           System.err.println("Error" + e);
         
          done = false;
       }
        
        
        return done;
    }
    
    
}
