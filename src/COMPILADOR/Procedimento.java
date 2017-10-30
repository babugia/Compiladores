package src.COMPILADOR;

public class Procedimento extends Simbolo {

	String label;
	
	public Procedimento(Token token, int escopo, String tipo, String label) {
		super(token, escopo, tipo);
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
	
}
