package src.MV;

public class Instrucao {
	String atributo1, atributo2;
	String instrucao;
	int linha;
	
	public Instrucao(String instrucao, int linha) {
		this.instrucao = instrucao;
		this.linha = linha;
	}
	
	public Instrucao(String instrucao, String atributo1, int linha) {
		this.instrucao = instrucao;
		this.atributo1 = atributo1;
		this.linha = linha;
	}
	
	public Instrucao(String instrucao, String atributo1, String atributo2, int linha) {
		this.instrucao = instrucao;
		this.atributo1 = atributo1;
		this.atributo2 = atributo2;
		this.linha = linha;
	}
	
	public Instrucao() {
		
	}
	
	public String getInstrucao() {
		return instrucao;
	}
	
	public String getAtributo1() {
		return this.atributo1;
	}
	public String getAtributo2() {
		return this.atributo2;
	}
	public int getLinha() {
		return linha;
	}
	
	public void setInstrucao(String instrucao) {
		this.instrucao = instrucao;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
