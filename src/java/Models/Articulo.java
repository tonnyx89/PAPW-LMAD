/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;



/**
 *
 * @author tonny
 */
public class Articulo extends Conexion {
    
    private int idArticulo;
    private String nombre;
    private String descripcion;
    private double precio;
    private int unidades;
    private double descuento;
    private int visitas;
    private int idVendedor;
    
   private String video;
   private String videoType;
   
    
    private byte [] img1;
    private byte [] img2;
    private byte [] img3;  
       
    private String nombreCat;
    private int idCat;
    
    private float promValoraciones;
    private int valoracion;
    
    public String valoraciones (){
        String val;
         float v =   (this.promValoraciones/5 )* 100;
         int value = (int) v;
         val = Integer.toString(value);
        return val;
    }
    
    public String descuentoPorcentaje(){
        String val;
            double d = this.descuento * 100;
            int dsc = (int) d;
            val= Integer.toString(dsc) + "%";
            
        return val;
    }

    public float getPromValoraciones() {
        return promValoraciones;
    }

    public void setPromValoraciones(float promValoraciones) {
        this.promValoraciones = promValoraciones;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }
   
    

    public String getVideoType() {
        return videoType;
    }

    public void setVideoType(String videoType) {
        this.videoType = videoType;
    }
     

    public int getIdCat() {
        return idCat;
    }

    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }
    

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }
    
   

    public String getNombreCat() {
        return nombreCat;
    }

    public void setNombreCat(String nombreCat) {
        this.nombreCat = nombreCat;
    }

   


    public int getVisitas() {
        return visitas;
    }

    public void setVisitas(int visitas) {
        this.visitas = visitas;
    }

    
    
    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public byte[] getImg1() {
        return img1;
    }

    public void setImg1(byte[] img1) {
        this.img1 = img1;
    }

    public byte[] getImg2() {
        return img2;
    }

    public void setImg2(byte[] img2) {
        this.img2 = img2;
    }

    public byte[] getImg3() {
        return img3;
    }

    public void setImg3(byte[] img3) {
        this.img3 = img3;
    }
    
    
    public Articulo(){
        
    }
   
    
   
    
}
