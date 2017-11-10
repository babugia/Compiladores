package src.COMPILADOR;

public class Variavel extends Simbolo {

	private String tipo;
	
	public Variavel(Token token, int escopo, String tipo, String tipoVar) {
		super(token, escopo, tipo);
		this.tipo = tipoVar;
	}
	
	public String getTipoVar() {
		return tipo;
	}
	
	public void setTipoVar(String tipoVar) {
		this.tipo = tipoVar;
	}
	
	
}
