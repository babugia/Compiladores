// est� classe ser� a classe de erro, iremos elencar os tipos de erros que acontecer�
//no compilador, por exemplo: erros l�xico, sint�tico e semantico

package src.COMPILADOR;

import javax.swing.JOptionPane;

public class VerificaErro 
{
    String msgErro;
    int linha = 0;
    int type;
    
    //falta o construtor da classe
    
    public void verificaErroLexico (int linhaErro, int cod) throws Exception
    {
        JOptionPane.showMessageDialog(null, "Erro de compila��o", "Erro", JOptionPane.ERROR_MESSAGE);
        System.out.println("Erro Lexico identificado na linha: " +linhaErro+ "  Descri��o: "+codigoDoErro(cod));
        throw new Exception("Erro l�xico. Descri��o: "+codigoDoErro(cod));
    }
    
    //m�todo para verificar o c�digo do erro e assim mostrar para o usu�rio
    public String codigoDoErro (int cod)
    {
        switch(cod)
        {
            case 1:
                return "Falta ponto final";
            case 2:
                return "Falta ';'";
            case 3:
                return "Falta identificador";
            case 4:
                return "Falta identificador 'programa'";
            case 5:
                return "Falta ':'";
            case 6:
                return "Falta ',' ou ':'";
            case 7:
                return "Falta atribui��o de tipo";
            case 8:
                return "Falta 'inicio'";
            case 9:
                return "Falta '('";
            case 10:
                return "Falta ')'";
            case 11:
                return "Erro na expressao'";
            case 12:
                return "Falta 'entao'";
            case 13:
                return "Falta 'verdeiro' ou 'falso'";
            case 14:
                return "Erro, sem o } para terminar o comentario.";
            case 15:
                return "Erro, palavra n�o pertence a linguagem.";
            case 16:
                return "Posicao invalida";
            case 17:
                return "Erro, Final do vetor de tokens atingido.";
            case 18:
                return "Atribui��o de fun��o repetida";
            case 19:
                return "�ltimo comando n�o era a atribui��o da fun��o";
            case 20:
                return "Var n�o existe";
            case 21:
                return "Tipo da Express�o inv�lida";
            case 22:
                return "Tipo da Express�o inv�lida";
            case 23:
                return "Sidentificador n�o encontrado";
            case 24:
                return "Identificador n�o existe";
            case 25:
                return "Expressao inv�lida, n�o � booleana";
            case 26:
                return "Express� n�o � booleana";
            case 27:
                return "Sidentificador inv�lido, var n�o declarada";
            case 28:
                return "Sidentificador inv�lido, fun��o j� existe";
            case 29:
                return "Sidentificador inv�lido";
            case 30:
                return "Sidentificador inv�lido, procedimento n�o encontrado";
        }
        return "Erro nao encontrado";
    }
     
 }
