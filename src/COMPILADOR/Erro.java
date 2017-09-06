package src.COMPILADOR;

public class Erro {
	int linha, cod;
	String mensagemErro;

	public void erroLexico(int linha, int cod) {
		System.out.println("Erro lexico, linha: " + linha + " Descrição: " + codErro(cod));
	}

	public String codErro(int cod) {

		switch (cod) {
		case 1:
			return "Caracter não pertencente a linguagem";
		case 2:
			return "sem o } para terminar o comentario.";
		case 3:
			return "Posicao invalida";

		}

		return "Erro nao encontrado";
	}
}
