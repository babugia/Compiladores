package src.COMPILADOR;

public class Erro {
	int linha, cod;
	String mensagemErro;

	public void erroLexico(int linha, int cod) throws Exception{
		System.out.println("Erro lexico, linha: " + linha + " Descri√ß√£o: " + codErro(cod));
		throw new Exception("Erro l√©xico. Descri√ß√£o: "+codErro(cod));
	}
	public void erroSintatico (int linhaErro, int cod) throws Exception{
        JOptionPane.showMessageDialog(null, "Erro de compilaÁ„o", "Erro", JOptionPane.ERROR_MESSAGE);
        System.out.println("Erro Sintatico identificado na linha: " +linhaErro+ "  DescriÁ„o: "+codErro(cod));
        throw new Exception("Erro sint·tico. DescriÁ„o: "+codErro(cod));
    }

	public String codErro(int cod) {

		switch (cod) {
		case 1:
			return "Caracter n√£o pertencente a linguagem";
		case 2:
			return "sem o } para terminar o comentario.";
		case 3:
			return;
		case 4:
			return;
		case 5:
			return;
		case 6:
			return;
		case 7:
			return;
		case 8:
			return;
			

		}

		return "Erro nao encontrado";
	}
}
