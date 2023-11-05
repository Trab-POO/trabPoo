import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class DadosConvenio extends Dados {
    private List<Convenio> convenios;

    public DadosConvenio(List<Convenio> convenios) {
        this.convenios = convenios;
    }

    public void salvarDados(String nomeArquivo) {
        try (FileOutputStream arquivo = new FileOutputStream(nomeArquivo);
             ObjectOutputStream objTxt = new ObjectOutputStream(arquivo)) {

            // Grava a lista de convenios no arquivo
            objTxt.writeObject(convenios);
            objTxt.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
