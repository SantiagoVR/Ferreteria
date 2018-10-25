/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author esvr
 */
public class viajes {
    private int codigo, dinero;
    private String nombreCliente, fechaEntrega, materiales, descripcion, entrega;
    
    public viajes() {
    }

    public viajes(int codigo, int dinero, String nombreCliente, String fechaEntrega, String materiales, String descripcion, String entrega) {
        this.codigo = codigo;
        this.dinero = dinero;
        this.nombreCliente = nombreCliente;
        this.fechaEntrega = fechaEntrega;
        this.materiales = materiales;
        this.descripcion = descripcion;
        this.entrega = entrega;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getMateriales() {
        return materiales;
    }

    public void setMateriales(String materiales) {
        this.materiales = materiales;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getEntrega() {
        return entrega;
    }

    public void setEntrega(String entrega) {
        this.entrega = entrega;
    }
}
