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
public class clientes {
    private int codigoCliente, deuda, pagoclientescodigo;
    private String cliente, descripcion, fechaPago, pago;
    
    public clientes() {
    }

    public clientes(int codigoCliente, int deuda, int pagoclientescodigo, String cliente, String descripcion, String fechaPago, String pago) {
        this.codigoCliente = codigoCliente;
        this.deuda = deuda;
        this.pagoclientescodigo = pagoclientescodigo;
        this.cliente = cliente;
        this.descripcion = descripcion;
        this.fechaPago = fechaPago;
        this.pago = pago;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public int getDeuda() {
        return deuda;
    }

    public void setDeuda(int deuda) {
        this.deuda = deuda;
    }

    public int getPagoclientescodigo() {
        return pagoclientescodigo;
    }

    public void setPagoclientescodigo(int pagoclientescodigo) {
        this.pagoclientescodigo = pagoclientescodigo;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }
    
    public String getPago() {
        return pago;
    }

    public void setPago(String pago) {
        this.pago = pago;
    }
    
}
