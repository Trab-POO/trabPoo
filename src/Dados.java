import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public abstract class  Dados {
	public static boolean gravarDados(Object a, String arq ){
		try {
			//Cria arquivo para inserir
			FileOutputStream arquivo = new FileOutputStream(arq);
			
			//classe para conter conteúdo de inserção
			ObjectOutputStream objTxt = new
			ObjectOutputStream(arquivo);
			
			//Grava o objeto cliente no arquivo
			objTxt.writeObject(a);
			objTxt.flush();
			objTxt.close();
			arquivo.flush();
			arquivo.close();
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	public static Object recuperarDados(String arq){
		Object retorno = null;
		FileInputStream arquivo = null;
		ObjectInputStream leitura = null;
		try {
			//Carrega o arquivo
			arquivo = new FileInputStream(arq);
			
			//Classe responsavel por recuperar os objetos do arquivo
			leitura = new ObjectInputStream(arquivo);
			
			//Le o objeto
			retorno = leitura.readObject();
			leitura.close();
			arquivo.close();
		}
		catch( Exception e ){
			System.out.println(e.getMessage());
			return null;
		}
		return retorno;
	}
	
}