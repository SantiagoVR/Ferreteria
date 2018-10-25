<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.4.4-rc1/css/foundation.min.css"/>
<link rel="stylesheet" href="css/ferreteria.css"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
    </head>
    <body>
        <div class="primary">
            <h1 class="text-center">Ferreteria Chavez Vilchis</h1>
        </div>
            <div class="grid-x text-center">
                <div class="cell small-4">
                    <div class="thumbnail-border">
                      <a href="servlet?accion=productos">
                        <img src="imagenes/inventario.png">
                      </a>
                    </div>
                    <a href="servlet?accion=productos" class="button secondary">Inventario</a>
                </div>
                <div class="cell small-4">
                    <div class="thumbnail-border">
                        <a href="servlet?accion=viajes">
                            <img src="imagenes/viaje.png">
                        </a>
                    </div>
                    <a href="servlet?accion=viajes" class="button azul">Viajes</a>
                </div>
                <div class="cell small-4">
                    <div class="thumbnail-border">
                        <a href="servlet?accion=clientes">
                            <img src="imagenes/clientes.png">
                        </a>
                    </div>
                    <a href="servlet?accion=clientes" class="button dorado">Clientes</a>
                </div>
            </div>
    </body>
</html>
