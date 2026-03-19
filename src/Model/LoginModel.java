package Model;

public class LoginModel {
    
    private int idLogin;
    private String Matricula;
    private String Senha;
    private Tipo_User Tipo_User;   
    public enum Tipo_User {FUNCIONARIO, ADM, GERENTE}
    
    public LoginModel(int idLogin, String Matricula, String Senha, 
            Tipo_User Tipo_User) {
        this.idLogin = idLogin;
        this.Matricula = Matricula;
        this.Senha = Senha;
        this.Tipo_User = Tipo_User;
    }
    
    public LoginModel(String Matricula, String Senha, Tipo_User Tipo_User) {
        this.Matricula = Matricula;
        this.Senha = Senha;
        this.Tipo_User = Tipo_User;
    }
    
    public int getidLogin() {return idLogin;}    
    public String getMatricula() {return Matricula;} 
    public String getSenha() {return Senha;}   
    public Tipo_User getTipo_User() {return Tipo_User;}  
}