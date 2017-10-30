package src.COMPILADOR;

public class Funcao extends Simbolo {

	String retorno;
	
	public Funcao(Token token, int escopo, String tipo, String retorno) {
		super(token, escopo, tipo);
		this.retorno = retorno;
	}
	
	public String getRetorno() {
		return retorno;
	}
}
