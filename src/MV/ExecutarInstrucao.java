package src.MV;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;

public class ExecutarInstrucao {

	ArrayList<Instrucao> instrucoes = null;
    Pilha pilha = null;
    boolean fim = false;
    int res = 0;
    String saida = null;
    int instrucaoNum = 0;
    
    public ExecutarInstrucao(ArrayList<Instrucao> instrucoes) throws Exception
    {
        this.instrucoes = instrucoes;
        instrucaoNum = 0;
    }
    
    public ArrayList<Instrucao> getInstrucoes()
    {
        return instrucoes;
    }

    public Pilha getPilha()
    {
        return pilha;
    }
    
    public String getSaida()
    {
        return saida;
    }
    
    public void setSaida()
    {
        saida = null;
    }
    
    public boolean isFim()
    {
        if(fim) 
            return true;
        
        return false;
    }
    
    public void run()
    {
        if(instrucaoNum < 0 || instrucaoNum < instrucoes.size())
        {
            executaInstrucao(instrucoes.get(instrucaoNum));
            instrucaoNum++;
        }
    }
    
    private void executaInstrucao(Instrucao instrucao)
    {
    		String i = instrucao.getInstrucao();
        if(i == "ADD")      add();
        if(i == "SUB")      sub();
        if(i == "MULT")     mult();
        if(i == "DIV")      div();
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
        if(i == "LDC")  ldc(Integer.parseInt(instrucao.getAtributo1()));
        if(i == "LDV")  ldv(Integer.parseInt(instrucao.getAtributo1()));
        if(i == "STR") str(Integer.parseInt(instrucao.getAtributo1()));
        if(i == "JMP") jmp(Integer.parseInt(instrucao.getAtributo1()));
        if(i == "JMPF")  jmpf(Integer.parseInt(instrucao.getAtributo1()));
        if(i == "CALL")  call(Integer.parseInt(instrucao.getAtributo1()));
        if(i == "ALLOC") alloc(Integer.parseInt(instrucao.getAtributo1()), Integer.parseInt(instrucao.getAtributo2()));
        if(i == "DALLOC") dalloc(Integer.parseInt(instrucao.getAtributo1()), Integer.parseInt(instrucao.getAtributo2()));
    }
    
    private void add()
    {
        // M[s-1] := M[s-1] + M[s]; s := s-1
        res = pilha.getValor(2) + pilha.getValor(1);
        pilha.setValor(2, res);
        pilha.pop();
    }
    
    private void sub()
    {
        //M[s-1]:=M[s-1] - M[s]; s:=s - 1
        res = pilha.getValor(2) - pilha.getValor(1);
        pilha.setValor(2, res);
        pilha.pop();
    }
    
    private void mult()
    {
        //M[s-1]:=M[s-1] * M[s]; s:=s - 1
        res = pilha.getValor(2) * pilha.getValor(1);
        pilha.setValor(2, res);
        pilha.pop();
    }
    
    private void div()
    {
        //M[s-1]:=M[s-1] div M[s]; s:=s - 1
        res = pilha.getValor(2) / pilha.getValor(1);
        pilha.setValor(2, res);
        pilha.pop();
    }
    
    private void inv()
    {
        //M[s]:= -M[s]
        res = -pilha.getValor(1);
        pilha.setValor(1, res);
    }
    
    private void and()
    {
        //se M [s-1] = 1 e M[s] = 1 então M[s-1]:=1 senão M[s-1]:=0; s:=s - 1
        if((pilha.getValor(2) == 1) && (pilha.getValor(1) == 1))
        {
            pilha.setValor(2, 1);
        }
        else
        {
            pilha.setValor(2, 0);
        }
        pilha.pop();
    }
    
    private void or()
    {
        //se M[s-1] = 1 ou M[s] = 1 então M[s-1]:=1 senão M[s-1]:=0; s:=s - 1
        if((pilha.getValor(2) == 1) || (pilha.getValor(1) == 1))
        {
            pilha.setValor(2, 1);
        }
        else
        {
            pilha.setValor(2, 0);
        }
        pilha.pop();
    }
    
    private void neg()
    {
        //M[s]:= 1-M[s]
        res = 1 - pilha.getValor(1);
        pilha.setValor(pilha.pilhaSize()-1, res);
    }
    
    private void cme()
    {
        //se M[s-1] < M[s] então M[s-1]:=1 senão M[s-1]:=0; s:=s - 1
        if((pilha.getValor(2)) < (pilha.getValor(1)))
        {
            pilha.setValor(2, 1);
        }
        else
        {
            pilha.setValor(2, 0);
        }
        pilha.pop();
    }
    
    private void cma()
    {
        //se M[s-1] > M[s] então M[s-1]:=1 senão M[s-1]:=0; s:=s - 1
        if((pilha.getValor(2)) > (pilha.getValor(1)))
        {
            pilha.setValor(2, 1);
        }
        else
        {
            pilha.setValor(2, 0);
        }
        pilha.pop();
    }
    
    private void ceq()
    {
        //se M[s-1] = M[s] então M[s-1]:=1 senão M[s-1]:=0; s:=s - 1
        if((pilha.getValor(2)) == (pilha.getValor(1)))
        {
            pilha.setValor(2, 1);
        }
        else
        {
            pilha.setValor(2, 0);
        }
        pilha.pop();
    }
    
    private void cdif()
    {
        //se M[s-1] != M[s] então M[s-1]:=1 senão M[s-1]:=0; s:=s - 1
        if((pilha.getValor(2)) != (pilha.getValor(1)))
        {
            pilha.setValor(2, 1);
        }
        else
        {
            pilha.setValor(2, 0);
        }
        pilha.pop();
    }
    
    private void cmeq()
    {
        //se M[s-1] <= M[s] então M[s-1]:=1 senão M[s-1]:=0; s:=s - 1
        if((pilha.getValor(2)) <= (pilha.getValor(1)))
        {
            pilha.setValor(2, 1);
        }
        else
        {
            pilha.setValor(2, 0);
        }
        pilha.pop();
    }   
    
    private void cmaq()
    {
        //se M[s-1] >= M[s] então M[s-1]:=1 senão M[s-1]:=0; s:=s - 1
        if((pilha.getValor(2)) >= (pilha.getValor(1)))
        {
            pilha.setValor(2, 1);
        }
        else
        {
            pilha.setValor(2, 0);
        }
        pilha.pop();
    }
    
    private void start()
    {
        //S:=-1
        pilha = new Pilha();
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
        pilha.push(pilha.pilhaSize(), res);
    }
    
    private void prn()
    {
        //M[s];s:=s-1;
        saida = String.valueOf(pilha.getValor(1));
        pilha.pop();
    }
    
    private void ret()
    {
        instrucaoNum = (pilha.getValor(1))-1;
        pilha.pop();
    }
    
    private void ldc(int param)
    {
        //S:=s+1 ; M[s]:=k
        pilha.push(pilha.pilhaSize(), param);
    }
    
    private void ldv(int param)
    {
        //S:=s+1 ; M[s]:=M[n]
        pilha.pushPos(param);
    }
    
    private void str(int param)
    {
        //M[n]:=M[s]; s;=s-1;
        pilha.setValorFixo(param, pilha.getValor(1));
        pilha.pop();
    }
    
    private void jmp(int param)
    {
        //desviar sempre instrucao:=param
        instrucaoNum = param;
    }
    
    private void jmpf(int param)
    {
        // desviar caso falso  se M[s]=0, entao i:=att1, senao i:=i+1
        res = pilha.getValor(1);
        if(res == 0)
            instrucaoNum = param;
        pilha.pop();
    }
    
    private void call(int param)
    {
        pilha.push(pilha.pilhaSize(), instrucaoNum +1);
        instrucaoNum = param;
    }
    
    private void alloc(int p1, int p2)
    {
        //{s:=s + 1; M[s]:=M[m+k]}
        for(int k=0; k<(p2);k++)
        {
            pilha.push(pilha.pilhaSize(), 0);
            pilha.setValor(1, pilha.getValorFixo(p1+k));
        }
    }
    
    private void dalloc(int p1, int p2)
    {
        //{M[m+k]:=M[s]; s:=s - 1}
         for(int k =(p2-1); k>=0; k--)
         {
             pilha.setValorFixo(p1+k, pilha.getValor(1));
             pilha.pop();
         }
    }
}
