package src.COMPILADOR;

import java.util.ArrayList;

public class AnalisadorSemantico {

	TabelaDeSimbolos tabelaDeSimbolos;
	ArrayList<Simbolo> simbolos = new ArrayList<Simbolo>();
	
	public AnalisadorSemantico() {
		tabelaDeSimbolos = new TabelaDeSimbolos();
		simbolos = tabelaDeSimbolos.getSimbolos(); 
	}
	
	
	//Método responsavel por pesquisar se existe duplicidade na declaração
	//de um identificador
	public boolean pesquisaIdentificadorTabela(Simbolo s) {
		
		
		if(s.getTipo()=="var") {
			for(int i=0; i<simbolos.size(); i++) {
				
				if(simbolos.get(i).tipo=="var"){
					
					if(simbolos.get(i).getEscopo()==s.escopo) {
						
						if(simbolos.get(i).token.getLexema()==s.getToken().getLexema()) {
							
							System.out.println("ERRO, VARIAVEL DO MESMO NÍVEL");
							
						}
					}
				}else {
					if(simbolos.get(i).getEscopo()<=s.escopo) {
						if(simbolos.get(i).getToken().getLexema()==s.getToken().getLexema()) {
							
							System.out.println("ERRO 2");
							
						}
					}
				}
			}
		}else {
			
			for(int i=0; i<simbolos.size(); i++) {
				if(simbolos.get(i).getEscopo()<=s.escopo) {
					if(simbolos.get(i).getToken().getLexema()==s.getToken().getLexema()) {
						
						System.out.println("ERRO 3");
						}
					}
				}
			}
		return false;
		
	}
	public boolean pesquisaIdentificadoresNaoDeclarados(Simbolo s){
		
		
		
		return false;
	}
}
