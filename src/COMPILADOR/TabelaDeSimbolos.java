package src.COMPILADOR;

import java.util.ArrayList;

public class TabelaDeSimbolos {

	ArrayList<Simbolo> simbolos = new ArrayList<Simbolo>();

	public ArrayList<Simbolo> getSimbolos() {
		return simbolos;
	}

	public void setSimbolos(ArrayList<Simbolo> simbolos) {
		this.simbolos = simbolos;
	}
	
	public void add(Simbolo simbolo) {
		simbolos.add(simbolo);
	}
	
	public Simbolo consultaTabela(Token token) {
		Simbolo simbolo = null;
		
		for(int i = 0; i<simbolos.size(); i++) 
			if(simbolos.get(i).token == token)
				simbolo = simbolos.get(i);
		
		
		return simbolo;
	}
	
	public void colocaTipoTabela(Simbolo simbolo) { // FAZER METODO NA CLASSE SIMBOLOVARIAVEL
		
	}
	
	
}
