import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DataB_Pokemons {
    
    
    public Connection conexion(){
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
    
    public void consultaUnPokemon(String dataBase, String table, String nombre){
        Connection conexion = conexion(dataBase);
        String sql = "DELETE FROM "+table+"WHERE NAME = ?";
        String type, id;
        double health, defense, velocity, atack;
        Statement sentencia;
        ResultSet resultados;
        try{
            sentencia = conexion().createStatement();
            resultados = sentencia.executeQuery("select * from prueba WHERE Name: " + nombre);
            
            id = resultados.getString("IdPokemon");
            nombre = resultados.getString("Name");
            type = resultados.getString("Type");
            health = resultados.getDouble("Health");
            defense = resultados.getDouble("Defense");
            velocity = resultados.getDouble("Velocity");
            atack = resultados.getDouble("Atack");
            
            System.out.println("ID= "+id+"\t\t\t"+"nombre= "+nombre+"\t\t\t"+"type= "+type+"\t\t\t"+"health= "+health+"\t\t\t"+"defense= "+defense+
            "\t\t\t"+"velocity: "+velocity+"\t\t\t"+"atack= "+atack);
            
            
        }catch(SQLException e){
            System.out.println("Error al consultar datos "+e.getMessage());
        }
        
         try{
            sentencia = conexion().createStatement();
            resultados = sentencia.executeQuery("select * from prueba WHERE NAME = " +nombre);
            
         }catch(SQLException e){ 
         System.out.println("Error al mostrar datos: "+e.getMessage());
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
