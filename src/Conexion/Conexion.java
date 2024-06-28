package Conexion;

// Libries required to create a conection between Java and SQL
// These all "import java.sql..." can be replaced with just "import java.sql.*" 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// Library to report information about connection status

import javax.swing.JOptionPane;

/////////////////////////////////////////////////////////////////////////////////

public class Conexion {
    // Variable where will contain the connection information with the SQL Data Base. 
    // It's important create it as a PUBLIC variable in order to be able to use it in anothers classes
    public Connection conexion = null;
    
    // Variable where will contain the SQL commands
    public Statement comando = null;
    
    // Variable where will contain the results of a SQL command
    public ResultSet registro;
    
    public Connection JavaToMySQL() throws Exception{
        try {
            // Loads the MySQL driver downloaded
            Class.forName("com.mysql.jdbc.Driver"); // 5.0.8 Driver version
            //Class.forName("com.mysql.cj.jdbc.Driver"); // 8.9 Driver version
            
            // Connection info
            String servidor = "jdbc:mysql://localhost:3307/practica1";
            String usuario = "root";
            String password = "";
            
            // Creates connection
            conexion = DriverManager.getConnection(servidor, usuario, password);
            
            JOptionPane.showMessageDialog(null,"Conexion exitosa");
            
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null,"No se puedo encontrar la clase Conexion");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"No se puedo conectar a la base de datos");
        }catch(Exception es){
           JOptionPane.showMessageDialog(null,"Error con la informacion gestionada"); 
        }finally{
            JOptionPane.showMessageDialog(null,"Proceso de conexion terminada"); 
            return conexion; 
        }
        
    }
}