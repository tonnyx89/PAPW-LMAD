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
public class Chat {
    private boolean estado;
    private int idCompra;
    private int idCliente;
    private ResultSet mensajes;

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public ResultSet getMensajes() {
        return mensajes;
    }

    public void setMensajes(ResultSet mensajes) {
        this.mensajes = mensajes;
    }
}
