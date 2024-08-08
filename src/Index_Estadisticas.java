
import java.util.Scanner;



public class Index_Estadisticas {

    public static void main(String[] args) {
         int seleccion;
         String pokeName, pokeType = null;
         double health, defense, velocity, atack;
         DataB_Pokemons datap = new DataB_Pokemons();
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to your Pokedex");
        do{
            System.out.println("Choose the modification you want to make to the pokedex");
            /*System.out.println("1.-Eliminate a pokemon");*/
            System.out.println("1.-Add a pokemon");
            System.out.println("2.-Show a pokemons");
            System.out.println("3.- See number of Pokemons");
            System.out.println("4.- Find a pokemon");
            System.out.println("5.- Exit");
            System.out.println(" ");
            System.out.println("Your opcion: ");
            System.out.print("- ");
            /*System.out.println("3.-compare a pokemon");*/
            seleccion=sc.nextInt();
             switch (seleccion) {
                 case 1:
                     System.out.println("Enter the name of the new pokemon");
                     System.out.print("- ");
                     pokeName=sc.nextLine();
                     pokeName=sc.nextLine();
                     System.out.println("Enter the type of the new pokemon");
                     System.out.print("- ");
                     pokeType=sc.nextLine();
                     System.out.println("Enter the health of the new pokemon");
                     System.out.print("- ");
                     health=sc.nextInt();
                     System.out.println("Enter the defense of the new pokemon");
                     System.out.print("- ");
                     defense=sc.nextDouble();
                     System.out.println("Enter the velocity of the new pokemon");
                     System.out.print("- ");
                     velocity=sc.nextDouble();
                     System.out.println("Enter the atack of the new pokemon");
                     System.out.print("- ");
                     atack=sc.nextDouble();
                     
                     datap.insertar(pokeName, pokeType, health, defense, velocity, atack);
                     
                     System.out.println(" ");
                     break;
                 case 2:
                     System.out.println(" ");
                     datap.actualizar(true);
                     break;
                 case 3:
                     System.out.println(" ");
                     break;
                 case 4:
                     System.out.println("Enter the name of the pokemon");
                     pokeName = sc.nextLine();
                     pokeName = sc.nextLine();
                     datap.consultaUnPokemon("juegopokemon", "pokemones", pokeName);
                     break;
                 case 5:
                     System.out.println("We are closing the System ...");
                     System.out.println("System closed.");
                     break;
                 default:
                     System.out.println("ENTER A VALID VALUE STUPID!");
                     System.out.println(" ");
                     break;
             }
        }while(seleccion!=5);
    }
}
