/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import modelo.clientes;
import modelo.productos;
import modelo.pedidos;
import modelo.viajes;

/**
 *
 * @author esvr
 */
public interface CRUD {
    public List observarProducto();
    public productos listaProductos(int codigo);
    public boolean nuevoProducto(productos producto);
    public boolean editarProducto(productos producto);
    public boolean eliminarProducto(int codigo);
    public boolean buscarProducto(String nombre);
    
    public List observarPedido();
    public pedidos listaPedidos(int codigoPedido);
    public boolean nuevoPedido(pedidos pedido);
    public boolean editarPedido(pedidos pedido);
    public boolean eliminarPedido(int codigoPedido);
    
    public List observarViajes();
    public viajes listaViajes(int codigoViaje);
    public boolean nuevoViaje(viajes viaje);
    public boolean editarViaje(viajes viaje);
    public boolean eliminarViaje(int codigoViaje);
    
    public List observarCliente();
    public clientes listaClientes(int codigoCliente);
    public boolean nuevoCliente(clientes cliente);
    public boolean editarCliente(clientes cliente);
    public boolean eliminarCliente(int codigoCliente);
       
}
