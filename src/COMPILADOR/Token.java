/* Cada token representa um símbolo válido na linguagem LPD. Está classe
 * é responsável por verificar todos esses simbolos, como por exemplo sfim, sinicio, etc..
 * */


package src.COMPILADOR;

public class Token {
	
    private final String simbolo;
    private final String lexema;
    private final int linha;
    
    public Token(String simbolo, String lexema, int linha) {
        this.simbolo = simbolo;
        this.lexema = lexema;
        this.linha = linha;
    }
    public String getSimbolo(){
        return simbolo;
    }
     
    public String getLexema(){
        return lexema;
    }
    
    public int getLinha(){
        return linha;
    }
    
    public String toString(){
        return "Símbolo\t: "+simbolo+"\nLexema\t: "+lexema+"\nLinha\t: "+linha;
    }
}
