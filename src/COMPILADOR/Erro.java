package src.COMPILADOR;

import javax.swing.JOptionPane;

public class Erro {
	int linha, cod;
	String mensagemErro;

	public void erroLexico(int linha, int cod) throws Exception{
		System.out.println("Erro lexico, linha: " + linha + " Descrição: " + codErro(cod));
		throw new Exception("Erro léxico. Descrição: "+codErro(cod));
	}
	public void erroSintatico (int linhaErro, int cod) throws Exception{
        JOptionPane.showMessageDialog(null, "Erro de compila��o", "Erro", JOptionPane.ERROR_MESSAGE);
        System.out.println("Erro Sintatico identificado na linha: " +linhaErro+ "  Descri��o: "+codErro(cod));
        throw new Exception("Erro sint�tico. Descri��o: "+codErro(cod));
    }

	public String codErro(int cod) {

		switch (cod) {
		case 1:
			return "Caracter não pertencente a linguagem";
		case 2:
			return "sem o } para terminar o comentario.";
		case 3:
			return "Atribui��o mal feita";     //erros l�xicos at� aqui 
		case 4:
			return "Var nao existe"; //daqui pra frente, erros sintaticos
		case 5:
			return "Sidentificador n�o encontrado";
		case 6:
			return "Tipo de express�o invalida ";
		case 7:
			return "Sidentificador invalido, procedimento n�o encontrado";
		case 8:
			return "Sidentificador invalido, fun��o n�o encontrada";
		case 10:
			return "Falta ponto e v�rgula";
		case 11:
			return "Falta dois pontos";
		case 12:
			return "Espera-se identificador depois da v�rgula";
		case 13:
			return "Espera-se somente inteiro ou booleano";
		case 14:
			return "Faltando in�cio";
		case 15:
			return "faltando abreparenteses ";
		case 16:
			return "faltando fechaparenteses ";
		case 17:
			return "faltando comando fa�a";
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
