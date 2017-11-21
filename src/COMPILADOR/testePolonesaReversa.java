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
		
		PolonesaReversa expressaoo = new PolonesaReversa();   
        expressaoo.setInfixa(teste); 
        ArrayList<String> expressa = new ArrayList<String>();
        expressa = expressaoo.toPolonesaReversaDesempilha();
        System.out.println(expressa);
    }  
}


