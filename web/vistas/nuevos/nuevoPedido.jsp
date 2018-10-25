<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.4.3/css/foundation.min.css"/>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
<link rel="stylesheet" href="css/ferreteria.css"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pedido</title>
    </head>
    <body>
        <h1 class="text-center">Agregar Pedido</h1>
        <div class="grid-container">
            <div class="grid-x grid-margin-x align-center-middle">
                <div class="cell small-10">
                    <fieldset class="fieldset">
                        <form action="servlet">
                            <div class="grid-container">
                                <div class="grid-x grid-margin-x align-center-middle text-center">
                                    <div class="cell small-4">
                                        <i class="font fas fa-pencil-alt fa-3x"></i>
                                        <input type="text" placeholder="Descripción del pedido" name="descripcionPedido">
                                    </div>
                                    <div class="cell small-4">
                                        <i class="far fa-calendar-alt fa-3x"></i>
                                        <input type="date" name="fechaLlegada">
                                    </div>
                                    <div class="cell small-4">
                                        <i class="font fas fa-truck-moving fa-3x"></i>
                                        <select name="entrega">
                                            <option value="entrega" select disabled>Entrega</option>
                                            <option value="No entregado">No entregado</option>
                                            <option value="Entregado">Entregado</option>
                                            <option value="Entregado despues de la fecha">Entregado después de la fecha</option>
                                        </select>
                                    </div>
                                    <div class="cell small-6">
                                        <input class="button expanded success" type="submit" name="accion" value="Agregar Pedido">
                                    </div>
                                </div>
                            </div>
                        </form>
                        <a href="servlet?accion=pedidos" class="button marron">
                            Regresar <i class="fas fa-arrow-left"></i>
                        </a>
                    </fieldset>
                </div>
            </div>
        </div>
    </body>
</html>
