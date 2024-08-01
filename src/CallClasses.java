/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author elcra
 */
public class CallClasses {
    
    public static void main(String[] args) {
      
        int Hp1, Hp2, defensa1, ataque1, velocidad1, defensa2, ataque2, velocidad2;
        String nombre1, nombre2;
        
        
      PeleaPokemon interfazMain = new PeleaPokemon();
      PokejuegoLocal combate = new PokejuegoLocal();
      
      
      DataB_Pokemons datos1 = new DataB_Pokemons();
      DataB_Pokemons datos2 = new DataB_Pokemons();
      
      datos1.consultaUnPokemon("JuegoPokemon", "TPokemones", 1);
      datos2.consultaUnPokemon("JuegoPokemon", "TPokemones", 2);
      
      Pokemon pokemon1 = new Pokemon(nombre1, Hp1, ataque1, defensa1, velocidad1);
      Pokemon pokemon2 = new Pokemon(nombre2, Hp2, ataque2, defensa2, velocidad2);
      
      
      
      
      
      interfazMain.setVisible(true);
      
      
        
    }
}
