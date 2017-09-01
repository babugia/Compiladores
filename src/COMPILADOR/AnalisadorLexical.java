package src.COMPILADOR;

import java.io.IOException;

//está classe será implementada o analisador lexical, seguindo os respectivos
//algoritmos que se encontra na apostila
public class AnalisadorLexical {

	private LeituraDeArquivo arquivo;
	private Token token;
	private char caracter;
	
	
	public void AnalisadorLexical(String caminho) throws IOException {
		
		arquivo = new LeituraDeArquivo(caminho);
		LerCaracter();
		
		while(arquivo.leituraCaracter() != -1) {
			if(caracter == '{') {
				while(caracter == '}') {
					if(caracter == '\n' || caracter == '\t' ) {
					}
					}
				}
			}
			
		
		
	}
	
	public void LerCaracter() {
		
		if(arquivo.leituraCaracter() != -1) {
			caracter = (char) arquivo.leituraCaracter();
		}
	}
}
