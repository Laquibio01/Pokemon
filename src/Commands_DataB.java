import java.util.ArrayList;
public class Commands_DataB extends Atributos_Pokemon{
    
    public Commands_DataB(String pokeName, String pokeType, double health, double defense, double velocity, double atack){
        // In this constructor we get all variables from Atributos_Pokemon
        super(pokeName, pokeType, health, defense, velocity, atack);
    }
    public String getInformationPokemon(){ //Here we can observe all the pokemons' information
        return "The name is " + getPokeName() + " the type is: " + getPokeType() + " health: " + getHealth() + " defense " + getDefense() + " velocity " + getVelocity() + " atack " + getAtack();
    }
}
