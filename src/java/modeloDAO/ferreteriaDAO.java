/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAO;

import interfaces.CRUD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import configuracion.conexion;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.clientes;
import modelo.pedidos;
import modelo.productos;
import modelo.viajes;

/**
 *
 * @author esvr
 */
public class ferreteriaDAO implements CRUD{

    conexion conexionBD = new conexion();
    Connection conexion;
    PreparedStatement preparedStatement;
    ResultSet result;
    productos producto = new productos();
    pedidos pedido = new pedidos();
    viajes viaje = new viajes();
    clientes cliente = new clientes();
    
    @Override
    public List observarProducto() {
       ArrayList<productos>list=new ArrayList<>();
        String sql="select * from productos";
        try {
            conexion = conexionBD.getConexion();
            preparedStatement = conexion.prepareStatement(sql);
            result = preparedStatement.executeQuery();
            while(result.next()){
                productos producto = new productos();
                producto.setCodigo(result.getInt("codigo"));
                producto.setNombre(result.getString("nombre"));
                producto.setCantidad(result.getInt("cantidad"));
                producto.setPrecio(result.getInt("precio"));
                producto.setDescripcionProducto(result.getString("descripcionProducto"));
                producto.setCategoria(result.getString("categoria"));
                producto.setUbicacion(result.getString("ubicacion"));
                list.add(producto);
                System.out.println("Lista de los productos exitosa");
            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error en la lista de los productos : " + e);
        }
        return list;
    }

    @Override
    public productos listaProductos(int codigo) {
        String sql="select * from productos where codigo =" + codigo;
        try {
            conexion = conexionBD.getConexion();
            preparedStatement = conexion.prepareStatement(sql);
            result = preparedStatement.executeQuery();
            while(result.next()){
                producto.setCodigo(result.getInt("codigo"));
                producto.setNombre(result.getString("nombre"));
                producto.setCantidad(result.getInt("cantidad"));
                producto.setPrecio(result.getInt("precio"));
                producto.setDescripcionProducto(result.getString("descripcionProducto"));
                producto.setCategoria(result.getString("categoria"));
                producto.setUbicacion(result.getString("ubicacion"));
            }
            System.out.println("Producto en especifico exitoso");
        } catch (Exception e) {
            System.out.println("Ocurrio un error tomar un producto en especifico : " + e);
        }
        return producto;
    }

    @Override
    public boolean nuevoProducto(productos producto) {
        String sql = "insert into productos (nombre,cantidad,precio,descripcionProducto,categoria,ubicacion) values ('"+ producto.getNombre() +"',"
                + "'"+ producto.getCantidad()+"', '"+ producto.getPrecio()+"', '"+ producto.getDescripcionProducto()+"', '"+ producto.getCategoria() + "', '" + producto.getUbicacion()+ "')";
        try{
            conexion = conexionBD.getConexion();
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.executeUpdate();
        System.out.println("Se agrego un nuevo producto");
        } catch(Exception e){
            System.out.println("Ocurrio un error al agregar un nuevo producto : " + e);
        }
        return false; 
    }
    
    @Override
    public boolean editarProducto(productos producto) {
        String sql = "update productos set nombre='"+ producto.getNombre() +"', cantidad='"+ producto.getCantidad()+"', precio='"+ producto.getPrecio()+
                "',descripcionProducto='"+ producto.getDescripcionProducto()+"',categoria= '"+ producto.getCategoria() +"',ubicacion= '"+ producto.getUbicacion() +"' where codigo=" + producto.getCodigo();
        try{
            conexion = conexionBD.getConexion();
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.executeUpdate();
        System.out.println("Se modifico el producto con exito");
        } catch(Exception e){
            System.out.println("Ocurrio un error al modificar el producto : " + e);
        }
        return false; 
    }

    @Override
    public boolean eliminarProducto(int codigo) {
        String sql="delete from productos where codigo = " + codigo;
        try {
            conexion = conexionBD.getConexion();
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.executeUpdate();
        System.out.println("Se elimino el producto con exito");
        } catch (Exception e) {
            System.out.println("Ocurrio un error al borrar un producto : " + e);
        }
        return false;
    }
    
    @Override
    public boolean buscarProducto(String nombre) {
        String sql="select * from productos where nombre LIKE '" + nombre +"'";
        try {
            conexion = conexionBD.getConexion();
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.executeQuery();
            System.out.println("Busqueda de los productos exitosa");
            } catch (SQLException ex) {
            System.out.println("Ocurrio un error en la busqueda de los productos : " + ex);
        }
        return false;
    }
       
    @Override
    public List observarPedido() {
        ArrayList<pedidos>list = new ArrayList<>();
        String sql="select * from pedidos";
        try {
            conexion = conexionBD.getConexion();
            preparedStatement = conexion.prepareStatement(sql);
            result = preparedStatement.executeQuery();
            while(result.next()){
                pedidos pedido = new pedidos();
                pedido.setNumeroPedido(result.getInt("numeroPedido"));
                pedido.setDescripcionPedido(result.getString("descripcionPedido"));
                pedido.setFechaLlegada(result.getString("fechaLlegada"));
                pedido.setEntrega(result.getString("entrega"));
                list.add(pedido);
                System.out.println("Lista de los pedidos exitosa");
            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error en la lista de los pedidos : " + e);
        }
        return list;
    }

    @Override
    public pedidos listaPedidos(int codigoPedido) {
        String sql="select * from pedidos where numeroPedido =" + codigoPedido;
        try {
            conexion = conexionBD.getConexion();
            preparedStatement = conexion.prepareStatement(sql);
            result = preparedStatement.executeQuery();
            while(result.next()){
                pedido.setNumeroPedido(result.getInt("numeroPedido"));
                pedido.setDescripcionPedido(result.getString("descripcionPedido"));
                pedido.setFechaLlegada(result.getString("fechaLlegada"));
                pedido.setEntrega(result.getString("entrega"));
            }
        System.out.println("Pedido en especifico exitoso");
        } catch (Exception e) {
            System.out.println("Ocurrio un error tomar un pedido en especifico : " + e);
        }
        return pedido;
    }

    @Override
    public boolean nuevoPedido(pedidos pedido) {
        String sql = "insert into pedidos (descripcionPedido,fechaLlegada,entrega) values ('"+ pedido.getDescripcionPedido()+"','"
                + pedido.getFechaLlegada()+ "','" + pedido.getEntrega()+"')";
        try{
            conexion = conexionBD.getConexion();
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.executeUpdate();
        System.out.println("Se agrego un nuevo pedido");
        } catch(Exception e){
            System.out.println("Ocurrio un error al agregar un nuevo pedido : " + e);
        }
        return false;  
    }

    @Override
    public boolean editarPedido(pedidos pedido) {
        String sql = "update pedidos set descripcionPedido='"+ pedido.getDescripcionPedido() +"', fechaLlegada='"+ pedido.getFechaLlegada()+
                "', entrega='"+ pedido.getEntrega() + "' where numeroPedido=" + pedido.getNumeroPedido();
        try{
            conexion = conexionBD.getConexion();
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.executeUpdate();
            System.out.println("Se modifico el pedido con exito");
        } catch(Exception e){
            System.out.println("Ocurrio un error al modificar el pedido : " + e);
        }
        return false; 
    }

    @Override
    public boolean eliminarPedido(int numeroPedido) {
        String sql="delete from pedidos where numeroPedido = " + numeroPedido;
        try {
            conexion = conexionBD.getConexion();
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.executeUpdate();
            System.out.println("Se elimino el pedido con exito");
        } catch (Exception e) {
            System.out.println("Ocurrio un error al borrar un pedido : " + e);
        }
        return false;
    }

    @Override
    public List observarViajes() {
        ArrayList<viajes>list=new ArrayList<>();
        String sql="select * from viajes";
        try {
            conexion = conexionBD.getConexion();
            preparedStatement = conexion.prepareStatement(sql);
            result = preparedStatement.executeQuery();
            while(result.next()){
                viajes viaje = new viajes();
                viaje.setCodigo(result.getInt("codigo"));
                viaje.setNombreCliente(result.getString("nombreCliente"));
                viaje.setFechaEntrega(result.getString("fechaEntrega"));
                viaje.setMateriales(result.getString("materiales"));
                viaje.setDescripcion(result.getString("descripcion"));
                viaje.setDinero(result.getInt("dinero"));
                viaje.setEntrega(result.getString("entrega"));
                list.add(viaje);
                System.out.println("Lista de los viajes exitosa");
            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error en la lista de los viajes : " + e);
        }
        return list;
    }

    @Override
    public viajes listaViajes(int codigoViaje) {
        String sql="select * from viajes where codigo =" + codigoViaje;
        try {
            conexion = conexionBD.getConexion();
            preparedStatement = conexion.prepareStatement(sql);
            result = preparedStatement.executeQuery();
            while(result.next()){
                viaje.setCodigo(result.getInt("codigo"));
                viaje.setNombreCliente(result.getString("nombreCliente"));
                viaje.setFechaEntrega(result.getString("fechaEntrega"));
                viaje.setMateriales(result.getString("materiales"));
                viaje.setDescripcion(result.getString("descripcion"));
                viaje.setDinero(result.getInt("dinero"));
                viaje.setEntrega(result.getString("entrega"));
            }
            System.out.println("Viaje en especifico exitoso");
        } catch (Exception e) {
            System.out.println("Ocurrio un error tomar un viaje en especifico : " + e);
        }
        return viaje;
    }

    @Override
    public boolean nuevoViaje(viajes viaje) {
        String sql = "insert into viajes (nombreCliente,fechaEntrega,materiales,descripcion,dinero,entrega) values ('"+ viaje.getNombreCliente() +"',"
                + "'"+ viaje.getFechaEntrega()+"', '"+ viaje.getMateriales()+"', '"+ viaje.getDescripcion()+"', '"+ viaje.getDinero() +"', '"+ viaje.getEntrega()+"')";
        try{
            conexion = conexionBD.getConexion();
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.executeUpdate();
            System.out.println("Se agrego un nuevo viaje");
        } catch(Exception e){
            System.out.println("Ocurrio un error al agregar un nuevo viaje : " + e);
        }
        return false;
    }

    @Override
    public boolean editarViaje(viajes viaje) {
        String sql = "update viajes set nombreCliente='"+ viaje.getNombreCliente() +"', fechaEntrega='"+ viaje.getFechaEntrega() + "', materiales='"+ 
                viaje.getMateriales()+"',descripcion='"+ viaje.getDescripcion()+"',dinero= '"+ viaje.getDinero() +"',entrega= '"+ viaje.getEntrega() +"' where codigo=" + viaje.getCodigo();
        try{
            conexion = conexionBD.getConexion();
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.executeUpdate();
            System.out.println("Se modifico el viaje con exito");
        } catch(Exception e){
            System.out.println("Ocurrio un error al modificar el viaje : " + e);
        }
        return false;
    }

    @Override
    public boolean eliminarViaje(int codigoViaje) {
        String sql="delete from viajes where codigo = " + codigoViaje;
        try {
            conexion = conexionBD.getConexion();
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.executeUpdate();
            System.out.println("Se elimino el viaje con exito");
        } catch (Exception e) {
            System.out.println("Ocurrio un error al borrar un viaje : " + e);
        }
        return false;
    }

    @Override
    public List observarCliente() {
        ArrayList<clientes>list=new ArrayList<>();
        String sql="select * from clientes";
        try {
            conexion = conexionBD.getConexion();
            preparedStatement = conexion.prepareStatement(sql);
            result = preparedStatement.executeQuery();
            while(result.next()){
                clientes cliente = new clientes();
                cliente.setCodigoCliente(result.getInt("codigo"));
                cliente.setCliente(result.getString("cliente"));
                cliente.setDeuda(result.getInt("deuda"));
                cliente.setPagoclientescodigo(result.getInt("pagoclientescodigo"));
                cliente.setDescripcion(result.getString("descripcion"));
                cliente.setFechaPago(result.getString("fechaPago"));
                cliente.setPago(result.getString("pago"));
                list.add(cliente);
                System.out.println("Lista de los clientes exitosa");
            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error en la lista de los clientes : " + e);
        }
        return list;
    }

    @Override
    public clientes listaClientes(int codigoCliente) {
        String sql="select * from clientes where codigo =" + codigoCliente;
        try {
            conexion = conexionBD.getConexion();
            preparedStatement = conexion.prepareStatement(sql);
            result = preparedStatement.executeQuery();
            while(result.next()){
                cliente.setCodigoCliente(result.getInt("codigo"));
                cliente.setCliente(result.getString("cliente"));
                cliente.setDeuda(result.getInt("deuda"));
                cliente.setPagoclientescodigo(result.getInt("pagoclientescodigo"));
                cliente.setDescripcion(result.getString("descripcion"));
                cliente.setFechaPago(result.getString("fechaPago"));
                cliente.setPago(result.getString("pago"));
            }
         System.out.println("Cliente en especifico exitoso");
        } catch (Exception e) {
            System.out.println("Ocurrio un error tomar un cliente en especifico : " + e);
        }
        return cliente;
    }

    @Override
    public boolean nuevoCliente(clientes cliente) {
        String sql = "insert into clientes (cliente,deuda,pagoclientescodigo,descripcion,fechaPago,pago) values ('"+ cliente.getCliente()+"',"
                + "'"+ cliente.getDeuda()+"', '"+ cliente.getPagoclientescodigo()+"', '"+ cliente.getDescripcion()+"', '"+ cliente.getFechaPago() +"', '"+ cliente.getPago()+"')";
        try{
            conexion=conexionBD.getConexion();
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.executeUpdate();
            System.out.println("Se agrego un nuevo cliente");
        } catch(Exception e){
            System.out.println("Ocurrio un error al agregar un nuevo cliente : " + e);
        }
        return false;
    }

    @Override
    public boolean editarCliente(clientes cliente) {
        String sql = "update clientes set cliente='"+ cliente.getCliente() +"', deuda='"+ cliente.getDeuda()+"', pagoclientescodigo='"+ cliente.getPagoclientescodigo()
                +"',descripcion='"+ cliente.getDescripcion() +"',fechaPago= '"+ cliente.getFechaPago() +"',pago= '"+ cliente.getPago() +"' where codigo=" + cliente.getCodigoCliente();
        try{
            conexion=conexionBD.getConexion();
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.executeUpdate();
            System.out.println("Se modifico el cliente con exito");
        } catch(Exception e){
            System.out.println("Ocurrio un error al modificar el cliente : " + e);
        }
        return false;
    }

    @Override
    public boolean eliminarCliente(int codigoCliente) {
        String sql="delete from clientes where codigo = " + codigoCliente;
        try {
            conexion=conexionBD.getConexion();
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.executeUpdate();
            System.out.println("Se elimino el cliente con exito");
        } catch (Exception e) {
            System.out.println("Ocurrio un error al borrar un cliente : " + e);
        }
        return false;
    }
    
}
