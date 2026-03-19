package Data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Model.LoginModel;
import java.sql.Connection;
import java.sql.DriverManager;

public class LoginDAO {
    
    private Connection con;

    public LoginDAO() {
        try {Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/RHUniverse",
                "root",
                "rafael292603");
            
        } catch (Exception e) {
            System.out.println("Erro na conexão: " + e.getMessage());
        }
    } 
    
    public LoginModel Autenticar(String matricula, String senha) {
    String sql = "SELECT * FROM Usuario WHERE Matricula = ? AND Senha = ?";
    
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, matricula);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("Id");
                String tipoStr = rs.getString("Tipo");

                LoginModel.Tipo_User tipo = 
                    LoginModel.Tipo_User.valueOf(tipoStr);

                return new LoginModel(id, matricula, senha, tipo);
            }

        } catch (Exception e) {
            System.out.println("Erro ao autenticar: " + e.getMessage());
        }
    return null;
    }
}