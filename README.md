ESPECIFICACIONES DEL CODIGO

CLASE PADRE
Es la clase principal de la cual se desprenden las subclases, las cuales son: 
-la subclase de heroe 
-la subclase del enemigo

Esta clase principal tiene los atributos necesarios para los personajes, los atributos que esta contiene son los siguientes:
- nombre 
- salud 
- ataque 
- defensa

Dentro de esta tambien estan los metodos para que los personajes puedan atacar y recibir daño 

SUBCLASE DEL HEROE 
Esta subclase toma los atributos de nombre, salud, ataque y defensa de la clase padre las cuales estan definidas como:
- nombre como String 
- salud, ataque y defensa con un valor entero (int)

Esta subclase tiene como atributo unico defenderse, donde el usuario al elegir esta opcion su atributo de salud aumenta 5 puntos 

SUBCLASE DEL ENEMIGO 
Esta subclase tiene como atributo:
- nombre definido como un String 
- salud y ataque expresado como un entero 

Esta subclase cuenta con un factor al igual que el heroe, cada vez que el usuario elija la opcion de atacar los puntos se escogeran de forma aleatorio mas un bonus de ataque de 6 puntos

Por ultimo, al final del codigo se asigna el nombre, salud, ataque y defensa del hero y del enemigo se le asigna el nombre, salud, ataque y defensa

LO QUE SE MUESTRA EN CONSOLA
-estado de los personajes 
-opciones que el usuario puede escoger
-resultado de la batalla: ganador y vencedor

NOTAS ACERCA DEL JUEGO 
El juego aun no cuenta con una historia, solo son es una simulacion de una batalla el cual hay un ganador y vencedor

esperen las proximas actualizaciones!!!