import java.util.ArrayList;

public class Medico extends Pessoa {
    private String especialidade;
    private ArrayList<Convenio> convenios = new ArrayList<>();
    private Agenda agenda = new Agenda();

    // Construtor
    public Medico(String nome, String cpf, int idade, String especialidade) {
        super(nome, cpf, idade);
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
        // Implementar lógica para consultar a agenda
    }

    public void registrarConsulta(Consulta consulta) {
        // Implementar lógica para registrar consulta
    }

    // Getter e Setter específico de Medico
    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}
