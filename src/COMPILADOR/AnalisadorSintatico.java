
package src.COMPILADOR;

import java.util.ArrayList;
import java.util.Vector;

public class AnalisadorSintatico {

	private Token token = null;
	private Erro erro = new Erro();
	private Vector<Token> vetorDeTokens;
	private int posicaoAtualNoVetor = 0;
	private int finalDoVetor = 0;
	private AnalisadorLexical lexico;
	private AnalisadorSemantico semantico;
	private TabelaDeSimbolos tabeladesimbolos;
	int escopo = 0;
	ArrayList<String> infixa = new ArrayList<String>();
	PolonesaReversa posfixa = new PolonesaReversa();

	public AnalisadorSintatico(String caminhoArquivo) throws Exception {
		lexico = new AnalisadorLexical(caminhoArquivo);
		semantico = new AnalisadorSemantico();
		tabeladesimbolos = new TabelaDeSimbolos();
		vetorDeTokens = lexico.pegaTokens();
		finalDoVetor = vetorDeTokens.size();
		token = vetorDeTokens.get(posicaoAtualNoVetor); // Recebe primeiro token
		System.out.println(
				"Simbolo: " + token.getSimbolo() + " Lexema: " + token.getLexema() + "  linha: " + token.getLinha());
		System.out.println(
				"Simbolo: " + token.getSimbolo() + " Lexema: " + token.getLexema() + "  linha: " + token.getLinha());

		if (token.simboloToCode() == 1) // sprograma
		{
			proximoToken();
			if (token.simboloToCode() == 17) // sidentificador
			{
				proximoToken(); // funcao para ler o proximo token
				if (token.simboloToCode() == 20) // spontovirgula
				{
					analisaBloco();
					if (token.simboloToCode() == 19) // sponto
					{
						// finaliza escopo, depois ver
						// GERACAO DE CÓDIGO, GERA DEALLOC E HLT
						//GeradorDeCodigo.getInstance().geraComando(Comandos.DALLOC, 0, 1);
						//GeradorDeCodigo.getInstance().geraComando(Comandos.HALT);
						System.out.println("Sucesso!");
						System.out.println(infixa);
					} else
						erro.erroSintatico(token.getLinha(), 21);
				} else
					erro.erroSintatico(token.getLinha(), 10);
			} else
				erro.erroSintatico(token.getLinha(), 5);
		} else
			erro.erroSintatico(token.getLinha(), 22);
	}

	private void proximoToken() throws Exception {
		if (posicaoAtualNoVetor <= finalDoVetor) {
			posicaoAtualNoVetor++;
			token = vetorDeTokens.get(posicaoAtualNoVetor);
			System.out.println("Simbolo: " + token.getSimbolo() + " Lexema: " + token.getLexema() + "  linha: "
					+ token.getLinha());
		}
	}

	private void analisaBloco() throws Exception {
		proximoToken();
		analisaEtVariaveis();
		analisaSubRotinas();
		analisaComandos();
	}

	private void analisaEtVariaveis() throws Exception {
		if (token.simboloToCode() == 14) // svar
		{
			proximoToken();
			if (token.simboloToCode() == 17) // sidentificador
			{
				while (token.simboloToCode() == 17) // sidentificador
				{
					analisaVariaveis();
					if (token.simboloToCode() == 20) // spontovirgula
					{
						proximoToken();
					} else {
						erro.erroSintatico(token.getLinha(), 10);
					}
				}
			} else {
				erro.erroSintatico(token.getLinha(), 12);
			}
		}
	}

	private void analisaVariaveis() throws Exception {
		do {
			if (token.simboloToCode() == 17) // sidentificador
			{
				Variavel s = new Variavel(token, escopo, "var", null);
				if (semantico.pesquisaIdentificadorTabela(s))
					erro.erroSintatico(token.getLinha(), 24);

				// insereTabela(new Simbolo(token, escopo, "var")) ou insereTabela(new
				// Variavel(token, escopo, "var", null))
				tabeladesimbolos.add(s);

				proximoToken();
				if ((token.simboloToCode() == 21) || (token.simboloToCode() == 37)) // svirgula ou sdoispontos
				{
					if (token.simboloToCode() == 21) // svirgula
					{
						proximoToken();
						if (token.simboloToCode() == 37) // sdoispontos
						{
							erro.erroSintatico(token.getLinha(), 5);
						}
					}
				} else {
					erro.erroSintatico(token.getLinha(), 23);
				}
			} else {
				erro.erroSintatico(token.getLinha(), 5);
			}
		}

		while (token.simboloToCode() != 37); // sdoispontos
		proximoToken();
		analisaTipo();
	}

	private void analisaTipo() throws Exception {
		if ((token.simboloToCode() != 15) && (token.simboloToCode() != 16)) // sinteiro e sbooleano
		{
			erro.erroSintatico(token.getLinha(), 7);
		} else {
			semantico.colocaTipoTabela(token.getLexema());
			proximoToken();
		}
	}

	private void analisaComandos() throws Exception {
		if (token.simboloToCode() == 2) // sinicio FAZER IGUAL PARA A FUNCAO ANALISAVARIAVEIS
		{
			proximoToken();
			analisaComandoSimples();
			while (token.simboloToCode() != 3) // sfim
			{
				if (token.simboloToCode() == 20) // spontovirgula
				{

					proximoToken();
					if (token.simboloToCode() != 3) // sfim
					{
						// Se encontrar mais de uma atribuicao no mesmo bloco deveria parar aqui
						analisaComandoSimples();
					}
				} else {
					erro.erroSintatico(token.getLinha(), 10);
				}
			}
			proximoToken();
		} else {
			erro.erroSintatico(token.getLinha(), 14);
		}
	}

	// chama cada comando conforme o simbolo lido
	private void analisaComandoSimples() throws Exception {
		switch (token.simboloToCode()) {
		case 17: // sidentificador
			analisaAtribChProcedimento();
			break;
		case 6: // sse
			analisaSe();
			break;
		case 9: // senquanto
			analisaEnquanto();
			break;
		case 13: // sleia
			analisaLeia();
			break;
		case 12: // sescreva
			analisaEscreva();
			break;
		default:
			analisaComandos();
			break;
		}
	}

	private void analisaAtribChProcedimento() throws Exception {
		proximoToken();
		if (token.simboloToCode() == 11) // satribuicao
		{

			analisaAtribuicao();
		} else {
			analisaChamadaProcedimento();
		}
	}

	// AQUI VAI O ANALISAATRBUIï¿½ï¿½O

	private void analisaLeia() throws Exception {
		// VEEEEEEEEEEEEEEEEEEEEEEEERIFICAR INICIO ************************
		proximoToken();
		if (token.simboloToCode() == 22) // sabreparenteses
		{
			proximoToken();
			if (token.simboloToCode() == 17) // sidentificador
			{

				if (!semantico.verificaTipoLeia(token.getLexema(), escopo)) {
					// ERRO
				}
				proximoToken();

				// GeradorDeCodigo.getInstance().geraComando(Comandos.RD);
				// GeradorDeCodigo.getInstance().geraComando(Comandos.STR,
				// semantico.getSimboloType(token).getInfo());

				if (token.simboloToCode() == 23) // sfechaparenteses
				{
					proximoToken();
				} else {
					erro.erroSintatico(token.getLinha(), 16);
				}
			} else {
				erro.erroSintatico(token.getLinha(), 5);
			}
		} else {
			erro.erroSintatico(token.getLinha(), 15);
		}
	}

	private void analisaEscreva() throws Exception {
		proximoToken();
		if (token.simboloToCode() == 22) // sabreparenteses
		{
			proximoToken();
			if (token.simboloToCode() == 17) // sidentificador
			{

				if (!semantico.pesquisaProcedimentoTabela(token.getLexema(), escopo)) {
					/*
					if (!semantico.verificaTipoEscreva(token.getLexema(), escopo)) {
						// ERRO
					} else {
						
						 * if(semantico.getSimboloType(token).getClass() == Rotina.class) {
						 * GeradorDeCodigo.getInstance().geraComando(Comandos.CALL,
						 * Comandos.Label+""+semantico.getSimboloType(token).getInfo());
						 * GeradorDeCodigo.getInstance().geraComando(Comandos.LDV, 0); } else {
						 * GeradorDeCodigo.getInstance().geraComando(Comandos.LDV,
						 * semantico.getSimboloType(token).getInfo()); }
						 * GeradorDeCodigo.getInstance().geraComando(Comandos.PRINT);
						 

					}
					*/

					proximoToken();

					if (token.simboloToCode() == 23) // sfechaparenteses
					{
						proximoToken();
					} else {
						erro.erroSintatico(token.getLinha(), 16);
					}
				} else {
					erro.erroSintatico(token.getLinha(), 26);
				}

			} else {
				erro.erroSintatico(token.getLinha(), 5);
			}
		} else {
			erro.erroSintatico(token.getLinha(), 15);
		}
	}

	private void analisaEnquanto() throws Exception {
		int label1 = semantico.getLabel();
		int label2 = semantico.getLabel();

		// Label principal do while
		//GeradorDeCodigo.getInstance().geraLabel(label1);
		proximoToken();
		label1++;
		analisaExpressao();
		/*
		 * if(semantico.booleanExp())
		 * 
		 * if(token.simboloToCode() == 10) //sfaca {
		 * GeradorDeCodigo.getInstance().geraComando(Comandos.JMPF,
		 * Comandos.Label+""+label2);
		 * 
		 * proximoToken(); analisaComandoSimples();
		 * 
		 * GeradorDeCodigo.getInstance().geraComando(Comandos.JUMP,
		 * Comandos.Label+""+label2); GeradorDeCodigo.getInstance().geraLabel(label2); }
		 * else { erro.erroSintatico(token.getLinha(),17); }
		 */
	}

	private void analisaSe() throws Exception {
		proximoToken();
		analisaExpressao();
		/*
		 * if(semantico.booleanExp()) { int labelSenao = semantico.getLabel(); int
		 * labelSe = semantico.getLabel();
		 * GeradorDeCodigo.getInstance().geraComando(Comandos.JMPF,
		 * Comandos.Label+""+labelSenao);
		 * 
		 * if(token.simboloToCode() == 7) //sentao { proximoToken();
		 * analisaComandoSimples();
		 * 
		 * GeradorDeCodigo.getInstance().geraComando(Comandos.JUMP,
		 * Comandos.Label+""+labelSe);
		 * GeradorDeCodigo.getInstance().geraLabel(labelSenao);
		 * 
		 * if(token.simboloToCode() == 8) //ssenao { proximoToken();
		 * analisaComandoSimples(); } GeradorDeCodigo.getInstance().geraLabel(labelSe);
		 * } else { erro.erroSintatico(token.getLinha(),18); } }
		 */
	}

	private void analisaSubRotinas() throws Exception {
		int flag = 0;
		int label = 0;

		while ((token.simboloToCode() == 4) || (token.simboloToCode() == 5)) // sprocedimento ou sfuncao
		{
			flag = 1;
			// Pega um label para pular a rotina
			label = semantico.getLabel();
			//GeradorDeCodigo.getInstance().geraComando(Comandos.JUMP, Comandos.Label + "" + label);

			if (token.simboloToCode() == 4) // sprocedimento
			{
				analisaDeclaracaoProcedimento();
			} else {
				analisaDeclaracaoFuncao();
			}
			if (token.simboloToCode() == 20) // spontovirgula
			{
				proximoToken();
			} else {
				erro.erroSintatico(token.getLinha(), 10);
			}

			if (flag == 1) {
				//GeradorDeCodigo.getInstance().geraLabel(label);
			}
		}
	}

	private void analisaDeclaracaoProcedimento() throws Exception {
		proximoToken();
		if (token.simboloToCode() == 17) // sidentificador
		{
			if (!semantico.pesquisaProcedimentoTabela(token.getLexema(), escopo)) {
				// GeradorDeCodigo.getInstance().geraLabel(semantico.getSimboloType(token).getInfo());

				proximoToken();
				if (token.simboloToCode() == 20) // spontovirgula
				{
					analisaBloco();
				} else {
					erro.erroSintatico(token.getLinha(), 10);
				}
			}
		} else {
			erro.erroSintatico(token.getLinha(), 5);
		}

		//GeradorDeCodigo.getInstance().geraComando(Comandos.RETURN);
	}

	/**
	 * 
	 * @throws Exception
	 */
	private void analisaDeclaracaoFuncao() throws Exception {
		proximoToken();
		if (token.simboloToCode() == 17) // sidentificador
		{
			if (!semantico.pesquisaFuncaoTabela(token.getLexema(), escopo)) {

				proximoToken();
				if (token.simboloToCode() == 37) // sdoispontos
				{
					proximoToken();
					if ((token.simboloToCode() == 15) || (token.simboloToCode() == 16)) // sinteiro ou sbooleano
					{
						// GeradorDeCodigo.getInstance().geraLabel(semantico.getSimboloType(func).getInfo());
						proximoToken();
						if (token.simboloToCode() == 20) // spontovirgula
						{
							analisaBloco(); // verificar analisa bloco DUUUUUUVIDA
						} else {
							erro.erroSintatico(token.getLinha(), 10);
						}
					} else
						erro.erroSintatico(token.getLinha(), 13);
				}

			}

		} else {
			erro.erroSintatico(token.getLinha(), 5);
		}
		//GeradorDeCodigo.getInstance().geraComando(Comandos.RETURN);
	}

	private void analisaExpressao() throws Exception {
		analisaExpressaoSimples();
		// smaior ou smaiorig ou sig ou smenor ou smenorig ou sdif
		if ((token.simboloToCode() == 24) || (token.simboloToCode() == 25) || (token.simboloToCode() == 26)
				|| (token.simboloToCode() == 27) || (token.simboloToCode() == 28) || (token.simboloToCode() == 29)) {
			infixa.add(token.getLexema());
			proximoToken();
			analisaExpressaoSimples();
		}

	}

	private void analisaExpressaoSimples() throws Exception {
		if ((token.simboloToCode() == 30) || (token.simboloToCode() == 31)) // smais ou smenos
		{
			if (token.simboloToCode() == 31) // nao adiciona o mais porque ele nao faz nada
				infixa.add("-u");
			proximoToken();
		}
		analisaTermo();
		while ((token.simboloToCode() == 30) || (token.simboloToCode() == 31) || (token.simboloToCode() == 35)) // smais
																												// ou
																												// smenos
																												// ou
																												// snao
		{
			//SE EU ADICIONAR O '+' DIRETO, FUNCIONA, SE EU ADICIONAR O TOKEN.GETLEXEMA() NAO FUNCIONA
			infixa.add("+");
			System.out.println("LEXEMA= " + token.getLexema());
			System.out.println("LEXEMA= " + "+");
			proximoToken();
			analisaTermo();
		}

	}

	private void analisaTermo() throws Exception {
		analisaFator();
		while ((token.simboloToCode() == 32) || (token.simboloToCode() == 33) || (token.simboloToCode() == 34)) // smult
																												// ou
																												// sdiv
																												// ou se
		{
			infixa.add(token.getLexema());
			proximoToken();
			analisaFator();
		}
	}

	private void analisaFator() throws Exception {
		if (token.simboloToCode() == 17) // sidentificador
		{
			// So vai retornar true se achar uma var ou func
			analisaChamadaFuncao();
		}

		else {
			if (token.simboloToCode() == 18) // snumero
			{
				infixa.add(token.getLexema());
				proximoToken();
			} else {
				if (token.simboloToCode() == 36) // snao
				{
					infixa.add(token.getLexema());
					proximoToken();
					analisaFator();
				} else {
					if (token.simboloToCode() == 22) // sabreparenteses
					{
						infixa.add(token.getLexema());
						proximoToken();
						analisaExpressao();
						if (token.simboloToCode() == 23) // sfechaparenteses
						{
							infixa.add(token.getLexema());
							proximoToken();
						} else {
							erro.erroSintatico(token.getLinha(), 16);
						}
					} else {
						if (token.simboloToCode() == 38 || token.simboloToCode() == 39) // sverdadeiro e sfalso
						{

							proximoToken();
						} else {
							erro.erroSintatico(token.getLinha(), 20);
						}
					}
				}
			}
		}
	}

	private void analisaChamadaProcedimento() throws Exception {
		// if(!semantico.pesquisaProcedimentoTabela(token.getLexema(),escopo))
		// {
		// GeradorDeCodigo.getInstance().geraComando(Comandos.CALL,
		// Comandos.Label+""+semantico.getSimboloType(t).getInfo());
		// }
	}

	private void analisaChamadaFuncao() throws Exception {
		// if(!semantico.pesquisaFuncaoTabela(token.getLexema(),escopo))
		// {
		// erro.erroSintatico(token.getLinha(), 27);
		// }

		infixa.add(token.getLexema());
		proximoToken();

	}

	// VEEEEEER DEPOIS ANALISA ATRIBUICAO()
	private void analisaAtribuicao() throws Exception {

		proximoToken();
		analisaExpressao();

		posfixa.setInfixa(infixa);
		ArrayList<String> expressao = new ArrayList<String>();
		expressao = posfixa.toPolonesaReversaDesempilha();
		System.out.println("posfixa = " + expressao);
		infixa.clear();

	}

}
