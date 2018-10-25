<%@page import="java.util.List"%>
<%@page import="modelo.pedidos"%>
<%@page import="modeloDAO.ferreteriaDAO"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.4.3/css/foundation.min.css"/>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
<link rel="stylesheet" href="css/ferreteria.css"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pedidos</title>
    </head>
    <body>
        <h1 class="text-center">Pedidos</h1>
            <div class="grid-container">
                <div class="grid-x grid-margin-x align-center-middle">
                    <div class="cell small-10">
                        <a href="servlet?accion=nuevoPedido" class="button">
                            Nuevo Pedido <i class="fas fa-plus-circle"></i>
                        </a>
                        <table>
                            <thead>
                                <tr>
                                    <th>Pedido número</th>
                                    <th>Descripción del pedido</th>
                                    <th>Fecha de llegada</th>
                                    <th>Entrega</th>
                                    <th>Opciones</th>
                                </tr>
                            </thead>
                            <%
                                ferreteriaDAO pedidoDao = new ferreteriaDAO();
                                List<pedidos>lista = pedidoDao.observarPedido();
                                Iterator<pedidos>iter = lista.iterator();
                                pedidos pedido = null;
                                while(iter.hasNext()){
                                    pedido = iter.next();
                            %>
                            <tbody>
                                <tr>
                                    <td><%= pedido.getNumeroPedido()%></td>
                                    <td><%= pedido.getDescripcionPedido()%></td>
                                    <td><%= pedido.getFechaLlegada()%></td>
                                    <td><%= pedido.getEntrega()%></td>
                                    <td>
                                        <a class="button warning" href="servlet?accion=editarPedido&numeroPedido=<%= pedido.getNumeroPedido()%>">
                                            Editar <i class="fas fa-edit"></i>
                                        </a>
                                        <a class="button alert" href="servlet?accion=eliminarPedido&numeroPedido=<%= pedido.getNumeroPedido()%>">
                                            Eliminar <i class="fas fa-trash"></i>
                                        </a>
                                    </td>
                                </tr>
                                <%
                                    }
                                %>
                            </tbody>
                        </table>
                            <a href="servlet?accion=productos" class="button marron">
                                Regresar <i class="fas fa-arrow-left"></i>
                            </a>
                    </div>
                </div>
            </div>
    </body>
</html>
