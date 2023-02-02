package clases;

import java.util.Scanner;

import excepciones.NoHayMasCartasException;

public class Juego {
	public static void main(String[] args) {
		
		Mazo mazoJuego = new Mazo();
		
		mazoJuego.barajar();
		
		Mano mazoJugador = new Mano();
		Scanner teclado = new Scanner(System.in);
		String respuesta = "";
		
		
		try {
				do {
					System.out.println("¿Quiere una carta? Y/N");
					respuesta = confirmar();
					if (respuesta.toLowerCase().equals("y")) {
						
							mazoJugador.pedirCarta(mazoJuego);	
					};
					System.out.println(mazoJugador.toString());
				
				
				} while (!mazoJugador.finDeJuego() && !respuesta.toLowerCase().equals("n")); 
				
				if (mazoJugador.finDeJuego()) {
					System.out.println("El juego ha acabado. Ha perdido. \nEl juego se cerrará.");
					System.exit(0);	
				} else {
					System.out.println("El juego ha acabado. Se ha plantado con " +mazoJugador.toString() +". \nEl juego se cerrará.");
					System.exit(0);
				}
				
			
			
		} catch (NoHayMasCartasException e) {
			System.out.println("No hay más cartas. \nEl juego se cerrará.");
					
				}
		teclado.close();
	}

	public static String confirmar() {
		Scanner teclado = new Scanner(System.in);
		String respuesta = teclado.nextLine();
		
		while (!respuesta.toLowerCase().equals("y") && !respuesta.toLowerCase().equals("n")) {
			System.out.println("El valor introducido no es válido.");
			System.out.println("Por favor, introduzca Y o N");
			respuesta = teclado.nextLine();
		} 
		return respuesta;
	}
	
}
