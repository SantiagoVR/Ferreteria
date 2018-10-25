<%@page import="modelo.clientes"%>
<%@page import="modeloDAO.ferreteriaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.4.3/css/foundation.min.css"/>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
<link rel="stylesheet" href="css/ferreteria.css"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cliente</title>
    </head>
    <%
        ferreteriaDAO clienteDao = new ferreteriaDAO();
        int codigo = Integer.parseInt((String)request.getAttribute("codigoCliente"));
        clientes cliente = (clientes)clienteDao.listaClientes(codigo);
    %>
    <body>
        <h1 class="text-center">Modificar Cliente</h1>
        <div class="grid-container">
            <div class="grid-x grid-margin-x align-center-middle">
                <div class="cell small-10">
                    <fieldset class="fieldset">
                        <form action="servlet">
                            <div class="grid-container">
                                <div class="grid-x grid-margin-x align-center-middle text-center">
                                    <div class="cell large-4 small-6">
                                        <i class="font fas fa-user fa-3x"></i>
                                        <input type="text" placeholder="Nombre Cliente" name="nombreCliente" value="<%= cliente.getCliente()%>">
                                    </div>
                                    <div class="cell large-4 small-6">
                                        <i class="font fas fa-file-invoice-dollar fa-3x"></i>
                                        <input type="number" placeholder="Deuda" name="deuda" value="<%= cliente.getDeuda()%>">
                                    </div>
                                    <div class="cell large-4 small-6">
                                        <i class="font fas fa-pencil-alt fa-3x"></i>
                                        <input type="number" placeholder="Numero de Pago" name="pagoNumero" value="<%= cliente.getPagoclientescodigo()%>">
                                    </div>
                                    <div class="cell large-4 small-6">
                                        <i class="font fas fa-pencil-alt fa-3x"></i>
                                        <input type="text" placeholder="Descripción" name="descripcion" value="<%= cliente.getDescripcion()%>">
                                    </div>
                                    <div class="cell large-4 small-6">
                                        <i class="far fa-calendar-alt fa-3x"></i>    
                                        <input type="date" name="fechaPago" value="<%= cliente.getFechaPago()%>">
                                    </div>
                                    <div class="cell large-4 small-6">
                                        <i class="font fas fa-money-check-alt fa-3x"></i>
                                        <select name="pago">
                                            <option value="cuenta" select disabled>Cuenta</option>
                                            <option value="<%= cliente.getPago()%>"><%= cliente.getPago()%></option>
                                            <option value="No pagado">No pagado</option>
                                            <option value="Pagado">Pagado</option>
                                        </select>
                                    </div>
                                    <div class="cell large-4 small-6">
                                        <input type="hidden" name="codigoCliente" value="<%= cliente.getCodigoCliente() %>">
                                        <input class="button expanded success" type="submit" name="accion" value="Modificar Cliente">
                                    </div>
                                </div>
                            </div>
                        </form>
                        <a href="servlet?accion=clientes" class="button marron">
                            Regresar <i class="fas fa-arrow-left"></i>
                        </a>
                    </fieldset>
                </div>
            </div>
        </div>
    </body>
</html>
