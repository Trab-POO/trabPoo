import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import java.util.Date;
public class Paciente extends Pessoa implements Serializable{
    private ArrayList<Consulta> consultas;

    // Construtor
    public Paciente(String nome, String cpf, String endereco, int nro, String bairro, Date dtNascimento, String s) {
        super(nome, cpf, endereco, nro, bairro, dtNascimento, s);
        consultas = new ArrayList<>();
    }

    // Métodos específicos de Paciente
    public void agendarConsulta(Medico medico, String dataHora) {
        // Verifica se a data e hora desejadas estão disponíveis na agenda do médico
        Agenda agendaMedico = medico.getAgenda();
        Map<String, Boolean> horariosDisponiveis = agendaMedico.getHorariosDisponiveis();

        if (horariosDisponiveis.containsKey(dataHora) && horariosDisponiveis.get(dataHora)) {
            // A data e hora estão disponíveis, então podemos agendar a consulta
            Consulta consulta = new Consulta(medico, this, dataHora);
            medico.registrarConsulta(consulta);
            consultas.add(consulta);
            agendaMedico.removerHorario(dataHora);
            System.out.println("Consulta agendada com sucesso para " + dataHora);
        } else {
            // A data e hora não estão disponíveis
            System.out.println("Desculpe, a data e hora selecionadas não estão disponíveis.");
        }
    }


    // Getter e Setter específico de Paciente
    public ArrayList<Consulta> getConsultas() {
        return consultas;
    }
}
