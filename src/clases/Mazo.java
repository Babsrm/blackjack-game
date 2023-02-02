package clases;

import java.util.ArrayList;
import java.util.Collections;

import clases.Carta.Palo;
import excepciones.NoHayMasCartasException;

public class Mazo {
	protected ArrayList<Carta> cartas;
	
	public Mazo() {
		this.cartas= new ArrayList<Carta>(); //instanciar la lista para inicializarla y darle memoria
		for(Palo p: Palo.values()) {       //recorro palos
			for (int i = 1; i <= 13; i++) {//otro bucle para crear las cartas con palo
			Carta c = new Carta(i,p);      //recorro numeros y palos
			cartas.add(c);                 //añado carta a la lista cartas	
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
			resultado=resultado+"\n"+carta.toString();
		}
		return resultado;
	}

	public Carta solicitarCarta () throws NoHayMasCartasException {
		if (this.cartas.size() ==0) {
			throw new NoHayMasCartasException();
		}
		Carta carta = cartas.get(0);
		//se coje la primera carta del mazo (mi lista)
		//mi lista de cartas tiene formato de array, por lo que la primera carta siempre será la posición 0
		//después la elimino de mi lista porque ya la he sacado del mazo
		cartas.remove(carta);
		
		return carta;
	}
}
