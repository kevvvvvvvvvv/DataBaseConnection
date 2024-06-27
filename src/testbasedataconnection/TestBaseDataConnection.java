
package testbasedataconnection;

import Conexion.Conexion;
import java.sql.SQLException;

/* @author kevin
 */
public class TestBaseDataConnection {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        try{
            Conexion conector = new Conexion();
            // si el valor es null va a atrapar la excepcion
            conector.JavaToMySQL();
            
            String tabla = "registro";
            String query = "select * from "+tabla;
            
            //Realizar la operacion dentro de la base de datos
            conector.comando = conector.conexion.createStatement();
            
            //Ejecutar el comando
            conector.registro = conector.comando.executeQuery(query);
            
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
