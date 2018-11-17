# Ferreteria
Proyecto en Java con JSP y MySQL, para tener una mejor administración para una ferretería, lo que incluirá será el control del inventario, pedidos de materiales que pidan, viajes de materiales que algún cliente necesite y cuentas de los clientes que tenga una deuda con la ferretería.

# Descripción del proyecto:
El proyecto es para una ferretería, que tendrá tres secciones inventario, viajes y clientes cada sección tiene varias secciones en el inventario aparecerá todos los productos existentes y podrá ver cuatro opciones que son agregar producto, editar producto, eliminar producto, regresar y pedidos son de los materiales que llegaran a las sucursales esta última redirigirá a otra sección donde tendrá las opciones de agregar pedido, editar pedido, eliminar pedido y regresar para la sección de viajes serán los que la ferretería realiza a sus clientes para la entrega de materiales de construcción donde tendrá las opciones de agregar viaje, editar viaje, eliminar viaje y para la sección de clientes será para las personas que tengan una deuda con la ferretería donde tendrán las opciones de agregar cliente, editar cliente, eliminar cliente en los todos los formularios ya sea para agregar o modificar aparecerán dos botones “regresar” y “aceptar” para que se agreguen los datos o sean modificados, cada formulario tiene diferentes datos para llenar
Arquitectura del proyecto:
Para este proyecto yo use el programa usa XAMPP para ejecutar un servidor local para el despliegue visual de cada sección del proyecto y de los datos que están en MySQL, además de la escritura de esta información por esta razón utilice XAMPP ya tiene apache, tomcat y MySQL, el tomcat será para el despliegue del archivo war. 
Se utilizo el patrón de diseño MVC para tener organizado cada aspecto en diferentes paquetes y no todo en uno solo y así tener un buen control sobre las funciones y los resultados que se pueden encontrar.

# Requerimientos del proyecto:
Los requerimientos para usar el proyecto son 

1.	JDK de java la versión más reciente si es posible para tu sistema operativo https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

2.	JRE de java versión más reciente si es posible para tu sistema operativo  https://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html

3.	Descargar XAMPP de preferencia la versión más reciente 

   1.	Tener instalado los apartados de apache, MySQL y Tomcat

4.	Cualquier navegador (Chome, Firefox, Opera, Edge) de preferencia usar Chome o Edge
Si en el caso de que se realice modificaciones al proyecto para mejorar es necesario el siguiente programa ya que se desarrolló en este  
5.	NetBeans 8.2 o superior dependiendo de que versión esté disponible en su forma completa https://netbeans.org/downloads/ al momento de la instalación se puede modificar el servidor para su despliegue por defecto esta Glassfish se puede cambiar o dejarlo pero yo recomiendo que se cambie por Tomcat.
Aparecerá algo como lo siguiente y solo se tiene que seleccionar customize o personalizado dependiendo del idioma en el que este y cambiar por tomcat en el servidor.

# Instalación:
El ambiente de desarrollo para modificar este proyecto es necesario tener instalado tanto JDK y JRE de java dependiendo del sistema operativo y el tipo de sistema que se tenga después de eso se tiene que descargar el programa NetBeans que es en donde se desarrolló este proyecto en su versión completa.
Para ayudar más encontré este tutorial de instalación para lo que antes escribí lo único que cambia es el JDK que lo busco específico para el programa de NetBeans https://www.youtube.com/watch?v=DdUjeI1BeEI aparte de esto se tiene que instalar XAMPP ya que se realiza una conexión a una base de datos que está en MySQL  y este servidor local tiene esta ventaja de tener varios programas integrados además de eso la base de datos tiene que llamarse ferretería y tener varias tablas para que los datos se puedan obtener en el programa que se realizó.

Lo que yo recomendaría para las pruebas es realizarlas en el programa de Netbeans ya que si el error está en el código se modifica en el momento o se busca y cuando se realizó las modificaciones se puede volver a correr y observar si el error se solucionó o así hasta que se solucione. 

La solución de la problemática solo la pude implementar en un ambiente local para que este en la nube tendría que modificarse para que se requiere de un usuario y contraseña además de investigar cómo implementarlo de esa forma para que también la base de datos este en línea. 
Para la versión local se necesita del JDK y/o JRE de java después el programa XAMPP con apache, MySQL y tomcat donde se tendrá que desplegar el archivo war en este último para que el usuario lo pueda usar y visualizar del mismo modo se tiene que crear una base de datos con el nombre ferreteria y varias tablas en esta que están en un archivo SQL o texto por si se llega a tener un problema.
Estos recursos estarán en esta entrega.
   
# Configuración:
La configuración que se puede necesitar es tener la base de datos con el nombre apropiado y las tablas además de los parámetros de cada dato esta configuración se encuentra en un archivo sql o txt dependiendo si uno no funciona. En el video se podrá ver esta situación. 
La única configuración de los requerimientos es tener el programa NetBeans en forma completa para que se pueda usar los servidores para poder correr el proyecto y como sugerencia es tener el servidor tomcat.
Ya que para desplegar un archivo war es necesario configurar tomcat que viene en XAMPP ya que pide un usuario y contraseña y por defecto no tienen ninguno tiene que abrir xampp luego en la sección de tomcat en el botón configuración antes de que termine el archivo y arriba de la última línea que tiene este se escribirá lo siguiente

    <role rolename="manager-gui"/>
    <user username="tomcat" password="tomcat" roles="manager-gui"/>

Se puede cambiar el username y password por el que se quiera al final seleccionara el botón archivo y guardar para que cuando entre donde se desplegara el archivo no exista problemas.

# Uso:

El usuario final y el administrador en este caso es el mismo ya que no está pensado para que clientes o personas ajenas a la ferretería tengan acceso a este programa.
El menú del programa tendrá tres apartados Inventario, viajes y clientes 
Para el apartado de inventario

•	Se podrá agregar un nuevo producto 

•	Modificar los productos que ya están 

•	Eliminar algún producto

•	Ir a la sección de pedidos 

•	Regresar a la página anterior

Para agregar un producto se tiene que introducir 

•	Nombre del producto 

•	Cantidad

•	Precio 

•	Descripción 

•	Categoría 

•	Ubicación 

Del mismo modo la opción de modificar es para estos datos, la única información que no se podrá modificar es el número de producto.

Para el apartado de pedidos

•	Se podrá agregar un nuevo pedido 

•	Modificar los pedidos existentes

•	Eliminar algún pedido

•	Regresar a la página anterior

Para agregar un producto se tiene que introducir 

•	Descripción del productos o productos 

•	Fecha en que llegara 

•	Estatus de la entrega 

Del mismo modo la opción de modificar es para estos datos, la única información que no se podrá modificar es el número de pedido.

Para el apartado de viajes

•	Se podrá agregar un nuevo viaje

•	Modificar los viajes existentes

•	Eliminar algún viaje

•	Regresar a la página anterior

Para agregar un viaje se tiene que introducir 

•	Nombre del cliente 

•	Fecha en que llegara 

•	Materiales que le llegaran

•	Descripción 

•	Dinero que debe

•	Estatus de la entrega 

Del mismo modo la opción de modificar es para estos datos, la única información que no se podrá modificar es el número de viaje.

Para el apartado de clientes

•	Se podrá agregar un nuevo cliente

•	Modificar los clientes existentes

•	Eliminar algún cliente

•	Regresar a la página anterior

Para agregar un cliente se tiene que introducir 

•	Nombre del cliente 

•	Deuda que tiene

•	Numero de pago

•	Descripción

•	Fecha de pago 

•	Estatus de la deuda 

Del mismo modo la opción de modificar es para estos datos, la única información que no se podrá modificar es el número de cliente.

# Video
Demostración de uso y configuración del proyecto https://www.youtube.com/watch?v=FYxePoyI5Gk 
