package src.COMPILADOR;

import java.util.ArrayList;

public class AnalisadorSemantico {

	TabelaDeSimbolos tabelaDeSimbolos;
	ArrayList<Simbolo> simbolos = new ArrayList<Simbolo>();
	
	public AnalisadorSemantico() {
		tabelaDeSimbolos = new TabelaDeSimbolos();
		simbolos = tabelaDeSimbolos.getSimbolos(); 
	}
	
	
	//M�todo responsavel por pesquisar se existe duplicidade na declara��o
	//de um identificador
	public boolean pesquisaIdentificadorTabela(Simbolo s) {
		if(s.getTipo()=="var") {
			for(int i=0; i<simbolos.size(); i++) {
				
				//VERIFICAR SE JA EXISTE VARIAVEL DECLARADA NO MESMO ESCOPO
				if(simbolos.get(i).tipo=="var"){
					
					if(simbolos.get(i).getEscopo()==s.getEscopo()) {
						
						if(simbolos.get(i).token.getLexema()==s.getToken().getLexema()) {
							
							System.out.println("Variavel ja declarada");
							
						}
					}
					
					//SE O SIMBOLO ANALISADO FOR PROC OU FUNC, VER SE JA TEM ALGUM DECLARADO EM ESCOPO MENOR OU IGUAL
				}else {
					if(simbolos.get(i).getEscopo()<=s.getEscopo()) {
						if(simbolos.get(i).getToken().getLexema()==s.getToken().getLexema()) {
							
							System.out.println("prodecimento ou funcao ja declarada");
							
						}
					}
				}
			}
			//NAO PODE TER NENHUM IDENTIFICADOR(VAR, PROC E FUNC) DE MESMO LEXEMA EM ESCOPOS MENORES OU IGUAL
		}else {	
			for(int i=0; i<simbolos.size(); i++) {
				if(simbolos.get(i).getEscopo()<=s.getEscopo()) {
					if(simbolos.get(i).getToken().getLexema()==s.getToken().getLexema()) {
						
						System.out.println("identificador ja declarado");
						}
					}
				}
			}
		
		return false;
		
	}
	
	public boolean pesquisaProcedimentoTabela(Simbolo s) {
		if(s.getTipo()=="procedimento") {
			for(int i=0; i<simbolos.size(); i++) {
				if(simbolos.get(i).getTipo() == s.getTipo()) {
					if(simbolos.get(i).getEscopo()<=s.getEscopo()) {
						if(simbolos.get(i).getToken().getLexema()==s.getToken().getLexema()) {
							return true;
						}
					}
				}
			}
		}
		
		return false;
	}
	
	public boolean pesquisaFuncaoTabela(Simbolo s) {
		if(s.getTipo()=="funcao") {
			for(int i=0; i<simbolos.size(); i++) {
				if(simbolos.get(i).getTipo() == s.getTipo()) {
					if(simbolos.get(i).getEscopo()<=s.getEscopo()) {
						if(simbolos.get(i).getToken().getLexema()==s.getToken().getLexema()) {
							return true;
						}
					}
				}
			}
		}
		
		return false;
	}
	
	//VERIFICAR SE IDENTIFICADOR PODE SER USADO ( SE FOI DECLARADO E EH DO MESMO TIPO JA DECLARADO)
	//RETORNAR SE PODE SER USADO OU NAO
	public boolean pesquisaIdentificadoresNaoDeclarados(Simbolo s){
		
		for(int i=0; i<simbolos.size(); i++) {
			if(s.getToken().getLexema() == simbolos.get(i).getToken().getLexema()) {
				if(simbolos.get(i).getEscopo()<=s.getEscopo()) {
					if(simbolos.get(i).getTipo() != s.getTipo()) {
						return false;
					}
				}
			}
		}	
		
		return true;
	}
	
	
	// ARRRUMAR O GETTIPO VAR (TEM Q CHECAR SE O TIPO EH INTEIRO
	//TEM Q TER COLOCADO O IDENTIFICADOR DO TIPOVARIAVEL PRA CONSEGUIR ACESSAR O GetTipoVar
	
	//ANALISA LEIA
	public boolean pesquisaVarTabela(Variavel var) {
		if(var.getTipo()=="var") {
			for(int i=0; i<simbolos.size(); i++) {
				if(simbolos.get(i).getTipo() == "var") {
					if(simbolos.get(i).getEscopo()<=var.getEscopo()) {
						if(var.getTipoVar() == simbolos.get(i).getTipo()) { //ARRUMAR
							if(simbolos.get(i).getToken().getLexema()==var.getToken().getLexema()) {
								return true;
							}
						}
						
					}
				}
			}
		}
		
		return false;
	}
}
