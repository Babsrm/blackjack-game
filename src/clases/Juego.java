package clases;

import java.util.Scanner;

import excepciones.NoHayMasCartasException;

public class Juego {
	static Mazo mazoJuego = new Mazo();
	static Mano banca = new Mano();
	static Mano jugador = new Mano();

	public static void main(String[] args) {

		mazoJuego.barajar();

		Scanner teclado = new Scanner(System.in);
		String respuesta = "";
		do {

			try {
				do {
					System.out.println("¿Quiere una carta? Y/N");
					respuesta = confirmar();
					if (respuesta.toLowerCase().equals("y")) {

						jugador.pedirCarta(mazoJuego);
					}
					;
					System.out.println(jugador.toString());

				} while (!jugador.finDeJuego() && !respuesta.toLowerCase().equals("n"));

				if (jugador.finDeJuego()) {
					System.out.println("El juego ha acabado. Se ha pasado de puntuación.");
				} else {
					System.out.println("El juego ha acabado. Se ha plantado. " + jugador.toString());
				}

			} catch (NoHayMasCartasException e) {
				System.out.println("No hay más cartas. \nEl juego se cerrará.");

			}
			juegaBanca();

			if (jugador.valorMano() > 21) {
				System.out.println("Te has pasado de puntuación :(");
				if (banca.valorMano() > 21) {
					System.out.println("Nadie gana :|");
				} else {
					System.out.println("Gana la banca :(");
				}
			} else {
				if (banca.valorMano() > 21) {
					System.out.println("Has ganado! Enhorabuena :)");
				} else {
					if (banca.valorMano() >= jugador.valorMano()) {
						System.out.println("Gana la banca :(");
					} else {
						System.out.println("Has ganado! Enhorabuena :)");
					}
				}
			}
			System.out.println("¿Quieres jugar de nuevo? Y/N");
			respuesta = confirmar();
		} while (respuesta.equalsIgnoreCase("y"));

		teclado.close();
	}

	private static void juegaBanca() {
		try {
			do {
				banca.pedirCarta(mazoJuego);
			} while (!banca.finDeJuego() && banca.valorMano() < jugador.valorMano() && !jugador.finDeJuego()
					&& jugador.valorMano() <= 21);
			System.out.println("La banca tiene una puntuación de " + banca);

		} catch (NoHayMasCartasException e) {
			System.out.println("No hay más cartas. \nEl juego se cerrará.");
		}

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
