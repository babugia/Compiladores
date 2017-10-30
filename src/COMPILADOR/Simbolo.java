package src.COMPILADOR;

public class Simbolo {
	Token token;
	int escopo;
	String tipo; //var, procedimento ou funcao
	
	public Simbolo(Token token, int escopo, String tipo) { 
		this.token = token;
		this.escopo = escopo;
		this.tipo = tipo;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Token getToken() {
		return token;
	}

	public int getEscopo() {
		return escopo;
	}

}
