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
      
      
      DataB_Pokemons datos = new DataB_Pokemons();
     
      
      datos.consultaUnPokemon("JuegoPokemon", "TPokemones", 1);
      nombre1 = datos.nombre;
      Hp1 = datos.health;
      defensa1 = datos.defense;
      ataque1 = datos.atack;
      velocidad1 = datos.velocity;
      
      datos.consultaUnPokemon("JuegoPokemon", "TPokemones", 2);
      nombre2 = datos.nombre;
      Hp2 = datos.health;
      defensa2 = datos.defense;
      ataque2 = datos.atack;
      velocidad2 = datos.velocity;
      
      Pokemon pokemon1 = new Pokemon(nombre1, Hp1, ataque1, defensa1, velocidad1);
      Pokemon pokemon2 = new Pokemon(nombre2, Hp2, ataque2, defensa2, velocidad2);
      
      interfazMain.establecerVida(Hp1, Hp2);
      
      
      
      
      
      interfazMain.setVisible(true);
      
      
        
    }
}
