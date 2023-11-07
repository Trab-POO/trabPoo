import java.io.Serializable;
import java.util.Date;

public class Consulta implements Serializable{
    private Medico medico;
    private Paciente paciente;
    private Date dataHora;
    private String batimentosCardiacos;
    private String pressao;
    private String temperatura;
    private String diagnóstico;
    private Remedio medicamento;
    private String observacoes;

    // Construtor
    // public Consulta(Medico medico, Paciente paciente, Date dataHora) {
    //     this.medico = medico;
    //     this.paciente = paciente;
    //     this.dataHora = dataHora;
    // }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public String getBatimentosCardiacos() {
        return batimentosCardiacos;
    }

    public void setBatimentosCardiacos(String batimentosCardiacos) {
        this.batimentosCardiacos = batimentosCardiacos;
    }

    public String getPressao() {
        return pressao;
    }

    public void setPressao(String pressao) {
        this.pressao = pressao;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getDiagnóstico() {
        return diagnóstico;
    }

    public void setDiagnóstico(String diagnóstico) {
        this.diagnóstico = diagnóstico;
    }

    public Remedio getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Remedio medicamento) {
        this.medicamento = medicamento;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}
