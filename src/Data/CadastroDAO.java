package Data;

import Model.CadastroModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;


public class CadastroDAO {
    
    private Connection con;

    public CadastroDAO() {
        try {Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/RHUniverse",
                "root",
                "rafael292603");
            
        } catch (Exception e) {
            System.out.println("Erro na conexão: " + e.getMessage());
        }   
    }
    
    public void Inserir(CadastroModel cadastro) {
        String sql = 
        "INSERT INTO Cadastro (Nome, CPF, Data_Nascimento, Cargo, "
                + "Salario_Base, Status) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, cadastro.getNomeCompleto());
            stmt.setString(2, cadastro.getCPF());
            stmt.setDate(3, java.sql.Date.valueOf(cadastro.getDataNascimento()));
            stmt.setString(4, cadastro.getCargo());
            stmt.setDouble(5, cadastro.getSalarioBase());
            stmt.setString(6, cadastro.getStatus().name());
           
            stmt.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Erro ao inserir funcionário: " + e.getMessage());
        }
    }
    
    public void Atualizar(CadastroModel cadastro) {

        String sql = "UPDATE"
           + " Cadastro SET Nome = ?, CPF = ?, Data_Nascimento = ?, Cargo = ?, "
                    + "Salario_Base = ?, Status = ?, WHERE id = ?";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, cadastro.getNomeCompleto());
            stmt.setString(2, cadastro.getCPF());
            stmt.setDate(3, java.sql.Date.valueOf(cadastro.getDataNascimento()));
            stmt.setString(4, cadastro.getCargo());
            stmt.setDouble(5, cadastro.getSalarioBase());
            stmt.setString(6, cadastro.getStatus().name());
            stmt.setInt(7, cadastro.getIdCadastro());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        }
    }
    
    public void Excluir(int idCadastro) {

        String sql = "DELETE FROM Cadastro WHERE id = ?";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, idCadastro);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        }
    }   
    
    public List<CadastroModel> listar() {

    List<CadastroModel> listaC = new ArrayList<>();
    String sql = "SELECT id, Nome, CPF, Data_Nascimento, Cargo, "
                + "Salario_Base, Status FROM Cadastro";

        try {
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {
        

            listaC.add(new CadastroModel(
                rs.getInt("Id"),
                rs.getString("Nome"),
                rs.getDate("Data_Nascimento").toLocalDate(),              
                rs.getString("CPF"),                
                rs.getString("Cargo"),
                rs.getDouble("Salario_Base"),
                CadastroModel.Status.valueOf(rs.getString("Status"))
            ));
        }

        } catch (SQLException e) {
           System.out.println("Erro ao listar: " + e.getMessage());
        }
        return listaC;
    }   
}