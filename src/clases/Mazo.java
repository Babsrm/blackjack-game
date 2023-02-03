package clases;

import java.util.ArrayList;
import java.util.Collections;

import clases.Carta.Palo;
import excepciones.NoHayMasCartasException;

public class Mazo {
	protected ArrayList<Carta> cartas;

	public Mazo() {
		this.cartas = new ArrayList<Carta>();
		for (Palo p : Palo.values()) {
			for (int i = 1; i <= 13; i++) {
				Carta c = new Carta(i, p);
				cartas.add(c);
			}
		}
	}

	public void barajar() {
		Collections.shuffle(cartas);
	}

	@Override
	public String toString() {
		String resultado = "";
		for (Carta carta : cartas) {
			resultado = resultado + "\n" + carta.toString();
		}
		return resultado;
	}

	public Carta solicitarCarta() throws NoHayMasCartasException {
		if (this.cartas.size() == 0) {
			throw new NoHayMasCartasException();
		}
		Carta carta = cartas.get(0);
		cartas.remove(carta);

		return carta;
	}
}
