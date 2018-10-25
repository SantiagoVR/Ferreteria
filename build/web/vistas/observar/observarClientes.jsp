<%@page import="java.util.List"%>
<%@page import="modelo.clientes"%>
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
        <title>Clientes</title>
    </head>
    <body>
        <h1 class="text-center">Clientes</h1>
        <div class="grid-container">
            <div class="grid-x grid-margin-x align-center-middle">
                <div class="cell small-12">
                    <a href="servlet?accion=nuevoCliente" class="button">
                        Nuevo Cliente <i class="fas fa-plus-circle"></i>
                    </a>
                    <table>
                        <thead>
                            <tr>
                                <th>Código del cliente</th>
                                <th>Nombre del cliente</th>
                                <th>Deuda que tiene</th>
                                <th>Numero de pago</th>
                                <th>Descripción</th>
                                <th>Fecha del pago</th>
                                <th>Estatus</th>
                                <th>Opciones</th>
                            </tr>
                        </thead>
                        <%
                            ferreteriaDAO clienteDao = new ferreteriaDAO();
                            List<clientes>lista = clienteDao.observarCliente();
                            Iterator<clientes>iter = lista.iterator();
                            clientes cliente = null;
                            while(iter.hasNext()){
                                cliente = iter.next();
                        %>
                        <tbody>
                            <tr>
                                <td><%= cliente.getCodigoCliente()%></td>
                                <td><%= cliente.getCliente()%></td>
                                <td><%= cliente.getDeuda() %></td>
                                <td><%= cliente.getPagoclientescodigo() %></td>
                                <td><%= cliente.getDescripcion()%></td>
                                <td><%= cliente.getFechaPago()%></td>
                                <td><%= cliente.getPago()%></td>
                                <td>
                                    <a class="button warning" href="servlet?accion=editarCliente&codigoCliente=<%= cliente.getCodigoCliente()%>">
                                        Editar <i class="fas fa-edit"></i>
                                    </a>
                                    <a class="button alert" href="servlet?accion=eliminarCliente&codigoCliente=<%= cliente.getCodigoCliente()%>">
                                        Eliminar <i class="fas fa-user-times"></i>
                                    </a>
                                </td>
                            </tr>
                            <%
                                }
                            %>
                        </tbody>
                    </table>
                    <a href="index.jsp" class="button marron">
                        Regresar <i class="fas fa-arrow-left"></i>
                    </a>
                </div>
            </div>
        </div>
    </body>
</html>
