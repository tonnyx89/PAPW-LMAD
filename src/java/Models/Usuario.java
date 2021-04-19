/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author tonny
 */
public class Usuario extends Conexion {
    
    private String nombre;
    private String apellido;
    private String correo;
    private String nickname;
    private String password;
    private String avatarRuta;

   private long telefono;
    private int pais;
    private int ciudad;
    private int estado;
    private int numero;
    private String calle;
    private String colonia;
    
    private int idUsuario;
     private byte[] avatar;
     
     
   private int prodsCar;
   
   private String PaisNom;
   private String CiudadNom;
   private String EstadoNom;
   
   private boolean PuedeValorar;

    public boolean isPuedeValorar() {
        return PuedeValorar;
    }

    public void setPuedeValorar(boolean PuedeValorar) {
        this.PuedeValorar = PuedeValorar;
    }

    public String getPaisNom() {
        return PaisNom;
    }

    public void setPaisNom(String PaisNom) {
        this.PaisNom = PaisNom;
    }

    public String getCiudadNom() {
        return CiudadNom;
    }

    public void setCiudadNom(String CiudadNom) {
        this.CiudadNom = CiudadNom;
    }

    public String getEstadoNom() {
        return EstadoNom;
    }

    public void setEstadoNom(String EstadoNom) {
        this.EstadoNom = EstadoNom;
    }


    public int getProdsCar() {
        return prodsCar;
    }

    public void setProdsCar(int prodsCar) {
        this.prodsCar = prodsCar;
    }
    
  

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getPais() {
        return pais;
    }

    public void setPais(int pais) {
        this.pais = pais;
    }

    public int getCiudad() {
        return ciudad;
    }

    public void setCiudad(int ciudad) {
        this.ciudad = ciudad;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getAvatarRuta() {
        return avatarRuta;
    }

    public void setAvatarRuta(String avatarRuta) {
        this.avatarRuta = avatarRuta;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
    
    
   public Usuario user(){
       return this;
   }
    
   
   public Usuario(){
       
   }
    
   public Usuario(String nickname, int id){
       this.idUsuario = id;
       this.nickname = nickname;
   }
   
   public Usuario(String nickname, String Password){
       this.nickname = nickname;
       this.correo = nickname;
       this.password = Password;
   }

   
   public Usuario( String nombre, String apellido, String correo, String nickname, String password,long telefono,  String imagen,
                    String calle, String colonia, int numero, int pais, int estado,int ciudad)
   {
       this.nombre = nombre;
       this.apellido = apellido;
       this.correo = correo;
       this.nickname = nickname;
       this.password = password;
       this.telefono = telefono;
       this.avatarRuta = imagen; 
       this.calle = calle;
       this.numero = numero;
       this.colonia = colonia;
       this.pais = pais;
       this.estado = estado;
       this.ciudad = pais;
   }
   
   
   public boolean puedeValorar(int id, int prod){
       Conexion con = new Conexion();
    Connection cnn;
    PreparedStatement ps;
    ResultSet rs;
    
    PreparedStatement pst = null;
       try{
           cnn = con.getConexion();
           
           
           String spAdd = "CALL spValidaValora(?,?)";
           pst = cnn.prepareStatement(spAdd);
           pst.setInt(1, id);
           pst.setInt(2,prod);
           
           


              
              
           if(pst.execute()){
             return true;
           }
           
           pst.close();
           
       }catch(Exception e){
           System.err.println("Error" + e);
       }finally{
           try{
               if(con.getConexion()!=null) con.getConexion().close();
               if(pst != null) pst.close();
           }catch(Exception e){
               System.err.println("Error" + e);
           }
       }
       
       

       return false;
   }
 
   
}
