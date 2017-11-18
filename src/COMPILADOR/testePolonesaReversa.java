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
//		teste.add( "5");  			//ESSE TA ESTRANHO (ARRUMAR A LOGICA DOS UNARIOS NA INFIXA)
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
//		teste.add(">");      //FALTANDO O e, VER SE TA CERTO
//		teste.add("d");
//		teste.add("ou");
//		teste.add("c");
//		teste.add("<");
//		teste.add("E");
//		teste.add("e");
//		teste.add("f");  
		
		teste.add("a");
		teste.add("+");
		teste.add("(");
		teste.add("b");
		teste.add("div");
		teste.add("9");
		teste.add("-");    //FALTANDO O -
		teste.add("3");
		teste.add(")");
		teste.add("*");
		teste.add("c");   
		
		
		
		PolonesaReversa expressaoo = new PolonesaReversa();   
        expressaoo.setInfixa(teste); 
        ArrayList<String> expressa = new ArrayList<String>();
        expressa = expressaoo.toPolonesaReversaDesempilha();
        System.out.println(expressa);
    }  
}


