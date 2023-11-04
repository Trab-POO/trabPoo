public class Login{

    //atributos
    private String usuario;
    private String senha;
    
    //Construtor
    public Login(String u, String s){
        this.setUsuario(u);
        this.setSenha(s);
    }

    //setters
    public void setUsuario(String u){
        this.usuario = u;
    }
    public void setSenha(String s){
        this.senha = s;
    }

    //getters
    public String getUsuario(String u){
        return this.usuario;
    }
    public String getSenha(String s){
        return this.senha;
    }
}
