package Java;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DataB_Pokemons {
    public String type = "", nombre = "";
    public int health, defense, velocity, atack;
    
public Connection conexion(){       //Clase para conexion de SQLServer
    String url = "jdbc:sqlserver://localhost:1433;databaseName=JuegoPokemon;encrypt=true;trustServerCertificate=true;";
    String user = "sa";
    String pass = "101211"; //Necesario cambiar la contraseña de tu usario personal
    Connection conexion = null;

    try {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); // Cargar el driver
        conexion = DriverManager.getConnection(url, user, pass);
        System.out.println("Conexion exitosa a la base de datos de SQL Server");
    } catch (ClassNotFoundException ex) {
        System.out.println("Error: no se encontró el driver JDBC de SQL Server");
    } catch(SQLException ex){
        System.out.println("Error al conectar a la base de datos: "+ex.getMessage());
    }
    return conexion;
}

   public void consultaUnPokemon(String dataBase, String table, int id){
  
        Connection conexion = conexion();
        String sql = "SELECT * FROM TPokemones WHERE IdPokemon = "+id;
        Statement sentencia;
        ResultSet resultados;
        try{
            System.out.println(sql);
            sentencia = conexion.createStatement();
            resultados = sentencia.executeQuery(sql);
            while(resultados.next()){
                    id = resultados.getInt(1);
                    this.nombre = resultados.getString(2);
                    this.type = resultados.getString(3);
                    this.health = resultados.getInt(4);
                    this.defense = resultados.getInt(5);
                    this.velocity = resultados.getInt(6);
                    this.atack = resultados.getInt(7);
            
                System.out.println("ID= "+id+"\t"+"Nombre= "+nombre+"\t\t"+"Type= "+type+"\t\t"+"Health= "+health+"\t"+"Defense= "+defense+
                "\t"+"Velocity: "+velocity+"\tt"+"Atack= "+atack);
            }
            
        }catch(SQLException e){
            System.out.println("Error al consultar datos: "+e.getMessage());
        }
        
        
    }
    
    private Connection conexion(String dataBase) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
