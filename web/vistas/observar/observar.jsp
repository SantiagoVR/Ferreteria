<%@page import="java.util.List"%>
<%@page import="modelo.productos"%>
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
        <title>Inventario</title>
    </head>
    <body>
        <h1 class="text-center">Inventario</h1>
        <div class="grid-container">
            <div class="grid-x grid-margin-x align-center-middle">
                <!-- <div class="cell small-11">
                    <form action="servlet">
                        <input type="submit" name="accion" value="buscarProducto">
                        <input type="text" name="nombre">
                    </form>
                </div> -->
                <div class="cell small-12">
                    <a href="servlet?accion=nuevoProducto" class="button">
                        Nuevo producto <i class="fas fa-plus-circle"></i>
                    </a>
                    <table>
                        <thead>
                            <tr>
                                <th>Código producto</th>
                                <th>Nombre del producto</th>
                                <th>Cantidad</th>
                                <th>Precio</th>
                                <th>Descripción</th>
                                <th>Categoría</th>
                                <th>Ubicación</th>
                                <th>Opciones</th>
                            </tr>
                        </thead>
                        <%
                            ferreteriaDAO proDao = new ferreteriaDAO();
                            List<productos>lista = proDao.observarProducto();
                            Iterator<productos>iter = lista.iterator();
                            productos prod = null;
                            while(iter.hasNext()){
                                prod = iter.next();
                        %>
                        <tbody>
                            <tr>
                                <td><%= prod.getCodigo()%></td>
                                <td><%= prod.getNombre()%></td>
                                <td><%= prod.getCantidad()%></td>
                                <td><%= prod.getPrecio()%></td>
                                <td><%= prod.getDescripcionProducto()%></td>
                                <td><%= prod.getCategoria()%></td>
                                <td><%= prod.getUbicacion()%></td>
                                <td>
                                    <a class="button warning" href="servlet?accion=editar&codigo=<%= prod.getCodigo()%>">
                                        Editar <i class="fas fa-edit"></i>
                                    </a>
                                    <a class="button alert" href="servlet?accion=eliminar&codigo=<%= prod.getCodigo()%>">
                                        Eliminar <i class="fas fa-trash"></i>
                                    </a>
                                </td>
                            </tr>
                            <%
                                }
                            %>
                        </tbody>
                    </table>
                        <a href="servlet?accion=pedidos" class="button naranja">
                            Pedidos <i class="fas fa-dolly"></i>
                        </a>
                        <a href="index.jsp" class="button marron">
                            Regresar <i class="fas fa-arrow-left"></i>
                        </a>
                </div>
            </div>
        </div>
    </body>
</html>
