package src.COMPILADOR;

import java.util.ArrayList;

public class testePolonesaReversa {
	public static void main(String [] args)
    {
		ArrayList<String> teste = new ArrayList<String>();
//		teste.add("a");
//		teste.add(">");
//		teste.add( "b");
//		teste.add( "e"); 		//certo
//		teste.add( "5");
//		teste.add( "=");
//		teste.add( "c");
		
//		teste.add("4");
//		teste.add("+");
//		teste.add( "5");
//		teste.add( "*");
//		teste.add( "3");
		
//		teste.add("(");
//		teste.add("4");
//		teste.add("+");
//		teste.add( "5");		//certo
//		teste.add(")");
//		teste.add( "*");
//		teste.add( "3");
		
//		teste.add("-u");			//certo
//		teste.add("a");
//		teste.add("+");
//		teste.add( "5");  			
//		teste.add( "*");
//		teste.add( "+u");
//		teste.add( "v");
//		
//		
//		teste.add("(");
//		teste.add("a");
//		teste.add("+");
//		teste.add("b");			
//		teste.add(")");
//		teste.add(">");      //CERTO
//		teste.add("d");
//		teste.add("ou");
//		teste.add("c");
//		teste.add("<");
//		teste.add("E");
//		teste.add("e");
//		teste.add("f");  
		
		//(a+b) > c+d 
//		teste.add("(");
//		teste.add("a");
//		teste.add("+");
//		teste.add("b");
//		teste.add(")");
//		teste.add(">");
//		teste.add("c");
//		teste.add("+");
//		teste.add("d");
		
	//  5 + -c , essa expressao tem q virar: 5 + -u c
		
//		teste.add("5");
//		teste.add("+");
//		teste.add("-u");
//		teste.add("c");
		
//		[a, *, a, +, (, c, div, b, )]
		
		//TESTE.TXT SINTATICO
		
		teste.add("a");
		teste.add("*");
		teste.add("a");
		teste.add("+");
		teste.add("(");
		teste.add("c");
		teste.add("div");
		teste.add("b");
		teste.add(")");
		
//		teste.add("-u");
//		teste.add("b");
//		teste.add("+");
//		teste.add("c");
		
		PolonesaReversa expressaoo = new PolonesaReversa();   
        expressaoo.setInfixa(teste); 
        ArrayList<String> expressa = new ArrayList<String>();
        expressa = expressaoo.toPolonesaReversaDesempilha();
        System.out.println(expressa);
        
        ArrayList<String> valores = new ArrayList<String>();
        
        for(int i = 0;i<expressa.size();i++) {
        		System.out.println(pode(expressa.get(i)));
        		if(pode(expressa.get(i)) == 2) {
        			valores.add(expressa.get(i-2));
        			valores.add(expressa.get(i));
        			valores.add(expressa.get(i-1));
        			
    
        		}
        		if(pode(expressa.get(i)) == 1) {
        			valores.add(expressa.get(i-1));
        			valores.add(expressa.get(i));
        		}
        }
        
        System.out.println(valores);
    }  
	
	//
	public static int pode(String s) {
		// cria um array de char
		char[] c = s.toCharArray();
		int retorno = 0;
			
		if(s == "nao" || s == "-u")
			retorno = 1;
		
		if(s=="div" || s == "e" || s == "ou" || s == "+" || s == "-" || s == "*"
				|| s == "=" || s == "!=" || s == "<" || s == ">" || s == "<=" 
				|| s == ">=" )
			retorno=2;
		
		return retorno;
	}
}


