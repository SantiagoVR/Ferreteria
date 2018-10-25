/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configuracion;

import java.sql.*;
/**
 *
 * @author esvr_
 */
public class conexion {
    
    public static Connection getConexion(){
         Connection conexion = null;
         
         try{
             Class.forName("com.mysql.jdbc.Driver");
             conexion = DriverManager.getConnection("jdbc:mysql://localhost/ferreteria","root","");
             System.out.println("La conexion es correcta");
         }catch(Exception e){
             System.out.println("Ocurrio un error en la base de datos: " + e);
         }
         return conexion;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        conexion.getConexion();
    }
    
}
