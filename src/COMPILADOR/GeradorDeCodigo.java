package src.COMPILADOR;
import java.io.File;
import java.util.Formatter;

public class GeradorDeCodigo {
	
	private File arquivo;
	private Formatter out; 
	private static GeradorDeCodigo singleToN = null; //designer patters Singleton para a classe ser instanciada
	//somente uma vez
	
	public static GeradorDeCodigo getInstance() throws Exception
    {
        return singleToN;
    }
	
	public static void init(String source) throws Exception
    {
        singleToN = new GeradorDeCodigo(source);
    }
    
	private GeradorDeCodigo(String source) throws Exception 
	{
	        arquivo = new File(source);
	        if(arquivo.exists())
	            arquivo.delete();
	        
	        arquivo.createNewFile();
	        out = new Formatter(arquivo);
	}
	
	public void geraLabel(int n) 
    {
        out.format(Comandos.Label + n + "\tNULL\n");
        out.flush();
    }

	public void geraComando(String operador) 
    {
        out.format("\t" + operador + "\n");
        out.flush();
    }

	public void geraComando(String operador, String primeiroArg) 
    {
        out.format("\t" + operador + "\t" + primeiroArg + "\n");
        out.flush();
    }

    public void geraComando(String operador, int primeiroArg) 
    {
        out.format("\t" + operador + "\t" +  primeiroArg + "\n");
        out.flush();
    }
    
    public void geraComando(String operador, String primeiroArg, String segundoArg) 
    {
        out.format("\t" + operador + "\t" + primeiroArg + "," + segundoArg + "\n");
        out.flush();
    }
    
    public void geraComando(String operador, int primeiroArg, int segundoArg) 
    {
        out.format("\t" + operador + "\t" + primeiroArg + "," + segundoArg + "\n");
        out.flush();
    }

    public void close() 
    {
        out.close();
    }

    private Exception exception() 
    {
        throw new UnsupportedOperationException("Não é suportado."); //To change body of generated methods, choose Tools | Templates.
    }
	
}
