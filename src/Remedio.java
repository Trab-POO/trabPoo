import java.io.Serializable;

public class Remedio implements Serializable{
    private String nome;

    // Construtor
    public Remedio(String nome) {
        this.nome = nome;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
