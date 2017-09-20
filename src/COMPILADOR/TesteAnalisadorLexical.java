package src.COMPILADOR;

import java.util.Vector;

public class TesteAnalisadorLexical {

	public static void main(String[] args) {
		
		Vector<Token> lista;
		AnalisadorLexical teste = null;
		try {
			teste = new AnalisadorLexical("/Users/babugia/Desktop/lexico/teste10.txt");
			lista = teste.pegaTokens();
			for (int i = 0; i < lista.size(); i++) {
				System.out.println(lista.get(i)+"\n");
			}
			System.out.println("NENHUM TOKEN GERADO");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
