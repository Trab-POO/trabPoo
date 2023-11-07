import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LeituraArquivoConvenios {

    public static List<Convenio> lerArquivo(String caminhoArquivo) {
        List<Convenio> convenios = new ArrayList<>();

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(caminhoArquivo))) {
            convenios = (List<Convenio>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e){
            System.out.println(e);
        }

        return convenios;
    }

    public static void salvarConvenios(List<Convenio> convenios, String caminhoArquivo) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(caminhoArquivo))) {
            out.writeObject(convenios);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Convenio> obterConveniosDisponiveis() {
        return lerArquivo("Convenios.bin"); // Substitua "convenios.bin" pelo caminho correto se necessário
    }

}
