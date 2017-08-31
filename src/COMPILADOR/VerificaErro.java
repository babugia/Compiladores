// está classe será a classe de erro, iremos elencar os tipos de erros que acontecerá
//no compilador, por exemplo: erros léxico, sintático e semantico

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
        JOptionPane.showMessageDialog(null, "Erro de compilação", "Erro", JOptionPane.ERROR_MESSAGE);
        System.out.println("Erro Lexico identificado na linha: " +linhaErro+ "  Descrição: "+codigoDoErro(cod));
        throw new Exception("Erro léxico. Descrição: "+codigoDoErro(cod));
    }
    
    //método para verificar o código do erro e assim mostrar para o usuário
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
                return "Falta atribuição de tipo";
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
                return "Erro, palavra não pertence a linguagem.";
            case 16:
                return "Posicao invalida";
            case 17:
                return "Erro, Final do vetor de tokens atingido.";
            case 18:
                return "Atribuição de função repetida";
            case 19:
                return "Último comando não era a atribuição da função";
            case 20:
                return "Var não existe";
            case 21:
                return "Tipo da Expressão inválida";
            case 22:
                return "Tipo da Expressão inválida";
            case 23:
                return "Sidentificador não encontrado";
            case 24:
                return "Identificador não existe";
            case 25:
                return "Expressao inválida, não é booleana";
            case 26:
                return "Expressã não é booleana";
            case 27:
                return "Sidentificador inválido, var não declarada";
            case 28:
                return "Sidentificador inválido, função já existe";
            case 29:
                return "Sidentificador inválido";
            case 30:
                return "Sidentificador inválido, procedimento não encontrado";
        }
        return "Erro nao encontrado";
    }
     
 }
