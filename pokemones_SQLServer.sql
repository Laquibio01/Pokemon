Create database JuegoPokemon

use JuegoPokemon
Drop table Tpokemones

Create table TPokemones(
IdPokemon int Primary Key Not Null Identity(1,1),
Name VARCHAR(50) Not Null,
Type varchar(50) Not Null, 
Health int Not null,
Defense int Not null,
Velocity int Not null,
Atack int Not null,
)


Insert into TPokemones (Name, Type, Health, Defense,Velocity, Atack) values
	('Pikachu', 'Electrico', 150, 87, 24, 12),
	('Charmeleon', 'Fuego', 169, 50, 15, 24),
	('Geodude', 'Roca', 220, 100, 12, 26);
	
	
	
