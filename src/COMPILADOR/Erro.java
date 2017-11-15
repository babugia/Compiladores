package src.COMPILADOR;

import javax.swing.JOptionPane;

public class Erro {
	int linha, cod;
	String mensagemErro;

	public void erroLexico(int linha, int cod) throws Exception{
		System.out.println("Erro lexico, linha: " + linha + " Descri√ß√£o: " + codErro(cod));
		throw new Exception("Erro l√©xico. Descri√ß√£o: "+codErro(cod));
	}
	public void erroSintatico (int linhaErro, int cod) throws Exception{
        JOptionPane.showMessageDialog(null, "Erro de compilacao", "Erro", JOptionPane.ERROR_MESSAGE);
        System.out.println("Erro Sintatico identificado na linha: " +linhaErro+ "  Descricao: "+codErro(cod));
        throw new Exception("Erro sintatico. Descricao: "+codErro(cod));
    }

	public String codErro(int cod) {

		switch (cod) {
		case 1:
			return "Caracter n√£o pertencente a linguagem";
		case 2:
			return "sem o } para terminar o comentario.";
		case 3:
			return "Atribuicao mal feita";     //erros lexicos ate aqui 
		case 4:
			return "Var nao existe"; //daqui pra frente, erros sintaticos
		case 5:
			return "Sidentificador nao encontrado";
		case 6:
			return "Tipo de expresscao invalida ";
		case 7:
			return "Sidentificador invalido, procedimento nao encontrado";
		case 8:
			return "Sidentificador invalido, funcao nao encontrada";
		case 10:
			return "Falta ponto e virgula";
		case 11:
			return "Falta dois pontos";
		case 12:
			return "Espera-se identificador depois da virgula";
		case 13:
			return "Espera-se somente inteiro ou booleano";
		case 14:
			return "Faltando inicio";
		case 15:
			return "faltando abreparenteses ";
		case 16:
			return "faltando fechaparenteses ";
		case 17:
			return "faltando comando faca";
		case 18:
			return "faltando comando entao";
		case 19:
			return "faltando comando enquanto";
		case 20:
			return "espera-se verdadeiro ou falso";
		case 21:
			return "faltando ponto de fim programa";
		case 22:
			return "faltando comando programa";
		case 23:
			return "virgula ou dois pontos esperados";	
		case 24:
			return "variavel j· declarada";
		case 25:
			return "identificador n„o existe";
		case 26:
			return "ImpossÌvel printar procedimentos";
		case 27:
			return "Funcao n„o declarada";
		case 28:
			return "Procedimento n„o declarado";
		}

		return "Erro nao encontrado";
	}
}
