package clases;

public class Carta {

	enum Palo { TREBOL, DIAMANTES, CORAZONES, PICAS};
	
	private int numero;
	private Palo palo;
		
	
	public Carta(int numero, Palo palo) {
		if (numero >=1 && numero <=13) {
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
		switch (numero) {
		case 1: {          //as
			return 11;
			}
		case 11:           //sota
		case 12:           //caballo
		case 13: {         //rey
			return 10;
		}
		default: return numero; //si no entra por ninguna de los casos anteriores, que tienen puntuación específica, entrará por el número de carta, la cual coincide con su puntuación
		}
		
	}
	
	public String mostrarNumero() {
			switch (numero) {
			case 1: {  return "As";}
			case 11: { return "J";}         
			case 12: { return "Q";}
			case 13: { return "K";}
			default: return ""+numero;
			}
	}


	@Override
	public String toString() {
		return "[" + mostrarNumero() + " -- " + palo + "]";
	}
	
	
	
}
