/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import modelo.productos;
import modelo.pedidos;
import modelo.viajes;
import modelo.clientes;
import modeloDAO.ferreteriaDAO;

/**
 *
 * @author esvr
 */

public class servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    String observar = "vistas/observar/observar.jsp";
    String nuevo = "vistas/nuevos/nuevo.jsp";
    String editar = "vistas/edicion/editar.jsp";
    
    String observarPedidos = "vistas/observar/observarPedidos.jsp";
    String nuevoPedido = "vistas/nuevos/nuevoPedido.jsp";
    String editarPedido = "vistas/edicion/editarPedido.jsp";
    
    String observarViajes = "vistas/observar/observarViajes.jsp";
    String nuevoViaje = "vistas/nuevos/nuevoViaje.jsp";
    String editarViaje = "vistas/edicion/editarViaje.jsp";
    
    String observarCliente = "vistas/observar/observarClientes.jsp";
    String nuevoCliente = "vistas/nuevos/nuevoCliente.jsp";
    String editarCliente = "vistas/edicion/editarCliente.jsp";
    
    productos producto = new productos();
    pedidos pedido = new pedidos();  
    viajes viaje = new viajes();  
    clientes cliente = new clientes();  
    
    ferreteriaDAO controlDao = new ferreteriaDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso = "";
        String action = request.getParameter("accion");
        if(action.equalsIgnoreCase("productos")){
            acceso = observar;
        }else if(action.equalsIgnoreCase("nuevoProducto")){
            acceso = nuevo;
        }else if(action.equalsIgnoreCase("agregar")){
            String nombre = request.getParameter("nombre");
            int cantidad = Integer.parseInt(request.getParameter("cantidad"));
            int precio = Integer.parseInt(request.getParameter("precio"));
            String descripcion = request.getParameter("descripcion");
            String categoria = request.getParameter("categoria");
            String ubicacion = request.getParameter("ubicacion");
            producto.setNombre(nombre);
            producto.setCantidad(cantidad);
            producto.setPrecio(precio);
            producto.setDescripcionProducto(descripcion);
            producto.setCategoria(categoria);
            producto.setUbicacion(ubicacion);
            controlDao.nuevoProducto(producto);
            acceso = observar;
        }else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("codigoProducto", request.getParameter("codigo"));
            acceso = editar;
        }else if(action.equalsIgnoreCase("modificar")){
            int codigo = Integer.parseInt(request.getParameter("codigoPro"));
            String nombre = request.getParameter("nombre");
            int cantidad = Integer.parseInt(request.getParameter("cantidad"));
            int precio = Integer.parseInt(request.getParameter("precio"));
            String descripcion = request.getParameter("descripcion");
            String categoria = request.getParameter("categoria");
            String ubicacion = request.getParameter("ubicacion");
            producto.setCodigo(codigo);
            producto.setNombre(nombre);
            producto.setCantidad(cantidad);
            producto.setPrecio(precio);
            producto.setDescripcionProducto(descripcion);
            producto.setCategoria(categoria);
            producto.setUbicacion(ubicacion);
            controlDao.editarProducto(producto);
            acceso = observar;
        }else if(action.equalsIgnoreCase("eliminar")){
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            producto.setCodigo(codigo);
            controlDao.eliminarProducto(codigo);
            acceso = observar;
        //Pedidos
        } else if(action.equalsIgnoreCase("pedidos")){
            acceso = observarPedidos;
        }else if(action.equalsIgnoreCase("nuevoPedido")){
            acceso = nuevoPedido;
        }else if(action.equalsIgnoreCase("Agregar Pedido")){
            String descripcionPedido = request.getParameter("descripcionPedido");
            String fechaLlegada = request.getParameter("fechaLlegada");
            String entrega = request.getParameter("entrega");
            pedido.setDescripcionPedido(descripcionPedido);
            pedido.setFechaLlegada(fechaLlegada);
            pedido.setEntrega(entrega);
            controlDao.nuevoPedido(pedido);
            acceso = observarPedidos;
        }else if(action.equalsIgnoreCase("editarPedido")){
            request.setAttribute("numeroPedido", request.getParameter("numeroPedido"));
            acceso = editarPedido;
        }else if(action.equalsIgnoreCase("Modificar Pedido")){
            int numeroPedido = Integer.parseInt(request.getParameter("numeroPed"));
            String descripcion = request.getParameter("descripcionPedido");
            String fecha = request.getParameter("fechaLlegada");
            String entrega = request.getParameter("entrega");
            pedido.setNumeroPedido(numeroPedido);
            pedido.setDescripcionPedido(descripcion);
            pedido.setFechaLlegada(fecha);
            pedido.setEntrega(entrega);
            controlDao.editarPedido(pedido);
            acceso = observarPedidos;
        }else if(action.equalsIgnoreCase("eliminarPedido")){
            int numeroPedido = Integer.parseInt(request.getParameter("numeroPedido"));
            pedido.setNumeroPedido(numeroPedido);
            controlDao.eliminarPedido(numeroPedido);
            acceso = observarPedidos;
        //Viajes
        } else if(action.equalsIgnoreCase("viajes")){
            acceso = observarViajes;
        }else if(action.equalsIgnoreCase("nuevoViaje")){
            acceso = nuevoViaje;
        }else if(action.equalsIgnoreCase("Agregar Viaje")){
            String nombreCliente = request.getParameter("nombreCliente");
            String fechaEntrega = request.getParameter("fechaEntrega");
            String materiales = request.getParameter("materiales");
            String descripcion = request.getParameter("descripcion");
            int dinero = Integer.parseInt(request.getParameter("dinero"));
            String entrega = request.getParameter("entrega");
            viaje.setNombreCliente(nombreCliente);
            viaje.setFechaEntrega(fechaEntrega);
            viaje.setMateriales(materiales);
            viaje.setDescripcion(descripcion);
            viaje.setDinero(dinero);
            viaje.setEntrega(entrega);
            controlDao.nuevoViaje(viaje);
            acceso = observarViajes;
        }else if(action.equalsIgnoreCase("editarViaje")){
            request.setAttribute("codigoViaje", request.getParameter("codigoViaje"));
            acceso = editarViaje;
        }else if(action.equalsIgnoreCase("Modificar Viaje")){
            int codigo = Integer.parseInt(request.getParameter("codigoViaje"));
            String nombreCliente = request.getParameter("nombreCliente");
            String fechaEntrega = request.getParameter("fechaEntrega");
            String materiales = request.getParameter("materiales");
            String descripcion = request.getParameter("descripcion");
            int dinero = Integer.parseInt(request.getParameter("dinero"));
            String entrega = request.getParameter("entrega");
            viaje.setCodigo(codigo);
            viaje.setNombreCliente(nombreCliente);
            viaje.setFechaEntrega(fechaEntrega);
            viaje.setMateriales(materiales);
            viaje.setDescripcion(descripcion);
            viaje.setDinero(dinero);
            viaje.setEntrega(entrega);
            controlDao.editarViaje(viaje);
            acceso = observarViajes;
        }else if(action.equalsIgnoreCase("eliminarViaje")){
            int codigo = Integer.parseInt(request.getParameter("codigoViaje"));
            viaje.setCodigo(codigo);
            controlDao.eliminarViaje(codigo);
            acceso = observarViajes;
        //Clientes
        } else if(action.equalsIgnoreCase("clientes")){
            acceso = observarCliente;
        }else if(action.equalsIgnoreCase("nuevoCliente")){
            acceso = nuevoCliente;
        }else if(action.equalsIgnoreCase("Agregar Cliente")){
            String nombreCliente = request.getParameter("nombreCliente");
            int deuda = Integer.parseInt(request.getParameter("deuda"));
            int numeroPago = Integer.parseInt(request.getParameter("numeroPago"));
            String descripcion = request.getParameter("descripcion");
            String fechaPago = request.getParameter("fechaPago");
            String pago = request.getParameter("pago");
            cliente.setCliente(nombreCliente);
            cliente.setDeuda(deuda);
            cliente.setPagoclientescodigo(numeroPago);
            cliente.setDescripcion(descripcion);
            cliente.setFechaPago(fechaPago);
            cliente.setPago(pago);
            controlDao.nuevoCliente(cliente);
            acceso = observarCliente;
        }else if(action.equalsIgnoreCase("editarCliente")){
            request.setAttribute("codigoCliente", request.getParameter("codigoCliente"));
            acceso = editarCliente;
        }else if(action.equalsIgnoreCase("Modificar Cliente")){
            int codigoCliente = Integer.parseInt(request.getParameter("codigoCliente"));
            String nombreCliente = request.getParameter("nombreCliente");
            int deuda = Integer.parseInt(request.getParameter("deuda"));
            int pagoNumero = Integer.parseInt(request.getParameter("pagoNumero"));
            String descripcion = request.getParameter("descripcion");
            String fechaPago = request.getParameter("fechaPago");
            String pago = request.getParameter("pago");
            cliente.setCodigoCliente(codigoCliente);
            cliente.setCliente(nombreCliente);
            cliente.setDeuda(deuda);
            cliente.setPagoclientescodigo(pagoNumero);
            cliente.setDescripcion(descripcion);
            cliente.setFechaPago(fechaPago);
            cliente.setPago(pago);
            controlDao.editarCliente(cliente);
            acceso = observarCliente;
        }else if(action.equalsIgnoreCase("eliminarCliente")){
            int codigo = Integer.parseInt(request.getParameter("codigoCliente"));
            cliente.setCodigoCliente(codigo);
            controlDao.eliminarCliente(codigo);
            acceso = observarCliente;
        }else if(action.equalsIgnoreCase("buscarProducto")){
            String nombre = request.getParameter("nombre");
            producto.setNombre(nombre);
            controlDao.buscarProducto(nombre);
            acceso = observar;
        }
       RequestDispatcher vista = request.getRequestDispatcher(acceso);
       vista.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
