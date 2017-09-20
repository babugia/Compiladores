package src.COMPILADOR;

import java.io.IOException;
import java.util.Vector;

//está classe será implementada o analisador lexical, seguindo os respectivos
//algoritmos que se encontra na apostila


//****************** TESTES LEXICO 22/09 ******************************


public class AnalisadorLexical {

	LeituraDeArquivo arquivo;
	char caracter;
	int linha = 1, leituraDoArquivo = 0, aux = 0;
	Vector<Token> listaDeTokens;
	Erro erro = new Erro();
	
	
	public AnalisadorLexical(String caminho) throws Exception{
		listaDeTokens = new Vector<Token>();
		Token token = null;
		
		arquivo = new LeituraDeArquivo(caminho);
		lerCaracter();
		
		while(leituraDoArquivo != -1) {
			if(caracter == '}' || caracter == '@' || caracter == '%' 
			|| caracter == '#' || caracter == '$' || caracter == 'ˆ' || caracter == '&'
			 || caracter == '?' || caracter == '/' || caracter == '|' || caracter == '`' || caracter == '['
			 || caracter == ']' || caracter == '˜') {
				System.out.println(caracter);
				erro.erroLexico(linha, 1);
			}
			if(caracter == '{') {
				aux = linha;
				while(caracter != '}') {
					if(caracter == '\n' || caracter == '\r') {
						linha++;
					}
					lerCaracter();
					if(leituraDoArquivo == -1)
                        erro.erroLexico(aux, 2);
				}
				lerCaracter();
				continue;
			}
			
			if(Character.isWhitespace(caracter)) {
				if(caracter == '\n') {
					linha++;
				}
				lerCaracter();
				continue;	
			}
			
			token = nextToken();
			if(token == null)
				erro.erroLexico(linha, 1);
			listaDeTokens.add(token);
			
		}
	
	}
	
	public Token nextToken() {
        if(Character.isDigit(caracter)){
            return trataDigito();
        }
        if(Character.isAlphabetic(caracter)){
            return trataIdentificadorEPalavraReservada();
        }
        if(caracter ==  ':'){
            return trataAtribuicao();
        }
        if(caracter == '+' || caracter == '-' || caracter == '*'){
            return trataOperadorAritmetico();
        }
        if(caracter == '>' || caracter == '=' || caracter == '!' || caracter == '<'){
            return trataOperadorRelacional();
        }
        return trataPontuacao();
    }
	
	public Vector<Token> pegaTokens(){
        return listaDeTokens;
    }
    
    public Token pegaToken(int i){
        return listaDeTokens.get(i);
    }
    
	public void lerCaracter() {
			
			leituraDoArquivo = arquivo.leituraCaracter();
			if(leituraDoArquivo != -1) {
				caracter = (char) leituraDoArquivo;
			}
		}
   
    
    private Token trataDigito() {
        String num = "";
        do{
            num = num+caracter;
            lerCaracter();
        }
        while(Character.isDigit(caracter));
        return new Token("Snumero", num, linha);
    }
    
    private Token trataIdentificadorEPalavraReservada() {
        String id = "";
        do{
             id = id+caracter;
             lerCaracter();
        }
        while(Character.isDigit(caracter) || Character.isAlphabetic(caracter));
        switch(id){
            case "programa":
                return new Token("sprograma", id, linha);
            case "inicio":
                return new Token("sinicio", id, linha);
            case "fim":
                return new Token("sfim", id, linha);
            case "procedimento":
                return new Token("sprocedimento", id, linha);
            case "funcao":
                return new Token("sfuncao", id, linha);
            case "se":
                return new Token("sse", id, linha);
            case "entao":
                return new Token("sentao", id, linha);
            case "senao":
                return new Token("ssenao", id, linha);
            case "enquanto":
                return new Token("senquanto", id, linha);
            case "faca":
                return new Token("sfaca", id, linha);
            case "escreva":
                return new Token("sescreva", id, linha);
            case "leia":
                return new Token("sleia", id, linha);
            case "var":
                return new Token("svar", id, linha);
            case "inteiro":
                return new Token("sinteiro", id, linha);
            case "booleano":
                return new Token("Sbooleano", id, linha);
            case "identificador":
            		return new Token("Sidentificador", id, linha);
            case "div":
                return new Token("Sdiv", id, linha);
            case "e":
                return new Token("Se", id, linha);
            case "ou":
                return new Token("Sou", id, linha); 
            case "nao":
            		return new Token("Snao", id, linha);
        }
        return new Token("Sidentificador", id, linha);
    }
    
    private Token trataAtribuicao() {
        String atrib = ""+caracter;
        lerCaracter();
        if(caracter == '='){
            atrib = atrib+'='; 
            lerCaracter();
            return new Token("satribuicao", atrib, linha);
        }
        return new Token("Sdoispontos", atrib, linha);
    }
    
    private Token trataOperadorAritmetico() {
        String atrib = ""+caracter;
        if(caracter == '+')
        {
            lerCaracter();    
            return new Token("Smais", atrib, linha);
        }
        else if(caracter == '-')
        {
            lerCaracter();
            return new Token("Smenos", atrib, linha);
        }
        else 
        {
            lerCaracter();
            return new Token("Smult", atrib, linha);
        }
    }
    
    private Token trataOperadorRelacional() {
        String operador = ""+caracter;
        if(caracter == '='){
            lerCaracter();
            return new Token("Sig", operador, linha);
        }
        if(caracter == '>'){
            lerCaracter();
            if(caracter == '='){
                operador = operador+caracter;
                lerCaracter();
                return new Token("Smaiorig", operador, linha);
            }
            return new Token("Smaior", operador, linha);
        }
        if(caracter == '<'){
            lerCaracter();
            if(caracter == '='){
                operador = operador+caracter;
                lerCaracter();
                return new Token("Smenorig", operador, linha);
            }
            return new Token("Smenor", operador, linha);
        }
        lerCaracter();
        if(caracter == '='){
            operador = operador+caracter;
            lerCaracter();
            return new Token("Sdif", operador, linha);
        }
        return null;
    }
    
     private Token trataPontuacao() {
        String atrib = ""+caracter;
        if(caracter == ';'){
            lerCaracter();
            return new Token("sponto_virgula", atrib, linha);
        }
        if(caracter == '('){
            lerCaracter();
            return new Token("sabre_parenteses", atrib, linha);
        }
        if(caracter == ')'){
            lerCaracter();
            return new Token("sfecha_parenteses", atrib, linha);
        }
        if(caracter == ','){
            lerCaracter();            
            return new Token("Svirgula", atrib, linha);
        }
        if(caracter == '.'){
            lerCaracter();
            return new Token("Sponto", atrib, linha); 
        }
        return null;
    }
}
