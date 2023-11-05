import java.util.ArrayList;
import java.util.Iterator;

public class DadosRemedio extends Dados{
    
    //Atributos
    private ArrayList<Remedio> remedios = new ArrayList<Remedio>();

    //Construtor
    public DadosRemedio(ArrayList<Remedio> vetor) {
        setRemedios(vetor);
    }
    public DadosRemedio() {
        if(super.recuperarDados("Remedios.bin") != null)
            this.remedios = (ArrayList<Remedio>) super.recuperarDados("Remedios.bin");
    }

    //setter
    public void setRemedios(ArrayList<Remedio> vetor){
        if (super.recuperarDados("Remedios.bin") == null){
            this.remedios = vetor;
        } else {
            this.remedios = (ArrayList<Remedio>) super.recuperarDados("Remedios.bin");

            Iterator<Remedio> auxVet = vetor.iterator();

            while(auxVet.hasNext()){
                this.remedios.add(auxVet.next());
            }
        }
    }

    //getter
    public ArrayList<Remedio> getRemedios(){
        return this.remedios;
    }

    //métodos
    public boolean addRemedio(Remedio p){
        if(!verificaRemedio(p))
            this.remedios.add(p);
        return true;
    }

    public boolean salvar(){
        try{
            super.gravarDados(this.remedios, "Remedios.bin");
            return true;
        } catch(Exception e){
            return false;
        }
    }

    public boolean verificaRemedio(Remedio r){
        Iterator<Remedio> auxRem = this.remedios.iterator();

        while(auxRem.hasNext()){
            if(auxRem.next() == r){
                return true;
            }
        }
        return false;
    }
}
