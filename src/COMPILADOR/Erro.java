package src.COMPILADOR;

import javax.swing.JOptionPane;

public class Erro {
	int linha, cod;
	String mensagemErro;

	public void erroLexico(int linha, int cod) throws Exception{
		System.out.println("Erro lexico, linha: " + linha + " DescriÃ§Ã£o: " + codErro(cod));
		throw new Exception("Erro lÃ©xico. DescriÃ§Ã£o: "+codErro(cod));
	}
	public void erroSintatico (int linhaErro, int cod) throws Exception{
        JOptionPane.showMessageDialog(null, "Erro de compilação", "Erro", JOptionPane.ERROR_MESSAGE);
        System.out.println("Erro Sintatico identificado na linha: " +linhaErro+ "  Descrição: "+codErro(cod));
        throw new Exception("Erro sintático. Descrição: "+codErro(cod));
    }

	public String codErro(int cod) {

		switch (cod) {
		case 1:
			return "Caracter nÃ£o pertencente a linguagem";
		case 2:
			return "sem o } para terminar o comentario.";
		case 3:
			return "Atribuição mal feita";     //erros léxicos até aqui 
		case 4:
			return "Var nao existe"; //daqui pra frente, erros sintaticos
		case 5:
			return "Sidentificador não encontrado";
		case 6:
			return "Tipo de expressão invalida ";
		case 7:
			return "Sidentificador invalido, procedimento não encontrado";
		case 8:
			return "Sidentificador invalido, função não encontrada";
		case 10:
			return "Falta ponto e vírgula";
		case 11:
			return "Falta dois pontos";
		case 12:
			return "Espera-se identificador depois da vírgula";
		case 13:
			return "Espera-se somente inteiro ou booleano";
		case 14:
			return "Faltando início";
		case 15:
			return "faltando abreparenteses ";
		case 16:
			return "faltando fechaparenteses ";
		case 17:
			return "faltando comando faça";
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
			
			
		}

		return "Erro nao encontrado";
	}
}
