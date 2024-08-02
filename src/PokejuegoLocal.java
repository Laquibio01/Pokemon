

public class PokejuegoLocal {
    
    
    int vida, ataque, defensa, velocidad, vida2, ataque2, defensa2, velocidad2;
    String nombre, nombre2, indicarGanador;
    Pokemon pokemon2 = new Pokemon("", 0, 0, 0, 0);
    
    public void establecerPokemonUno(String nombre, int vida, int ataque, int defensa, int velocidad){
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.velocidad = velocidad;
    }
    Pokemon pokemon1 = new Pokemon(nombre, vida, ataque, defensa, velocidad);
    
    public void establecerPokemonDos(String nombre, int vida, int ataque, int defensa, int velocidad){ 
        this.nombre2 = nombre;
        this.vida2 = vida;
        this.ataque2 = ataque;
        this.defensa2 = defensa;
        this.velocidad2 = velocidad;
    }
    
                      
    
    public void realizarTurno() {
        //Declaracion de variables de atacante y defensor
        
        Pokemon pokemon1 = new Pokemon(nombre, vida, ataque, defensa, velocidad);
        Pokemon pokemon2 = new Pokemon(nombre2, vida2, ataque2, defensa2, velocidad2);
        
        //Declaracion de variables de atacante y defensor
        Pokemon atacante; 
        Pokemon defensor;
       
        while (pokemon1.getVida() > 0 & pokemon2.getVida() > 0) {
            if (pokemon1.getVelocidad() > pokemon2.getVelocidad()) //Define quien tiene el primer turno segun el que tenga mas velocidad
                for(int i=1;i<3;i++){ // Bucle segun el jugador
                    if(i==1){// Mostrar información del turno
                        atacante = pokemon1;
                        defensor = pokemon2;
                    }else{
                        atacante = pokemon2;
                        defensor = pokemon1;
                    }
                        if (pokemon1.getVida() > 0 & pokemon2.getVida() < 0) {
                            indicarGanador = atacante.getNombre() + " es el ganador!";  
                        }
        //Se imprime la informacion del turno        
                System.out.println("**Turno de " + atacante.getNombre() + "**");
                System.out.println("Vida de " + atacante.getNombre() + ": " + atacante.getVida());
                System.out.println("Vida de " + defensor.getNombre() + ": " + defensor.getVida());

                // Manda a llamar la funcion atacar poniendo como parametro que ataca al pokemon defensor
                atacante.atacar(defensor);
                
                //Si la vida de uno de los pokemones es menor a 0 entonces declara al ganador
                if (pokemon1.getVida() < 0 & pokemon2.getVida() > 0) {
                       indicarGanador = defensor.getNombre() + " es el ganador!";    
                }
            }
        }
        String ganador = "";

        // Se determina el ganador al final del combate
        if (pokemon1.getVida() <= 0) {
            ganador = pokemon2.getNombre();
        } else if (pokemon2.getVida() <= 0){
            ganador = pokemon1.getNombre();
        }
        System.out.println(ganador + " es el ganador");
    }

}

