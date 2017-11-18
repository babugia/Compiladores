package src.COMPILADOR;

import java.util.ArrayList;
import java.util.Stack;

public class PolonesaReversa {

	private ArrayList<String> infixa;

	public ArrayList<String> getInfixa() {
		return infixa; // nota��o normal, que o ser humano faz
	}

	public void setInfixa(ArrayList<String> infixa) // regras de negocio para a infixa
	{
		this.infixa = infixa;
	}

	public ArrayList<String> toPolonesaReversaDesempilha() {
		Stack<String> stack = new Stack<String>();
		System.out.println(getInfixa());

		ArrayList<String> saida = new ArrayList<String>();
		// String saida = "";
		for (int i = 0; i < infixa.size(); i++) {
			String ch = infixa.get(i);
			if (pode(ch)) {
				// saida += ch;
				saida.add(ch);

			}

			if (ch == "+" || ch == "-" || ch == "*" || ch == "div" || ch == ">"
					|| ch == "<" || ch == ">=" || ch == "<=" || ch == "!=" 
					|| ch == "=" || ch == "e" || ch == "ou" || ch == "-u" 
					|| ch == "+u" || ch == "nao") {
				

				if (!stack.isEmpty() &&  prioridadeOperandos(ch) > prioridadeOperandos(stack.peek())) {
					stack.push(ch);
				} else {

					while (!stack.isEmpty() && prioridadeOperandos(stack.peek()) >= prioridadeOperandos(ch)) {
						// saida += stack.pop();
						saida.add(stack.pop());
					}
				}
				//stack.push(ch);
				if(stack.isEmpty())
					stack.push(ch);
			}
			if (ch == "(") {
				stack.push(ch);
			}
			if (ch == ")") {
				while (stack.peek() != "(") {
					// saida += stack.pop();
					saida.add(stack.pop());
				}
				stack.pop();
			}
		}
		while (!stack.isEmpty()) {
			// saida += stack.pop();
			saida.add(stack.pop());
		}
		return saida;
	}

	/*
	 * Prioridade +,0,nao *,/ =,- <,>,!=... e ou
	 */

	// n pode ser char por causa dos operadores >=, !=, -u, ....
	private int prioridadeOperandos(String opcao) {
		int resp = 0;
		switch (opcao) {
		case "(":
			resp = 1; // parenteses tem a maior prioridade
			break;
		case "+":
			resp = 5; // o + tem a terceira maior prioridade
			break;
		case "-":
			resp = 5; // o - tem a terceira maior prioridade
			break;
		case "div":
			resp = 6; // multiplica��o tem a segunda maior prioridade
			break;
		case "*":
			resp = 6; // ou divis�o tem a segunda maior prioridade
			break;
		case "-u":
			resp = 7;
			break;
		case "+u":
			resp = 7;
			break;
		case ">":
			resp = 4;
			break;
		case "<":
			resp = 4;
			break;
		case ">=":
			resp = 4;
			break;
		case "<=":
			resp = 4;
			break;
		case "=":
			resp = 4;
			break;
		case "!=":
			resp = 4;
			break;
		case "e":
			resp = 3;
			break;
		case "ou":
			resp = 2;
			break;

		}
		return resp;
	}

	public boolean ehInteiro(String s) {
		// cria um array de char
		char[] c = s.toCharArray();
		boolean d = true;
		for (int i = 0; i < c.length; i++) {
			// verifica se o char não é um dígito
			if (!Character.isDigit(c[i])) {
				d = false;
				break;
			}
		}
		return d;
	}

	public boolean pode(String s) {
		// cria um array de char
		char[] c = s.toCharArray();
		boolean d = true;
		
		if (!Character.isDigit(c[0]) && !Character.isLetter(c[0])) {
			d = false;
		}
		//VAI DAR BOSTA SE FOR NAO, OU OU E
		
	
		if(s == "nao" || s == "e" || s == "ou" || s == "div")
			d = false;
		
		
		if(c.length > 1 && (c[0] == '-' || c[0] == '+')) //unarios
			d = true;
		
		//System.out.println(" String: "+s+ " = "+d);
		
		return d;
	}
}
