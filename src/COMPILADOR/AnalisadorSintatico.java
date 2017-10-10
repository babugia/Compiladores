
package src.COMPILADOR;

import java.util.Vector;

public class AnalisadorSintatico {

	private Token token = null;
    private Erro erro = new Erro();
    private Vector<Token> vetorDeTokens;
    private int posicaoAtualNoVetor = 0;
    private int finalDoVetor = 0;
    private AnalisadorLexical lexico;
    private boolean wasFuncAtrib = false;
	
	//recebe o caminho do arquivo e come�a a execu��o do sintatico
	
	public AnalisadorSintatico(String caminhoArquivo) throws Exception
	{
		lexico = new AnalisadorLexical(caminhoArquivo);
        vetorDeTokens = lexico.pegaTokens();
        finalDoVetor = vetorDeTokens.size();
        token = vetorDeTokens.get(posicaoAtualNoVetor);  //Recebe primeiro token
        System.out.println("Simbolo: "+token.getSimbolo()+" Lexema: "+token.getLexema()+"  linha: "+token.getLinha());
		System.out.println("Simbolo: "+token.getSimbolo()+" Lexema: "+token.getLexema()+"  linha: "+token.getLinha());
		
		if(token.simboloToCode() == 1)  //sprograma
        {
			proximoToken();
            if(token.simboloToCode() == 17)  //sidentificador
            {
                proximoToken(); //fun��o auxiliar para ler o proximo token
                if(token.simboloToCode() == 20) //spontovirgula
                {
                    analisaBloco();
                    if(token.simboloToCode() == 19)  //sponto
                    {
                        System.out.println("Sucesso!");
                    }
                    else erro.erroSintatico(token.getLinha(),21);
                }
                else erro.erroSintatico(token.getLinha(),10);
            }
            else erro.erroSintatico(token.getLinha(),5);
        }
        else erro.erroSintatico(token.getLinha(),22);
    }
	
	//fun��o auxiliar que pega o proximoToken; ou seja vai ler do lexico o token e trazer pra c�
	
	private void proximoToken() throws Exception
    {
        if(posicaoAtualNoVetor <= finalDoVetor)
        {
            posicaoAtualNoVetor++;
            token = vetorDeTokens.get(posicaoAtualNoVetor);
            System.out.println("Simbolo: "+token.getSimbolo()+" Lexema: "+token.getLexema()+ "  linha: "+token.getLinha());
        }
    }
    
    //analisa bloco, onde chama as fun��es de analisar variaveis, rotinas e comandos;
	//
	
    private void analisaBloco () throws Exception
    {
        proximoToken();
        analisaEtVariaveis();  //fun��o que l� as v�riaveis
        analisaSubRotinas();   //fun�ao que vai analisar as subRotinas
        analisaComandos(); //fun��o para analisar os comandos
    }
    
    private void analisaEtVariaveis() throws Exception
    {
        if(token.simboloToCode() == 14) //svar
        {
            proximoToken();
            if(token.simboloToCode() == 17) //sidentificador
            {
                while(token.simboloToCode() == 17)  //sidentificador
                {
                    analisaVariaveis();
                    if(token.simboloToCode() == 20)  //spontovirgula
                    {
                        proximoToken();
                    }
                    else
                    {
                        erro.erroSintatico(token.getLinha(),10);
                    }
                }
            }
            else
            {
                erro.erroSintatico(token.getLinha(),12);
            }
        }
    }
    private void analisaVariaveis() throws Exception
    {
    	//*********************verificar se � necess�rio o sinicio******************************
        do
        {
            if(token.simboloToCode() == 17)  //sidentificador
            {
                proximoToken();
                if((token.simboloToCode() == 21) || (token.simboloToCode() == 37)) //svirgula ou sdoispontos
                {
                    if(token.simboloToCode() == 21) //svirgula
                    {
                        proximoToken();
                        if(token.simboloToCode() == 37)  //sdoispontos
                        {
                            erro.erroSintatico(token.getLinha(),5);
                        }
                    }
                }
                else 
                {
                    erro.erroSintatico(token.getLinha(),23);
                }
            }
            else 
            {
                erro.erroSintatico(token.getLinha(),5);
            }
        }
        while(token.simboloToCode() != 37);  //sdoispontos
        proximoToken();
        analisaTipo();
    }
    
    private void analisaTipo() throws Exception
    {
        if((token.simboloToCode() != 15) && (token.simboloToCode() != 16))  //sinteiro e sbooleano
        {
            erro.erroSintatico(token.getLinha(),7);
        }
        else
        {
            proximoToken();
        }
    }
    
    private void analisaComandos() throws Exception
    {
        if(token.simboloToCode() == 2)  //sinicio    FAZER IGUAL PARA A FUNCAO ANALISAVARIAVEIS
        {
            proximoToken();
            analisaComandoSimples();
            while(token.simboloToCode()!= 3)  //sfim  
            {
                if(token.simboloToCode() == 20)  //spontovirgula
                {
                	
                    proximoToken();
                    if(token.simboloToCode() != 3)  //sfim
                    {
                        // Se encontrar mais de uma atribui��o no mesmo bloco deveria parar aqui
                        analisaComandoSimples();
                    }
                }
                else
                {
                        erro.erroSintatico(token.getLinha(),10);
                }
            } 
            proximoToken();
        }
        else
        {
            erro.erroSintatico(token.getLinha(),14);  
        }
    }
    
   //chama cada comando conforme o simbolo lido
    private void analisaComandoSimples() throws Exception
    {
        switch (token.simboloToCode())
        {
            case 17:    // sidentificador
            	analisaAtribChProcedimento();
                break;
            case 6:    // sse
                analisaSe();
                break;
            case 9:    //senquanto
                analisaEnquanto();
                break;
            case 13:    //sleia
                analisaLeia();
                break;
            case 12:    //sescreva
                analisaEscreva();
                break;
            default:
                analisaComandos();
                break;
        }
    }
  
    private void analisaAtribChProcedimento() throws Exception   
    {
        //Simbolo onde ocorre o STR, ou o label da chamada de proc
        proximoToken();
        if(token.simboloToCode() == 11)  // satribuicao
        {
               analisaAtribuicao(); //verificar ANALISA ATRIBUI��O DUVIDA    
        }
        else
        {            
            analisaChamadaProcedimento(); //verificar analisa chamada procedimento
        }
    }
    
    //AQUI VAI O ANALISAATRBUI��O
    
    private void analisaLeia() throws Exception
    {
    	//VEEEEEEEEEEEEEEEEEEEEEEEERIFICAR INICIO ************************
        proximoToken();
        if(token.simboloToCode() == 22)  // sabreparenteses
        {
            proximoToken();
            if(token.simboloToCode() == 17)  //sidentificador
            {
                proximoToken();
                if(token.simboloToCode() == 23)  //sfechaparenteses
                {
                    proximoToken();
                }
                else
                {
                    erro.erroSintatico(token.getLinha(),16);
                }
            }
            else
            {
                erro.erroSintatico(token.getLinha(),5);
            }
        }
        else
        {
            erro.erroSintatico(token.getLinha(),15);
        }
    }
    
    private void analisaEscreva() throws Exception
    {
        proximoToken();
        if(token.simboloToCode() == 22)  //sabreparenteses
        {
            proximoToken();
            if(token.simboloToCode() == 17) //sidentificador
            {
                proximoToken();
                if(token.simboloToCode() == 23)  //sfechaparenteses
                {
                    proximoToken();
                }
                else
                {
                    erro.erroSintatico(token.getLinha(),16);
                }
            }
            else
            {
                erro.erroSintatico(token.getLinha(),5);
            }
        }
        else
        {
            erro.erroSintatico(token.getLinha(),15);
        }
    }
    
    private void analisaEnquanto() throws Exception
    {   
        proximoToken();
        analisaExpressao();
        
            if(token.simboloToCode() == 10) //sfaca
            {
                proximoToken();
                analisaComandoSimples();
            }
            else
            {
                erro.erroSintatico(token.getLinha(),17);
            }
    }
    
    private void analisaSe() throws Exception
    {
        proximoToken();
        analisaExpressao();
            if(token.simboloToCode() == 7)  //sentao
            {
                proximoToken();
                analisaComandoSimples();
                if(token.simboloToCode() == 8)  //ssenao
                {
                    proximoToken();
                    analisaComandoSimples();
                }
            }
            else
            {
                erro.erroSintatico(token.getLinha(),18);
            }    
     }
    
    private void analisaSubRotinas() throws Exception
    {
        while((token.simboloToCode() == 4) || (token.simboloToCode() == 5))  //sprocedimento ou sfuncao
        {
            if(token.simboloToCode() == 4)  //sprocedimento
            {
                analisaDeclaracaoProcedimento();
            }
            else
            {
                analisaDeclaracaoFuncao();
            }
            if(token.simboloToCode() == 20)  //spontovirgula
            {
                proximoToken();
            }
            else
            {
                erro.erroSintatico(token.getLinha(),10);
            }
        }
    }
    
    private void analisaDeclaracaoProcedimento() throws Exception
    {
        proximoToken();
        if(token.simboloToCode() == 17)  //sidentificador
        {
                proximoToken();
                if(token.simboloToCode() == 20)  //spontovirgula
                {
                    analisaBloco();
                }
                else
                {
                    erro.erroSintatico(token.getLinha(),10);
                }
        }
        else
        {
            erro.erroSintatico(token.getLinha(),5);
        }
    }
    
    /**
     * 
     * @throws Exception 
     */
    private void analisaDeclaracaoFuncao() throws Exception
    {
        proximoToken();
        if(token.simboloToCode() == 17)  //sidentificador
        {
                proximoToken();
                if(token.simboloToCode() == 37)  //sdoispontos
                {
                    proximoToken();
                    if((token.simboloToCode() == 15) || (token.simboloToCode() == 16))  //sinteiro ou sbooleano
                    {
                        proximoToken();
                        if(token.simboloToCode() == 20)  //spontovirgula
                        {
                            analisaBloco(); //verificar analisa bloco DUUUUUUVIDA
                        }
                        else
                        {
                            erro.erroSintatico(token.getLinha(),10);
                        }
                    }
                    else erro.erroSintatico(token.getLinha(),13);
                }
        }
        else
        {
            erro.erroSintatico(token.getLinha(),5);
        }
        
    }
    
   
    private void analisaExpressao() throws Exception
    {
        analisaExpressaoSimples();
        // smaior ou smaiorig ou sig ou smenor ou smenorig ou sdif
        if((token.simboloToCode() == 24) || (token.simboloToCode() == 25) || (token.simboloToCode() == 26) || (token.simboloToCode() == 27) || (token.simboloToCode() == 28) || (token.simboloToCode() == 29))
        {
            proximoToken();
            analisaExpressaoSimples();
        }
    }
    
    private void analisaExpressaoSimples() throws Exception
    {
        if((token.simboloToCode() == 30) || (token.simboloToCode() == 31))  //smais ou smenos
        {
            if(token.simboloToCode() == 31) // n�o adiciona o mais porque ele n�o faz nada
            	proximoToken();
        }
        analisaTermo();
        while((token.simboloToCode() == 30) || (token.simboloToCode() == 31) || (token.simboloToCode() == 35))  //smais ou smenos ou sou
        {
            proximoToken();
            analisaTermo();
        }
        
    }
    
    /* Deve adicionar os operadores na tabela de simbolos.
     * @throws Exception 
     */
    private void analisaTermo() throws Exception
    {
        analisaFator();
        while((token.simboloToCode() == 32) || (token.simboloToCode() == 33) || (token.simboloToCode() == 34))  //smult ou sdiv ou se
        {
            proximoToken();
            analisaFator();
        }
    }
    
    /**
     * Vai adicionando os identificadore ou n�meros na tabela de s�bolos.
     * Tamb�m adiciona abre e fecha parentesis.
     * @throws Exception 
     */
    private void analisaFator() throws Exception
    {
        if(token.simboloToCode() == 17)  //sidentificador
        {
            //S� vai retornar true se achar uma var ou func
                    analisaChamadaFuncao();
        }
        
        else
        {
            if(token.simboloToCode() == 18)  //snumero
            {
                proximoToken();
            }
            else
            {
                if(token.simboloToCode() == 36)  //snao
                {
                    
                    proximoToken();
                    analisaFator();
                }
                else
                {
                    if(token.simboloToCode() == 22)  //sabreparenteses
                    {
                        
                        proximoToken();
                        analisaExpressao();
                        if(token.simboloToCode() == 23)  //sfechaparenteses
                        {
                            
                            proximoToken();
                        }
                        else
                        {
                            erro.erroSintatico(token.getLinha(), 16);
                        }
                    }
                    else
                    {
                        if(token.simboloToCode() == 38 || token.simboloToCode() == 39) //sverdadeiro e sfalso
                        {
                            
                            proximoToken();
                        }
                        else
                        {
                            erro.erroSintatico(token.getLinha(), 20);
                        }
                    }
                }
            }
        }
    }
    
    private void analisaChamadaProcedimento() throws Exception
    {
        //proximoToken();
    }
    
   
    private void analisaChamadaFuncao() throws Exception
    {
        proximoToken();
    }
    
    private void analisaAtribuicao() throws Exception {
    	proximoToken();
    	analisaExpressao();
    	                                                                                                                                                   
    }
    
}

    
    
    

