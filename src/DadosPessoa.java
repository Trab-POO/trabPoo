import java.util.ArrayList;
import java.util.Iterator;

public class DadosPessoa extends Dados{
    
    //Atributos
    private ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();

    //Construtor
    public DadosPessoa(ArrayList<Pessoa> vetorPessoas) {
        setPacientes(vetorPessoas);
    }
    public DadosPessoa() {
        if(super.recuperarDados("Pessoas.bin") != null)
            this.pessoas = (ArrayList<Pessoa>) super.recuperarDados("Pessoas.bin");
    }

    //setter
    public void setPacientes(ArrayList<Pessoa> vetor){
        if (super.recuperarDados("Pessoas.bin") == null){
            this.pessoas = vetor;
        } else {
            this.pessoas = (ArrayList<Pessoa>) super.recuperarDados("Pessoas.bin");

            Iterator<Pessoa> auxVet = vetor.iterator();

            while(auxVet.hasNext()){
                this.pessoas.add(auxVet.next());
            }
        }
    }

    //getter
    public ArrayList<Pessoa> getPessoas(){
        return this.pessoas;
    }

    //métodos
    public boolean addPessoa(Pessoa p){
        this.pessoas.add(p);
        return true;
    }
    
    public boolean salvar(){
        try{
            super.gravarDados(this.pessoas, "Pessoas.bin");
            return true;
        } catch(Exception e){
            return false;
        }
    }
}
