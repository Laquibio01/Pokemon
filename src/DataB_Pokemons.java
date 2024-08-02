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
    String pass = "1234"; //Necesario cambiar la contraseña de tu usario personal
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
    
    public void consulta(){
        Statement sentencia;
        ResultSet resultados;
        
        try{
            sentencia = conexion().createStatement();
            resultados = sentencia.executeQuery("select * from prueba");
            while(resultados.next()){
                
                String id = resultados.getString("IdPokemon");
                String nombre = resultados.getString("Name");
                String type = resultados.getString("Type");
                double health = resultados.getDouble("Health");
                double defense = resultados.getDouble("Defense");
                double velocity = resultados.getDouble("Velocity");
                double atack = resultados.getDouble("Atack");
                
                System.out.println("ID= "+id+"\t\t\t"+"nombre= "+nombre+"\t\t\t"+"type= "+type+"\t\t\t"+"health= "+health+"\t\t\t"+"defense= "+defense+
                "\t\t\t"+"velocity: "+velocity+"\t\t\t"+"atack= "+atack);
            }
            sentencia.close();
            resultados.close();
        }catch(SQLException e){
            System.out.println("Error al consultar datos "+e.getMessage());
        }
    }
    
    public void insertar(String namePokemon, String typePokemon, double healthPokemon, double defensePokemon, double velocityPokemon, double atackPokemon){
        Connection conexion = conexion();
        String sqlinsertar= "INSERT INTO POKEMONES(Name, Type, Health, Defense, Velocity, Atack) VALUES(?,?,?,?,?,?)";
        
        try(PreparedStatement pstmt = conexion.prepareStatement(sqlinsertar)){
      
            
            pstmt.setString(2, namePokemon);
            pstmt.setString(3, typePokemon);
            pstmt.setDouble(4, healthPokemon);
            pstmt.setDouble(5, defensePokemon);
            pstmt.setDouble(6, velocityPokemon);
            pstmt.setDouble(7, atackPokemon);
                    
                    
            pstmt.executeUpdate();
            System.out.println("Datos insetrtados correctamente.");
        }catch(SQLException e){
            System.out.println("Error al insertar datos: "+e.getMessage());
        }
    }
    
    public void actualizar (boolean consulta){
        if(consulta){
            consulta();
        }
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
    
    public void borrar(String dataBase, String table, String nombre, boolean consulta){
        Connection conexion = conexion(dataBase);
        String sql = "DELETE FROM "+table+"WHERE NAME = ?";
        
        try(PreparedStatement pstmt= conexion.prepareStatement(sql)){
            pstmt.setString(2, nombre);
            int filasAfectadas = pstmt.executeUpdate();
            if(filasAfectadas>0){
                System.out.println("Fila borrada correctamente.");
            }else{
                System.out.println("No se encontro la fila con el nombre especificado.");
            }
        }catch(SQLException e){
            System.out.println("Error al borrar la fila: "+e.getMessage());
        }
        if(consulta){
            consulta();
        }
    }
    
    
    

    private Connection conexion(String dataBase) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
