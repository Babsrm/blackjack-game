package clases;

import java.util.ArrayList;

import excepciones.NoHayMasCartasException;

public class Mano extends Mazo {

	public Mano() {
		this.cartas = new ArrayList<Carta>();
	}

	public int valorMano() {
		int sumaValor = 0;
		for (Carta carta : cartas) {
			sumaValor = sumaValor + carta.getValor();
		}
		return sumaValor;
	}

	public boolean finDeJuego() {
		boolean acabado = false;
		if (valorMano() > 21) {
			acabado = true;
			;
		}
		return acabado;
	}

	@Override
	public String toString() {
		return "Puntuación mano: " + valorMano() + "\nCartas: " + super.toString();
	}

	public void pedirCarta(Mazo m) throws NoHayMasCartasException {
		Carta c = m.solicitarCarta();
		this.cartas.add(c);
	}
}
