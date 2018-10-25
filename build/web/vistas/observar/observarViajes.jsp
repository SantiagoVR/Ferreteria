<%@page import="java.util.List"%>
<%@page import="modelo.viajes"%>
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
        <title>Viajes</title>
    </head>
    <body>
        <h1 class="text-center">Viajes</h1>
            <div class="grid-container">
                <div class="grid-x grid-margin-x align-center-middle">
                    <div class="cell small-10">
                        <a href="servlet?accion=nuevoViaje" class="button">
                            Nuevo Viaje <i class="fas fa-plus-circle"></i>
                        </a>
                        <table>
                            <thead>
                                <tr>
                                    <th>Código viaje</th>
                                    <th>Nombre cliente</th>
                                    <th>Fecha de entrega</th>
                                    <th>Materiales</th>
                                    <th>Descripción</th>
                                    <th>Dinero</th>
                                    <th>Entrega</th>
                                    <th>Opciones</th>
                                </tr>
                            </thead>
                            <%
                                ferreteriaDAO viajesDao = new ferreteriaDAO();
                                List<viajes>lista = viajesDao.observarViajes();
                                Iterator<viajes>iter = lista.iterator();
                                viajes viaje = null;
                                while(iter.hasNext()){
                                    viaje = iter.next();
                            %>
                            <tbody>
                                <tr>
                                    <td><%= viaje.getCodigo()%></td>
                                    <td><%= viaje.getNombreCliente()%></td>
                                    <td><%= viaje.getFechaEntrega()%></td>
                                    <td><%= viaje.getMateriales()%></td>
                                    <td><%= viaje.getDescripcion()%></td>
                                    <td><%= viaje.getDinero()%></td>
                                    <td><%= viaje.getEntrega()%></td>
                                    <td>
                                        <a class="button warning" href="servlet?accion=editarViaje&codigoViaje=<%= viaje.getCodigo()%>">
                                            Editar <i class="fas fa-edit"></i>
                                        </a>
                                        <a class="button alert" href="servlet?accion=eliminarViaje&codigoViaje=<%= viaje.getCodigo()%>">
                                            Eliminar <i class="fas fa-trash"></i>
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
