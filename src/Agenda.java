import java.util.Map;
import java.io.Serializable;
import java.util.HashMap;

public class Agenda implements Serializable{
    private Map<String, Boolean> horariosDisponiveis = new HashMap<>();

    // Método para adicionar horários disponíveis
    public void adicionarHorario(String dataHora) {
        horariosDisponiveis.put(dataHora, true);
    }

    // Método para remover horários disponíveis
    public void removerHorario(String dataHora) {
        horariosDisponiveis.remove(dataHora);
    }

    // Método para consultar horários disponíveis
    public Map<String, Boolean> getHorariosDisponiveis() {
        return horariosDisponiveis;
    }

    // Método para obter a agenda diretamente
    public Map<String, Boolean> getAgenda() {
        return horariosDisponiveis;
    }

    public boolean confereHorario(String hr){
        if(this.getAgenda().containsKey(hr)){
            return true;
        } else {
            return false;
        }
    }
}
