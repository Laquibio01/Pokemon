

class Pokemon {

    String nombre;
    int vida;
    int ataque;
    int defensa;
    int velocidad;

    public Pokemon(String nombre,
                   int vida, int ataque,  
                   int defensa, int velocidad) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.velocidad = velocidad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void atacar(Pokemon oponente) {
        int daño = this.ataque - oponente.defensa;

        if (daño > 0) {
            oponente.vida -= daño;
            System.out.println( nombre + " ataco a " + oponente.nombre + "!");
            System.out.println("Daño infligido: " + daño);
            System.out.println("Vida restante de " + oponente.nombre + ": " + oponente.vida);
        } else {
            System.out.println("El ataque de " + nombre + " no fue efectivo...");
        }
    }

    public void recibirAtaque(int daño) {
        this.vida -= daño;
        if (vida <= 0) {
            vida = 0;
            System.out.println("¡" + nombre + " ha sido derrotado!");
        }
    }
}