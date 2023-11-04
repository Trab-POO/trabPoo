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
}
