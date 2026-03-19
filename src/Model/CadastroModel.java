package Model;

import java.time.LocalDate;

public class CadastroModel {
    
    private int idCadastro;
    private String NomeCompleto;
    private LocalDate DataNascimento;
    private String CPF;
    private String Cargo;
    private double SalarioBase;
    private Status Status;
    public enum Status {ATIVO,INATIVO}

    public CadastroModel (int idCadastro, String NomeCompleto, 
                    LocalDate DataNascimento, String CPF, String Cargo, 
                    double SalarioBase, Status Status) {
        this.idCadastro = idCadastro;
        this.NomeCompleto = NomeCompleto;
        this.DataNascimento = DataNascimento;
        this.CPF = CPF;
        this.Cargo = Cargo;
        this.SalarioBase = SalarioBase;
        this.Status = Status;
    }

    public CadastroModel(String NomeCompleto, LocalDate DataNascimento,
                    String CPF, String Cargo, double SalarioBase, 
                    Status Status) {
        this.NomeCompleto = NomeCompleto;
        this.DataNascimento = DataNascimento;
        this.CPF = CPF;
        this.Cargo = Cargo;
        this.SalarioBase = SalarioBase;
        this.Status = Status;
    }

    public int getIdCadastro() { return idCadastro; }
    public String getNomeCompleto() { return NomeCompleto; }
    public LocalDate getDataNascimento() { return DataNascimento; }
    public String getCPF() { return CPF; }
    public String getCargo() { return Cargo; }
    public double getSalarioBase() { return SalarioBase; }
    public Status getStatus() { return Status; }
}