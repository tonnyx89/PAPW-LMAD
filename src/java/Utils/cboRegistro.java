/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Models.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author tonny
 */
public class cboRegistro extends Conexion {
    
    private int idPais;
    private int idCiudad;
    private int idEstado;

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    
    public cboRegistro(){
        
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }


    
    public ResultSet paises () throws SQLException{
        ResultSet rs;
    String pList = "SELECT idPais, nommbrePais FROM pais";
       
           
        PreparedStatement pst = getConexion().prepareStatement(pList);
           return rs = pst.executeQuery();

    }
    
    
    public ResultSet estados () throws SQLException{
        ResultSet rs;
        String pList = "SELECT idEstado, nombreEstado FROM estado ";


            PreparedStatement pst = getConexion().prepareStatement(pList);
               return rs = pst.executeQuery();

    }
    
    
    public ResultSet ciudades () throws SQLException{
        ResultSet rs;
        String pList = "SELECT idCiudad, nombreCiudad FROM ciudad ";


            PreparedStatement pst = getConexion().prepareStatement(pList);
               return rs = pst.executeQuery();

    }
    
    
    
    
}
