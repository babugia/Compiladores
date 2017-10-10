package src.COMPILADOR;

import java.io.IOException;
import java.util.Vector;

public class AnalisadorLexical {
	
	//SEXTA (06/08) ENTREGAR UML LEXICO COM MUDANCAS DO PROJETO E UML DO SINTATICO, O CERTO EH MOSTRAR OS ERROS
	//EM ORDEM (EM QUAL LINHA, EX: ERRO LINHA 3, ERRO LINHA 8...), TANTO ERRO LEXICO QUANTO SINTATICO.
	
	//TESTES DO SINTATICO = 11/10

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
			 || caracter == ']' || caracter == 'ˆ') {
				System.out.println("caracter invalido é "+ caracter);
				erro.erroLexico(linha, 1);
				
			}
			
			/*if(analisarLetras(caracter) == false){
				System.out.println(caracter);
				erro.erroLexico(linha, 1);
			}*/

			if(caracter == '{') {
				aux = linha;
				while(caracter != '}') {
					if(caracter == '\n' ) { //|| caracter == '\r'
						linha++;
					}
					lerCaracter();
					if(leituraDoArquivo == -1)
                        erro.erroLexico(aux, 2);
				}
				lerCaracter();
				continue;
			}
//			if(caracter == 'f')
//				System.out.println("f");
			if(Character.isWhitespace(caracter)) {
				if(caracter == '\n') {
					linha++;
				}
				lerCaracter();
				continue;	
			}
			
			if(caracter == 'p')
				System.out.println("f");

			
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
        if(Character.isLetter(caracter)){
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
        return new Token("snumero", num, linha);
    }
    
    private Token trataIdentificadorEPalavraReservada() {
        String id = "";
        do{
             id = id+caracter;
             lerCaracter();
        }
        while(Character.isDigit(caracter) || Character.isLetter(caracter));
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
                return new Token("sbooleano", id, linha);
            case "identificador":
            	return new Token("sidentificador", id, linha);
            case "div":
                return new Token("sdiv", id, linha);
            case "e":
                return new Token("se", id, linha);
            case "ou":
                return new Token("sou", id, linha); 
            case "nao":
            	return new Token("snao", id, linha);
        }
        return new Token("sidentificador", id, linha);
    }
    
    private Token trataAtribuicao() {
        String atrib = ""+caracter;
        lerCaracter();
        if(caracter == '='){
            atrib = atrib+'='; 
            lerCaracter();
            return new Token("satribuicao", atrib, linha);
        }
        return new Token("sdoispontos", atrib, linha);
    }
    
    private Token trataOperadorAritmetico() {
        String atrib = ""+caracter;
        if(caracter == '+')
        {
            lerCaracter();    
            return new Token("smais", atrib, linha);
        }
        else if(caracter == '-')
        {
            lerCaracter();
            return new Token("smenos", atrib, linha);
        }
        else 
        {
            lerCaracter();
            return new Token("smult", atrib, linha);
        }
    }
    
    private Token trataOperadorRelacional() {
        String operador = ""+caracter;
        if(caracter == '='){
            lerCaracter();
            return new Token("sig", operador, linha);
        }
        if(caracter == '>'){
            lerCaracter();
            if(caracter == '='){
                operador = operador+caracter;
                lerCaracter();
                return new Token("smaiorig", operador, linha);
            }
            return new Token("smaior", operador, linha);
        }
        if(caracter == '<'){
            lerCaracter();
            if(caracter == '='){
                operador = operador+caracter;
                lerCaracter();
                return new Token("smenorig", operador, linha);
            }
            return new Token("smenor", operador, linha);
        }
        lerCaracter();
        if(caracter == '='){
            operador = operador+caracter;
            lerCaracter();
            return new Token("sdif", operador, linha);
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
            return new Token("svirgula", atrib, linha);
        }
        if(caracter == '.'){
            lerCaracter();
            return new Token("sponto", atrib, linha); 
        }
        return null;
    }
     
     private boolean analisarLetras(char caracter) {
     System.out.println(Character.isWhitespace(caracter));
     if(!Character.isWhitespace(caracter))
    	 	System.out.println("entro");
     
   	  if(!(Character.toString(caracter).matches("[abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ]")) && 
   	  !Character.isDigit(caracter) || !Character.isWhitespace(caracter) || caracter != '\n' || caracter != '\r') { 
   		  return false;
   	  }
   		  
         return true;
   }
     
//     private boolean isValid(char caracter) {
//    	 	
//     }

}
