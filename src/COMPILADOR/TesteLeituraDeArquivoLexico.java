package src.COMPILADOR;

import java.io.IOException;


//Author Murilo Santana

//Classe para testar a leitura do arquivo fonte, 
//onde � passado por parametro o caminho do diret�rio no LeituraDeArquivo

public class TesteLeituraDeArquivoLexico {
    
    public static void main(String [] args)
    {
        int caracterLido = 0;
        LeituraDeArquivo leitor = null;
        try 
        {
            leitor = new LeituraDeArquivo("C:\\Users\\murilo\\Desktop\\teste.txt");
        } 
        catch (IOException ex) {}
        do
        {
            caracterLido = leitor.leituraCaracter();
            if(caracterLido != -1)
                System.out.println(""+(char)caracterLido);
        }
        while(caracterLido != -1);
    }
}
