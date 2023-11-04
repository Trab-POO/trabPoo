import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class Medico extends Pessoa {
    private String especialidade;
    private ArrayList<Convenio> convenios = new ArrayList<>();
    private ArrayList<Consulta> consultas = new ArrayList<>();
    private Agenda agenda = new Agenda();

    // Construtor
    public Medico(String nome, String cpf, int idade, String endereco, int nro, String bairro, Date dt_nascimento, String especialidade) {
        super(nome, cpf, idade, endereco,nro,bairro,dt_nascimento);
        this.especialidade = especialidade;
    }

    public Agenda getAgenda() {
        return agenda;}

    // Métodos específicos de Medico
    public void adicionarConvenio(Convenio convenio) {
        convenios.add(convenio);
    }

    public void removerConvenio(Convenio convenio) {
        convenios.remove(convenio);
    }
    public void consultarAgenda() {
        Map<String, Boolean> horarios = agenda.getHorariosDisponiveis();

        if (!horarios.isEmpty()) {
            System.out.println("Horários disponíveis para consulta:");
            for (String horario : horarios.keySet()) {
                System.out.println(horario);
            }
        } else {
            System.out.println("Não há horários disponíveis para consulta.");
        }
    }


    public void registrarConsulta(Consulta consulta) {
        // Adicionar a consulta à lista de consultas do médico
        this.consultas.add(consulta);

        // Registrar a consulta na agenda do médico
        String dataHoraConsulta = consulta.getDataHora();
        agenda.removerHorario(dataHoraConsulta);

    }


    // Getter e Setter específico de Medico
    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public ArrayList<Convenio> getConvenios() {
        return convenios;
    }

    public void setConvenios(ArrayList<Convenio> convenios) {
        this.convenios = convenios;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }
}
