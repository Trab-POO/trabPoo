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

    //métodos
    public boolean addMedico(Medico p){
        if(!verificaMedico(p))
            this.medicos.add(p);
        return true;
    }
    
    public boolean salvar(){
        try{
            super.gravarDados(this.medicos, "Medicos.bin");
            return true;
        } catch(Exception e){
            return false;
        }
    }

    public boolean remover(String CPF) {
        Iterator<Medico> auxVet = medicos.iterator();

        int aux = 0;
		while(auxVet.hasNext()) {
			if(CPF.equals(auxVet.next().getCpf())) {
				this.medicos.remove(aux);
				return true;
			}
            aux++;
		}
		return false;
	}

    public Medico getMedico(String CPF) {
        Iterator<Medico> auxVet = medicos.iterator();

        int aux = 0;
		while(auxVet.hasNext()) {
			if(CPF.equals(auxVet.next().getCpf())) {
				return this.medicos.get(aux);
			}
            aux++;
		}
        return null;
	}

    public boolean verificaMedico(Medico r){
        Iterator<Medico> aux = this.medicos.iterator();

        while(aux.hasNext()){
            if(aux.next() == r){
                return true;
            }
        }
        return false;
    }
}
