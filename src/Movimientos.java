public class Movimientos {
    int daño, usos;
    String tipoMovimiento;//Un boton debera enviar un parametro string el cual se utilizara
    String tipoAtaque;//Supongamos que proviene de la clase de ataque que indica el tipo de ataque

    public Movimientos(int daño, String tipoMovimiento, String tipoAtaque) {
        this.daño = daño;
        this.tipoMovimiento = tipoMovimiento;
        this.tipoAtaque = tipoAtaque;
    }
    
    //Comprueba la cantidad de usos disponibles y si cuenta con ellos llama al metodo
    public int comprobador()
    {
        if(tipoMovimiento == "Fuerte" && usos <=10);
        {
            movimientoFuerte();
        }
        if(tipoMovimiento == "Ligero" && usos <=20);
        {
            movimientoLigero();
        }
        return daño;
    }
    
    //Metodo que le asigna a la variable daño
    public int movimientoFuerte()
    {
        switch(tipoAtaque)
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
        switch(tipoAtaque)
        {
            case "Agua" ->{daño = 19;}
            case "Fuego" ->{daño = 28;}
            case "Tierra" ->{daño = 23;}
            case "Vientoalv" ->{daño = 25;}            
        }
        usos++;
    }
    
    
}
