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
	ArrayList<String> infixa = new ArrayList<String>();
	
	public AnalisadorSintatico(String caminho) throws Exception {
		lexico = new AnalisadorLexical(caminho);
		token = vetorDeTokens.get(posicaoAtualNoVetor);
		System.out.println("Simbolo: "+ token.getSimbolo() + " Lexema: " + token.getLexema() + "  linha: " + token.getLinha());
		System.out.println("Simbolo: " + token.getSimbolo() + " Lexema: " + token.getLexema() + "  linha: " + token.getLinha());
		
		if(token.simboloToCode() == 1) //sprograma 
		{ 
			proximoToken();
			if(token.simboloToCode() == 17) //sidentificador
			{
				proximoToken();
				if(token.simboloToCode() == 20) //sponto e virgula
				{
					analisaBloco();
				}
			}
		}
	}
	
	private void proximoToken() 
	{
		if(posicaoAtualNoVetor <= finalDoVetor)
		{
			posicaoAtualNoVetor++;
			token = vetorDeTokens.get(posicaoAtualNoVetor);
			System.out.println("Simbolo: " + token.getSimbolo() + " Lexema: " + token.getLexema() + "  linha: "
					+ token.getLinha());
		}
	}
	
	private void analisaBloco() throws Exception 
	{
		proximoToken();
		analisaEtVariaveis();
		analisaSubRotinas();
		analisaComandos();
	}
	
	private void analisaEtVariaveis() throws Exception 
	{
		if (token.simboloToCode() == 14) // svar
		{
			proximoToken();
			if (token.simboloToCode() == 17) // sidentificador
			{
				while (token.simboloToCode() == 17) //sidentificador
				{
					//analisaVariaveis(); FALTA IMPLEMENTAR
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
	
    private void analisaSubRotinas() throws Exception 
    {
		
	}
    
    private void analisaComandos() throws Exception 
    {
		
   	}
}

