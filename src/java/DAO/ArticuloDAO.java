/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author tonny
 */
package DAO;


import Models.Articulo;
import Models.Conexion;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


public class ArticuloDAO{
    Conexion con = new Conexion();
    Connection cnn;
    PreparedStatement ps;
    ResultSet rs;
    public Articulo a = new Articulo();
     
   
    public List resultados(String parametro, int idCat, String inicio, String fin,int tipo) {
        ArrayList<Articulo> lista = new ArrayList<Articulo>();
        String param = "CALL spBusquedaMixta(?,?,?,?,?);";
        try{
            cnn = con.getConexion();
            ps = cnn.prepareStatement(param); 
            ps.setString(1, parametro);
            ps.setInt(2,idCat);
            ps.setString(3, inicio);
            ps.setString(4, fin);
            ps.setInt(5,tipo);
            rs = ps.executeQuery();
            while(rs.next()){
                Articulo art = new Articulo();
                art.setIdArticulo(rs.getInt("idArticulo"));
                art.setNombre(rs.getString("nombreArticulo"));
                art.setPrecio(rs.getDouble("precio"));
                art.setNombreCat(rs.getString("nombreCategoria"));
                art.setImg1(rs.getBytes("imagen"));
                lista.add(art);
                
                System.out.println(art);
            }
            
        } catch(Exception e){
            
        }
        return lista;
    }
    
    public List IndexLandscape(int op){
        ArrayList<Articulo> lista = new ArrayList<Articulo>();
        String param = "CALL spPaginaPrincipal(?);";
        try{
            cnn = con.getConexion();
            ps = cnn.prepareStatement(param); 
            ps.setInt(1, op);
            rs = ps.executeQuery();
            while(rs.next()){
                Articulo art = new Articulo();
                art.setIdArticulo(rs.getInt("idArticulo"));
                art.setNombre(rs.getString("nombreArticulo"));
                art.setPrecio(rs.getDouble("precio"));
                art.setDescuento(rs.getDouble("descuento"));
                art.setImg1(rs.getBytes("imagen"));
                if(op > 4 ){
                    art.setUnidades(rs.getInt("vendidos"));
                }
                lista.add(art);
                
                System.out.println(art);
            }
            
        } catch(Exception e){
            
        }
        return lista;
    
    }

    public void verImagen(int id, HttpServletResponse response){
        String query = "SELECT * FROM imagen WHERE idArticulo = ? LIMIT 1";
        InputStream is = null;
        OutputStream os = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        response.setContentType("image/*");
        try{
            os = response.getOutputStream();
            cnn = con.getConexion();
            ps = cnn.prepareStatement(query); 
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                is = rs.getBinaryStream("imagen");
            }
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream (os);
            int i = 0;
            while((i = bis.read())!= -1){
                bos.write(i);
            }
            
        }catch(Exception e){

        }
    }

    public boolean agrearArticulo(Articulo an) {
        boolean agregado = false;
        a = an;
        PreparedStatement pst = null;
        rs = null;
       try{
           cnn = con.getConexion();
           String spAdd = "CALL spNuevoArticulo(?,?,?,?,?)";
           pst = cnn.prepareStatement(spAdd);
           pst.setString(1, a.getNombre());
           pst.setString(2,a.getDescripcion());
           pst.setDouble(3, a.getPrecio());
           pst.setInt(4, a.getUnidades());
           pst.setDouble(5, a.getDescuento());
           
           rs = pst.executeQuery();
           int idNArt = 0;
           
           while(rs.next()){
             a.setIdArticulo( rs.getInt("idp"));
           }
             
           idNArt = a.getIdArticulo();
           
           
           rs.close();
           if(idNArt > 0){
           cnn = con.getConexion();
           spAdd = "CALL spCategoriasNuevoArticulo(?,?)";
           pst = cnn.prepareStatement(spAdd);
           pst.setInt(1, a.getIdCat());
           pst.setInt(2, idNArt);
           
            
          if(pst.execute()){
              agregado = true;             
          }
          rs.close();
       }
          
          
       }catch(Exception e){
           System.err.println("Error" + e);
       }
        
        return agregado;
    }
    
    public boolean agregarImagen(Part file, int art){
        boolean si = false;
         PreparedStatement pst = null;
       try{
          
           InputStream is = file.getInputStream();
           cnn = con.getConexion();
           String spAdd = "CALL spImagenesNuevoArticulo(?,?,?); "; 
            pst = cnn.prepareStatement(spAdd);
            pst.setInt(1, art);
            pst.setBlob(2, is);
            pst.setString(3, "image/png");
            if(pst.execute()){
               si = true; 
            }        
            
       }catch(Exception e){
           System.err.println("Error" + e);
           si = false;
       }
        
        return si;
    }
    
    public boolean agregarVideo(String ruta, String tipo, int id){
       boolean si = false;
         PreparedStatement pst = null;
       try{
          
           
           cnn = con.getConexion();
           String spAdd = "call spVideosNuevoArticulo(?,?,?); "; 
            pst = cnn.prepareStatement(spAdd);
            pst.setString(1, ruta);
            pst.setString(2, tipo);
            pst.setInt(3, id);
            if(pst.execute()){
               si = true; 
            }        
            
       }catch(Exception e){
           System.err.println("Error" + e);
           si = false;
       }
        
        return si;
    }
    

    public boolean editarArticulo(Articulo a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean publicarArticulo(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
    public boolean eliminarArticulo(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public boolean valorarArticulo(int id, int usuario, double stars){
        
         String param = "CALL spValorarProducto(?,?,?);";
        try{
            cnn = con.getConexion();
            ps = cnn.prepareStatement(param); 
            ps.setInt(1, usuario);
            ps.setInt(2,id);
            ps.setDouble(3,stars);
            ps.executeQuery();
           
            return true;
        } catch(Exception e){
            return false;
        }
        
    }
    
}
