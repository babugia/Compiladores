package src.COMPILADOR;

public class Erro {
	int linha, cod;
	String mensagemErro;

	public void erroLexico(int linha, int cod) throws Exception{
		System.out.println("Erro lexico, linha: " + linha + " Descrição: " + codErro(cod));
		throw new Exception("Erro léxico. Descrição: "+codErro(cod));
	}

	public String codErro(int cod) {

		switch (cod) {
		case 1:
			return "Caracter não pertencente a linguagem";
		case 2:
			return "sem o } para terminar o comentario.";

		}

		return "Erro nao encontrado";
	}
}
