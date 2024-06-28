package testbasedataconnection;

import Conexion.Conexion;
import java.sql.SQLException;

public class TestBaseDataConnection {

    public static void main(String[] args) throws Exception {
        
        // Example of a connection
        try{
            Conexion conector = new Conexion();
            
            // Loads "conexion" variable. If it fails, goes to catch
            conector.JavaToMySQL();
            
            // Statement to show table info
            String tabla = "persona";
            String query = "select * from "+tabla;
            
            // Converts the string instruction into a command that MySQL can understand
            conector.comando = conector.conexion.createStatement();
            
            // Executes the command and saves the result into "registro"
            conector.registro = conector.comando.executeQuery(query);
            
            // Shows the result
            System.out.println("---------------------------");
            while(conector.registro.next()){
                System.out.println(conector.registro.getString(1)+" "+conector.registro.getString(2)+" "+conector.registro.getString(3));
                System.out.println("---------------------------");
            }
            
        }catch(SQLException e){
            System.out.println("Error en la operación SQL");
        }
    }
    
}