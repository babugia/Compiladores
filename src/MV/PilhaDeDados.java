package src.MV;

public class PilhaDeDados {

	public int i, valor;
	
	public PilhaDeDados(int i, int valor) {
		this.i = i;
		this.valor = valor;
	}
	
	public int getValor() {
		return valor;
	}
	
	public int getEndereco() {
		return i;
	}
	
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public void setEndereco(int i) {
		this.i = i;
	}
}
