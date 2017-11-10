package src.COMPILADOR;

public class PolonesaReversa {
	
	private String infixa;
	
	public String getInfixa()
	{
		return infixa; //notação normal, que o ser humano faz
	}
   public void setInfixa(String infixa) //regras de negocio para a infixa
   {
        this.infixa = infixa;
   }
   
   public String toPolonesaReversaDesempilha() {
       Pilha p = new Pilha();
       String saida = "";
       for (int i = 0; i < infixa.length(); i++) {
           char ch = infixa.charAt(i);
           if (Character.isDigit(ch)) {
               saida += ch;
           }
           
           if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
        	   
        	   if (!p.isEmpty() && prioridadeOperandos(p.top().toString().charAt(0)) >= prioridadeOperandos(ch)) {
        		   p.push(ch);
        	   }else {
        		   
        		   while (!p.isEmpty() && prioridadeOperandos(p.top().toString().charAt(0)) >= prioridadeOperandos(ch)) {
                       saida += p.pop();
                   }
        	   }
               p.push(ch);
           }
           if (ch == '(') {
               p.push(ch);
           }
           if(ch == ')') {
               while(p.top().toString().charAt(0) != '(') {
                   saida += p.pop();
               }
               p.pop();
           }
       }
       while(!p.isEmpty()) {
           saida += p.pop();
       }
       return saida;
   }
   
   private int prioridadeOperandos(char opcao) {
       int resp = 0;
       switch (opcao) {
           case '(':
               resp = 1; //parenteses tem a maior prioridade
               break;
           case '+':
               resp = 2; //o + tem a terceira maior prioridade
               break;
           case '-':
               resp = 2; //o - tem a terceira maior prioridade
               break;
           case '*':
               resp = 3; //multiplicação tem a segunda maior prioridade
               break;
           case '/':
               resp = 3; //ou divisão tem a segunda maior prioridade
               break;
       }
       return resp;
   }
}
