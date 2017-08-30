package src.view;

public class Instrucao {
	int atributo1, atributo2;
	String instrucao;
	
	public Instrucao(String instrucao) {
		this.instrucao = instrucao;
	}
	
	public Instrucao(String instrucao, int atributo1) {
		this.instrucao = instrucao;
		this.atributo1 = atributo1;
	}
	
	public Instrucao(String instrucao, int atributo1, int atributo2) {
		this.instrucao = instrucao;
		this.atributo1 = atributo1;
		this.atributo2 = atributo2;
	}
	
	public Instrucao() {
		
	}
	
	public String getInstrucao() {
		return instrucao;
	}
	
	public int getAtributo1() {
		return this.atributo1;
	}
	public int getAtributo2() {
		return this.atributo2;
	}
	
	public void setInstrucao(String instrucao) {
		this.instrucao = instrucao;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
