package src.COMPILADOR;

public class testePolonesaReversa {
	public static void main(String [] args)
    {
		PolonesaReversa expressaoo = new PolonesaReversa();   
        expressaoo.setInfixa("1+2"); 
        String expressao = expressaoo.toPolonesaReversaDesempilha();
        System.out.println(expressao);
    }  
}


