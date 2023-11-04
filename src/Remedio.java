public class Remedio {
    private String nome;
    private String dosagem;

    // Construtor
    public Remedio(String nome, String dosagem) {
        this.nome = nome;
        this.dosagem = dosagem;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }
}
