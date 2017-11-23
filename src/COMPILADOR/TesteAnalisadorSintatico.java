/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package src.COMPILADOR;

import java.util.Vector;;

public class TesteAnalisadorSintatico 
{
    
    public static void main(String [] args)
    {
        AnalisadorSintatico teste = null;
        try
        {
            teste = new AnalisadorSintatico("C:\\Users\\Pichau\\Desktop\\testes\\testesintatico\\teste8.txt");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println(""+e.getMessage());
        }
    }
    
}