<%@page import="modelo.viajes"%>
<%@page import="modeloDAO.ferreteriaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.4.3/css/foundation.min.css"/>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
<link rel="stylesheet" href="css/ferreteria.css"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Viaje</title>
    </head>
    <%
        ferreteriaDAO viajesDao = new ferreteriaDAO();
        int codigo = Integer.parseInt((String)request.getAttribute("codigoViaje"));
        viajes viaje = (viajes)viajesDao.listaViajes(codigo);
    %>
    <body>
        <h1 class="text-center">Modificar viaje</h1>
        <div class="grid-container">
            <div class="grid-x grid-margin-x align-center-middle">
                <div class="cell small-10">
                    <fieldset class="fieldset">
                        <form action="servlet">
                            <div class="grid-container">
                                <div class="grid-x grid-margin-x align-center-middle text-center">
                                    <div class="cell large-4 small-6">
                                        <i class="font fas fa-user fa-3x"></i>
                                        <input type="text" name="nombreCliente" placeholder="Nombre del cliente" value="<%= viaje.getNombreCliente()%>">
                                    </div>
                                    <div class="cell large-4 small-6">
                                        <i class="far fa-calendar-alt fa-3x"></i>
                                        <input type="datetime-local" name="fechaEntrega" value="<%= viaje.getFechaEntrega()%>">
                                    </div>
                                    <div class="cell large-4 small-6">
                                        <i class="far fa-list-alt fa-3x"></i>   
                                        <input type="text" name="materiales" placeholder="Materiales que se entregaran" value="<%= viaje.getMateriales()%>">
                                    </div>
                                    <div class="cell large-4 small-6">
                                        <i class="font fas fa-pencil-alt fa-3x"></i>    
                                        <input type="text" name="descripcion" placeholder="Descripción de la etrega" value="<%= viaje.getDescripcion() %>">
                                    </div>
                                    <div class="cell large-4 small-6">
                                        <i class="font fas fa-hand-holding-usd fa-3x"></i>    
                                        <input type="number" name="dinero" placeholder="Precio" value="<%= viaje.getDinero()%>">
                                    </div>
                                    <div class="cell large-4 small-6">
                                        <i class="font fas fa-truck-moving fa-3x"></i>
                                        <select name="entrega">
                                            <option value="entrega" select disabled>Entrega</option>
                                            <option value="<%= viaje.getEntrega()%>"><%= viaje.getEntrega()%></option>
                                            <option value="No entregado">No entregado</option>
                                            <option value="Entregado">Entregado</option>
                                        </select>
                                    </div>
                                    <div class="cell large-4 small-6">    
                                        <input type="hidden" name="codigoViaje" value="<%= viaje.getCodigo() %>">
                                        <input class="button expanded success" type="submit" name="accion" value="Modificar Viaje">
                                    </div>
                                </div>
                            </div>
                        </form>
                        <a href="servlet?accion=viajes" class="button marron">
                            Regresar <i class="fas fa-arrow-left"></i>
                        </a>
                    </fieldset>
                </div>
            </div>
        </div>
    </body>
</html>
