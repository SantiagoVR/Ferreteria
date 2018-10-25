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
public class pedidos {
    private int numeroPedido;
    private String descripcionPedido, fechaLlegada, entrega;
    
    public pedidos() {
    }

    public pedidos(int numeroPedido, String descripcionPedido, String fechaLlegada, String entrega) {
        this.numeroPedido = numeroPedido;
        this.descripcionPedido = descripcionPedido;
        this.fechaLlegada = fechaLlegada;
        this.entrega = entrega;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public String getDescripcionPedido() {
        return descripcionPedido;
    }

    public void setDescripcionPedido(String descripcionPedido) {
        this.descripcionPedido = descripcionPedido;
    }

    public String getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(String fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }
    
    public String getEntrega() {
        return entrega;
    }

    public void setEntrega(String entrega) {
        this.entrega = entrega;
    }
    
}
