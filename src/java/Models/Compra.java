/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.ResultSet;

/**
 *
 * @author tonny
 */
public class Compra {
    
 private int idCompra;
    private int idUsuario;
    private String fecha;
    private int idMetodoPago;
    private String metodoPago;
    private short confirmacion;
    private double costoTotal;
    
    ResultSet detalleCompra;

    public ResultSet getDetalleCompra() {
        return detalleCompra;
    }

    public void setDetalleCompra(ResultSet detalleCompra) {
        this.detalleCompra = detalleCompra;
    }
    

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdMetodoPago() {
        return idMetodoPago;
    }

    public void setIdMetodoPago(int idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public short getConfirmacion() {
        return confirmacion;
    }

    public void setConfirmacion(short confirmacion) {
        this.confirmacion = confirmacion;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }
    
    
    
}
