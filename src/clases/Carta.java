package clases;

public class Carta {

	enum Palo { TREBOL, DIAMANTES, CORAZONES, PICAS};
	
	private int numero;
	private Palo palo;
	
	
	public Carta(int numero, Palo palo) {
		if (numero <1 || numero >13) {
			this.numero = numero;
			this.palo = palo;	
		}
	}


	public int getNumero() {
		return numero;
	}


	public Palo getPalo() {
		return palo;
	}
	
	public int getValor() {
		int valor=0;
		switch (numero) {
		case 1: {
			return 1;
			}
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
		case 9: {
			return numero;
		}
		case 10:
		case 11: 
		case 12: {
			return 10;
		}
		}
		
	}
	
	
}
