/* Cada token representa um símbolo válido na linguagem LPD. Está classe
 * é responsável por verificar todos esses simbolos, como por exemplo sfim, sinicio, etc..
 * */


package src.COMPILADOR;

//Author: Murilo Santana 
public class Token {
	
    private final String simbolo;
    private final String lexema;
    private final int linha;
    
    public Token(String simbolo, String lexema, int linha)
    { //construtor da classe Token para fazer as respectivas verificações válidas
        this.simbolo = simbolo;
        this.lexema = lexema;
        this.linha = linha;
    }
    
    //getters e setters para o simbolo, lexema e linha
    public String getSimbolo()
    {
        return simbolo;
    }
     
    public String getLexema()
    {
        return lexema;
    }
    
    public int getLinha()
    {
        return linha;
    }
    
    //string de retorno com o resultado do léxico montado
    public String toString()
    {
        return "Símbolo\t: "+simbolo+"\nLexema\t: "+lexema+"\nCódigo\t: "+simboloCodigo()+"\nLinha\t: "+linha;
    }
    
    
    //método que representa o simbolo e o seu respectivo código, exemplo: sprograma, sinicio... 
    public int simboloCodigo()
    {
       switch (simbolo)
       {
       case "Sinv" :
            return 0;   
       case "sprograma":
           return 1;
       case "sinicio":
           return 2;
       case "sfim":
           return 3;
       case "sprocedimento":
           return 4;
       case "sfuncao":
           return 5;
       case "sse":
           return 6;
       case "sentao":
           return 7;
       case "ssenao":
           return 8;
       case "senquanto":
           return 9;
       case "sfaca":
           return 10;
       case "satribuicao":
           return 11;
       case "sescreva":
           return 12;
       case "sleia":
           return 13;
       case "svar":
           return 14;
       case "sinteiro":
           return 15;
       case "Sbooleano":
           return 16;
       case "Sidentificador":
           return 17;
       case "Snumero":
           return 18;
       case "Sponto":
           return 19;
       case "sponto_virgula":
           return 20;
       case "Svirgula":
           return 21;
       case "sabre_parenteses":
           return 22;
       case "sfecha_parenteses":
           return 23;
       case "Smaior":
           return 24;
       case "Smaiorig":
           return 25;
       case "Sig":
           return 26;
       case "Smenor":
           return 27;
       case "Smenorig":
           return 28;
       case "Sdif":
           return 29;
       case "Smais":
           return 30;
       case "Smenos":
           return 31;
       case "Smult":
           return 32;
       case "Sdiv":
           return 33;
       case "Se":
           return 34;
       case "Sou":
           return 35;
       case "Snao":
           return 36;
       case "Sdoispontos":
           return 37;
       }
       return -1;
    }
    
    // //método que representa o simbolo e o seu respectivo código, exemplo: sprograma, sinicio, 
    // porém com passagem de parametro, caso receba algum simbolo
    public static int simboloCodigo(String simbolo)
    {
        try
        {
            switch (simbolo)
            {
            //Caso seja um inversor de sinal
            case "Sinv" :
                return 0;   
           case "sprograma":
               return 1;
           case "sinicio":
               return 2;
           case "sfim":
               return 3;
           case "sprocedimento":
               return 4;
           case "sfuncao":
               return 5;
           case "sse":
               return 6;
           case "sentao":
               return 7;
           case "ssenao":
               return 8;
           case "senquanto":
               return 9;
           case "sfaca":
               return 10;
           case "satribuicao":
               return 11;
           case "sescreva":
               return 12;
           case "sleia":
               return 13;
           case "svar":
               return 14;
           case "sinteiro":
               return 15;
           case "Sbooleano":
               return 16;
           case "Sidentificador":
               return 17;
           case "Snumero":
               return 18;
           case "Sponto":
               return 19;
           case "sponto_virgula":
               return 20;
           case "Svirgula":
               return 21;
           case "sabre_parenteses":
               return 22;
           case "sfecha_parenteses":
               return 23;
           case "Smaior":
               return 24;
           case "Smaiorig":
               return 25;
           case "Sig":
               return 26;
           case "Smenor":
               return 27;
           case "Smenorig":
               return 28;
           case "Sdif":
               return 29;
           case "Smais":
               return 30;
           case "Smenos":
               return 31;
           case "Smult":
               return 32;
           case "Sdiv":
               return 33;
           case "Se":
               return 34;
           case "Sou":
               return 35;
           case "Snao":
               return 36;
           case "Sdoispontos":
               return 37;
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage()); 
        }
        return 0;
    }

}
