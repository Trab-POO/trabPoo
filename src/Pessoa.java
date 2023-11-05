import java.io.Serializable;
import java.util.*;
public class Pessoa implements Serializable{
    private String nome;
    private String cpf;
    private String endereco;
    private int nro;
    private String bairro;
    private Date dt_nascimento;
    private String senha;

    // Construtor
    public Pessoa(String nome, String cpf, String endereco, int nro, String bairro, Date dt_nascimento, String s) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.nro = nro;
        this.bairro = bairro;
        this.dt_nascimento = dt_nascimento;
        this.senha = s;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNro() {
        return nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Date getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(Date dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    //métodos
    public boolean verificaAcesso(String n, String s){
        return (n == getNome() && s == getSenha());
    }
}
