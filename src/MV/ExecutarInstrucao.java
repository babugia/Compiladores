package src.MV;

import java.util.Vector;

import javax.swing.JOptionPane;

public class ExecutarInstrucao {

	Vector<Instrucao> m_instrucoes = null;
    Pilha m_pilha = null;
    boolean fim = false;
    int res = 0;
    String saida = null;
    int m_instrucao = 0;
    
    private void executaExpressaoSimples(Instrucao instrucao)
    {
//        getInstrucaoNome i = instrucao.getInstrucao();
//        if(i == getInstrucaoNome.ADD)      add();
//        if(i == getInstrucaoNome.SUB)      sub();
//        if(i == getInstrucaoNome.MULT)     mult();
//        if(i == getInstrucaoNome.DIVI)     divi();
//        if(i == getInstrucaoNome.INV)      inv();
//        if(i == getInstrucaoNome.AND)      and();
//        if(i == getInstrucaoNome.OR)       or();
//        if(i == getInstrucaoNome.NEG)      neg();
//        if(i == getInstrucaoNome.CME)      cme();
//        if(i == getInstrucaoNome.CMA)      cma();
//        if(i == getInstrucaoNome.CEQ)      ceq();  
//        if(i == getInstrucaoNome.CDIF)     cdif(); 
//        if(i == getInstrucaoNome.CMEQ)     cmeq(); 
//        if(i == getInstrucaoNome.CMAQ)     cmaq(); 
//        if(i == getInstrucaoNome.START)    start();
//        if(i == getInstrucaoNome.HLT)      hlt();
//        if(i == getInstrucaoNome.NULL)     nul();
//        if(i == getInstrucaoNome.RD)       rd();
//        if(i == getInstrucaoNome.PRN)      prn();
//        if(i == getInstrucaoNome.RETURN)   ret();
    	
    	String i = instrucao.getInstrucao();
        if(i == "ADD")      add();
        if(i == "SUB")      sub();
        if(i == "MULT")     mult();
        if(i == "DIV")     div();
        if(i == "INV")      inv();
        if(i == "AND")      and();
        if(i == "OR")       or();
        if(i == "NEG")      neg();
        if(i == "CME")      cme();
        if(i == "CMA")      cma();
        if(i == "CEQ")      ceq();  
        if(i == "CDIF")     cdif(); 
        if(i == "CMEQ")     cmeq(); 
        if(i == "CMAQ")     cmaq(); 
        if(i == "START")    start();
        if(i == "HLT")      hlt();
        if(i == "NULL")     nul();
        if(i == "RD")       rd();
        if(i == "PRN")      prn();
        if(i == "RETURN")   ret();
    }
    
    private void add()
    {
        // M[s-1] := M[s-1] + M[s]; s := s-1
        res = m_pilha.getValor(2) + m_pilha.getValor(1);
        m_pilha.setValor(2, res);
        m_pilha.pop();
    }
    
    private void sub()
    {
        //M[s-1]:=M[s-1] - M[s]; s:=s - 1
        res = m_pilha.getValor(2) - m_pilha.getValor(1);
        m_pilha.setValor(2, res);
        m_pilha.pop();
    }
    
    private void mult()
    {
        //M[s-1]:=M[s-1] * M[s]; s:=s - 1
        res = m_pilha.getValor(2) * m_pilha.getValor(1);
        m_pilha.setValor(2, res);
        m_pilha.pop();
    }
    
    private void div()
    {
        //M[s-1]:=M[s-1] div M[s]; s:=s - 1
        res = m_pilha.getValor(2) / m_pilha.getValor(1);
        m_pilha.setValor(2, res);
        m_pilha.pop();
    }
    
    private void inv()
    {
        //M[s]:= -M[s]
        res = -m_pilha.getValor(1);
        m_pilha.setValor(1, res);
    }
    
    private void and()
    {
        //se M [s-1] = 1 e M[s] = 1 então M[s-1]:=1 senão M[s-1]:=0; s:=s - 1
        if((m_pilha.getValor(2) == 1) && (m_pilha.getValor(1) == 1))
        {
            m_pilha.setValor(2, 1);
        }
        else
        {
            m_pilha.setValor(2, 0);
        }
        m_pilha.pop();
    }
    
    private void or()
    {
        //se M[s-1] = 1 ou M[s] = 1 então M[s-1]:=1 senão M[s-1]:=0; s:=s - 1
        if((m_pilha.getValor(2) == 1) || (m_pilha.getValor(1) == 1))
        {
            m_pilha.setValor(2, 1);
        }
        else
        {
            m_pilha.setValor(2, 0);
        }
        m_pilha.pop();
    }
    
    private void neg()
    {
        //M[s]:= 1-M[s]
        res = 1 - m_pilha.getValor(1);
        m_pilha.setValor(m_pilha.pilhaSize()-1, res);
    }
    
    private void cme()
    {
        //se M[s-1] < M[s] então M[s-1]:=1 senão M[s-1]:=0; s:=s - 1
        if((m_pilha.getValor(2)) < (m_pilha.getValor(1)))
        {
            m_pilha.setValor(2, 1);
        }
        else
        {
            m_pilha.setValor(2, 0);
        }
        m_pilha.pop();
    }
    
    private void cma()
    {
        //se M[s-1] > M[s] então M[s-1]:=1 senão M[s-1]:=0; s:=s - 1
        if((m_pilha.getValor(2)) > (m_pilha.getValor(1)))
        {
            m_pilha.setValor(2, 1);
        }
        else
        {
            m_pilha.setValor(2, 0);
        }
        m_pilha.pop();
    }
    
    private void ceq()
    {
        //se M[s-1] = M[s] então M[s-1]:=1 senão M[s-1]:=0; s:=s - 1
        if((m_pilha.getValor(2)) == (m_pilha.getValor(1)))
        {
            m_pilha.setValor(2, 1);
        }
        else
        {
            m_pilha.setValor(2, 0);
        }
        m_pilha.pop();
    }
    
    private void cdif()
    {
        //se M[s-1] != M[s] então M[s-1]:=1 senão M[s-1]:=0; s:=s - 1
        if((m_pilha.getValor(2)) != (m_pilha.getValor(1)))
        {
            m_pilha.setValor(2, 1);
        }
        else
        {
            m_pilha.setValor(2, 0);
        }
        m_pilha.pop();
    }
    
    private void cmeq()
    {
        //se M[s-1] <= M[s] então M[s-1]:=1 senão M[s-1]:=0; s:=s - 1
        if((m_pilha.getValor(2)) <= (m_pilha.getValor(1)))
        {
            m_pilha.setValor(2, 1);
        }
        else
        {
            m_pilha.setValor(2, 0);
        }
        m_pilha.pop();
    }   
    
    private void cmaq()
    {
        //se M[s-1] >= M[s] então M[s-1]:=1 senão M[s-1]:=0; s:=s - 1
        if((m_pilha.getValor(2)) >= (m_pilha.getValor(1)))
        {
            m_pilha.setValor(2, 1);
        }
        else
        {
            m_pilha.setValor(2, 0);
        }
        m_pilha.pop();
    }
    
    private void start()
    {
        //S:=-1
        m_pilha = new Pilha();
    }
    
    private void hlt()
    {
        fim = true;
    }
    
    private void nul()
    {
        //nada a se fazer.
    }
    
    private void rd()
    {
        //S:=s+1; M[s]:=proxima entra
        String value = JOptionPane.showInputDialog(null, "Valor:", "Entrada de valor", JOptionPane.QUESTION_MESSAGE);
        res = Integer.parseInt(value);
        m_pilha.push(m_pilha.pilhaSize(), res);
    }
    
    private void prn()
    {
        //M[s];s:=s-1;
        saida = String.valueOf(m_pilha.getValor(1));
        m_pilha.pop();
    }
    
    private void ret()
    {
        m_instrucao = (m_pilha.getValor(1))-1;
        m_pilha.pop();
    }
    
    private void executaExpressaoComposta(Instrucao instrucao)
    {
//        getInstrucaoNome i = instrucao.getInstrucao();
//        if(i == getInstrucaoNome.LDC)  ldc(instrucao.getParam1());
//        if(i == getInstrucaoNome.LDV)  ldv(instrucao.getParam1());
//        if(i == getInstrucaoNome.STR) str(instrucao.getParam1());
//        if(i == getInstrucaoNome.JMP) jmp(instrucao.getParam1());
//        if(i == getInstrucaoNome.JMPF)  jmpf(instrucao.getParam1());
//        if(i == getInstrucaoNome.CALL)  call(instrucao.getParam1());
    		String i = instrucao.getInstrucao();
        if(i == "LDC")  ldc(Integer.parseInt(instrucao.getAtributo1()));
        if(i == "LDV")  ldv(Integer.parseInt(instrucao.getAtributo1()));
        if(i == "STR") str(Integer.parseInt(instrucao.getAtributo1()));
        if(i == "JMP") jmp(Integer.parseInt(instrucao.getAtributo1()));
        if(i == "JMPF")  jmpf(Integer.parseInt(instrucao.getAtributo1()));
        if(i == "CALL")  call(Integer.parseInt(instrucao.getAtributo1()));
    }
    
    private void ldc(int param)
    {
        //S:=s+1 ; M[s]:=k
        m_pilha.push(m_pilha.pilhaSize(), param);
    }
    
    private void ldv(int param)
    {
        //S:=s+1 ; M[s]:=M[n]
        m_pilha.pushPos(param);
    }
    
    private void str(int param)
    {
        //M[n]:=M[s]; s;=s-1;
        m_pilha.setValorFixo(param, m_pilha.getValor(1));
        m_pilha.pop();
    }
    
    private void jmp(int param)
    {
        //desviar sempre instrucao:=param
        m_instrucao = param;
    }
    
    private void jmpf(int param)
    {
        // desviar caso falso  se M[s]=0, entao i:=att1, senao i:=i+1
        res = m_pilha.getValor(1);
        if(res == 0)
            m_instrucao = param;
        m_pilha.pop();
    }
    
    private void call(int param)
    {
        m_pilha.push(m_pilha.pilhaSize(), m_instrucao +1);
        m_instrucao = param;
    }
    
    private void executaExpressaoDuplamenteComposta(Instrucao instrucao)
    {
    		//quer que retorna o nome da instrucao
        String i = instrucao.getInstrucao();
//        if(i == getInstrucaoNome.ALLOC) alloc(instrucao.getAtributo1(), instrucao.getAtributo2());
//        if(i == getInstrucaoNome.DALLOC) dalloc(instrucao.getAtributo1(), instrucao.getAtributo2());
        //Integer.parseInt("1234");
        if(i == "ALLOC") alloc(Integer.parseInt(instrucao.getAtributo1()), Integer.parseInt(instrucao.getAtributo2()));
        if(i == "DALLOC") dalloc(Integer.parseInt(instrucao.getAtributo1()), Integer.parseInt(instrucao.getAtributo2()));
    }
    
    private void alloc(int p1, int p2)
    {
        //{s:=s + 1; M[s]:=M[m+k]}
        for(int k=0; k<(p2);k++)
        {
            m_pilha.push(m_pilha.pilhaSize(), 0);
            m_pilha.setValor(1, m_pilha.getValorFixo(p1+k));
        }
    }
    
    private void dalloc(int p1, int p2)
    {
        //{M[m+k]:=M[s]; s:=s - 1}
         for(int k =(p2-1); k>=0; k--)
         {
             m_pilha.setValorFixo(p1+k, m_pilha.getValor(1));
             m_pilha.pop();
         }
    }
}
