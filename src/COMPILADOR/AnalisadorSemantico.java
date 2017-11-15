package src.COMPILADOR;

import java.util.ArrayList;

public class AnalisadorSemantico {

	TabelaDeSimbolos tabelaDeSimbolos;
	
	public AnalisadorSemantico() {
		tabelaDeSimbolos = new TabelaDeSimbolos();
	}
	
	
	//M�todo responsavel por pesquisar se existe duplicidade na declara��o
	//de um identificador
	//verificacao da ocorrencia da duplicidadade na declaracao de um identificador pag 83 1
	public boolean pesquisaIdentificadorTabela(Simbolo s) {
		if(s instanceof Variavel) { //s.getTipo()=="var"
			for(int i=0; i<tabelaDeSimbolos.getSimbolos().size(); i++) {
				
				//VERIFICAR SE JA EXISTE VARIAVEL DECLARADA NO MESMO ESCOPO
				if(tabelaDeSimbolos.getSimbolos().get(i) instanceof Variavel){ //tabelaDeSimbolos.getSimbolos().get(i).tipo=="var"
					
					if(tabelaDeSimbolos.getSimbolos().get(i).getEscopo()==s.getEscopo()) {
						
						if(tabelaDeSimbolos.getSimbolos().get(i).token.getLexema()==s.getToken().getLexema()) {
							
							System.out.println("Variavel ja declarada");
							
						}
					}
					
					
					//SE O SIMBOLO ANALISADO FOR PROC OU FUNC, VER SE JA TEM ALGUM DECLARADO EM ESCOPO MENOR OU IGUAL
				}else {
					if(tabelaDeSimbolos.getSimbolos().get(i).getEscopo()<=s.getEscopo()) {
						if(tabelaDeSimbolos.getSimbolos().get(i).getToken().getLexema()==s.getToken().getLexema()) {
							
							System.out.println("prodecimento ou funcao ja declarada");
							
						}
					}
				}
			}
			//NAO PODE TER NENHUM IDENTIFICADOR(VAR, PROC E FUNC) DE MESMO LEXEMA EM ESCOPOS MENORES OU IGUAL
		}else {	
			for(int i=0; i<tabelaDeSimbolos.getSimbolos().size(); i++) {
				if(tabelaDeSimbolos.getSimbolos().get(i).getEscopo()<=s.getEscopo()) {
					if(tabelaDeSimbolos.getSimbolos().get(i).getToken().getLexema()==s.getToken().getLexema()) {
						
						System.out.println("identificador ja declarado");
						}
					}
				}
			}
		
		return false;
		
	}
	
//	public boolean pesquisaProcedimentoTabela(Simbolo s) {
//		if(s.getTipo()=="procedimento") {
//			for(int i=0; i<tabelaDeSimbolos.getSimbolos().size(); i++) {
//				if(tabelaDeSimbolos.getSimbolos().get(i).getTipo() == s.getTipo()) {
//					if(tabelaDeSimbolos.getSimbolos().get(i).getEscopo()<=s.getEscopo()) {
//						if(tabelaDeSimbolos.getSimbolos().get(i).getToken().getLexema()==s.getToken().getLexema()) {
//							return true;
//						}
//					}
//				}
//			}
//		}
//		
//		return false;
//	}
	public boolean pesquisaProcedimentoTabela(String lexema, int escopo) {
		for(int i=0; i<tabelaDeSimbolos.getSimbolos().size(); i++) {
			if(tabelaDeSimbolos.getSimbolos().get(i) instanceof Procedimento) { //tabelaDeSimbolos.getSimbolos().get(i).getTipo() == "procedimento"
				if(tabelaDeSimbolos.getSimbolos().get(i).getEscopo()<=escopo) {
						if(tabelaDeSimbolos.getSimbolos().get(i).getToken().getLexema()==lexema) {
							return true;
						}
				}
			}
		}
	
	return false;
}
	
//	public boolean pesquisaFuncaoTabela(Simbolo s) {
//		if(s.getTipo()=="funcao") {
//			for(int i=0; i<tabelaDeSimbolos.getSimbolos().size(); i++) {
//				if(tabelaDeSimbolos.getSimbolos().get(i).getTipo() == s.getTipo()) {
//					if(tabelaDeSimbolos.getSimbolos().get(i).getEscopo()<=s.getEscopo()) {
//						if(tabelaDeSimbolos.getSimbolos().get(i).getToken().getLexema()==s.getToken().getLexema()) {
//							return true;
//						}
//					}
//				}
//			}
//		}
//		
//		return false;
//	}
	public boolean pesquisaFuncaoTabela(String lexema, int escopo) {
		for(int i=0; i<tabelaDeSimbolos.getSimbolos().size(); i++) {
			if(tabelaDeSimbolos.getSimbolos().get(i) instanceof Funcao) { //tabelaDeSimbolos.getSimbolos().get(i).getTipo() == "funcao"
				if(tabelaDeSimbolos.getSimbolos().get(i).getEscopo()<=escopo) {
						if(tabelaDeSimbolos.getSimbolos().get(i).getToken().getLexema()==lexema) {
							return true;
						}
				}
			}
		}
	
	return false;
}
	
	//VERIFICAR SE IDENTIFICADOR PODE SER USADO ( SE FOI DECLARADO E EH DO MESMO TIPO JA DECLARADO)
	//verificacao de uso de identificadores nao declarados
	//RETORNAR SE PODE SER USADO OU NAO
	//------------ ERRO 2 PAGINA 83 ---------------------------------------
	public boolean pesquisaIdentificadoresNaoDeclarados(Simbolo s){
		
		for(int i=0; i<tabelaDeSimbolos.getSimbolos().size(); i++) {
			if(s.getToken().getLexema() == tabelaDeSimbolos.getSimbolos().get(i).getToken().getLexema()) {
				if(tabelaDeSimbolos.getSimbolos().get(i).getEscopo()<=s.getEscopo()) { //VER SE ESSE IF DO ESCOPO TA CERTO
					if(tabelaDeSimbolos.getSimbolos().get(i).getTipo() != s.getTipo()) { //ver se ta certo assim: tabelaDeSimbolos.getSimbolos().get(i).getTipo() != s.getTipo(), tava assim antes
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
//	public boolean pesquisaVarTabela(Variavel var) {
//		if(var.getTipo()=="var") {
//			for(int i=0; i<tabelaDeSimbolos.getSimbolos().size(); i++) {
//				if(tabelaDeSimbolos.getSimbolos().get(i).getTipo() == "var") {
//					if(tabelaDeSimbolos.getSimbolos().get(i).getEscopo()<=var.getEscopo()) {
//						if(var.getTipoVar() == tabelaDeSimbolos.getSimbolos().get(i).getTipo()) { //ARRUMAR
//							if(tabelaDeSimbolos.getSimbolos().get(i).getToken().getLexema()==var.getToken().getLexema()) {
//								return true;
//							}
//						}
//						
//					}
//				}
//			}
//		}
//		
//		return false;
//	}
	
	public boolean pesquisaVarTabela(String lexema, int escopo) {
			for(int i=0; i<tabelaDeSimbolos.getSimbolos().size(); i++) {
				if(tabelaDeSimbolos.getSimbolos().get(i) instanceof Variavel) { //tabelaDeSimbolos.getSimbolos().get(i).getTipo() == "var"
					if(tabelaDeSimbolos.getSimbolos().get(i).getEscopo()<=escopo) {
							if(tabelaDeSimbolos.getSimbolos().get(i).getToken().getLexema()==lexema) {
								return true;
							}
					}
				}
			}
		
		return false;
   }
   public void colocaTipoTabela(String tipo) { 
	   for(int i=tabelaDeSimbolos.getSimbolos().size(); i>0; i--) {
		   
		   //SE FOR UMA VARIAVEL E SE TIVER SEM TIPO DEFINIDO, SETAR TIPO
		   if(tabelaDeSimbolos.getSimbolos().get(i) instanceof Variavel) 
			   if(((Variavel)tabelaDeSimbolos.getSimbolos().get(i)).getTipoVar() != null)
				   ((Variavel)tabelaDeSimbolos.getSimbolos().get(i)).setTipoVar(tipo);
	   }
		
	}
   
   public boolean verificaTipoLeia(String lexema, int escopo) {
	   
	   for(int i=0; i<tabelaDeSimbolos.getSimbolos().size(); i++) {
			if(tabelaDeSimbolos.getSimbolos().get(i) instanceof Variavel) { //tabelaDeSimbolos.getSimbolos().get(i).getTipo() == "var"
				if(tabelaDeSimbolos.getSimbolos().get(i).getEscopo()<=escopo) {
						if(tabelaDeSimbolos.getSimbolos().get(i).getToken().getLexema()==lexema) {
							if(((Variavel)tabelaDeSimbolos.getSimbolos().get(i)).getTipoVar() == "inteiro")
								return true;
						}
				}
			}
		}
	   
	   
	   return false;
   }
   
public boolean verificaTipoEscreva(String lexema, int escopo) {
	   
	   for(int i=0; i<tabelaDeSimbolos.getSimbolos().size(); i++) {
			if(tabelaDeSimbolos.getSimbolos().get(i) instanceof Variavel) { //tabelaDeSimbolos.getSimbolos().get(i).getTipo() == "var"
				if(tabelaDeSimbolos.getSimbolos().get(i).getEscopo()<=escopo) {
						if(tabelaDeSimbolos.getSimbolos().get(i).getToken().getLexema()==lexema) {
							if(((Variavel)tabelaDeSimbolos.getSimbolos().get(i)).getTipoVar() == "inteiro")
								return true;
						}
				}
			}else if(tabelaDeSimbolos.getSimbolos().get(i) instanceof Funcao) {
				if(tabelaDeSimbolos.getSimbolos().get(i).getEscopo()<=escopo) {
					if(tabelaDeSimbolos.getSimbolos().get(i).getToken().getLexema()==lexema) {
						if(((Funcao)tabelaDeSimbolos.getSimbolos().get(i)).getRetorno() == "inteiro")
							return true;
					}
			}
			}
		}
	   
	   
	   return false;
   }

}
