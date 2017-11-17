package src.COMPILADOR;

import java.util.ArrayList;

public class testePolonesaReversa {
	public static void main(String [] args)
    {
		ArrayList<String> teste = new ArrayList<String>();
//		teste.add("a");
//		teste.add(">");
//		teste.add( "b");
//		teste.add( "e");
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
//		teste.add( "5");
//		teste.add(")");
//		teste.add( "*");
//		teste.add( "3");
		
//		teste.add("-u");
//		teste.add("a");
//		teste.add("+");
//		teste.add( "5");  			ESSE TA ESTRANHO
//		teste.add( "*");
//		teste.add( "+u");
//		teste.add( "v");
		
		
		PolonesaReversa expressaoo = new PolonesaReversa();   
        expressaoo.setInfixa(teste); 
        ArrayList<String> expressa = new ArrayList<String>();
        expressa = expressaoo.toPolonesaReversaDesempilha();
        System.out.println(expressa);
    }  
}


