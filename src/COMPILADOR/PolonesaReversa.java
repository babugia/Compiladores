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

	// (a+b) > c+d
	// saida:ab+cd+>
	// pilha:

	// dps fzr teste com unarios
	// 5 + -c , essa expressao tem q virar: 5 + -u c
	// saida: 5c -u +
	// pilha:
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

			if (ch == "+" || ch == "-" || ch == "*" || ch == "div" || ch == ">" || ch == "<" || ch == ">=" || ch == "<="
					|| ch == "!=" || ch == "=" || ch == "e" || ch == "ou" || ch == "-u" || ch == "+u" || ch == "nao") {

				if (!stack.isEmpty() && prioridadeOperandos(ch) > prioridadeOperandos(stack.peek())) {
					stack.push(ch);
				} else {

					while (!stack.isEmpty() && prioridadeOperandos(stack.peek()) >= prioridadeOperandos(ch)) {
						// saida += stack.pop();
						saida.add(stack.pop());
					}
					stack.push(ch);
				}
				// stack.push(ch);
				if (stack.isEmpty())
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
	 * Prioridade +,-,nao 
	 * *,div 
	 * +,-, 
	 * <,>,!=... 
	 *	e 
	 *	ou
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
		case "nao":
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

	public boolean operador(String ch) {

		if (ch == "+" || ch == "-" || ch == "*" || ch == "div" || ch == ">" || ch == "<" || ch == ">=" || ch == "<="
				|| ch == "!=" || ch == "=" || ch == "e" || ch == "ou" || ch == "-u" || ch == "+u" || ch == "nao")
			return true;

		return false;
	}

	public boolean pode(String s) {
		char[] c = s.toCharArray();
		boolean d = true;

		if (!Character.isDigit(c[0]) && !Character.isLetter(c[0])) {
			d = false;
		}

		if (s == "nao" || s == "e" || s == "ou" || s == "div")
			d = false;

		return d;
	}
}
