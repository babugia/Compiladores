package src.MV;

import java.util.Vector;

public class Pilha {

	int posicao = 0;
	Vector<PilhaDeDados> conteudo = new Vector<PilhaDeDados>();
	PilhaDeDados aux;

	/**
	 *
	 */
	public Pilha() {
		this.posicao = 0;
	}

	public boolean pilhaVazia() {
		if (this.posicao < 1) {
			return true;
		} else
			return false;
	}

	public int pilhaSize() {
		if (!pilhaVazia()) {
			return conteudo.size();
		} else
			return 0;
	}

	public void push(int i, int valor) {
		aux = new PilhaDeDados(i, valor);
		conteudo.add(aux);
		this.posicao++;
	}

	public void pushPos(int end) {
		posicao++;
		aux = new PilhaDeDados(conteudo.size(), conteudo.get(end).valor);
		conteudo.add(aux);
	}

	public PilhaDeDados pop() {
		posicao--;
		return conteudo.remove(conteudo.size() - 1);
	}

	public int getEndereco(int pos) {
		return conteudo.get(conteudo.size() - pos).getEndereco();
	}

	public int getValor(int pos) {
		return conteudo.get((conteudo.size() - pos)).getValor();
	}

	public int getValorFixo(int i) {
		return conteudo.get(i).getValor();
	}

	public void setValor(int posicao, int valor) {
		int a = conteudo.get(conteudo.size() - posicao).getEndereco();
		aux = new PilhaDeDados(a, valor);
		conteudo.set(conteudo.size() - posicao, aux);
	}

	public void setValorFixo(int posicao, int valor) {
		aux = new PilhaDeDados(posicao, valor);
		conteudo.set(posicao, aux);
	}
}
