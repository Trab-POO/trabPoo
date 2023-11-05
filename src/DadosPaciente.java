import java.util.ArrayList;
import java.util.Iterator;

public class DadosPaciente extends Dados{
    
    //Atributos
    private ArrayList<Paciente> pacientes = new ArrayList<Paciente>();

    //Construtor
    public DadosPaciente(ArrayList<Paciente> vetorPacientes) {
        setPacientes(vetorPacientes);
    }
    public DadosPaciente() {
        if(super.recuperarDados("Pacientes.bin") != null)
            this.pacientes = (ArrayList<Paciente>) super.recuperarDados("Pacientes.bin");
    }

    //setter
    public void setPacientes(ArrayList<Paciente> vetor){
        if (super.recuperarDados("Pacientes.bin") == null){
            this.pacientes = vetor;
        } else {
            this.pacientes = (ArrayList<Paciente>) super.recuperarDados("Pacientes.bin");

            Iterator<Paciente> auxVet = vetor.iterator();

            while(auxVet.hasNext()){
                this.pacientes.add(auxVet.next());
            }
        }
    }

    //getter
    public ArrayList<Paciente> getPacientes(){
        return this.pacientes;
    }

    //métodos
    public boolean remover(String CPF) {
        Iterator<Paciente> auxVet = pacientes.iterator();

        int aux = 0;
		while(auxVet.hasNext()) {
			if(CPF.equals(auxVet.next().getCpf())) {
				this.pacientes.remove(aux);
				return true;
			}
            aux++;
		}
		return false;
	}

    public boolean addPaciente(Paciente p){
        if(!verificaPaciente(p))
            this.pacientes.add(p);
        return true;
    }

    public boolean salvar(){
        try{
            super.gravarDados(this.pacientes, "Pacientes.bin");
            return true;
        } catch(Exception e){
            return false;
        }
    }

    public boolean verificaPaciente(Paciente r){
        Iterator<Paciente> aux = this.pacientes.iterator();

        while(aux.hasNext()){
            if(aux.next() == r){
                return true;
            }
        }
        return false;
    }
}
