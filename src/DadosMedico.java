import java.util.ArrayList;
import java.util.Iterator;

public class DadosMedico extends Dados{
    
    //Atributos
    private ArrayList<Medico> medicos = new ArrayList<Medico>();

    //Construtor
    public DadosMedico(ArrayList<Medico> vetorMedicos) {
        setMedicos(vetorMedicos);
    }
    public DadosMedico() {
        if(super.recuperarDados("Medicos.bin") != null)
            this.medicos = (ArrayList<Medico>) super.recuperarDados("Medicos.bin");
    }

    //setter
    public void setMedicos(ArrayList<Medico> vetor){
        if (super.recuperarDados("Medicos.bin") == null){
            this.medicos = vetor;
        } else {
            this.medicos = (ArrayList<Medico>) super.recuperarDados("Medicos.bin");

            Iterator<Medico> auxVet = vetor.iterator();

            while(auxVet.hasNext()){
                this.medicos.add(auxVet.next());
            }
        }
    }

    //getter
    public ArrayList<Medico> getMedicos(){
        return this.medicos;
    }
}
