import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DataB_Pokemons {
    
   /*  public Connection conexion(){                  // Conexion para MYSQL
        String url = "jdbc:mysql://localhost:3306/juegopokemon";
        String user = "root";
        String pass = "";
        Connection conexion = null;
        
        try {
            conexion = DriverManager.getConnection(url, user, pass);
            System.out.println("Conexion exitosa a la base de datos de MYSQL");
        }catch(SQLException ex){
            System.out.println("Error al conectar a la base de datos "+ex.getMessage());
        }
        return conexion;
    }
    */
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
            resultados = sentencia.executeQuery("select * from TPokemones");
            while(resultados.next()){
                
                String id = resultados.getString("IdPokemon");
                String nombre = resultados.getString("Name");
                String type = resultados.getString("Type");
                float health = resultados.getFloat("Health");
                float defense = resultados.getFloat("Defense");
                float velocity = resultados.getFloat("Velocity");
                float atack = resultados.getFloat("Atack");
                
                System.out.println("ID= "+id+"\t"+"Nombre= "+nombre+"\t"+"Type= "+type+"\t"+"Health= "+health+"\t"+"Defense= "+defense+
                "\t"+"Velocity: "+velocity+"\tt"+"Atack= "+atack);
            }
            sentencia.close();
            resultados.close();
        }catch(SQLException e){
            System.out.println("Error al consultar datos "+e.getMessage());
        }
    }
    
    public void insertar( String namePokemon, String typePokemon, float healthPokemon, float defensePokemon, float velocityPokemon, float atackPokemon){
        Connection conexion = conexion();
        String sqlinsertar= "INSERT INTO TPOKEMONES(Name, Type, Health, Defense, Velocity, Atack) VALUES(?,?,?,?,?,?)";
        
        try(PreparedStatement pstmt = conexion.prepareStatement(sqlinsertar)){
         
            /*
            int IdMax = pstmt.getMaxRows();
            
            if(Identifier == IdMax){
                Identifier = Identifier+1;
            }
            
            pstmt.setInt(1, Identifier);
            */
            pstmt.setString(1, namePokemon);
            pstmt.setString(2, typePokemon);
            pstmt.setFloat(3, healthPokemon);
            pstmt.setFloat(4, defensePokemon);
            pstmt.setFloat(5, velocityPokemon);
            pstmt.setFloat(6, atackPokemon);
                    
                    
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
    
    public void consultaUnPokemon(String dataBase, String table, String nombre){
  
        Connection conexion = conexion();
        String sql = "SELECT * FROM TPokemones WHERE Name = '"+nombre+" ' ";
        String type;
        int id;
        float health, defense, velocity, atack;
        Statement sentencia;
        ResultSet resultados;
        
        
        try{
            System.out.println(sql);
            sentencia = conexion.createStatement();
            resultados = sentencia.executeQuery(sql);
            while(resultados.next()){
                    id = resultados.getInt(1);
                    nombre = resultados.getString(2);
                    type = resultados.getString(3);
                    health = resultados.getFloat(4);
                    defense = resultados.getFloat(5);
                    velocity = resultados.getFloat(6);
                    atack = resultados.getFloat(7);
            
                System.out.println("ID= "+id+"\t"+"Nombre= "+nombre+"\t\t"+"Type= "+type+"\t\t"+"Health= "+health+"\t"+"Defense= "+defense+
                "\t"+"Velocity: "+velocity+"\tt"+"Atack= "+atack);
            }
            
        }catch(SQLException e){
            System.out.println("Error al consultar datos: "+e.getMessage());
        }
        
        
    }
    
    public void borrar(String dataBase, String table, String nombre, boolean consulta){
        Connection conexion = conexion();
        String sql = "DELETE FROM "+table+" WHERE Name =  '"+nombre+" ' ";
        
        try(PreparedStatement pstmt= conexion.prepareStatement(sql)){
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
    
    public void numberPokemon(){
        Connection conexion = conexion();
        try{
            DatabaseMetaData MaxRows = conexion.getMetaData();
            System.out.println(MaxRows);
        }catch(SQLException e){
            System.out.println("Error al encontrar el numero de pokemons: "+e.getMessage());
        }
    }
    
    
    

    private Connection conexion(String dataBase) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
