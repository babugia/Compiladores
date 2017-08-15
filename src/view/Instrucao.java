package view;

public class Instrucao {
	int posicao, valor;
	String instrucao;
	
	public Instrucao(String instrucao) {
		this.instrucao = instrucao;
	}
	
	public Instrucao(String instrucao, int posicao) {
		this.instrucao = instrucao;
		this.posicao = posicao;
	}
	
	public Instrucao(String instrucao, int posicao, int valor) {
		this.instrucao = instrucao;
		this.posicao = posicao;
		this.valor = valor;
	}
	
	public Instrucao() {
		
	}
	
	public void setInstrucao(String instrucao) {
		this.instrucao = instrucao;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
