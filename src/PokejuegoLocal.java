

public class PokejuegoLocal {
    
    Pokemon pokemon1 = new Pokemon("Pikachu", 100, 50, 40, 90); //Nombre, vida, ataque, defensa y velocidad
    Pokemon pokemon2 = new Pokemon("Charmander", 80, 40, 30, 50);//Nombre, vida, ataque, defensa y velocidad
    
    public void realizarTurno() {
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
                        if (pokemon1.getVida() < 0 & pokemon2.getVida() < 0) {
                            System.out.println(atacante.getNombre() + " es el ganador!");  
                        }
        //Se imprime la informacion del turno        
                System.out.println("**Turno de " + atacante.getNombre() + "**");
                System.out.println("Vida de " + atacante.getNombre() + ": " + atacante.getVida());
                System.out.println("Vida de " + defensor.getNombre() + ": " + defensor.getVida());

                // Manda a llamar la funcion atacar poniendo como parametro que ataca al pokemon defensor
                atacante.atacar(defensor);
                
                //Si la vida de uno de los pokemones es menor a 0 entonces declara al ganador
                if (pokemon1.getVida() > 0 & pokemon2.getVida() > 0) {
                        System.out.println(atacante.getNombre() + " es el ganador!");  
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

