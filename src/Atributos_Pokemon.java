public class Atributos_Pokemon {
    
    private String pokeName, pokeType; //In these Strings will add poke's name and poke's type
    private double health, defense, velocity, atack; //In these Doubles will add health, defense, velocity and atack
    
    
    public Atributos_Pokemon(String pokeName, String pokeType, double health, double defense, double velocity, double atack){
        //This constructor was made to add parameters for the pokemons that will be add using a this
        
        
        this.pokeName = pokeName;
        this.pokeType = pokeType;
        this.health = health;
        this.defense = defense;
        this.velocity = velocity;
        this.atack = atack;
    }
    
    //We are going to make some setters and getters for each variable
    
     public String getPokeName(){
        return pokeName;
    }
    
    public String getPokeType(){
        return pokeType;
    }
    
    public Double getHealth(){
        return health;
    }
    
    public Double getDefense(){
        return defense;
    }
    
    public Double getVelocity(){
        return velocity;
    }
    
    public Double getAtack(){
        return atack;
    }
    
    public void setPokeName(String pokeName){
        this.pokeName = pokeName;
    }
    
    public void setPokeType(String pokeType){
        this.pokeType = pokeType;
    }
    
    public void setHealth(Double health){
        this.health = health;
    }
    
    public void setDefense(Double defense){
        this.defense = defense;
    }
    
    public void setVelocity(Double velocity){
        this.velocity = velocity;
    }
    
    public void setAtack(Double atack){
        this.atack = atack;
    }

    
}
