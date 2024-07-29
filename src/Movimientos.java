public class Movimientos {
    int daño, usos;
    String tipoMovimiento;//Un boton debera enviar un parametro string el cual se utilizara    
    String tipoPokemon;
    
    Atributos_Pokemon atributosPoke = new Atributos_Pokemon();

    public Movimientos(int daño, String tipoMovimiento) {
        this.daño = daño;
        this.tipoMovimiento = tipoMovimiento;        
    }
    
    
    //Comprueba la cantidad de usos disponibles y si cuenta con ellos llama al metodo
    public String comprobador()
    {
        tipoPokemon = atributosPoke.getPokeType();
        
        if("Fuerte".equals(tipoMovimiento) && usos <=10);
        {
            movimientoFuerte();
        }
        if("Ligero".equals(tipoMovimiento) && usos <=20);
        {
            movimientoLigero();
        }
        return tipoPokemon;
    }
    
    //Metodo que le asigna a la variable daño
    public int movimientoFuerte()
    {
        switch(tipoPokemon)
        {
            case "Agua" ->{daño = 15;}
            case "Fuego" ->{daño = 20;}
            case "Tierra" ->{daño = 18;}
            case "Vientoalv" ->{daño = 20;}            
        }
        usos++;
        return daño;
    }
    
    
    public void movimientoLigero()
    {
        switch(tipoPokemon)
        {
            case "Agua" ->{daño = 19;}
            case "Fuego" ->{daño = 28;}
            case "Tierra" ->{daño = 23;}
            case "Vientoalv" ->{daño = 25;}            
        }
        usos++;
    }       
}
