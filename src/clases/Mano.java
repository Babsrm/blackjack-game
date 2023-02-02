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
	
	public boolean finDeJuego () {
		boolean acabado=false;
		if (valorMano() >21) {
			acabado = true;;		
		}
		return acabado;
	}

	@Override
	public String toString() {
		return "Puntuación mano: " + valorMano() + "\nCartas: " + super.toString();
	}
	
	public void pedirCarta (Mazo m) throws NoHayMasCartasException {
		Carta c = m.solicitarCarta(); //meto la carta en una carta nueva, variable. del mazo m!! cuidado porque si no pongo m. estoy llamando a this. y actúa sobre mano en vez de sobre mazo
		this.cartas.add(c); //la añado a mi lista (mi mano) de cartas
	}
	
}
