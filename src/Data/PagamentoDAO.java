package Data;

import Model.PagamentoModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PagamentoDAO {
    
    private Connection con;

    public PagamentoDAO() {
        try {Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/RHUniverse",
                "root",
                "rafael292603");
            
        } catch (Exception e) {
            System.out.println("Erro na conexão: " + e.getMessage());
        }   
    }
    
    public void Inserir(PagamentoModel pagamento) {
        String sql = 
        "INSERT INTO Folha (Nome_Funcionario, Mes, Ano, Salario_Mensal, Jornada, Horas_Extras, "
                + "Beneficio_Total, Salario_Bruto, INSS, Desconto_Total, "
                + "Salario_Liquido, FGTS) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, pagamento.getNomeFuncionario());
            stmt.setString(2, pagamento.getMes().name());
            stmt.setString(3, pagamento.getAno());
            stmt.setDouble(4, pagamento.getSalarioMensal());
            stmt.setInt(5, pagamento.getJornada());
            stmt.setDouble(6, pagamento.getHorasExtras());
            stmt.setDouble(7, pagamento.getBeneficioTotal());
            stmt.setDouble(8, pagamento.getSalarioBruto());
            stmt.setDouble(9, pagamento.getInss());
            stmt.setDouble(10, pagamento.getDescontoTotal());
            stmt.setDouble(11, pagamento.getSalarioLiquido());
            stmt.setDouble(12, pagamento.getFgts());

            stmt.executeUpdate();

            stmt.close();

        } catch (Exception e) {
            System.out.println("Erro ao inserir folha: " + e.getMessage());
        }
    }
    
    public void Atualizar(PagamentoModel pagamento) {

        String sql = "UPDATE Folha SET "
                + "Nome_Funcionario = ?, "
                + "Mes = ?, "
                + "Ano = ?, "
                + "Salario_Mensal = ?,"
                + "Jornada = ?, "
                + "Horas_Extras = ?, "
                + "Beneficio_Total = ?, "
                + "Salario_Bruto = ?, "
                + "INSS = ?, "
                + "Desconto_Total = ?, "
                + "Salario_Liquido = ?, "
                + "FGTS = ? "
                + "WHERE idPagamento = ?";

        try {

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, pagamento.getNomeFuncionario());
            stmt.setString(2, pagamento.getMes().name());
            stmt.setString(3, pagamento.getAno());
            stmt.setDouble(4, pagamento.getSalarioMensal());
            stmt.setInt(5, pagamento.getJornada());
            stmt.setDouble(6, pagamento.getHorasExtras());
            stmt.setDouble(7, pagamento.getBeneficioTotal());
            stmt.setDouble(8, pagamento.getSalarioBruto());
            stmt.setDouble(9, pagamento.getInss());
            stmt.setDouble(10, pagamento.getDescontoTotal());
            stmt.setDouble(11, pagamento.getSalarioLiquido());
            stmt.setDouble(12, pagamento.getFgts());
            stmt.setInt(13, pagamento.getIdPagamento());

            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar folha: " + e.getMessage());
        }
    }
    
    public void Excluir(int idPagamento) {

        String sql = "DELETE FROM Folha WHERE idPagamento = ?";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, idPagamento);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        }
    }
    
    public List<PagamentoModel> listar() {

    List<PagamentoModel> listaP = new ArrayList<>();
    String sql = "SELECT idPagamento, Nome_Funcionario, Mes, Ano, Salario_Mensal, Jornada, Horas_Extras, "
                + "Beneficio_Total, Salario_Bruto, INSS, Desconto_Total, "
                + "Salario_Liquido, FGTS FROM Folha";

        try {
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {
        

            listaP.add(new PagamentoModel(
                rs.getInt("idPagamento"),    
                rs.getString("Nome_Funcionario"),
                PagamentoModel.Mes.valueOf(rs.getString("Mes")),
                rs.getString("Ano"),
                rs.getDouble("Salario_Mensal"),
                rs.getInt("Jornada"),
                rs.getDouble("Horas_Extras"),
                rs.getDouble("Beneficio_Total"),
                rs.getDouble("Salario_Bruto"),
                rs.getDouble("INSS"),
                rs.getDouble("Desconto_Total"),
                rs.getDouble("Salario_Liquido"),
                rs.getDouble("FGTS")
            ));
        }

        } catch (SQLException e) {
           System.out.println("Erro ao listar: " + e.getMessage());
        }
        return listaP;
    }
}
