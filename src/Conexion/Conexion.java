package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*@author kevin*/

public class Conexion {
    Connection conexion = null;
    Statement comando = null;
    ResultSet registro;
    
    public Connection JavaToMySQL() {
        try {
            // Instanciar librería del conector
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Datos de la conexión
            String servidor = "jdbc:mysql://localhost:3306/practica1";
            String usuario = "root";
            String password = "";
            
            // Establecer conexión
            conexion = DriverManager.getConnection(servidor, usuario, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return conexion;
    }
}

