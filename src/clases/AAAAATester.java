package clases;

import clases.Carta.Palo;

public class AAAAATester {

	public static void main(String[] args) {
		Mazo m = new Mazo();
		
		System.out.println(m.toString());
		
		Mano mano = new Mano();
		
		Carta nueva = new Carta (1, Palo.CORAZONES);
		
		System.out.println(nueva.toString());
		m.barajar();
		System.out.println(m.toString());
	}

}
